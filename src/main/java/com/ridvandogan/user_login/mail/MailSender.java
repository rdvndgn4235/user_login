package com.ridvandogan.user_login.mail;

/**
 * Created at 25.05.2022.
 *
 * @author Ridvan Dogan
 */
public interface MailSender {
    void send(String to, String email);
}
