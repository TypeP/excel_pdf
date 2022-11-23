package kr.inflearn;
import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
public class ExcelDAO {
	private List<ExcelVO> list;
	private HSSFWorkbook wb;
	public ExcelDAO() {
		list=new ArrayList<ExcelVO>();
		wb=new HSSFWorkbook();
	}
    public void excel_input() {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	try {
            HSSFSheet firstSheet = wb.createSheet("BOOK SHEET");
            HSSFRow rowA = firstSheet.createRow(0);
            HSSFCell cellA = rowA.createCell(0);
            cellA.setCellValue(new HSSFRichTextString("책제목"));
            HSSFCell cellB = rowA.createCell(1);
            cellB.setCellValue(new HSSFRichTextString("저자"));
            HSSFCell cellC = rowA.createCell(2);
            cellC.setCellValue(new HSSFRichTextString("출판사"));


            int i=1;
            while(true) {
	        	System.out.print("책제목:");
	    		String title=br.readLine();
	    		System.out.print("책저자:");
	    		String author=br.readLine();
	    		System.out.print("출판사:");
	    		String company=br.readLine();
	    		
	            HSSFRow rowRal = firstSheet.createRow(i);	            
	            HSSFCell cellTitle = rowRal.createCell(0);            
	            cellTitle.setCellValue(new HSSFRichTextString(title));	            
	            HSSFCell cellAuthor = rowRal.createCell(1);
	            cellAuthor.setCellValue(new HSSFRichTextString(author));	            
	            HSSFCell cellCompany = rowRal.createCell(2);
	            cellCompany.setCellValue(new HSSFRichTextString(company));	            
	            i++;
	            
	            ExcelVO vo=new ExcelVO(title, author, company);
	            // isbn, image 검색

	            System.out.print("계속입력 하시면 Y / 입력종료 N:");
	            String key=br.readLine();
	            if(key.equals("N")) break;
	        }
            System.out.println("데이터 추출중...........");
            excel_save();
		} catch (Exception e) {
            e.printStackTrace();
		}
    }		
	//상세 검색은 책 제목(d_titl), 저자명(d_auth), 목차(d_cont), ISBN(d_isbn), 출판사(d_publ) 5개 항목 중에서 1개 이상 값을 입력해야함.

	
 public void excel_save() {
		  try {
		  HSSFSheet sheet = wb.getSheetAt(0);
		   if(wb != null && sheet != null) {
			  Iterator rows = sheet.rowIterator();
	          rows.next();
	         
				FileOutputStream fos = new FileOutputStream("isbn.xls");
				wb.write(fos);
				fos.close();
				System.out.println("책 내용저장성공");
		   }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	}
}