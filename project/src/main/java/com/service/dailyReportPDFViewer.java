/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Header;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfWriter;

public class dailyReportPDFViewer extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map model, Document document,PdfWriter writer, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 
		response.setHeader("Content-Disposition", "attachment; filename=\"DailyReport.pdf\""); //This code responsible for direct download PDF file
		  
		@SuppressWarnings("unchecked")
		ArrayList list = (ArrayList) model.get("result");
		
          document.open();
          
          Font f1 = FontFactory.getFont(FontFactory.COURIER, 50, Font.BOLD, new CMYKColor(0,79,81,83));
          Font f = new Font();
          f.setStyle(Font.BOLD);
          f.setSize(5);
          Paragraph p1 = new Paragraph("Daily Report", f1);
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
		  
		  Table t1 = new Table(5);
		  t1.addCell(" Date ");
		  t1.addCell(" Item Number ");
		  t1.addCell(" Item Name ");
		  t1.addCell(" Quantity ");
		  t1.addCell(" Profit ");
		 // t1.addCell(" Total Profit ");
		  //Table t2 = new Table(1);
		 // t2.addCell(" Total Profit ");
		  
		  int count = 0;
		 
		  java.util.Iterator itr = list.iterator();
		  
          while (itr.hasNext()) {          
            count++;
            
            ArrayList listView = (ArrayList) itr.next();
            
            String Date = (String) listView.get(0);
          	String ItemNo = (String) listView.get(1);
          	String itemName = (String) listView.get(2);
          	String qty = (String) listView.get(3);
          	String profit = (String) listView.get(4);
          	
              
		   t1.addCell(Date);
		   t1.addCell(ItemNo);
		   t1.addCell(itemName);
		   t1.addCell(qty);
		   t1.addCell(profit);
		 
          }
          
         /* while (itr.hasNext()) {          
              count++;
              
              ArrayList listView = (ArrayList) itr.next();
              
              
            	String total = (String) listView.get(0);
                
  		  
            	t2.addCell(total);
          }  */
		  
		  document.add(t1);
	//	document.add(t2);
		
          document.close();
	}
	

}


