package com.library.system.controller;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class Email {

	public static void main(String[] args) throws GeneralSecurityException, MessagingException {
		 
		Properties props = new Properties();
        
        // ����debug����
        props.setProperty("mail.debug", "true");
        // ���ͷ�������Ҫ������֤
        props.setProperty("mail.smtp.auth", "true");
        // �����ʼ�������������
        props.setProperty("mail.host", "smtp.qq.com");
        // �����ʼ�Э������
        props.setProperty("mail.transport.protocol", "smtp");
     
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
     while(true){
        Session session = Session.getInstance(props);
     
        Message msg = new MimeMessage(session);
        msg.setSubject("ͼ�����ϵͳ�޸�������֤");
        StringBuilder builder = new StringBuilder();
        builder.append("ͼ�����ϵͳ��֤��:");
        builder.append("123456!");
        msg.setText(builder.toString());
        msg.setFrom(new InternetAddress("719568690@qq.com"));
     
        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", "719568690@qq.com", "kngqytyqbqajbaie");
     
        transport.sendMessage(msg, new Address[] { new InternetAddress("3352045217@qq.com") });
        transport.close();
     }
	}

}