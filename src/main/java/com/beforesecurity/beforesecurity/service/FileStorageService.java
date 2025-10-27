package com.beforesecurity.beforesecurity.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import com.beforesecurity.beforesecurity.model.Task;

@Service
public class FileStorageService {


  // 🔹 Ruta absoluta en tu PC para guardar los PDF
    private static final String PDF_STORAGE_DIR = "C:/Users/PC/Documents/PDFGenerateAutomatically/";

    public String saveTaskPdf(Task task) throws IOException {
        // Crear directorio si no existe
        File dir = new File(PDF_STORAGE_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Nombre del archivo
        String fileName = "task_" + task.getId() + ".pdf";
        String filePath = PDF_STORAGE_DIR + fileName;

        // Crear PDF
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream content = new PDPageContentStream(document, page)) {
                content.beginText();
             content.setFont(PDType1Font.HELVETICA, 18);
                content.newLineAtOffset(50, 750);
                content.showText("Task Details");
                content.endText();

                content.beginText();
               content.setFont(PDType1Font.HELVETICA, 12);
                content.newLineAtOffset(50, 700);
                content.showText("Title: " + task.getTitle());
                content.newLineAtOffset(0, -20);
                content.showText("Description: " + task.getDescription());
                content.newLineAtOffset(0, -20);
                content.showText("Priority: " + task.getPriority());
                content.newLineAtOffset(0, -20);
                content.showText("Due Date: " + task.getDueDate());
                content.endText();
            }

            document.save(filePath);
        }

        return filePath;
    }






















}
