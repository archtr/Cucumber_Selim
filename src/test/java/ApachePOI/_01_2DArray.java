package ApachePOI;

public class _01_2DArray {
    public static void main(String[] args) {
        String [][] zoo={{"aslan","1"},{"kaplan","2"},{"zebra","3","1"},{"fil","4"}};
        System.out.println(zoo[2][0]);
        System.out.println(zoo[2][1]);

       for (int i=0; i< zoo.length;i++){ // satır sayısı
           for (int j=0;j< zoo[i].length;j++){ // i.satırın uzunluğu
               System.out.println(zoo[i][j]+ " ");
           }
           System.out.println();
       }
       // List : ne kadar eleman olacağı beğilken
        // aslında ne kadar ekleneceği belli değilken kullanıyoruz

    }
}
