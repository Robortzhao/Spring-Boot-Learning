package com.springbootlearning.mail;

import com.springbootlearning.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author zhaoyanhai
 * @description 测试发送邮件
 * @date 2019/10/4
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("408453682@qq.com", "Test simple mail", "Hello, this is simple Mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content = "<html>" +
                "<body>" +
                "<h3>hello world !this is a Html email!</h3>" +
                "</body>" +
                "</html>";
        mailService.sendHtmlMail("408453682@qq.com", "Test html mail", content);
    }

    @Test
    public void sendAttachmentMail() throws Exception {
        String filePath = "E:\\JavaProject\\SpringBootLearning\\README.md";
        mailService.sendAttachmentsMail("408453682@qq.com", "AttachmentMail", "Hello,this is Attachment Mail!", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content = "<html><body>this mail have a image：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "E:\\JavaProject\\12.jpg";

        mailService.sendInlineResourceMail("408453682@qq.com", "This mail have a image", content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("408453682@qq.com", "主题：这是模板邮件", emailContent);
    }

}
