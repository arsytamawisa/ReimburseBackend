package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
