package com.enigma.reimbursment.online.models.request.bill;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadRequest {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
