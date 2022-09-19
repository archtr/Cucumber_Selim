package _JDBC.Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {
    @Test
    private void test1() throws SQLException {
        // next() bir adım sonraki row
        // previous() bir adım önceki row
        // absolute(4): baştan itibaren 4. row a gider direkt verilen row a gider ve o veriyi verir
        // relative(4)  bulunduğu noktadan 4 sonraki row a gider

        ResultSet rs=statement.executeQuery("select * from film");
        rs.absolute(10); // 10. satıra git
        String title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15); // 15. satıra git
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15); //(-) sondan 15. satıra git
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5); //en son bulunduğun yerden 5 satır ileri git
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-5); //en son bulunduğun yerden 5 satır geri git
        title=rs.getString("title");
        System.out.println("title = " + title);

    }

}
