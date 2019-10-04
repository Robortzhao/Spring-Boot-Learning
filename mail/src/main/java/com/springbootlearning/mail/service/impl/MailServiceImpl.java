package com.springbootlearning.mail.service.impl;

import com.springbootlearning.mail.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * @author zhaoyanhai
 * @description TODO
 * @date 2019/10/4
 **/
@Component
public class MailServiceImpl implements MailService {

    private final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * @param to,subject,content
     * @return void
     * @Description 发送简单邮件
     * @author zhaoyanhai
     * @date 2019/10/4
     **/
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            LOGGER.info(" simpleMail send success!");
        } catch (Exception e) {
            LOGGER.info(" simpleMail send exception!", e);
        }
    }

    /**
     * @param to,subject,content
     * @return void
     * @Description 发送html类型的邮件
     * @author zhaoyanhai
     * @date 2019/10/4
     **/
    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
            LOGGER.info("HtmlMail send success!");
        } catch (MessagingException e) {
            LOGGER.info("HtmlMail send exception!");
        }
    }

    /**
     * @param to,subject,content,ilePath
     * @return void
     * @throws MessagingException
     * @Description 发送带附件的邮件
     * @author zhaoyanhai
     * @date 2019/10/4
     **/
    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            //发送多个附件可以用多个 helper.addAttachment()
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            LOGGER.info("AttachmentMail send success!");
        } catch (MessagingException e) {
            LOGGER.info("AttachmentMail send exception!");
        }
    }

    /**
     * @param to,subject,content,rscPath,rscId
     * @return void
     * @throws MessagingException
     * @Description 发送正文中有静态资源（图片）的邮件
     * @author zhaoyanhai
     * @date 2019/10/4
     **/
    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
            mailSender.send(message);
            LOGGER.info("InlineResourceMail send success!");
        } catch (MessagingException e) {
            LOGGER.error("InlineResourceMail send exception！", e);
        }
    }
}
