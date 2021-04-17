package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Admin;

import com.enigma.reimbursment.online.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends AbstractService<Admin, String> {

    @Autowired
    protected AdminService(AdminRepository repository){
        super(repository);
    }
}
