package com.qa.util;


import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.IOException;
import java.util.Properties;



public class SendEmail {

    public static void email_with_attachment() throws InterruptedException {
        System.out.println("============Waiting for Extenet report to generate ==============");
        System.out.println("============Preparing for sending email ==============");
        final String user = "akshaykinhikar21@gmail.com";// change accordingly
        final String password = "enwopgqitwiwykgh";// change accordingly
        String fromEmail = "akshaykinhikar21@gmail.com";
        String toEmail = "akskinhikar@gmail.com";

        // SMTP server properties
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");


        // Create session with Authentication
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });

        Thread.sleep(5000);

        //session.setDebug(true);

        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject("Extent Report with Attached PDF file");

            // Create Email in muliple parts
            Multipart emailContent = new MimeMultipart();

            // Create Body Text Part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Hello,\nPlease find attached PDF extent report file.\nRegards \nQA Team");

            // Create Body Part for Attaching PDF file
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart
                    .attachFile("/Users/akshaykinhikar/Desktop/Selenium/IntellijWorkspace/sfautomationwork/sfsc/test-output/PDFReport/ExtentPDF.pdf");

            // Create Body Part for Attaching HTML file
            MimeBodyPart attachmentBodyPart2 = new MimeBodyPart();
            attachmentBodyPart2
                    .attachFile("/Users/akshaykinhikar/Desktop/Selenium/IntellijWorkspace/sfautomationwork/sfsc/test-output/SparkReport/Spark.html");

            // Adding the Email body parts to email content
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(attachmentBodyPart);
            emailContent.addBodyPart(attachmentBodyPart2);
            msg.setContent(emailContent);

            Transport.send(msg);
            System.out.println("============Email Sent==============");

        } catch (MessagingException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            SendEmail.email_with_attachment();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
