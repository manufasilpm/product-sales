package com.sparksupport.product_sales.controller.pdf;

import com.sparksupport.product_sales.service.pdf.PdfExportService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/export")
@RequiredArgsConstructor
public class ProductExportController {

    private final PdfExportService pdfExportService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/products/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void exportToPdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=product_report.pdf");
        pdfExportService.exportProductPdf(response);
    }
}
