import java.io.*;
import java.util.*;
import java.util.List;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import kr.inflearn.ExcelVO;

public class Project04_F {

	public static void main(String[] args) {
		String fileName="isbn.xls";
		List<ExcelVO> data=new ArrayList<ExcelVO>();
		
		try(FileInputStream fis=new FileInputStream(fileName)){
			HSSFWorkbook workbook=new HSSFWorkbook(fis);
			HSSFSheet sheet=workbook.getSheetAt(0);
			Iterator<Row> rows=sheet.rowIterator();
			rows.next();
			String [] imsi=new String[3];
			while(rows.hasNext()) {
				HSSFRow row=(HSSFRow)rows.next();
				Iterator<Cell> cells=row.cellIterator();
				int i=0;
				while(cells.hasNext()) {
					HSSFCell cell=(HSSFCell)cells.next();
					imsi[i]=cell.toString();
					i++;
					if(i==3) break;
				}
				//묶고(VO)->담고 (List)
				ExcelVO vo =new ExcelVO(imsi[0],imsi[1],imsi[2]);
				data.add(vo);
			}
			pdf_maker(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void pdf_maker(List<ExcelVO> data) {
		String [] headers = new String [] {"제목","저자","출판사"};
		Document doc = new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(new File("bookList.pdf")));
			doc.open();
			
			BaseFont bFont=BaseFont.createFont("H2MJRE.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			Font fontHeader= new Font(bFont,12);
			Font fontRow= new Font(bFont,10);
			
			PdfPTable table= new PdfPTable(data.size());
			for(String header:headers) {
				PdfPCell cell = new PdfPCell();
				cell.setGrayFill(0.9f);
				cell.setPhrase(new Phrase(header.toUpperCase(),fontHeader));
				table.addCell(cell);
			}
			table.completeRow();
			
			for(ExcelVO vo:data) {
				Phrase phrase = new Phrase(vo.getTitle(), fontRow);
				table.addCell(new PdfPCell(phrase));
				
				phrase = new Phrase(vo.getAuthor(), fontRow);
				table.addCell(new PdfPCell(phrase));
				
				phrase = new Phrase(vo.getCompany(), fontRow);
				table.addCell(new PdfPCell(phrase));
				
				table.completeRow();
				
				
			}
			
			doc.addTitle("PDF Table Demo");
			doc.add(table);
			System.out.println("bookList 생성완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
