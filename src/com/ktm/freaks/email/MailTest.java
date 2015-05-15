//package com.ktm.freaks.email;
//
//import java.io.ObjectInputStream.GetField;
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class MailTest {
//
//    public static void main(String[] args) throws AddressException, MessagingException {
//    	String host = "smtp.gmail.com";
//	    String from = "rajanpupa@gmail.com";
//	    String pass = getPassword();
//	    
//	    Properties props = System.getProperties();
//	    props.put("mail.smtp.starttls.enable", "true"); // added this line
//	    props.put("mail.smtp.host", host);
//	    props.put("mail.smtp.user", from);
//	    props.put("mail.smtp.password", pass);
//	    props.put("mail.smtp.port", "587");
//	    props.put("mail.smtp.auth", "true");
//
//	    String[] to = {"rupadhyay@veriskhealth.com"}; // added this line
//
//	    Session session = Session.getDefaultInstance(props, null);
//	    MimeMessage message = new MimeMessage(session);
//	    message.setFrom(new InternetAddress(from));
//
//	    InternetAddress[] toAddress = new InternetAddress[to.length];
//
//	    // To get the array of addresses
//	    for( int i=0; i < to.length; i++ ) { // changed from a while loop
//	        toAddress[i] = new InternetAddress(to[i]);
//	    }
//	    System.out.println(Message.RecipientType.TO);
//
//	    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
//	        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
//	    }
//	    message.setSubject("sending in a group");
//	    
//	    String html = getHtmlOpening();getHtmlMessage();
//	    html += "<h3>Hello Rajan</h3>";
//	    html += "<p>Welcome to you very very much.</p>";
//	     html += getHtmlSignature();
//	    
//	    //message.setText("<h2> hello world</h2>");//, "text/html; charset=utf-8"
//	    message.setText(html, "utf-8", "html");//"<h2> hello world</h2>"
//	    Transport transport = session.getTransport("smtp");
//	    transport.connect(host, from, pass);
//	    transport.sendMessage(message, message.getAllRecipients());
//	    transport.close();
//    }
//    
//    private static String getHtmlMessage2() {
//	return "<h2> hello world</h2>";
//    }
//    
//
//    private static String getHtmlMessage() {
//	String html = "";
//	
//	html += "<html>";
//	html += "<head>";
//	html += "<title>";
//	html += "Java | Html | email | example";
//	html += "</title>";
//	html += "</head>";
//	html += "<body>";
//	html += "<h2>Welcome to the world of java emails</h2>";
//	html += "<p>You will enjoy sending emails using java.</p>";
//	
//	html += "</body>";
//	html += "</html>";
//	
//	return html;
//    }
//    
//
//    private static String getHtmlOpening() {
//	String html = "<html>" +
// 		"<head>                                                                                                                              " +
// 	 "<meta http-equiv=Content-Type content=\"text/html; charset=windows-1252\">                                                              " +
// 	 "<meta name=Generator content=\"Microsoft Word 12 (filtered)\">                                                                          " +
// 	 "<style>                                                                                                                               " +
// 	 "<!--                                                                                                                                  " +
// 	 " /* Font Definitions */                                                                                                               " +
// 	 " @font-face                                                                                                                           " +
// 	 "	{font-family:\"Cambria Math\";                                                                                                      " +
// 	 "	panose-1:2 4 5 3 5 4 6 3 2 4;}                                                                                                    " +
// 	 "@font-face                                                                                                                            " +
// 	 "	{font-family:Calibri;                                                                                                             " +
// 	 "	panose-1:2 15 5 2 2 2 4 3 2 4;}                                                                                                   " +
// 	 "@font-face                                                                                                                            " +
// 	 "	{font-family:Tahoma;                                                                                                              " +
// 	 "	panose-1:2 11 6 4 3 5 4 4 2 4;}                                                                                                   " +
// 	 " /* Style Definitions */                                                                                                              " +
// 	 " p.MsoNormal, li.MsoNormal, div.MsoNormal                                                                                             " +
// 	 "	{margin:0in;                                                                                                                      " +
// 	 "	margin-bottom:.0001pt;                                                                                                            " +
// 	 "	font-size:12.0pt;                                                                                                                 " +
// 	 "	font-family:\"Times New Roman\",\"serif\";}                                                                                           " +
// 	 "a:link, span.MsoHyperlink                                                                                                             " +
// 	 "	{color:blue;                                                                                                                      " +
// 	 "	text-decoration:underline;}                                                                                                       " +
// 	 "a:visited, span.MsoHyperlinkFollowed                                                                                                  " +
// 	 "	{color:purple;                                                                                                                    " +
// 	 "	text-decoration:underline;}                                                                                                       " +
// 	 "p.MsoAcetate, li.MsoAcetate, div.MsoAcetate                                                                                           " +
// 	 "	{mso-style-link:\"Balloon Text Char\";                                                                                              " +
// 	 "	margin:0in;                                                                                                                       " +
// 	 "	margin-bottom:.0001pt;                                                                                                            " +
// 	 "	font-size:8.0pt;                                                                                                                  " +
// 	 "	font-family:\"Tahoma\",\"sans-serif\";}                                                                                               " +
// 	 "span.BalloonTextChar                                                                                                                  " +
// 	 "	{mso-style-name:\"Balloon Text Char\";                                                                                              " +
// 	 "	mso-style-link:\"Balloon Text\";                                                                                                    " +
// 	 "	font-family:\"Tahoma\",\"sans-serif\";}                                                                                               " +
// 	 ".MsoPapDefault                                                                                                                        " +
// 	 "	{margin-bottom:10.0pt;                                                                                                            " +
// 	 "	line-height:115%;}                                                                                                                " +
// 	 "@page WordSection1                                                                                                                    " +
// 	 "	{size:8.5in 11.0in;                                                                                                               " +
// 	 "	margin:1.0in 1.0in 1.0in 1.0in;}                                                                                                  " +
// 	 "div.WordSection1                                                                                                                      " +
// 	 "	{page:WordSection1;}                                                                                                              " +
// 	 "-->                                                                                                                                   " +
// 	 "</style>                                                                                                                              " +
// 	 "                                                                                                                                      " +
// 	 "</head>                                                                                                                               " +
// 	 "                                                                                                                                      " +
// 	 "<body lang=EN-US link=blue vlink=purple>";   
//	return html;
//    }
//    private static String getHtmlSignature() {
// 	String html = "";
// 	html += 	 "                                                                                                                                      " +
// 	 "<div class=WordSection1>                                                                                                              " +
// 	 "                                                                                                                                      " +
// 	 "<p class=MsoNormal><span style='font-size:10.0pt;font-family:\"Arial\",\"sans-serif\"'><hr/></span></p>                                                                                  " +
// 	 "                                                                                                                                      " +
// 	 "<p class=MsoNormal><b><span style='color:#00608E'>Rajan Prasad Upadhyay</span></b><span                                               " +
// 	 "style='color:#5F6062'> | Associate Software Engineer | WeMustCode                                                             " +
// 	 "Technologies, Kathmandu, Nepal<br>                                                                                                    " +
// 	 "</span><a href=\"mailto:SpShrestha@VeriskHealth.com\"><span style='color:#5F6062'>RUpadhyay@VeriskHealth.com</span></a><span            " +
// 	 "style='color:#5F6062'>&nbsp; | Tel:&nbsp; +977-1-4435625 ext 208 | </span><a                                                          " +
// 	 "href=\"http://www.veriskit.com/\"><span style='color:#5F6062'>www.VeriskIT.com</span></a></p>                                           " +
// 	 "                                                                                                                                      " +
// 	 "<p class=MsoNormal>&nbsp;</p>                                                                                                         " +
// 	 "                                                                                                                                      " +
// 	 "</div>                                                                                                                                " +
// 	 "                                                                                                                                      " +
// 	 "</body>                                                                                                                               " +
// 	 "                                                                                                                                      " +
// 	 "</html>                                                                                                                               " ;
// 	
// 	return html;
//     }
//    
//    private static String getPassword() {
//	return "";
//    }
//}
