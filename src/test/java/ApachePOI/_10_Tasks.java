package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Tasks {
    /*  Soru 1:
     *  yeni excel
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 satır boşluk bırakarak alt alata
     */

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(); // hafizada bir workbook olusturuldu

        XSSFSheet sheet = workbook.createSheet("Sayfa1"); // icinde sheet olusturdum

        // HAFIZADA islemlere devam ediliyor

        // hafizada 0. yi yerde satir olusturuldu
        // hafizada yeni satirda ilk hucre olusturuldu

        for (int i = 1; i <= 10; i++) {
            Row yeniSatir = sheet.createRow(i - 1);

            for (int j = 1; j < 10; j++) {
                Cell yeniHucre = yeniSatir.createCell(j - 1);
                yeniHucre.setCellValue((j + "x" + i + ("= "+ i * j)));
            }
        }


        String path = "src/test/java/ApachePOI/Resource/_10_Tasks.xlsx";
        // Yazma islemini YAZMA acip oyle yapacagiz.(SAVE)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);                     // Workbook excel  dosyasina yazildi
        workbook.close();                                 // workbook icin ayrilan hafiza baslatildi
        outputStream.close();                             // yazma icin acilan kanal kapatildi.
        System.out.println("Islem tamamlandi");
    }
}
