package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.*;
import com.enigma.reimbursment.online.exceptions.NotEmailException;
import com.enigma.reimbursment.online.models.request.register.RegisterAdminRequest;
import com.enigma.reimbursment.online.models.request.register.RegisterEmployeeRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.register.RegisterResponse;
import com.enigma.reimbursment.online.services.*;
import com.google.common.hash.Hashing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@CrossOrigin
@RequestMapping("/register")
@RestController
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeContractService employeeContractService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SendEmailService sendEmailService;


    @PostMapping("/admin")
    public ResponseMessage<RegisterResponse> register_admin (@RequestBody @Valid RegisterAdminRequest request) {


        /* Save data register to table login */
        Login login = modelMapper.map(request, Login.class);
        Role role = roleService.findById(request.getRoleId());
        login.setRole(role);
        login = loginService.save(login);

        /* Save data register to table admin */
        Admin admin = new Admin();
        admin.setLogin(login);
        admin.setName(request.getName());
        adminService.save(admin);

        RegisterResponse response = modelMapper.map(login, RegisterResponse.class);
        return ResponseMessage.success(response);
    }


    @GetMapping("/verification/{token}")
    public RedirectView verification (@PathVariable String token, HttpServletResponse httpServletResponse) {
        Employee employee = employeeService.checkVerificationEmailToken(token);

        if (employee == null) {
            return null;
        } else {
            employeeService.changeIsVerifiedEmail(token);
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:3000/register-success");
            return redirectView;
        }
    }


    @PostMapping("/employee")
    public ResponseMessage<RegisterResponse> register_employee (@RequestBody @Valid RegisterEmployeeRequest model) throws MessagingException {

        String password = model.getPassword();
        String encode = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        model.setPassword(encode);
        /* Save data register to table login */
        if(!model.getEmail().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            throw new NotEmailException();
        }
        Login login = modelMapper.map(model, Login.class);
        Role role = roleService.findById(4);
        login.setRole(role);
        login = loginService.save(login);


        /* Save data register to table employee */
        String verificationToken = generateVerificationToken();
        Employee employee = new Employee();
        EmployeeContract contract = new EmployeeContract();
        employee.setLogin(login);
        employee.setEmailVerificationToken(verificationToken);
        employee = employeeService.save(employee);
        contract.setEmployeeId(employee);
        employeeContractService.save(contract);


        /* Send Mail */
        sendEmailService.sendEmailVerificationToken(verificationToken, model.getEmail());

        RegisterResponse response = modelMapper.map(login, RegisterResponse.class);
        return ResponseMessage.success(response);
    }


    protected String generateVerificationToken() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();

        while (stringBuilder.length() <= 20) { // length of the random string.
            int index = (int) (rnd.nextFloat() * characters.length());
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();
    }

}
