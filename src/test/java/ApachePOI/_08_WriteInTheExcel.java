package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // var olan bir excel yazma işlemi

        String path="src/test/java/ApachePOI/resourse/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path); // okuma modunda açıldı
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("Sheet1");

        // hafızada oluşturma ve yazma işlemleri yapılıyor
        Row yeniSatir= sheet.createRow(1); // satır oluşturuldu 1. yerde
        Cell yeniHucre= yeniSatir.createCell(0); // yeni satırda ilk hücre oluşturuldu
        yeniHucre.setCellValue("Merhaba Dünya"); // bilgi yazıldı

        for (int i=1; i<10;i++){
            yeniSatir.createCell(i).setCellValue(i);
        }
        // sıra kaydetmeye geldi , bütün bilgiler hafızada buraya kadar , her şey workbookta
        inputStream.close(); // okuma modunu kapattım , çünkü yazma modunda açmam gerekiyor

        // yazma işlemini yazma modunda açıp öyle yapacağız
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close(); // hafıza boşaltıldı
        outputStream.close();
        System.out.println("işlem tamamlandı");



    }
}
