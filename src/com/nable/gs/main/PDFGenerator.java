package com.nable.gs.main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	
	public static void main(String[] args) {

	        String htmlFilePath = "C:\\Users\\Gihan\\Downloads\\04 Gold Loan Application Form-Template.html";
	        try {
	            // Load HTML from file
	            String html = new String(Files.readAllBytes(Paths.get(htmlFilePath)));

	            PDFGenerator generator = new PDFGenerator();
	            String pdfBase64 = generator.getPDFOutputStream(html);

	            System.out.println("Base64 PDF: " + pdfBase64);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    }

}
