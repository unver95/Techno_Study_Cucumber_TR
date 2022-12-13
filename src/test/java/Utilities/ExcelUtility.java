package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelUtility {
    // kendisine verilen path deki excelin, istenilen, sheetindeki
    // istenilen kolona kadar sütunları okuyup Arraylist formatında geri döndüren fonksiyonu yazınız.
    // getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2



    public static ArrayList<ArrayList<String>> getListData(String path, String sheetName, int columnCount) {

        ArrayList<ArrayList<String>> excelLists = new ArrayList<>();
        Sheet sheet = null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i =0; i < sheet.getPhysicalNumberOfRows(); i++){
            ArrayList<String>rowData = new ArrayList<>();
            for (int j = 0; j < columnCount; j++){
                Cell cell = sheet.getRow(i).getCell(j);
                rowData.add(cell.toString());
            }
            excelLists.add(rowData);
        }
        return excelLists;
    }

    public static void writeToExcel(String path, Scenario senaryo, String browserName, String time){

        File f = new File(path);

        if (!f.exists()){ // yok ise
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("CampusTest");

            Row yeniSatir = sheet.createRow(0);

            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue(senaryo.getName());

            yeniHucre = yeniSatir.createCell(1);
            yeniHucre.setCellValue(senaryo.getStatus().toString());

            yeniHucre=yeniSatir.createCell(2);
            yeniHucre.setCellValue(browserName);

            yeniHucre = yeniSatir.createCell(3);
            yeniHucre.setCellValue(time);

            //file save

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }else { //var ise

        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> excelList = new ArrayList<>();

        excelList =  getListData("src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx", "testCitizen", 2);
        System.out.println(excelList);
    }
}
