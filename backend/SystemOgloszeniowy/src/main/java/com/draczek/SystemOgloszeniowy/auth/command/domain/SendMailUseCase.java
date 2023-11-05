package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionToken;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Class for stuff related to sending mails.
 */
@RequiredArgsConstructor
public class SendMailUseCase {

  private final JavaMailSender emailSender;

  private void sendMail(String sendTo, String subject, String text) {
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(sendTo);
    simpleMailMessage.setFrom(((JavaMailSenderImpl) emailSender).getUsername());
    simpleMailMessage.setSubject(subject);
    simpleMailMessage.setText(text);
    emailSender.send(simpleMailMessage);
  }

  /**
   * Method for sending new user's activation token keys.
   *
   * @param userActionToken token
   */
  public void sendActivateAccountMail(UserActionToken userActionToken) {
    sendMail(userActionToken.getUser().getUsername(),
        "Aktywacja konta PZAW DR ®",
        userActionToken.getKey());
  }

  /**
   * Method for sending reset password token keys.
   *
   * @param userActionToken token
   */
  public void sendResetPasswordMail(UserActionToken userActionToken) {
    sendMail(userActionToken.getUser().getUsername(),
        "Reset hasła PZAW DR ®",
        userActionToken.getKey());
  }
}
