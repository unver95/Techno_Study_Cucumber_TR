package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewFolderExcelWrite {
    public static void main(String[] args) throws IOException {

        // Workbook varolan exvelin workbook u idi, bunu olusmamis bir excel icin kullanmiyor

        XSSFWorkbook workbook = new XSSFWorkbook(); // hafizada bir workbook olusturuldu
        XSSFSheet sheet = workbook.createSheet("Sayfa1"); // icinde sheet olusturdum

        // HAFIZADA islemlere devam ediliyor

        Row yeniSatir = sheet.createRow(0);         // hafizada 0. yi yerde satir olusturuldu
        Cell yeniHucre = yeniSatir.createCell(0);   // hafizada yeni satirda ilk hucre olusturuldu
        yeniHucre.setCellValue("Hello World");             // hafizada bilgi yazildi

        for (int i =1; i <10; i++){
            yeniSatir.createCell(i).setCellValue(i);       // Hello World 1 2 3 4 5 6 7 8 9
        }

        String path = "src/test/java/ApachePOI/Resource/YeniExcel.xlsx";
        // Yazma islemini YAZMA acip oyle yapacagiz.(SAVE)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);                     // Workbook excel  dosyasina yazildi
        workbook.close();                                 // workbook icin ayrilan hafiza baslatildi
        outputStream.close();                             // yazma icin acilan kanal kapatildi.
        System.out.println("Islem tamamlandi");
    }
}
