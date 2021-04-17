package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, String> {

    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId", nativeQuery = true)
    List<Reimbursement> filterCategoryById(@Param("categoryId") String categoryId);

    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId AND id_employee = :employeeId", nativeQuery = true)
    List<Reimbursement> filterCategoryByIdEmployee(@Param("categoryId") String categoryId, @Param("employeeId") String employeeId);


    //filter by date
    @Query(value = "SELECT * FROM reimbursement WHERE date_of_claim_submission  BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Reimbursement> filterByDateOfClaim(@Param("startDate") String startDate,
                                            @Param("endDate") String endDate);

    //filter by id employee
    @Query(value = "SELECT * FROM reimbursement WHERE id_employee = :employeeId", nativeQuery = true)
    List<Reimbursement> filterByIdEmployee(@Param("employeeId") String employeeId);

    //filter by date,category and id employee
    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId AND id_employee = :employeeId AND date_of_claim_submission BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Reimbursement> filterByDateCategoryAndIdEmployee(@Param("categoryId") String categoryId,
                                                          @Param("employeeId") String employeeId,
                                                          @Param("startDate") String startDate,
                                                          @Param("endDate") String endDate);

    //filter by date(start-end) and id employee
    @Query(value = "SELECT * FROM reimbursement WHERE id_employee = :employeeId AND date_of_claim_submission BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Reimbursement> filterByDateAndIdEmployee(@Param("employeeId") String employeeId,
                                                  @Param("startDate") String startDate,
                                                  @Param("endDate") String endDate);

    //filter status on adminHc(status_onFinance,on hc,reject,success)
    @Query(value = "SELECT * FROM reimbursement WHERE status_reject = :statusReject AND status_on_hc = :statusOnHc AND status_success = :statusSuccess AND status_on_finance = :statusOnFinance", nativeQuery = true)
    List<Reimbursement> filterStatusAdminOnHc(@Param("statusReject") Boolean statusReject,
                                              @Param("statusOnHc") Boolean statusOnHc,
                                              @Param("statusSuccess") Boolean statusSuccess,
                                              @Param("statusOnFinance") Boolean statusOnFinance);

    @Query(value = "SELECT COUNT(id) FROM reimbursement", nativeQuery = true)
    Integer getCountEmployeeReimbursement();

    //perhitungan dashboard untuk reimburse berdasarkan category claim
    @Query(value = "SELECT COUNT(id) FROM reimbursement where id_category = 1", nativeQuery = true)
    Integer getCountEmployeeReimbursementGlasses();

    @Query(value = "SELECT COUNT(id) FROM reimbursement where id_category = 2", nativeQuery = true)
    Integer getCountEmployeeReimbursementTraining();

    @Query(value = "SELECT COUNT(id) FROM reimbursement where id_category = 3", nativeQuery = true)
    Integer getCountEmployeeReimbursementGiveBirth();

    @Query(value = "SELECT COUNT(id) FROM reimbursement where id_category = 4", nativeQuery = true)
    Integer getCountEmployeeReimbursementOfficialTravel();

    @Query(value = "SELECT COUNT(id) FROM reimbursement where id_category = 5", nativeQuery = true)
    Integer getCountEmployeeReimbursementInsurance();

    //filter status_on_finance_true
    @Query(value = "SELECT * FROM reimbursement WHERE status_on_finance = true", nativeQuery = true)
    List<Reimbursement> getStatusFinance();

    //filter status_on_finance_true and byCategoryId
    @Query(value = "SELECT * FROM reimbursement WHERE status_on_finance = true AND id_category = :categoryId", nativeQuery = true)
    List<Reimbursement> getStatusFinanceAndCategoryId(@Param("categoryId") String categoryId);

    //filter status on_finance= true and status on hc true and categoryId
    @Query(value = "SELECT * FROM reimbursement WHERE id_category = :categoryId AND status_on_finance = true AND status_on_hc = true", nativeQuery = true)
    List<Reimbursement> filterFinanceCategoryById(@Param("categoryId") String categoryId);

    //pagination
    @Query(value = "SELECT*FROM reimbursement ",
    countQuery = "SELECT count(id) FROM reimbursement",nativeQuery = true)
    List<Reimbursement> findALL();

    //page
    @Query(value = "SELECT * FROM reimbursement LIMIT 10 OFFSET :offset",nativeQuery = true)
    List<Reimbursement>pageReimburse(@Param("offset") Integer offset);

    @Query(value = "SELECT COUNT(id) FROM reimbursement WHERE status_success = true",nativeQuery = true)
    Integer getCountStatusSuccessReimbursementEmployee();

    @Query(value = "SELECT COUNT(id) FROM reimbursement WHERE status_success = false",nativeQuery = true)
    Integer getCountStatusProcessReimbursementEmployee();

    //buat finance
    @Query(value = "SELECT * FROM reimbursement WHERE status_on_finance = true AND status_on_hc = true LIMIT 10 OFFSET :offset",nativeQuery = true)
    List<Reimbursement>pageReimburseFinance(@Param("offset") Integer offset);

    @Query(value = "SELECT COUNT(id) FROM reimbursement  WHERE status_on_finance = true AND status_on_hc = true", nativeQuery = true)
    Integer getCountEmployeeReimbursementFinance();
}
