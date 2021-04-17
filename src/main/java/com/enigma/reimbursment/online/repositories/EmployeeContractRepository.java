package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.EmployeeContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeContractRepository extends JpaRepository<EmployeeContract, String> {

    @Query(value = "SELECT COUNT(id) FROM employee_contract WHERE type_contract = 'PKWT' ", nativeQuery = true)
    Integer getCountEmployeePKWT();

    @Query(value = "SELECT COUNT(id) FROM employee_contract WHERE type_contract = 'PROBABITION' ", nativeQuery = true)
    Integer getCountEmployeeProbabition();

    @Query(value = "SELECT*FROM employee_contract LIMIT 10 OFFSET :offset ", nativeQuery = true)
    List<EmployeeContract> pageEmployeeContract(@Param("offset") Integer offset);

    @Query(value = "SELECT COUNT(id) FROM employee_contract", nativeQuery = true)
    Integer getCountEmployeeContract();

    @Query(value = "SELECT * FROM reimburse.employee_contract JOIN employee ON(employee_contract.employee_id = employee.id) WHERE fullname LIKE %:fullname% ", nativeQuery = true)
    List<EmployeeContract> findByNameEmployeeContract(@Param("fullname") String fullname);

}


