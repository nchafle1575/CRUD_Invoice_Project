package com.crud.util;


import com.crud.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class InvoiceUtil {

    public Invoice  CalculateFinalAmountIncludingGST (Invoice inv) {
        var amount=inv.getAmount();
        var gst= 0.1;
        var finalAmount=amount+(amount*gst);
        inv.setFinalAmount(finalAmount);
        return inv;
    }

    public void copyNonNullValues(Invoice req, Invoice db) {

        if(req.getName() !=null) {
            db.setName(req.getName());
        }

        if(req.getAmount() !=null) {
            db.setAmount(req.getAmount());
        }

        if(req.getNumber() !=null) {
            db.setNumber(req.getNumber());
        }

        if(req.getReceivedDate() !=null) {
            db.setReceivedDate(req.getReceivedDate());
        }

        if(req.getType() !=null) {
            db.setType(req.getType());
        }

        if(req.getVendor() !=null) {
            db.setVendor(req.getVendor());
        }

        if(req.getComments() !=null) {
            db.setComments(req.getComments());
        }
    }
}