package repositories;

import models.Book;

import java.sql.ResultSet;

public class BookRepository extends Repository {

    // Insert values into cells

    public boolean insert(Book book) {
        String sql = "INSERT INTO bogtabel(Forfatter, Title, UdgivelsesÅr ) VALUES (" +
                book.getAuthor() + ", " +
                book.getTitle() +", " +
                book.getPublishYear() + ");";

        return execute(sql);
    }

    //Get values from Sql database
    public ResultSet get(int id) {
        String sql = "SELECT * FROM bogtabel WHERE BogId =" + id + ";";

        return read(sql);
    }

    // Delete values from Sql database
    public boolean delete (int id) {
        String sql = "DELETE FROM bogtabel (Forfatter, Title, UdgivelsesÅr) WHERE BogId = " + id + ";";
                return execute(sql);

    }
}
