package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {
    @Test
    public void test1() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from language");

        ResultSetMetaData rsmd=rs.getMetaData(); // sonuçların haricindeki diğer bilgiler : colon sayısı , isimleri , tipleri vs

        int columnCount=  rsmd.getColumnCount(); // kolon sayısı
        System.out.println("columnCount = " + columnCount);

        for(int i=1; i<=columnCount;i++){
            String columnName=rsmd.getColumnName(i);
            String columnType=rsmd.getColumnTypeName(i);
            System.out.println(columnType+" "+columnName);
        }
    }
    @Test
    public void test2() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        ResultSet rs=statement.executeQuery("select * from language");

        ResultSetMetaData rsmd=rs.getMetaData(); // sonuçların haricindeki diğer bilgiler : colon sayısı , isimleri , tipleri vs

        int columnCount=  rsmd.getColumnCount(); // kolon sayısı

        for(int i=1; i<=columnCount;i++){
            String columnName=rsmd.getColumnName(i);
            System.out.print(columnName+" | ");
        }
        System.out.println();
        int cnt=0;
        while (rs.next()){
           for (int i=1; i<=rsmd.getColumnCount();i++){
               System.out.print(rs.getString(i)+"\t");
               //System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
               //cnt++; alternatif çözüm
               System.out.println();
           }
        }
    }
    @Test
    public void test3() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        ResultSet rs=statement.executeQuery("select * from language");

        ResultSetMetaData rsmd=rs.getMetaData(); // sonuçların haricindeki diğer bilgiler : colon sayısı , isimleri , tipleri vs

        int columnCount=  rsmd.getColumnCount(); // kolon sayısı

        for(int i=1; i<=columnCount;i++){
            String columnName=rsmd.getColumnName(i);
            System.out.printf("%-20s",columnName);
            // % : değişkenin değerini işaret eder
            // - : sola dayalı yazdırır , default sağa dayalı
            // 20: kaç hane kullanılacak her zaman onun bilgisi
            // s : string değerler için , sayısal değerler için d kullanılır
            // "%5.2d : sayı için 5 hane kullan , ondalıklı kısım için 2 hane
        }
        System.out.println();
        // int cnt=0;
        while (rs.next()){
            for (int i=1; i<=rsmd.getColumnCount();i++){
                System.out.printf("%-20s",rs.getString(i));
                //System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
                //cnt++; alternatif çözüm
            }
            System.out.println();
        }
    }
    @Test
    public void test4() throws SQLException {
        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.
        getTable("select * from actor");
    }
    public  void getTable(String sorgu) throws SQLException {
        ResultSet rs=statement.executeQuery(sorgu);

        ResultSetMetaData rsmd=rs.getMetaData(); // sonuçların haricindeki diğer bilgiler : colon sayısı , isimleri , tipleri vs

        int columnCount=  rsmd.getColumnCount(); // kolon sayısı

        for(int i=1; i<=columnCount;i++){
            String columnName=rsmd.getColumnName(i);
            System.out.printf("%-20s",columnName);

        }
        System.out.println();
        // int cnt=0;
        while (rs.next()){
            for (int i=1; i<=rsmd.getColumnCount();i++){
                System.out.printf("%-20s",rs.getString(i));
                //System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
                //cnt++; alternatif çözüm
            }
            System.out.println();
        }
    }
}
