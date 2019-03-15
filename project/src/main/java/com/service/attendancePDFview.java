/** IT17119122
 * Liyanage I.M */
package com.service;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;

import com.lowagie.text.pdf.CMYKColor;


public class attendancePDFview extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map model, Document document,PdfWriter writer, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 
		response.setHeader("Content-Disposition", "attachment; filename=\"AttendanceReport.pdf\""); //This code responsible for direct download PDF file
		  
		@SuppressWarnings("unchecked")
		ArrayList list = (ArrayList) model.get("result");

          document.open();
          
          Font f1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Font.BOLD, new CMYKColor(0,832, 317, 315));
          Font f = new Font();
          f.setStyle(Font.BOLD);
          f.setSize(8);
          Paragraph p1 = new Paragraph("Attendance Report", f1);
          p1.setAlignment(Element.ALIGN_CENTER);
          document.add(p1);
          
          Paragraph p5 = new Paragraph("                 ");
		  document.add(p5);
		  
		  p1.setSpacingBefore(20f);
		  
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
		  
		  Paragraph p4 = new Paragraph("                 ");
		  document.add(p4);
		  
		  p3.setSpacingBefore(20f);
		  
		  PdfPTable t = new PdfPTable(6);
		  t.setWidthPercentage(100);
		  
	      PdfPCell cell = new PdfPCell();
	      cell.setPaddingBottom(20);
	      
	      t.addCell(" ID ");
		  t.addCell(" Name ");
		  t.addCell(" IN Time ");
		  t.addCell(" OUT Time ");
		  t.addCell(" Date ");
		  t.addCell(" Working Hours ");


		  int count = 0;
		  
		  java.util.Iterator itr = list.iterator();
          while (itr.hasNext()) {          
	           count++;
	           ArrayList search_list = (ArrayList) itr.next();
	           
	         String eid = (String) search_list.get(0);
          	String ename = (String) search_list.get(1);
          	String intime = (String) search_list.get(2);
          	String outtime = (String) search_list.get(3);
          	String year = (String) search_list.get(4);
          	String month = (String) search_list.get(5);
          	String day = (String) search_list.get(6);
          	String workHours = (String) search_list.get(7);
          	
	           cell.setPaddingBottom(20);   
			t.addCell(eid);
			t.addCell(ename);
			t.addCell(intime);
			t.addCell(outtime);
			t.addCell(year+"/"+month+"/"+day);
			t.addCell(workHours); 
          }
		  
		  document.add(t);
		
          document.close();
	}

}
