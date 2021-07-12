package com.excel.demo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args)  throws IOException{
		String path = "teste-izagro.xlsx";

//		writeExcelFile(path);
		readExcelFile(path);
	}

	public static void readExcelFile(String path) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet workSheet = workbook.getSheet(workbook.getSheetName(0));

		var content = "";

		for (int i = workSheet.getFirstRowNum(); i < workSheet.getLastRowNum() + 1; i++) {
			Row row = workSheet.getRow(i);
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				content += cell + " - ";
			}
			content +="\n";
		}

		System.out.println(content);
	}

	public static void writeExcelFile(String path) throws IOException {
		XSSFWorkbook excelEnvironment = new XSSFWorkbook();
		XSSFSheet excelSheet = excelEnvironment.createSheet( " Planilha de Cotação ");

		XSSFRow row;

		Map< String, Object[] > empinfo = new TreeMap< String, Object[] >();

		empinfo.put( "1", new Object[] {});
		empinfo.put( "2", new Object[] {"nome", "joão" });
		empinfo.put( "3", new Object[] {"email", "joao@email.com" });
		empinfo.put( "4", new Object[] {"telefone", "(16) 99999-1122"});
		empinfo.put( "5", new Object[] {"idade", 22 });

		Set< String > keyId = empinfo.keySet();
		int rowId = 0;

		for (String key : keyId) {

			// Todo configurar tamanho da cédula
			excelSheet.setColumnWidth(0, 3000);
			excelSheet.setColumnWidth(1, 7000);
			row = excelSheet.createRow(rowId++);
			// Todo criar estilo para cédula
			CellStyle style = excelEnvironment.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			Object[] objectArr = empinfo.get(key);
			int cellId = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellId++);
				cell.setCellValue((String) obj);
				// Todo quebrar linha quando exceder tamanho
				style.setWrapText(true);
				cell.setCellStyle(style);

			}
		}

		FileOutputStream excelFileOut = new FileOutputStream(path);

		excelEnvironment.write(excelFileOut);

		excelFileOut.close();

	}

}
