package ApachePOI;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        // hafızada yeni bir workbook oluştur , sonra sheet oluştur , sonra row oluştur, sonra cell oluştur
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        // hafızada oluşturma ve yazma işlemleri yapılıyor
        Row yeniSatir= sheet.createRow(1); // satır oluşturuldu 1. yerde
        Cell yeniHucre= yeniSatir.createCell(0); // yeni satırda ilk hücre oluşturuldu
        yeniHucre.setCellValue("Merhaba Dünya"); // bilgi yazıldı

        for (int i=1; i<10;i++){
            yeniSatir.createCell(i).setCellValue(i);
        }


        // yazma işlemini yazma modunda açıp öyle yapacağız
        String yeniExcelPath="src/test/java/ApachePOI/resourse/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(yeniExcelPath);
        workbook.write(outputStream);
        workbook.close(); // hafıza boşaltıldı
        outputStream.close();
        System.out.println("işlem tamamlandı");







    }
}
