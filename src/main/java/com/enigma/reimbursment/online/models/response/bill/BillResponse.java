package com.enigma.reimbursment.online.models.response.bill;

import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.web.multipart.MultipartFile;

public class BillResponse {

    private String billImage;
    private String url;

    public String getUrl() {
        return url;
    }

    public BillResponse() {
    }

    public BillResponse(String billImage, String url) {
        this.billImage = billImage;
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBillImage() {
        return billImage;
    }

    public void setBillImage(String billImage) {
        this.billImage = billImage;
    }



}
