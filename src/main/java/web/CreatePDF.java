package web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {
		
   
    public void Create(String numberpdf) throws IOException {
      	
    	Document document = new Document(); //создание класса Document
    	
    	String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) {
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"webapps/CreatePDF/Check.pdf";
		String fontpath =abspath+"/webapps/CreatePDF/fonts/times.ttf";
    	
		try {	
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
					
		document.open(); 
		
		BaseFont times = null;
		try {
			times = BaseFont.createFont(fontpath, "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		String string_pdf = ""+ Calc.first_calcGet;
		Paragraph paragraph = new Paragraph();
	    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
	    
	    String string_pdf2 = "Дополнительный текст, который выводится в PDF. При этом нужно понимать, что можно указывать значения переменных, которые будут выводится в файл PDF.";
	    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
	
	    try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    
	  //организация перехода на следующую строку
		 paragraph.clear();
		 String string_pdf3 = " ";
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
    }
}
	    
	 
	    
	    
		
