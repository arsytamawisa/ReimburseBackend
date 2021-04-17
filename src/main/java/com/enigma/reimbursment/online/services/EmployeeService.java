package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.repositories.EmployeeContractRepository;
import com.enigma.reimbursment.online.repositories.EmployeeRepository;
import com.enigma.reimbursment.online.repositories.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService extends AbstractService<Employee,String> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeContractRepository employeeContractRepository;

    @Autowired
    ReimbursementRepository reimbursementRepository;

    @Autowired
    protected EmployeeService(EmployeeRepository repository){
        super(repository);
    }

    public Employee checkVerificationEmailToken(String token){
        return employeeRepository.checkVerificationEmailToken(token);
    }

    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    public Employee findByIdLogin(String idLogin) {
        return employeeRepository.findIdLogin(idLogin);
    }

    public void changeIsVerifiedEmail(String token) {
        employeeRepository.changeIsVerifiedEmail(token);
    }

    public EmployeeResponseDashboard employeeDashboard(){
        EmployeeResponseDashboard response = new EmployeeResponseDashboard();
        response.setCountEmployee(Double.valueOf(employeeRepository.getCountEmployee()));
        response.setCountEmployeeActive(Double.valueOf(employeeRepository.getCountEmployeeActive()));
        response.setCountEmployeeReimburse(Double.valueOf(reimbursementRepository.getCountEmployeeReimbursement()));
        response.setCountEmployeeFemale(employeeRepository.getCountFemaleEmployee());
        response.setCountEmployeeMale(employeeRepository.getCountMaleEmployee());
        response.setCountEmployeePKWT(employeeContractRepository.getCountEmployeePKWT());
        response.setCountEmployeeProbabition(employeeContractRepository.getCountEmployeeProbabition());
        response.setCountEmployeeTypeOffice(employeeRepository.getCountTypeEmployeeOffice());
        response.setCountEmployeeTypeOnsite(employeeRepository.getCountTypeEmployeeOnsite());
        response.setCountEmployeeReimbursementGiveBirth(reimbursementRepository.getCountEmployeeReimbursementGiveBirth());
        response.setCountEmployeeReimbursementGlasses(reimbursementRepository.getCountEmployeeReimbursementGlasses());
        response.setCountEmployeeReimbursementInsurance(reimbursementRepository.getCountEmployeeReimbursementInsurance());
        response.setCountEmployeeReimbursementTraining(reimbursementRepository.getCountEmployeeReimbursementTraining());
        response.setCountEmployeeReimbursementOfficialTravel(reimbursementRepository.getCountEmployeeReimbursementOfficialTravel());
        response.setCountStatusProcessReimbursementEmployee(reimbursementRepository.getCountStatusProcessReimbursementEmployee());
        response.setCountStatusSuccessReimbursementEmployee(reimbursementRepository.getCountStatusSuccessReimbursementEmployee());

        return response;
    }

    public List<Employee> findByNameEmployee(String fullname) {
        return employeeRepository.findByNameEmployee(fullname);
    }

    public List<Employee> findByStatusEmployee(String employeeStatus) {
        return employeeRepository.findByStatusEmployee(employeeStatus);
    }

    public List<Employee> findByTypeEmployee(String employeeType){
        return employeeRepository.findByTypeEmployee(employeeType);
    }

    public Integer countPage(){
        return employeeRepository.countEmployee();
    }

    public List<Employee> getPage(int offset){
        return employeeRepository.pageEmployee(offset);
    }

}