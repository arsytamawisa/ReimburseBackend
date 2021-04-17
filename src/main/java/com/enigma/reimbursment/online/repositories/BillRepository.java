package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Bill;
import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill,String> {

    @Query(value = "SELECT * FROM bill WHERE id_reimbursement = :reimbursementId AND user = 'employee'", nativeQuery = true)
    Bill findByIdBill(@Param("reimbursementId") String reimbursementId);


    @Query(value = "SELECT * FROM bill WHERE id_reimbursement = :reimbursementId AND user = 'admin'", nativeQuery = true)
    Bill findByIdBillAdmin(@Param("reimbursementId") String reimbursementId);
}
