package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_WriteInTheEcel {
    public static void main(String[] args) throws IOException {
        // var olan Excel e yazma islemi

        String path = "src/test/java/ApachePOI/Resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path); // Dosya okuma modu acildi
        // bir excele ayni anda hem okuma hemde yazma yapmasin

        Workbook workbook = WorkbookFactory.create(inputStream); // exceldeki workbook hafizaya aldi
        Sheet sheet = workbook.getSheetAt(0);

        // HAFIZADA islemlere devam ediliyor

        Row yeniSatir = sheet.createRow(0);         // hafizada 0. yi yerde satir olusturuldu
        Cell yeniHucre = yeniSatir.createCell(0);   // hafizada yeni satirda ilk hucre olusturuldu
        yeniHucre.setCellValue("Hello World");             // hafizada bilgi yazildi

        for (int i =1; i <10; i++){
            yeniSatir.createCell(i).setCellValue(i);       // Hello World 1 2 3 4 5 6 7 8 9
        }

        // sira kaydetmeye geldi, butun bilgiler hafizada buraya kadar, her sey WORKBOOK da
        inputStream.close();                               //okuma modu, kanali kapatiliyor.


        // Yazma islemini YAZMA acip oyle yapacagiz.(SAVE)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);                     // Workbook excel  dosyasina yazildi
        workbook.close();                                 // workbook icin ayrilan hafiza baslatildi
        outputStream.close();                             // yazma icin acilan kanal kapatildi.
        System.out.println("Islem tamamlandi");

        //Talip notu:
        //  Excel e yazacağımız zaman excellin hangi celline yazacagimizi belirlemek için önce açıp okuyoruz...
        //  (Dolu hücrelere yazmamak için) Sonra yazacağımız hücreyi belirliyoruz.Ne yazacağımız hafızaya alıyoruz.
        //  Okuma modunu kapatıp.Hafizada yazdığımız veriyi excelle kaydediyoruz..
    }
}
