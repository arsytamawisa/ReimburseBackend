package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Role;
import com.enigma.reimbursment.online.repositories.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractService<Role,Integer>{
    protected RoleService(RoleRepository repository) {
        super(repository);
    }
}
