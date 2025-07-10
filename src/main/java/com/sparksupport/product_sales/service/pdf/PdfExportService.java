package com.sparksupport.product_sales.service.pdf;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PdfExportService {
    void exportProductPdf(HttpServletResponse response) throws IOException;
}