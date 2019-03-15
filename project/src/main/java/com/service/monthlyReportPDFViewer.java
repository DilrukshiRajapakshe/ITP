/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfWriter;
import com.model.monthlyProfitReport;

public class monthlyReportPDFViewer extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map model, Document document,PdfWriter writer, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 
		response.setHeader("Content-Disposition", "attachment; filename=\"MonthlyReport.pdf\""); //This code responsible for direct download PDF file
		  
		@SuppressWarnings("unchecked")
		ArrayList list = (ArrayList) model.get("result");
		
          document.open();
          
          Font f1 = FontFactory.getFont(FontFactory.COURIER, 50, Font.BOLD, new CMYKColor(0,79,81,83));
          Font f = new Font();
          f.setStyle(Font.BOLD);
          f.setSize(5);
          monthlyProfitReport mpr = new monthlyProfitReport();
          String d1 = mpr.getStartDate();
          String d2 = mpr.getEndDate();
          Paragraph p1 = new Paragraph("Report", f1);
          p1.setAlignment(Element.ALIGN_CENTER);
          document.add(p1);
          
          Paragraph p2 = new Paragraph();

		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		  LocalDate localDate = LocalDate.now();
		  p2.add("Date : "+dtf.format(localDate));	
		  document.add(p2);
		  
		  Paragraph p3 = new Paragraph();
		 Calendar cal = Calendar.getInstance();
	     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
		  p3.add("Time : "+sdf.format(cal.getTime()));
		  
		  	
		  document.add(p3);
		  
		  Table t1 = new Table(2);
		  t1.addCell(" Date ");
		  t1.addCell(" Profit of the Day ");
		  
		  
		 
		  int count = 0;
		 
		  java.util.Iterator itr = list.iterator();
		  
          while (itr.hasNext()) {          
            count++;
            
            ArrayList listView = (ArrayList) itr.next();
            
            String Date = (String) listView.get(0);
          	String tot = (String) listView.get(1);
          	
              
		   t1.addCell(Date);
		   t1.addCell(tot);

          }
          
		 
		  document.add(t1);
		  
          document.close();
	}
	





}
