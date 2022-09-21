package services;

import models.Book;
import repositories.BookRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookService {

    private BookRepository repo = new BookRepository();

    public boolean insert(Book book) {
        return repo.insert(book);
    }

    public boolean delete(int id) {
        return repo.delete(id);
    }

    public Book getBook(int id) {
        ResultSet resultSet = repo.get(id);

        try {
            resultSet.next();

            return new Book(resultSet.getInt("BogId"),
                    resultSet.getString("Forfatter"),
                    resultSet.getString("Title"),
                    resultSet.getInt("UdgivelsesÅr"));

        }
        catch (SQLException e) {
            return null;
        }
    }
}
