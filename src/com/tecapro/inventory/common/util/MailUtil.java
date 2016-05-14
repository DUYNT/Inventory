/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * MailUtil class
 *
 * Can configuration info of mail: addresses to, cc, bcc; contents of subject, body, etc.
 * Can attach file into mail
 * Body of mail used template engine (Velocity), can replace parts in body
 */
@Component("MailUtil")
@Scope("prototype")
@EnableAsync
public class MailUtil {

    /**
     * instance of JavaMailSenderImpl
     */
    @Autowired
    private JavaMailSenderImpl mailSender;
    
    /**
     * instance of MimeMessageHelper
     */
    private MimeMessageHelper mimeMessageHelper;
    
    /**
     * instance of MimeMessage
     */
    private MimeMessage mimeMessage;

    /**
     * Re init mimeMessage
     * @throws MessagingException when error occur
     */
    public void init() throws MessagingException {
        
        if (!Boolean.valueOf(mailSender.getJavaMailProperties().getProperty("mail.smtp.auth"))) {
            mailSender.setUsername(null);
            mailSender.setPassword(null);
            mailSender.setJavaMailProperties(new Properties());
        }
        
        this.mimeMessage = this.mailSender.createMimeMessage();
        if ("".equals(mailSender.getDefaultEncoding())) {
            this.mimeMessageHelper = new MimeMessageHelper(this.mimeMessage, true);
        } else {
            this.mimeMessageHelper = new MimeMessageHelper(this.mimeMessage, true, mailSender.getDefaultEncoding());
        }
        this.setSentDate(null);
    }

    /**
     * Set address of recipient to MimeMessageHeper object
     * @param to The address of recipient
     * @throws MessagingException when error occur
     */
    public void setTo(String to) throws MessagingException {
        this.mimeMessageHelper.setTo(to);
    }

    /**
     * Set address of recipient to MimeMessageHeper object
     * @param to The address of recipient
     * @param name The name of recipient
     * @throws MessagingException when error occur
     * @throws UnsupportedEncodingException 
     */
    public void setTo(String to, String name) throws MessagingException, UnsupportedEncodingException {
        this.mimeMessageHelper.addTo(to, name);
    }

    /**
     * Set array address of recipients to MimeMessageHeper object
     * @param to The array address of recipients
     * @throws MessagingException when error occur
     */
    public void setTo(String[] to) throws MessagingException {
        this.mimeMessageHelper.setTo(to);
    }

    /**
     * Set cc address of recipient to MimeMessageHeper object
     * @param cc The address of recipient
     * @throws MessagingException when error occur
     */
    public void setCc(String cc) throws MessagingException {
        this.mimeMessageHelper.setCc(cc);
    }

    /**
     * Set array cc address of recipients to MimeMessageHeper object
     * @param cc The array address of recipients
     * @throws MessagingException when error occur
     */
    public void setCc(String[] cc) throws MessagingException {
        this.mimeMessageHelper.setCc(cc);
    }

    /**
     * Set bcc address of recipient to MimeMessageHelper object
     * @param bcc The bcc address of recipient
     * @throws MessagingException when error occur
     */
    public void setBcc(String bcc) throws MessagingException {
        this.mimeMessageHelper.setBcc(bcc);
    }

    /**
     * Set array bcc address of recipients to MimeMessageHelper object
     * @param bcc The array bcc address of recipient
     * @throws MessagingException when error occur
     */
    public void setBcc(String[] bcc) throws MessagingException {
        this.mimeMessageHelper.setBcc(bcc);
    }

    /**
     * Set from address of sender to MimeMessageHeper object
     * @param from The address of sender
     * @throws MessagingException when error occur
     * @throws UnsupportedEncodingException 
     */
    public void setFrom(String from) throws MessagingException {
        this.mimeMessageHelper.setFrom(from);
    }

    /**
     * Set from address of sender to MimeMessageHeper object
     * @param from The address of sender
     * @param name The name of sender
     * @throws MessagingException when error occur
     * @throws UnsupportedEncodingException 
     */
    public void setFrom(String from, String name) throws MessagingException, UnsupportedEncodingException {
        this.mimeMessageHelper.setFrom(from, name);
    }

    /**
     * Set replyTo address of recipient to MimeMessageHeper object
     * @param replyTo The address of recipient
     * @throws MessagingException when error occur
     */
    public void setReplyTo(String replyTo) throws MessagingException {
        this.mimeMessageHelper.setReplyTo(replyTo);
    }

    /**
     * Set replyTo address of recipient to MimeMessageHeper object
     * @param replyTo The address of recipient
     * @param name The name of recipient
     * @throws MessagingException when error occur
     * @throws UnsupportedEncodingException 
     */
    public void setReplyTo(String replyTo, String name) throws MessagingException, UnsupportedEncodingException {
        this.mimeMessageHelper.setReplyTo(replyTo, name);
    }

    /**
     * Set subject of mail to MimeMessageHeper object
     * @param subject The subject of mail
     * @throws MessagingException when error occur
     */
    public void setSubject(String subject) throws MessagingException {
        this.mimeMessageHelper.setSubject(subject);
    }

    /**
     * Set content plain/text of mail to MimeMessageHeper object
     * @param text The content of mail
     * @throws MessagingException when error occur
     */
    public void setText(String text) throws MessagingException {
        this.mimeMessageHelper.setText(text);
    }

    /**
     * Set content html/text of mail to MimeMessageHeper object
     * @param text The content of mail
     * @param isHtml true: html/text, false: plain/text
     * @throws MessagingException when error occur
     */
    public void setText(String text, boolean isHtml) throws MessagingException {
        this.mimeMessageHelper.setText(text, isHtml);
    }

    /**
     * Set sent date of mail to MimeMessageHeper object
     * @param sentDate The date object
     * @throws MessagingException when error occur
     */
    public void setSentDate(Date sentDate) throws MessagingException {
        // Check date object
        if (sentDate == null) {
            sentDate = Calendar.getInstance().getTime();
        }
        this.mimeMessageHelper.setSentDate(sentDate);
    }

    /**
     * Add attachment into mail
     * @param fileName The name of file to attach
     * @param file The file on system
     * @throws MessagingException when error occur
     */
    public void addAttachment(String fileName, File file) throws MessagingException {
        // Check existence of file
        if ((file != null) && file.exists()) {

            // Check fileName, if is null or empty, to get name of file
            if ((fileName == null) || "".equals(fileName)) {
                fileName = file.getName();
            }
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            this.mimeMessageHelper.addAttachment(fileName, fileSystemResource);
        }
    }

    /**
     * Do send mail
     * @throws MessagingException when error occur
     */
    public void send() {
        // Do send mail
        this.mailSender.send(this.mimeMessage);
    }

    /**
     * Do send mail asynchronous
     * 
     * @throws MessagingException
     *             when error occur
     */
    @Async
    public void sendAsync() {
        // Do send mail
        mailSender.send(mimeMessage);
    }
    
}