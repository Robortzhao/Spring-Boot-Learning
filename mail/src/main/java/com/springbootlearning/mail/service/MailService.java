package com.springbootlearning.mail.service;

/**
 * @author zhaoyanhai
 * @description 发送邮件的接口
 * @date 2019/10/4
 **/

public interface MailService {

    public void sendSimpleMail(String to, String subject, String content);

    public void sendHtmlMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

}
