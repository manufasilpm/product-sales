package com.sparksupport.product_sales.service.impl.pdf;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;
import com.sparksupport.product_sales.model.product.Product;
import com.sparksupport.product_sales.repository.product.ProductRepository;
import com.sparksupport.product_sales.service.pdf.PdfExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PdfExportServiceImpl implements PdfExportService {

    private final ProductRepository productRepository;

    @Override
    public void exportProductPdf(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, Color.BLACK);
        Paragraph title = new Paragraph("Product Report", titleFont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(20f);
        document.add(title);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1.5f, 2.5f, 3f, 2f, 2f, 2f});
        table.setSpacingBefore(10);

        writeHeader(table);
        writeData(table);

        document.add(table);
        document.close();
    }

    private void writeHeader(PdfPTable table) {
        Stream.of("ID", "Name", "Description", "Price", "Quantity", "Revenue")
                .forEach(header -> {
                    PdfPCell cell = new PdfPCell();
                    cell.setBackgroundColor(Color.LIGHT_GRAY);
                    cell.setPadding(5);
                    cell.setPhrase(new Phrase(header));
                    table.addCell(cell);
                });
    }

    private void writeData(PdfPTable table) {
        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            table.addCell(String.valueOf(product.getId()));
            table.addCell(product.getName());
            table.addCell(product.getDescription());
            table.addCell(String.valueOf(product.getPrice()));
            table.addCell(String.valueOf(product.getQuantity()));
            table.addCell(String.valueOf(product.getRevenue()));
        }
    }
}