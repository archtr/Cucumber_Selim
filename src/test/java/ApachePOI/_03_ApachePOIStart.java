package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {

        // Dosyanın yolu alındı
        String path="src/test/java/ApachePOI/resourse/ApacheExcel2.xlsx";

        // java dosya okuma işlemcisine dosyanın yolunu veriyoruz
        //böylece program ile dosya arasında bağlantı oluştu
        FileInputStream dosyaOkumaBaglantısı=new FileInputStream(path);

        // dosya okuma işlemcisi üzerinden çalışma kitabını alıyorum
        // hafızada workbook u alıp oluşturdu
        Workbook calismaKitabi= WorkbookFactory.create(dosyaOkumaBaglantısı);

        // istediğim isimdeki çalışma sayfasını alıyorum
        Sheet calismaSayfasi=calismaKitabi.getSheet("Sheet1");
        // istediğim sıradaki satırı alıyorum
        Row satir=calismaSayfasi.getRow(0);
        // istediğim sıradaki hücreyi alıyorum
        Cell hucre=satir.getCell(0);
        System.out.println("hucre = " + hucre);



    }
}
