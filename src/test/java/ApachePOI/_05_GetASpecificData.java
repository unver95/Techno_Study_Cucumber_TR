package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _05_GetASpecificData {
    /*
     * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
     * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
     * yani metoda "password" kelimesi gönderilecek, dönen değer password un değeri olacak.
     * bulup ve sonucun döndürülmesi için metod kullanınız.
     * src/test/java/ApachePOI/resources/LoginData.xlsx
     */

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String kelime;

        System.out.print("Aranacak kelime giriniz: ");
        kelime = input.nextLine();


        System.out.println(bul(kelime));
    }

    public static String bul(String arananKelime) throws IOException {
        String returnWord = "";
        String path = "src/test/java/ApachePOI/Resource/LoginData.xlsx";

        FileInputStream inputSream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputSream);
        Sheet sheet = workbook.getSheetAt(0);


        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(arananKelime)) {
                for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    returnWord += sheet.getRow(i).getCell(1 + j) + " ";
                }
            }
        }
        return returnWord;
    }
}
