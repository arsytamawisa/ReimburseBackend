package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Bill;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService extends AbstractService<Bill,String>{

    @Autowired
    BillRepository billRepository;

    protected BillService(BillRepository repository) {
        super(repository);
    }

    public Bill filterByIdBill(String reimbursementId) {
        return billRepository.findByIdBill(reimbursementId);
    }

    public Bill filterByIdBillAdmin(String reimbursementId) {
        return billRepository.findByIdBillAdmin(reimbursementId);
    }
}
