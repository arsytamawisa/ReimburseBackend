package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.repositories.EmployeeContractRepository;
import com.enigma.reimbursment.online.repositories.EmployeeRepository;
import com.enigma.reimbursment.online.repositories.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReimbursementService extends AbstractService<Reimbursement, String> {

    @Autowired
    ReimbursementRepository reimbursementRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeContractRepository employeeContractRepository;

    @Autowired
    protected ReimbursementService(ReimbursementRepository repository) {
        super(repository);
    }

    public List<Reimbursement> filterCategoryById(String categoryId) {
        System.out.println(categoryId);
        return reimbursementRepository.filterCategoryById(categoryId);
    }

    public List<Reimbursement> filterCategoryByIdEmployee(String employeeId, String categoryId) {
        System.out.println(categoryId);
        return reimbursementRepository.filterCategoryByIdEmployee(employeeId, categoryId);
    }

    public List<Reimbursement> filterByDateOfClaim(String startDate, String endDate) {
        return reimbursementRepository.filterByDateOfClaim(startDate, endDate);
    }

    public List<Reimbursement> filterByIdEmployee(String employeeId) {
        return reimbursementRepository.filterByIdEmployee(employeeId);
    }

    public List<Reimbursement> filterByDateAndIdEmployee(String employeeId, String startDate, String endDate) {
        return reimbursementRepository.filterByDateAndIdEmployee(employeeId, startDate, endDate);
    }

    public List<Reimbursement> filterByDateCategoryAndIdEmployee(String categoryId, String employeeId, String startDate, String endDate) {
        return reimbursementRepository.filterByDateCategoryAndIdEmployee(categoryId, employeeId, startDate, endDate);
    }

    public List<Reimbursement> filterStatusAdminOnHc(Boolean statusReject, Boolean statusOnHc, Boolean
            statusSuccess, Boolean statusOnFinance) {
        return reimbursementRepository.filterStatusAdminOnHc(statusReject, statusOnHc, statusSuccess, statusOnFinance);
    }

    public EmployeeResponseDashboard responseDashboard() {
        EmployeeResponseDashboard response = new EmployeeResponseDashboard();
        response.setCountEmployeeReimburse(Double.valueOf(reimbursementRepository.getCountEmployeeReimbursement()));
        response.setCountEmployeeActive(response.getCountEmployeeActive());
        response.setCountEmployee(response.getCountEmployee());
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

    //filter status_on_finance_true
    public List<Reimbursement> getStatusFinance() {
        return reimbursementRepository.getStatusFinance();
    }

    //filter status_on_finance_true and byCategoryId
    public List<Reimbursement> getStatusFinanceAndByCategoryId(String categoryId) {
        return reimbursementRepository.getStatusFinanceAndCategoryId(categoryId);
    }

    //filter status on_finance, on_hc and categoryId
    public List<Reimbursement>filterFinanceCategoryById(String categoryId) {
        return reimbursementRepository.filterFinanceCategoryById(categoryId);
    }

    //////cobaCoba
    public List<Reimbursement> reimbursementPage() {
        return  reimbursementRepository.findALL();
    }

    public Integer countPage(){
        return reimbursementRepository.getCountEmployeeReimbursement();
    }

    public List<Reimbursement> getPage(int offset){
        return reimbursementRepository.pageReimburse(offset);
    }

    //finance
    public Integer countPageFinance(){
        return reimbursementRepository.getCountEmployeeReimbursementFinance();
    }

    public List<Reimbursement> getPageFinance(int offset){
        return reimbursementRepository.pageReimburseFinance(offset);
    }

}