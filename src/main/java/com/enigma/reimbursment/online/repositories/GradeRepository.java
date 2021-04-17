package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade,String> {

    @Query(value = "SELECT * FROM grade ORDER BY grade ASC", nativeQuery = true)
    List<Grade> getAll();
}
