package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değer password un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */
public class _05_GetASpecificData {
    public static void main(String[] args) throws IOException {

        System.out.print("Aranacak Kelime = ");
        Scanner oku=new Scanner(System.in);
        String arananKelime= oku.next();

        String donenSonuc=bul(arananKelime);
        System.out.print("donenSonuc = " + donenSonuc);
    }
    public static String bul(String arananKelime){
        String donecek="";
        String path="src/test/java/ApachePOI/resourse/LoginData.xlsx";
        Workbook workbook=null;

        try {
            FileInputStream inputStream=new FileInputStream(path);
            workbook=WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet=workbook.getSheetAt(0); // Login sheet
        int satirSayisi=sheet.getPhysicalNumberOfRows();

        for (int i=0;i<satirSayisi;i++){
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0);

            if (arananKelime.equalsIgnoreCase(cell.toString())){
                int hucreSayisi=row.getPhysicalNumberOfCells();
                for (int j=1;j<hucreSayisi;j++){

                    donecek+=row.getCell(j);
                }
            }
        }


        return donecek;
    }
}
