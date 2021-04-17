package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.model.forgotPassword.ForgotPasswordModel;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.services.LoginService;
import com.enigma.reimbursment.online.services.SendEmailService;
import com.google.common.hash.Hashing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.Random;


@CrossOrigin
@RequestMapping("/forgot-password")
@RestController
public class ForgotPasswordController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    SendEmailService emailService;

    @Autowired
    private SendEmailService sendEmailService;


    public String encode(String password){
        return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }

    @PostMapping
    public ResponseMessage<ForgotPasswordModel> forgotPassword(@RequestBody @Valid ForgotPasswordModel request) throws MessagingException {
        ForgotPasswordModel response = new ForgotPasswordModel();

        /* Find email in table login */
        Login login = loginService.findByEmail(request.getEmail());

        if (login != null) {
            String newPassword = randomString();

            /* Send Mail */
            sendEmailService.sendEmailForgotPassword(newPassword, request.getEmail());

            /* Reset Password */
            loginService.resetPassword(login.getId(), encode(newPassword));

            /* Set Response */
            response.setEmail(request.getEmail());
            return new ResponseMessage(200, "Success", response);
        } else {
            return new ResponseMessage(200, "Failed", null);
        }
    }

    protected String randomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();

        while (stringBuilder.length() <= 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * characters.length());
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();
    }
}

