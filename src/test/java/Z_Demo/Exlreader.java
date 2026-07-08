package Z_Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import PageObj.SignUpObj;

import org.apache.poi.ss.usermodel.DataFormatter;

public class Exlreader {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		String path = "/home/user/Desktop/TestData.xlsx";
		// FIX 1: You must instantiate the formatter object here!
        DataFormatter formatter = new DataFormatter();
		
		
		try (FileInputStream fis = new FileInputStream(path);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            // Get the first sheet
	            Sheet sheet = workbook.getSheet("Sheet2");
	            int totalColumns = sheet.getRow(0).getLastCellNum();
	            
	            
	            
	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {	
	                Row row = sheet.getRow(i);
//	                System.out.println(row.getCell(i));
	                if (row == null) {
	                    System.out.println(); // Skip empty rows gracefully
	                    continue;
	                }
	                
	                for (int j = 0; j < totalColumns; j++) {
	                    // CREATE_NULL_AS_BLANK prevents NullPointerException on empty cells
	                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                    
	                    // Print cell value aligned nicely
	                    System.out.printf("%-18s", cell.toString());                      
	                }
	                System.out.println();
	                String fname = formatter.formatCellValue(row.getCell(1));
                    String lname = formatter.formatCellValue(row.getCell(2));
                    String email = formatter.formatCellValue(row.getCell(3));
                    String password = formatter.formatCellValue(row.getCell(4));
                    String conf_pass = formatter.formatCellValue(row.getCell(5));
                    
                    
                    
                    
                    
                    
                    
	            }
	            
		
		
		
	}

}
}
