package com.crud.controller;


import com.crud.entity.Invoice;
import com.crud.exception.InvoiceNotFoundException;
import com.crud.service.InvoiceService;
import com.crud.util.InvoiceUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:4200") //Required in case of Angular Client
public class InvoiceRestController {

    Logger logger = LoggerFactory.getLogger(InvoiceRestController.class);

    @Autowired
    private InvoiceService service;

    @Autowired
    private InvoiceUtil util;

    /**
     * Takes Invoice Object as input and returns save Status as ResponseEntity<String>
     */
    @Operation(summary = "Add the Invoice")
    @PostMapping("/invoices")
    public ResponseEntity<String> saveInvoice(@RequestBody Invoice inv){
        ResponseEntity<String> resp = null;
        try{
            Long id = service.saveInvoice(inv);
            logger.info(String.valueOf(id));
            resp= new ResponseEntity<String>(
                    "Invoice '"+id+"' created",HttpStatus.CREATED); //201-created
        } catch (Exception e) {
            e.printStackTrace();
            logger.trace(e.getMessage());
            resp = new ResponseEntity<String>(
                    "Unable to save Invoice",
                    HttpStatus.INTERNAL_SERVER_ERROR); //500-Internal Server Error
        }
        return resp;
    }

    /**
     * To retrieve all Invoices, returns data retrieval Status as ResponseEntity<?>
     */
    @Operation(summary = "Get All Invoice")
    @GetMapping("/invoices")
    public ResponseEntity<?> getAllInvoices() {
        ResponseEntity<?> resp=null;
        try {

            List<Invoice> list= service.getAllInvoices();
            logger.info(list.toString());
            resp= new ResponseEntity<List<Invoice>>(list,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.trace(e.getMessage());
            resp = new ResponseEntity<String>(
                    "Unable to get Invoice",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resp;
    }

    /**
     * To retrieve one Invoice by providing id, returns Invoice object & Status as ResponseEntity<?>
     */
    @Operation(summary = "Get Invoice by ID")
    @GetMapping("/invoices/{id}")
    public ResponseEntity<?> getOneInvoice(@PathVariable Long id){
        ResponseEntity<?> resp= null;
        try {
            Invoice inv= service.getOneInvoice(id);
            resp= new ResponseEntity<Invoice>(inv,HttpStatus.OK);
        }catch (InvoiceNotFoundException nfe) {
            throw nfe;
        }catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>(
                    "Unable to find Invoice",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resp;
    }

    /**
     * To delete one Invoice by providing id, returns Status as ResponseEntity<String>
     */
    @Operation(summary = "Delete Invoice by ID")
    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            service.deleteInvoice(id);
            resp= new ResponseEntity<String> (
                    "Invoice '"+id+"' deleted",HttpStatus.OK);

        } catch (InvoiceNotFoundException nfe) {
            throw nfe;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "Unable to delete Invoice", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }

    /**
     * To modify one Invoice by providing id, updates Invoice object & returns Status as ResponseEntity<String>
     */
    @Operation(summary = "Update Invoice by ID")
    @PutMapping("/invoices/{id}")
    public ResponseEntity<String> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice){

        ResponseEntity<String> resp = null;
        try {
            //db Object
            Invoice inv= service.getOneInvoice(id);
            //copy non-null values from request to Database object
            util.copyNonNullValues(invoice, inv);
            //finally update this object
            service.updateInvoice(inv);
            resp = new ResponseEntity<String>(
                    "Invoice '"+id+"' Updated",
                    HttpStatus.RESET_CONTENT); //205- Reset-Content(PUT)

        } catch (InvoiceNotFoundException nfe) {
            throw nfe; // re-throw exception to handler
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>(
                    "Unable to Update Invoice",
                    HttpStatus.INTERNAL_SERVER_ERROR); //500-ISE
        }
        return resp;
    }

    /**
     * To update one Invoice just like where clause condition, updates Invoice object & returns Status as ResponseEntity<String>
     */

    @Operation(summary = "Update the invoice number by using Id")
    @PatchMapping("/invoices/{id}/{number}")
    public ResponseEntity<String> updateInvoiceNumberById(
            @PathVariable Long id,
            @PathVariable String number
    )
    {
        ResponseEntity<String> resp = null;
        try {
            service.updateInvoiceNumberById(number, id);
            resp = new ResponseEntity<String>(
                    "Invoice '"+number+"' Updated",
                    HttpStatus.PARTIAL_CONTENT); //206- Reset-Content(PUT)

        } catch(InvoiceNotFoundException pne) {
            throw pne; // re-throw exception to handler
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>(
                    "Unable to Update Invoice",
                    HttpStatus.INTERNAL_SERVER_ERROR); //500-ISE
        }
        return resp;
    }

}
