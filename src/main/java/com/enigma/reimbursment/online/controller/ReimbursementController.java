package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.model.reimbursement.ReimbursementModelFinance;
import com.enigma.reimbursment.online.models.model.reimbursement.ReimbursementModelHc;
import com.enigma.reimbursment.online.models.model.reimbursement.RequestModelEmployee;
import com.enigma.reimbursment.online.models.pagination.PageList;
import com.enigma.reimbursment.online.models.request.reimbursements.*;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import com.enigma.reimbursment.online.models.model.reimbursement.FinanceResponse;
import com.enigma.reimbursment.online.models.model.reimbursement.ReimburseEmployeeResponse;
import com.enigma.reimbursment.online.models.search.reimbursmentsearch.ReimbursementSearch;
import com.enigma.reimbursment.online.services.CategoryService;
import com.enigma.reimbursment.online.services.EmployeeService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import com.enigma.reimbursment.online.services.SendEmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("reimburse")
@RestController
public class ReimbursementController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping
    public ResponseMessage<ReimbursementResponse> add(@RequestBody FindClaimReimburse model) {
        Reimbursement reimbursement = modelMapper.map(model, Reimbursement.class);
        reimbursement.setDateOfClaimSubmission(LocalDate.now());
        if (model.getStartDate() == null || model.getEndDate() == null) {
            reimbursement.setStartDate(null);
            reimbursement.setEndDate(null);
        } else {
            reimbursement.setStartDate(LocalDate.parse(model.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            reimbursement.setEndDate(LocalDate.parse(model.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }

        Employee employee = employeeService.findById(model.getEmployeeId());
        reimbursement.setEmployeeId(employee);
        reimbursement = reimbursementService.save(reimbursement);

        Category category = categoryService.findById(model.getCategoryId());
        reimbursement.setCategoryId(category);
        reimbursement = reimbursementService.save(reimbursement);

        ReimbursementResponse data = modelMapper.map(reimbursement, ReimbursementResponse.class);
        return ResponseMessage.success(data);

    }


    //    filter by id category and id employee for employee
    @PostMapping("/filter-category-employee")
    public ResponseMessage<List<ReimbursementResponse>> filterCategoryIdEmployee(@RequestBody FindCategoryRequestEmployee model) {
        List<Reimbursement> reimbursements = reimbursementService.filterCategoryByIdEmployee(model.getCategoryId(), model.getEmployeeId());
        List<ReimbursementResponse> reimbursementResponses = reimbursements.stream().map(
                e -> modelMapper.map(e, ReimbursementResponse.class))
                .collect(Collectors.toList());
        if (reimbursements.isEmpty()) {
            return ResponseMessage.error(200, "Data Tidak Ditemukan", null);
        }
        System.out.println(reimbursements);
        return ResponseMessage.success(reimbursementResponses);
    }


    //filter by id category for admin
    @PostMapping("/filter-category")
    public ResponseMessage<List<Reimbursement>> filterCategory(@RequestBody FindCategoryRequest model) {
        System.out.println(model);
        List<Reimbursement> reimbursements = reimbursementService.filterCategoryById(model.getCategoryId());
        if (reimbursements == null) {
            throw new EntityNotFoundException();
        }
        System.out.println(reimbursements);
        return ResponseMessage.success(reimbursements);
    }


    //filter by id employee for admin hc
    @PostMapping("/filter-employee-admin")
    public ResponseMessage<List<Reimbursement>> filterIdEmployee(@RequestBody FindEmployeeRequest request) {
        List<Reimbursement> reimbursements = reimbursementService.filterByIdEmployee(request.getEmployeeId());
        if (reimbursements == null) {
            throw new EntityNotFoundException();
        }
        return ResponseMessage.success(reimbursements);
    }

    //    filter status adminOnHc (success,reject,onFinance,hc)
    @PostMapping("/filter-status-admin")
    public ResponseMessage<List<Reimbursement>> filterStatusAdmin(@RequestBody FindStatusAdminRequest model) {

        List<Reimbursement> reimbursements = reimbursementService.filterStatusAdminOnHc(model.getStatusReject()
                , model.getStatusOnHc(), model.getStatusSuccess(), model.getStatusOnFinance());

        System.out.println("reimbursement :" + reimbursements);
        return ResponseMessage.success(reimbursements);
    }


    //filter by date
    @PostMapping("/date")
    public ResponseMessage<List<Reimbursement>> filterByDateClaim(@RequestBody FindDateOfClaim model) throws ParseException {
        Reimbursement reimbursement = new Reimbursement();
        List<Reimbursement> reimbursements = reimbursementService.filterByDateOfClaim(model.getStartDate(), model.getEndDate());
        return ResponseMessage.success(reimbursements);
    }


    //filter by date,category and id employee for admin hc / employee
    @PostMapping("/filter-date-category-employee")
    public ResponseMessage<List<Reimbursement>> filterByDateCategoryAndEmployee(@RequestBody FindDateCategoryAndIdEmployee model) throws ParseException {
        List<Reimbursement> reimbursements = reimbursementService.filterByDateCategoryAndIdEmployee(model.getCategoryId(), model.getEmployeeId(), model.getStartDate(), model.getEndDate());
        System.out.println("test: " + reimbursements);
        return ResponseMessage.success(reimbursements);
    }


    //    //filter-date-employee for admin hc/employee
    @PostMapping("/filter-date-employee")
    public ResponseMessage<List<Reimbursement>> filterByDateIdEmployee(@RequestBody FindDateAndIdEmployee request) throws ParseException {
        Reimbursement reimbursement = new Reimbursement();
        List<Reimbursement> reimbursements = reimbursementService
                .filterByDateAndIdEmployee(request.getEmployeeId(), request.getStartDate(), request.getEndDate());
        System.out.println("reimbursement:" + reimbursements);
        return ResponseMessage.success(reimbursements);
    }


    //edit reimburse for admin hc
    @PutMapping("/{id}")
    public ResponseMessage<ReimbursementResponse> edit(@PathVariable String id, @RequestBody ReimbursementRequest model) {
        Reimbursement entity = reimbursementService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        entity.setDateOfClaimSubmission(LocalDate.parse(model.getDateOfClaimSubmission(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        entity.setDisbursementDate(LocalDate.parse(model.getDisbursementDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        entity.setStartDate(LocalDate.parse(model.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        entity.setEndDate(LocalDate.parse(model.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Employee employee = employeeService.findById(model.getEmployeeId());
        entity.setEmployeeId(employee);
        modelMapper.map(model, entity);

        Category category = categoryService.findById(model.getCategoryId());
        entity.setCategoryId(category);
        modelMapper.map(model, entity);

        entity = reimbursementService.save(entity);

        ReimbursementResponse data = modelMapper.map(entity, ReimbursementResponse.class);
        return ResponseMessage.success(data);

    }


    @GetMapping("/{id}")
    public ResponseMessage<ReimbursementResponse> findById(@PathVariable String id) {
        Reimbursement entity = reimbursementService.findById(id);
        if (entity == null)
            throw new EntityNotFoundException();
        ReimbursementResponse data = modelMapper.map(entity, ReimbursementResponse.class);
        return ResponseMessage.success(data);

    }


    @GetMapping
    public ResponseMessage<PageList<ReimbursementResponse>> findAll(@Valid ReimbursementSearch request) {

        System.out.println("request " + request);

        Reimbursement reimbursement = modelMapper.map(request, Reimbursement.class);
        System.out.println("reimbursement" + reimbursement);

        Page<Reimbursement> pagination = reimbursementService
                .findAll(reimbursement, request.getPage(),
                        request.getSize(), request.getSort());
        System.out.println("pagination:" + pagination);

        List<Reimbursement> reimbursements = pagination.toList();

        List<ReimbursementResponse> reimburseResponsePageList = reimbursements.stream()
                .map(e -> modelMapper.map(e, ReimbursementResponse.class))
                .collect(Collectors.toList());
        System.out.println("pagedlist:" + reimburseResponsePageList);

        PageList<ReimbursementResponse> response = new PageList(reimburseResponsePageList,
                pagination.getNumber(), pagination.getSize(), pagination.getTotalElements());

        System.out.println("response" + response);
        return new ResponseMessage(200, "OK", response);
    }


    //UNTUK ADMIN HC
    @PutMapping("/{id}/hc")
    public ResponseMessage<ReimbursementModelHc> editAdminHc(@PathVariable String id, @RequestBody ReimbursementModelHc model) {
        Reimbursement entity = reimbursementService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        Employee employee = employeeService.findById(entity.getEmployeeId().getId());
        entity.setEmployeeId(employee);
        modelMapper.map(model, entity);

        Category category = categoryService.findById(entity.getCategoryId().getId());
        entity.setCategoryId(category);
        modelMapper.map(model, entity);

        entity = reimbursementService.save(entity);

        ReimbursementModelHc data = modelMapper.map(entity, ReimbursementModelHc.class);
        return ResponseMessage.success(data);
    }


    //untuk employee
    @PutMapping("/{id}/employee")
    public ResponseMessage<ReimburseEmployeeResponse> editEmployee
    (@PathVariable String id, @RequestBody RequestModelEmployee model) throws ParseException {
        Reimbursement entity = reimbursementService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        entity.setDateOfClaimSubmission(LocalDate.parse(model.getDateOfClaimSubmission(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));


        Employee employee = employeeService.findById(entity.getEmployeeId().getId());
        entity.setEmployeeId(employee);

        Category category = categoryService.findById(entity.getCategoryId().getId());
        entity.setCategoryId(category);
        modelMapper.map(model, entity);

        entity = reimbursementService.save(entity);

        ReimburseEmployeeResponse data = modelMapper.map(entity, ReimburseEmployeeResponse.class);
        return ResponseMessage.success(data);
    }

    //edit reimburse untuk finance
    @PutMapping("/{id}/finance")
    public ResponseMessage<Reimbursement> editFinance(@PathVariable String id, @RequestBody ReimbursementModelFinance model) throws ParseException, MessagingException {
        Reimbursement entity = reimbursementService.findById(id);
        System.out.println("id:"+id);
        Employee employee = employeeService.findById(entity.getEmployeeId().getId());
        System.out.println("idEmployee:" +entity.getEmployeeId().getId());
        entity.setEmployeeId(employee);
        entity.setDisbursementDate(LocalDate.now());

        Integer claim = entity.getClaimFee();
        String categoryName = entity.getCategoryId().getCategoryName();

        Integer borne = 0;
        switch (categoryName) {
            case "Kacamata":
                borne = employee.getGrade().getGlasessCost();
                break;
            case "Pelatihan":
                borne = employee.getGrade().getTrainingCost();
                break;
            case "Melahirkan":
                borne = employee.getGrade().getGiveBirthCost();
                break;
            case "Perjalanan Dinas":
                borne = employee.getGrade().getOfficialTravelCost();
                break;
            case "Asuransi":
                borne = employee.getGrade().getInsuranceCost();
                break;
            default:
                break;

        }

        if (claim>borne) {
            entity.setBorneCost(borne);
        }
        else {
            entity.setBorneCost(claim);
        }

        System.out.println(entity);

        modelMapper.map(model, entity);

        Category category = categoryService.findById(entity.getCategoryId().getId());
        entity.setCategoryId(category);
        modelMapper.map(model, entity);

        entity = reimbursementService.save(entity);

        if(entity.getStatusSuccess() == true){
            sendEmailService.sendEmailNotification(entity);
        }

//        FinanceResponse data = modelMapper.map(entity, FinanceResponse.class);
        return ResponseMessage.success(entity);
    }


    //status admin finance
    @GetMapping("/filter-status-finance")
    public ResponseMessage<List<Reimbursement>> getStatusFinance() {
        List<Reimbursement> reimbursements = reimbursementService.getStatusFinance();
        return new ResponseMessage(200, "OK", reimbursements);
    }

    //find status admin finance and by CategoryId
    @PostMapping("/filter-status-finance-category")
    public ResponseMessage<List<Reimbursement>> getStatusFinanceAndByCategoryId(@RequestBody FilterFinanceAndCategory model) {
        List<Reimbursement> reimbursements = reimbursementService.getStatusFinanceAndByCategoryId(model.getCategoryId());
        return new ResponseMessage(200, "OK", reimbursements);
    }

    //filter category finance
    @PostMapping("/filter-category-finance")
    public ResponseMessage<List<Reimbursement>> filterFinanceCategoryById(@RequestBody FilterFinanceAndCategory model) {
        List<Reimbursement> reimbursements = reimbursementService.getStatusFinanceAndByCategoryId(model.getCategoryId());
        if(reimbursements == null) {
            throw new EntityNotFoundException();
        }
        return ResponseMessage.success(reimbursements);

    }

    //pagination mantap ini bisa
    @GetMapping("/page")
    public ResponseMessage<PageList<Reimbursement>> findAll(PageReimburse request){
        List<Reimbursement> reimbursements = reimbursementService.getPage(request.getPage()*10);
        List<Reimbursement> models = reimbursements.stream().map(e->modelMapper.map(e,Reimbursement.class))
                .collect(Collectors.toList());
        Long totalElement = Long.valueOf(reimbursementService.countPage());
        return getPageListResponseMessage(request, models, totalElement);
    }

    private ResponseMessage<PageList<Reimbursement>> getPageListResponseMessage(PageReimburse request, List<Reimbursement> models, Long totalElement) {
        PageList<Reimbursement> data = new PageList<>();
        data.setList(models);
        data.setPage(request.getPage());
        data.setSize(request.getSize());
        data.setTotal(totalElement);
        return ResponseMessage.success(data);
    }

    //finance
    @GetMapping("/page/finance")
    public ResponseMessage<PageList<Reimbursement>> findAllFinance(PageReimburse request){
        List<Reimbursement> reimbursements = reimbursementService.getPageFinance(request.getPage()*10);
        List<Reimbursement> models = reimbursements.stream().map(e->modelMapper.map(e,Reimbursement.class))
                .collect(Collectors.toList());
        Long totalElement = Long.valueOf(reimbursementService.countPageFinance());
        return getPageListResponseMessage(request, models, totalElement);
    }

}
