import models.Book;
import services.BookService;

import java.util.Scanner;

public class Menu {

    private BookService service = new BookService();

//     System.out.println("d: Sum Between Two Integers");
//        System.out.println("e: Repeat the String");
//        System.out.println("f: It is Palindrome");
//        System.out.println("?: Display");
//        System.out.println("q: Quit");

    int choice;
    String order;

    public void begin() {

        Scanner sc = new Scanner(System.in);

        int id = 2;

        service.insert(new Book("Stephen King", "Rædsel", 1995));
        Book book = service.getBook(id);


        System.out.println("Opret bog --- 1");
        System.out.println("Opret Lånere ---2");
        System.out.println("Opret lån --- 3");
        System.out.println("Find Bog-----4");

        System.out.println("Select an Option: ");

        choice = scan.nextInt();

        //Logic

        switch (choice)
        {
            case 1 :
                order= UserInput.generateBooks();
                break;

            case 2 :
                order = UserInput.generateBorrowers();
                break;

            case 3 :
                order = UserInput.generateBorrowing();

            case 4:
                order = UserInput.updateKunde();
        }

    }
}


