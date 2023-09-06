package com.java.FacturacionToval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.FacturacionToval.model.InvoiceDetail;
import com.java.FacturacionToval.model.InvoiceDetailDTO;
import com.java.FacturacionToval.repository.InvoiceDetailRepository;

import java.util.List;

@Service
public class InvoiceDetailService {
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public void saveInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception {
        invoiceDetailRepository.save(invoiceDetail);
    }

    public List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(int invoice_id) throws Exception {
        return invoiceDetailRepository.getInvoiceDetailsByInvoiceId(invoice_id);
    }

    public List<InvoiceDetail> getInvoiceDetailsByProductId(int prod_id) throws Exception {
        return invoiceDetailRepository.getInvoiceDetailsByProductId(prod_id);
    }

    public void nullProduct(int id) throws Exception {
        List<InvoiceDetail> invoiceDetailsList = getInvoiceDetailsByProductId(id);
        if (invoiceDetailsList.isEmpty()) {
            System.out.println("OK");
        } else {
            for (InvoiceDetail invoice : invoiceDetailsList) {
                invoice.setProduct(null);
            }
        }
    }
}
