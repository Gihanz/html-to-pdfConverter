package com.nable.gs.main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import com.itextpdf.html2pdf.HtmlConverter;

public class PDFGenerator {
	   
    public String getPDFOutputStream (String HTML) {
    	
    	ByteArrayOutputStream pdfStreamD = new ByteArrayOutputStream();
    	String encodedString = "";
		try {
			HtmlConverter.convertToPdf(HTML, pdfStreamD);
			byte[] encoded = Base64.encodeBase64(pdfStreamD.toByteArray());
			encodedString = new String(encoded);

		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	System.out.println(encodedString);
		return encodedString;
    }

}
