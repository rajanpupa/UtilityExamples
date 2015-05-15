//package com.ktm.freaks.email;
//
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class RMailSender {
//
//    String smtpHost;
//    String smtpPort;
//    String userName;
//    String password;
//
//    RMail rmail;
//
//    public RMailSender(RMail rmail) {
//	this.rmail = rmail;
//    }
//
//    public void sendMessage() throws Exception {
//	String host = smtpHost;
//	String from = userName;
//	String pass = password;
//
//	Properties props = System.getProperties();
//	props.put("mail.smtp.starttls.enable", "true"); // added this line
//	props.put("mail.smtp.host", host);
//	props.put("mail.smtp.user", from);
//	props.put("mail.smtp.password", pass);
//	props.put("mail.smtp.port", "587");
//	props.put("mail.smtp.auth", "true");
//
//	String[] to = { "rupadhyay@veriskhealth.com" }; // added this line
//
//	Session session = Session.getDefaultInstance(props, null);
//	MimeMessage message = new MimeMessage(session);
//	message.setFrom(new InternetAddress(from));
//
//	InternetAddress[] toAddress = new InternetAddress[to.length];
//
//	// To get the array of addresses
//	for (int i = 0; i < to.length; i++) { // changed from a while loop
//	    toAddress[i] = new InternetAddress(to[i]);
//	}
//	System.out.println(Message.RecipientType.TO);
//
//	for (int i = 0; i < toAddress.length; i++) { // changed from a while
//						     // loop
//	    message.addRecipient(Message.RecipientType.TO, toAddress[i]);
//	}
//	message.setSubject(rmail.getSubject());
//
//	String html = rmail.getMessage();
//
//	// message.setText("<h2> hello world</h2>");//,
//	// "text/html; charset=utf-8"
//	message.setText(html, "utf-8", "html");// "<h2> hello world</h2>"
//	Transport transport = session.getTransport("smtp");
//	transport.connect(host, from, pass);
//	transport.sendMessage(message, message.getAllRecipients());
//	transport.close();
//    }
//
//    // setters and getters
//    public String getSmtpHost() {
//	return smtpHost;
//    }
//
//    public void setSmtpHost(String smtpHost) {
//	this.smtpHost = smtpHost;
//    }
//
//    public String getUserName() {
//	return userName;
//    }
//
//    public void setUserName(String userName) {
//	this.userName = userName;
//    }
//
//    public String getPassword() {
//	return password;
//    }
//
//    public void setPassword(String password) {
//	this.password = password;
//    }
//}
