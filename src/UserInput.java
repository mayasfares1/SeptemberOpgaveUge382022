import models.Book;
import repositories.DBAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javax.swing.UIManager.getString;

public class UserInput {

    public static String  getString(String s) {

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();




    }

    // Insert values into table

    public void insert(Book book) {

        String sql = "INSERT INTO bogtabel(Forfatter, Title, UdgivelsesÅr ) VALUES (" +
                book.getAuthor() + ", " +
                book.getTitle() +", " +
                book.getPublishYear() + ");";


        // se lige try-with-resources f.eks. her  https://www.baeldung.com/java-try-with-resources
        try (Connection con = DBAccess.ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            // her klargøres mit prepared statement ved at min parametre indsættes.
            ps.setString(1, getString("Type the title of the book "));
//            ps.setString(2, kunde.getAdresse());
//            ps.setString(3, kunde.getPostNr());


            ps.executeUpdate();    //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            ResultSet id = ps.getGeneratedKeys();
            System.out.println("We have reached :" + id.next());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//  Print names
    public static List<String> GetInfo() {

        List<String> Forfatterlist = new ArrayList<>();

        String sql = "select * from bogtabel ";

        int id = 0;
        try (Connection con = DBAccess.ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {           // https://en.wikipedia.org/wiki/Prepared_statement


            ResultSet resultSet = ps.executeQuery();   //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            while (resultSet.next()) {
                id = resultSet.getInt("BogId");
                String navn = resultSet.getString("Forfatter");
                String adresse = resultSet.getString("Title");
                String postNr = resultSet.getString("UdgivelsesÅr");


            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        System.out.println("We have reached row :" + id);
        return Forfatterlist;
    }


// Search function

    public static String updateKunde(int idKunde, String kundeNavn , String adresse, String PostNr) {

        String sql = "update  KundeTabel set KundeNavn = ? , Adresse = ? , PostNr = ? where idKundeTabel = ?";



        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, kundeNavn);
            ps.setString(2, adresse);
            ps.setString(3, PostNr);

            // det er det her jeg søger på.
            ps.setInt(4, idKunde);


            int res = ps.executeUpdate();    //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            if (res > 0) {

                return "Kunden med navnet " + "\""  + kundeNavn + "\""  + " er nu blevet opdateret";
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "en kunde med navnet " + "\"" + kundeNavn + "\"" + " fandtes ikke i listen";


    }

}
