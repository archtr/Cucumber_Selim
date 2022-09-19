package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {
    // kendisine verilen path deki excelin , istenilen , sheetindeki
    // verilen lolon kadar sütunları okuyup ArrayList formatında geri döndüren fonksiyonu yazınız.
    //  getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2
    public static ArrayList <ArrayList<String>> getListData(String path, String sheetName,int columnCount){
        ArrayList <ArrayList<String>> tablo=new ArrayList<>();
        Workbook workbook=null;

        try {
            FileInputStream inputStream=new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sayfa=workbook.getSheet(sheetName);
        for (int i=0;i<sayfa.getPhysicalNumberOfRows() ;i++){
            ArrayList<String> satirData=new ArrayList<>();
            for (int j=0; j<columnCount ;j++){
                satirData.add(sayfa.getRow(i).getCell(j).toString());
            }
            tablo.add(satirData);

        }
        return tablo;
    }
    // TODO: kendisine verilen path scenario browsertipi zaman ve parametreleri
     //    yeni bir excele bütün raporu yazacak, dosyanın varlığını veya yokluğunu kontrol etmeyi goggledan bulunuz

    public static void writeExcel(String path, Scenario scenario,String browserName,String time) throws IOException {

        File f=new File(path);

        if (!f.exists()){ // ! olunca yoksa demek
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");
        Row newRow= sheet.createRow(0);

        Cell newCell= newRow.createCell(0);
        newCell.setCellValue(scenario.getName());

        newCell= newRow.createCell(1);
        newCell.setCellValue(scenario.getStatus().toString());

        newCell= newRow.createCell(2);
        newCell.setCellValue(browserName);

        newCell= newRow.createCell(3);
        newCell.setCellValue(time);

        try {
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        }catch (IOException e){
        throw new RuntimeException(e);
        }
      }
        else {
            FileInputStream inputStream=null; // okuma modunda açıldı
            Workbook workbook= null;
            try {
                inputStream=new FileInputStream(path);
                workbook=WorkbookFactory.create(inputStream);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
            Sheet sheet=workbook.getSheetAt(0);

            int rowCount=sheet.getPhysicalNumberOfRows();
            Row newRow= sheet.createRow(rowCount);

            Cell newCell= newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell= newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell= newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell= newRow.createCell(3);
            newCell.setCellValue(time);

            try {
                inputStream.close();
                FileOutputStream outputStream=new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }


    }

    public static void main(String[] args) {

        ArrayList <ArrayList<String>> tablo=
        getListData("src/test/java/ApachePOI/resourse/ApacheExcel2.xlsx","testCitizen", 2);

        System.out.println("tablo = " + tablo);

    }
}
