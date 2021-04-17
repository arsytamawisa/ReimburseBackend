package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.response.login.LoginResponse;
import com.enigma.reimbursment.online.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService extends AbstractService<Login, String> {

    @Autowired
    protected LoginRepository loginRepository;

    @Autowired
    protected LoginService(LoginRepository repository){
        super(repository);
    }

    public Login findByEmailAndPassword(String email, String password){
        return loginRepository.findByEmailAndPassword(email,password);
    }

    public Login findByEmail(String email){
        return loginRepository.findByEmail(email);
    }

    public void resetPassword(String id, String password) {
        loginRepository.resetPassword(id, password);
    }

    public void resetPassword2(String email, String password) {
        loginRepository.resetPassword2(email, password);
    }


}
