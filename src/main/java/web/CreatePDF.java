package web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class CreatePDF
 */
@WebServlet("/pdf")
public class CreatePDF extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		    String fonturl = "webapps/project14/assets/times.ttf";
	        //Set content type to application / pdf
	        //browser will open the document only if this is set
	        response.setContentType("application/pdf");
	        //Get the output stream for writing PDF object        
	        OutputStream out=response.getOutputStream();
	        BaseFont times = null;
	        Font font = null;
			try {
				times = BaseFont.createFont(fonturl, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
				font = new Font(times, 14, Font.NORMAL);
			} catch (DocumentException | IOException e) {
				e.printStackTrace();
			}
	        try {
	            Document document = new Document();
	            /* Basic PDF Creation inside servlet */
	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(new Paragraph("Результат подсчетов:", font));
	            document.add(new Paragraph(Calc.first_calcGet, font));
	            document.add(new Paragraph(Calc.second_calcGet, font));
	            document.add(new Paragraph("Банк: " + Calc.bankGet, font));
	            document.add(new Paragraph("Период реинвестирования: " + Calc.periodGet, font));
	            document.add(new Paragraph(Calc.radioGet + Calc.resultGet, font));
	            
	            document.close();
	        }
	                catch (DocumentException exc){
	                throw new IOException(exc.getMessage());
	                }
	        finally {            
	            out.close();
	        }
	    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}