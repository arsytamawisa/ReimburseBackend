package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = "SELECT * FROM employee WHERE email_verification_token = :token", nativeQuery = true)
    Employee checkVerificationEmailToken(@Param("token") String token);

    @Query(value = "SELECT * FROM employee WHERE is_verified_email = true AND is_completed = true", nativeQuery = true)
    List<Employee> getAll();

    //filter by nama employee
    @Query(value = "SELECT * FROM employee WHERE fullname LIKE %:fullname%", nativeQuery = true)
    List<Employee> findByNameEmployee(@Param("fullname") String fullname);

    //filter by employee status
    @Query(value = "SELECT * FROM employee WHERE employee_status = :employeeStatus", nativeQuery = true)
    List<Employee> findByStatusEmployee(@Param("employeeStatus") String employeeStatus);

    //filter by type employee
    @Query(value = "SELECT * FROM employee WHERE employee_type = :employeeType", nativeQuery = true)
    List<Employee> findByTypeEmployee(@Param("employeeType") String employeeType);

    //pagination
    @Query(value = "SELECT * FROM employee LIMIT 10 OFFSET :offset", nativeQuery = true)
    List<Employee>getPagination(@Param("offset") Integer offset);


    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET is_verified_email = true WHERE email_verification_token = :token", nativeQuery = true)
    Integer changeIsVerifiedEmail(@Param("token") String token);

    @Query(value = "SELECT * FROM employee WHERE id_login = :id_login", nativeQuery = true)
    Employee findIdLogin(@Param("id_login") String idLogin);

    @Query(value = "SELECT COUNT(id) FROM employee", nativeQuery = true)
    Integer getCountEmployee();

    @Query(value = "SELECT COUNT(id) FROM employee WHERE employee_status = 'ACTIVE'", nativeQuery = true)
    Integer getCountEmployeeActive();

    @Query(value = "SELECT COUNT(id) FROM employee WHERE gender = 'FEMALE'", nativeQuery = true)
    Integer getCountFemaleEmployee();

    @Query(value = "SELECT COUNT(id) FROM employee WHERE gender = 'MALE'", nativeQuery = true)
    Integer getCountMaleEmployee();

    //berdasar Type Employee Onsite
    @Query(value = "SELECT COUNT(id) from employee WHERE employee_type = 'ONSITE'",nativeQuery = true)
    Integer getCountTypeEmployeeOnsite();

    //berdasar Type Employee
    @Query(value = "SELECT COUNT(id) from employee WHERE employee_type = 'OFFICE'",nativeQuery = true)
    Integer getCountTypeEmployeeOffice();

    @Query(value = "SELECT COUNT(id) FROM employee", nativeQuery = true)
    Integer countEmployee();

    //page
    @Query(value = "SELECT * FROM employee WHERE is_verified_email = true LIMIT 10 OFFSET :offset ",nativeQuery = true)
    List<Employee>pageEmployee(@Param("offset") Integer offset);


}
