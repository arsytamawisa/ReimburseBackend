package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.response.login.LoginResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface LoginRepository extends JpaRepository<Login, String> {

    @Query(value = "SELECT * FROM login WHERE email = :email AND password = :password", nativeQuery = true)
    Login findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT * FROM login WHERE email = :email", nativeQuery = true)
    Login findByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE login SET password = :password WHERE id = :id", nativeQuery = true)
    Integer resetPassword(@Param("id") String id, @Param("password") String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE login SET password = :password WHERE email = :email", nativeQuery = true)
    Integer resetPassword2(@Param("email") String email, @Param("password") String password);

}
