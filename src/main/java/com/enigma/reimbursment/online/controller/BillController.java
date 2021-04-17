package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Bill;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.request.bill.ImageUploadRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.bill.BillResponse;
import com.enigma.reimbursment.online.services.BillService;
import com.enigma.reimbursment.online.services.FilesStorageService;
import com.enigma.reimbursment.online.services.FilesStorageServiceImpl;
import com.enigma.reimbursment.online.services.ReimbursementService;
import com.google.common.io.Files;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/bill")
@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    FilesStorageService storageService;

    @Autowired
    FilesStorageServiceImpl filesStorageService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ServletWebServerApplicationContext server;


    @PostMapping(value = "/{id}/upload/file", consumes = "multipart/form-data")
    public ResponseMessage uploadFile(@PathVariable String id, ImageUploadRequest file) throws IOException {
        System.out.println(file.getFile().getOriginalFilename());
        System.out.println(Files.getFileExtension(file.getFile().getOriginalFilename()));

        String[] allowedFile = {"pdf", "png", "jpeg", "jpg"};
        List<String> allowedList = new ArrayList<>(Arrays.asList(allowedFile));
        String extension = Files.getFileExtension(file.getFile().getOriginalFilename());
        if (allowedList.contains(extension)) {
            Integer port = server.getWebServer().getPort();
            Bill image = billService.filterByIdBill(id);
            if (image == null) {
                String message = "";
                String fileName = "employee-" + id + "." + Files.getFileExtension(file.getFile().getOriginalFilename());
                try {
                    storageService.save(file.getFile(), fileName);
                    Bill bill = new Bill();
                    Reimbursement entity = reimbursementService.findById(id);
                    bill.setReimbursementId(entity);
                    bill.setBillImage(fileName);
                    bill.setUser("employee");
                    bill.setUrl("http://10.10.14.109/bill/files/" + fileName);
                    billService.save(bill);
                    message = "Uploaded the file successfully: " + fileName;
                    return new ResponseMessage(200, message, null);
                } catch (Exception e) {
                    e.printStackTrace();
                    message = "Could not upload the file: " + fileName;
                    return ResponseMessage.error(417, message, null);
                }
            } else {
                return ResponseMessage.error(400, "IMAGE HAS BEEN UPLOADED", null);
            }
        } else {
            return ResponseMessage.error(400, file.getFile().getOriginalFilename()
                    + " format file upload is not allowed", null);
        }
    }


    @PutMapping(value = "/{id}/upload/file", consumes = "multipart/form-data")
    public ResponseMessage<BillResponse> updateFile(@PathVariable String id, ImageUploadRequest file) throws IOException {
        Bill image = billService.filterByIdBill(id);
        /* Remove file if exist */
        if(image!=null) {
            deleteFileByIdReimburseEmployee(id);
            billService.RemoveById(image.getId());
        }

        String message = "";
        String fileName = "employee-" + id + "." + Files.getFileExtension(file.getFile().getOriginalFilename());

        String[] allowedFile = {"pdf", "png", "jpeg", "jpg"};
        List<String> allowedList = new ArrayList<>(Arrays.asList(allowedFile));
        String extension = Files.getFileExtension(file.getFile().getOriginalFilename());
        if (allowedList.contains(extension)) {
            try {

                Reimbursement entity = reimbursementService.findById(id);
                storageService.save(file.getFile(), fileName);

                Integer port = server.getWebServer().getPort();
                Bill bill = new Bill();
                bill.setReimbursementId(entity);
                bill.setBillImage(fileName);
                bill.setUser("employee");
                bill.setUrl("http://10.10.14.109:" + port + "/bill/files/" + fileName);
                billService.save(bill);

                /* Set Response */
                message = "Update the file successfully: " + fileName;
                BillResponse response = new BillResponse();
                response.setUrl(bill.getUrl());
                response.setBillImage(bill.getBillImage());
                return new ResponseMessage(200, message, response);
            } catch (Exception e) {
                message = "Could not upload the file: " + fileName;
                return ResponseMessage.error(417, message, null);
            }
        } else {
            message = "Format file is not allowed";
            return new ResponseMessage(400, "Bad Request", message);
        }
    }


    @PutMapping(value = "/{id}/upload/file/admin", consumes = "multipart/form-data")
    public ResponseMessage<BillResponse> updateFileAdmin(@PathVariable String id, ImageUploadRequest file) throws IOException {
        Bill image = billService.filterByIdBillAdmin(id);

        /* Remove file if exist */
        if(image!=null) {
            deleteFileByIdReimburse(id);
            billService.RemoveById(image.getId());
        }

        String message = "";
        String fileName = "admin-" + id + "." + Files.getFileExtension(file.getFile().getOriginalFilename());

        /* Validation File */
        String[] allowedFile = {"pdf", "png", "jpeg", "jpg"};
        List<String> allowedList = new ArrayList<>(Arrays.asList(allowedFile));
        String extension = Files.getFileExtension(file.getFile().getOriginalFilename());

        if (allowedList.contains(extension)) {
            try {
                /* Save reimburse */
                Reimbursement entity = reimbursementService.findById(id);
                storageService.save(file.getFile(), fileName);

                /* Set Bill */
                Integer port = server.getWebServer().getPort();
                Bill bill = new Bill();
                bill.setReimbursementId(entity);
                bill.setBillImage(fileName);
                bill.setUser("admin");
                bill.setUrl("http://10.10.14.109:" + port + "/bill/files/" + fileName);
                billService.save(bill);

                /* Set Response */
                message = "Update the file successfully: " + fileName;
                BillResponse response = new BillResponse();
                response.setUrl(bill.getUrl());
                response.setBillImage(bill.getBillImage());
                return new ResponseMessage(200, message, response);
            } catch (Exception e) {
                message = "Could not upload the file: " + fileName;
                return ResponseMessage.error(417, message, null);
            }
        } else {
            message = "Format file is not allowed";
            return new ResponseMessage(400, "Bad Request", message);
        }
    }


    @GetMapping("/files")
    public ResponseMessage<List<BillResponse>> getListFiles() {
        List<BillResponse> billInfo = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(BillController.class, "getFile", path.getFileName().toString()).build().toString();

            return new BillResponse(filename, url);
        }).collect(Collectors.toList());

        return ResponseMessage.success(billInfo);
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        System.out.println(file.getFilename());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @GetMapping("/{id}/file")
    public ResponseMessage findFileByIdReimburse(@PathVariable String id) {
        Bill bill = billService.filterByIdBillAdmin(id);
        if (bill == null) {
            return new ResponseMessage(404, "File not found");
        }
        return new ResponseMessage(200, "OK", bill);
    }


    @GetMapping("/{id}/file/employee")
    public ResponseMessage findFileByIdReimburseEmployee(@PathVariable String id) {
        Bill bill = billService.filterByIdBill(id);
        if (bill == null) {
            return new ResponseMessage(404, "File not found");
        }
        return new ResponseMessage(200, "OK", bill);
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


    public void deleteFileByIdReimburse(String id) {
        Integer port = server.getWebServer().getPort();
        Bill bill = billService.filterByIdBillAdmin(id);
        filesStorageService.deleteById(bill.getBillImage(), port);
    }


    public void deleteFileByIdReimburseEmployee(String id) {
        Integer port = server.getWebServer().getPort();
        Bill bill = billService.filterByIdBill(id);
        filesStorageService.deleteById(bill.getBillImage(), port);
    }

}
