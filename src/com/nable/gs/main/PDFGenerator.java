package com.nable.gs.main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

public class PDFGenerator {

    public String getPDFOutputStream(String html) {

        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
        String encodedString = "";

        try {
            ConverterProperties props = new ConverterProperties();

            PdfWriter writer = new PdfWriter(pdfStream);
            PdfDocument pdfDoc = new PdfDocument(writer);

            Document document = new Document(pdfDoc, PageSize.A4);
            document.setMargins(0, 0, 0, 0);

            HtmlConverter.convertToPdf(html, pdfDoc, props);

            document.close();

            byte[] encoded = Base64.encodeBase64(pdfStream.toByteArray());
            encodedString = new String(encoded);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return encodedString;
    }
}
