package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ServletWebServerApplicationContext server;


    public void sendEmailForgotPassword(String password, String email) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");

        String message = "" +
                "<img style='width:200px' src='https://i.postimg.cc/8zwCSTy9/undraw-my-passw-ord-d6kg.png'>" +
                "<h3>Kata sandi baru anda: " + password + " </h3>";

        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("EROS - Lupa Password");
        mimeMessageHelper.setText(message, true);
        javaMailSender.send(mimeMessage);
    }


    public void sendEmailVerificationToken(String token, String to) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
        Integer port = server.getWebServer().getPort();

        String message = "" +
                "<img style='width:200px' src='https://i.postimg.cc/QCkzzvFj/undraw-Confirmation-re-b6q5.png'>" +
                "<h3>Hai Enigmanians, aktifkan akunmu dengan mengakses link di bawah ini ya \uD83D\uDE07 \uD83D\uDE07</h3>" +
                "<a href='http://10.10.14.109:" + port + "register/verification/" + token + "'>" +
                "http://10.10.14.109:" + port + "/register/verification/" + token +
                "</a>";

        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("EROS - Verifikasi Email");
        mimeMessageHelper.setText(message, true);
        javaMailSender.send(mimeMessage);
    }


    public void sendEmailNotification(Reimbursement reimburse) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");

        String message = ""
                + "<img style='width:200px' src='https://iili.io/qk7YPf.png'>"
                + "<h3> Selamat " + reimburse.getEmployeeId().getFullname() + " \uD83E\uDD73 \uD83E\uDD73 </h3>"
                + "Pengajuan Klaim " + reimburse.getCategoryId().getCategoryName()
                + " Anda telah disetujui. </h3>";

        mimeMessageHelper.setTo(reimburse.getEmployeeId().getLogin().getEmail());
        mimeMessageHelper.setSubject("EROS - Klaim Reimburse");
        mimeMessageHelper.setText(message, true);
        javaMailSender.send(mimeMessage);
    }
}
