package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.models.request.login.FindByEmail;
import com.enigma.reimbursment.online.models.request.login.ResetPasswordRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.services.CategoryService;
import com.enigma.reimbursment.online.services.EmployeeService;
import com.enigma.reimbursment.online.services.LoginService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import com.google.common.hash.Hashing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;

@CrossOrigin
@RestController
@RequestMapping
public class UtilController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/dashboard")
    public ResponseMessage<EmployeeResponseDashboard> employeeDashboards(){
        EmployeeResponseDashboard responseDashboard = employeeService.employeeDashboard();
        responseDashboard.setCountDataDashboard((responseDashboard.getCountEmployeeActive()/ responseDashboard.getCountEmployee())*100);
        return ResponseMessage.success(responseDashboard);

    }

    @PostMapping("/email")
    public ResponseMessage<Login> findByEmailAndRoleId(@RequestBody FindByEmail model) throws ParseException {
        Login login = loginService.findByEmail(model.getEmail());
        return ResponseMessage.success(login);
    }

    @PostMapping("/reset-password")
    public ResponseMessage<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        loginService.resetPassword2(request.getEmail(), encode(request.getPassword()));
        return new ResponseMessage(200, "Success");
    }

    public String encode(String password){
        return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }

}
