package com.ridvandogan.user_login.mail;

import com.sun.xml.bind.api.impl.NameConverter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created at 25.05.2022.
 *
 * @author Ridvan Dogan
 */

@Service
@AllArgsConstructor
public class MailService implements MailSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    private final JavaMailSender mailSender;

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
            messageHelper.setText(email, true);
            messageHelper.setTo(to);
            messageHelper.setSubject("Confirm your email");
            messageHelper.setFrom("rdvndgn4235@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            LOGGER.error("failed to send mail", ex);
            throw new IllegalStateException("failed to send mail.");
        }
    }
}
