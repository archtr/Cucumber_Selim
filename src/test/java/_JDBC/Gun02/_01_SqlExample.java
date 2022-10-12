package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends JDBCParent {
    // last,first,getRow,getID,getDouble
    @Test
    public void test1() throws SQLException {
        ResultSet rs=statement.executeQuery("select city_id,city,country_id from city;");
        rs.last(); // sonuncu row a gider
        String id=rs.getString(1);// city_id
        System.out.println("id = " + id);

        int idInt=rs.getInt(1); // aynı city_id yi int olarak aldım ,
        // uygun olan tipler için dönüşüm var , dönüşüm yapamıyorsa zaten hata veriyor
        System.out.println("idInt = " + idInt);

        String name=rs.getString(2); // city ismini string olarak aldım
        System.out.println("name = " + name); // stringi int olarak alamam o yüzden sadece string olarak alındı

        int kacinciSatir=rs.getRow();
        // dolayısıyla bir sorgunun sonucunda kaç satır geldiğini
        // rs.last() dedikten sonra rs.getRow() ile alabilirim

        rs.first(); // ilk satıra gider



    }
}
