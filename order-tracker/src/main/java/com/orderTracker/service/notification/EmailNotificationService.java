package com.orderTracker.service.notification;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class EmailNotificationService {

    private final JavaMailSender mailSender;

    @Value("${source.sender.email}")
    private String senderEmail;

    public EmailNotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOrderStatusEmail(NotificationRequest request) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(senderEmail);
            helper.setTo(request.to());
            helper.setSubject(request.subject());

            String content = loadHtmlTemplate("templates/order-status.html")
                    .replace("{{customerName}}", request.customerName())
                    .replace("{{orderId}}", request.orderId())
                    .replace("{{status}}", request.status());

            helper.setText(content, true);

            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String loadHtmlTemplate(String path) {
        try {
            Path templatePath = new ClassPathResource(path).getFile().toPath();
            return Files.readString(templatePath, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load email template", e);
        }
    }
}