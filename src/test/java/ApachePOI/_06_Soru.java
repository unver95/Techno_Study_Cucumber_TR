package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    /*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sayi;

        System.out.print("Aranacak sayi giriniz: ");
        sayi = input.nextInt();


        System.out.println(bul(sayi));
    }

    public static String bul(int sayi) {
        String returnWord = "";
        String path = "src/test/java/ApachePOI/Resource/LoginData.xlsx";


        FileInputStream inputStream;
        Workbook workbook;
        Sheet sheet;

        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            returnWord = returnWord.concat(sheet.getRow(i).getCell(sayi) + "\n") ;
        }
        return returnWord;
    }
}
