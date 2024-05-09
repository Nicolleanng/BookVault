/*BookVault Book Collection Console Program by Nicolle Gallo */
import java.util.*;

//BookVault class that contains main and functions
public class BookVault{
    static ArrayList<BookDetails> addedBooks = new ArrayList<BookDetails>();
    static Scanner sc = new Scanner(System.in);
    /* My Functions */
    //add book functionality 
    public static void addBook(){
        String category;
        boolean validCategory = false;
        System.out.println("Enter title: ");
        String title = sc.nextLine();
        System.out.println("Enter author: ");
        String author = sc.nextLine();
        do{
            System.out.println("Enter a category (Read, Want, Reading, Own): ");
            category = sc.nextLine();
            // check if one of 4 categories (Case Sensitive)
            if(category.equals("Read")||category.equals("Want")||category.equals("Reading")||category.equals("Own")){
                validCategory = true;
            }else{
                System.out.println("Not a category. Try again.");
            }
        }while(!validCategory);
        System.out.println("Enter personal note: ");
        String note = sc.nextLine();
        //new instance of BookDetails class
        BookDetails book = new BookDetails(title, author, category, note);
        addedBooks.add(book);
        System.out.println("New book was added!");
    }
    //edit book functionality
    public static void editBook(){
        // Check if there are any books in the collection
        if(addedBooks.isEmpty()){
            System.out.println("No books have been added");
        }else{
            System.out.println("Please enter the title of the book you want to edit: ");
            String title = sc.nextLine();
            boolean foundBook = false;
            for (int i = 0; i < addedBooks.size(); i++) {
                BookDetails book = addedBooks.get(i);
                if (book.getTitle().equals(title)) {
                    System.out.println("New title: ");
                    String newTitle = sc.nextLine();
                    System.out.println("New author: ");
                    String newAuthor = sc.nextLine();
                    System.out.println("New category (Read, Want, Reading, Own): ");
                    String newCategory = sc.nextLine();
                    System.out.println("New note: ");
                    String newNote = sc.nextLine();
                    //if book details have been changed, update them
                    if(!newTitle.isEmpty()){
                        book.setTitle(newTitle);
                    }
                    if(!newAuthor.isEmpty()){
                        book.setAuthor(newAuthor);
                    }
                    if(!newCategory.isEmpty()){
                        book.setCategory(newCategory);
                    }
                    if(!newNote.isEmpty()){
                        book.setNote(newNote);
                    }
                    System.out.println("This book has been edited");
                    foundBook = true;
                    break;
                }
            }
            if(!foundBook){
                System.out.println("Book not found in your collection");
            }
        }
    }
    //delete book functionality
    public static void deleteBook(){
        boolean deleted = false;
        // Check if there are any books in the collection
        if(addedBooks.isEmpty()){
            System.out.println("No books have been added");
        }else{
            System.out.print("Please enter the title of the book you want to delete: ");
            String title = sc.nextLine();
            //loops through all added books
            for(int i = 0; i < addedBooks.size(); i++){
                //delete book if the title entered matches a book in the collection
                if(addedBooks.get(i).getTitle().equals(title)){
                    addedBooks.remove(i);
                    deleted = true;
                    System.out.println("The book has been deleted.");
                    break;
                }
            // if book title entered is not in your collection
            }if(!deleted){
                System.out.println("This book was not found in your collection");
            }
        }
    }
    //show book details functionality
    public static void showBooks(){
        //count number of books var
        int counter = 0; 
        // Check if there are any books in the collection
        if(addedBooks.isEmpty()) {
            System.out.println("No books have been added");
        }else{
            System.out.println("Select a category to show your books:");
            System.out.println("1.Read");
            System.out.println("2.Want");
            System.out.println("3.Reading");
            System.out.println("4.Own");
            System.out.println("Choose your option: ");
            int option = sc.nextInt();
            sc.nextLine(); 
            //show books for individual categories and include separate book counters.
                switch(option){
                    case 1: 
                        System.out.println("The books in the Read category:");
                        for(int i = 0; i < addedBooks.size(); i++){
                            BookDetails book = addedBooks.get(i);
                            if(book.getCategory().equals("Read")){
                                System.out.println(book);
                                counter++;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("The books in the Want category:");
                        for(int i = 0; i < addedBooks.size(); i++){
                            BookDetails book = addedBooks.get(i);
                            if(book.getCategory().equals("Want")){
                                System.out.println(book);
                                counter++;
                            }
                        }break;
                    case 3:
                        System.out.println("The books in the Reading category:");
                        for(int i = 0; i < addedBooks.size(); i++){
                            BookDetails book = addedBooks.get(i);
                            if(book.getCategory().equals("Reading")){
                                System.out.println(book);
                                counter++;
                            }
                        }break;
                    case 4:
                        System.out.println("The books in the Own category:");
                        for(int i = 0; i < addedBooks.size(); i++){
                            BookDetails book = addedBooks.get(i);
                            if(book.getCategory().equals("Own")){
                                System.out.println(book);
                                counter++;
                            }
                        }break;
                    default:
                        System.out.println("Not one of the options");
                }
            System.out.println("The total # of books in this category: " + counter + "\n");
        }
    }
    //search book functionality
    public static void searchBook(){
        //was book found during search var
        boolean foundBook = false;
        // Check if there are any books in the collection
        if(addedBooks.isEmpty()){
            System.out.println("No books have been added");
        }else{
            //options to search by author or title of the book entered by the user
            System.out.println("Search for book by: ");
            System.out.println("1.Title");
            System.out.println("2.Author");
            System.out.println("Choose your option: ");
            int option = sc.nextInt();
            sc.nextLine(); 
            switch (option) {
                case 1:
                    System.out.println("Please enter the title of the book you want to serch for: ");
                    String title = sc.nextLine();
                    for (int i = 0; i < addedBooks.size(); i++) {
                        BookDetails book = addedBooks.get(i);
                        if (book.getTitle().equals(title)) {
                            System.out.println("This book has been found:");
                            System.out.println(book);
                            foundBook = true;
                            break;
                        }
                    }break;
                case 2:
                    System.out.println("Please enter the author of the book you want to search for: ");
                    String author = sc.nextLine();
                    for(int i = 0; i < addedBooks.size(); i++){
                        BookDetails book = addedBooks.get(i);
                        if(book.getAuthor().equals(author)){
                            System.out.println("This book has been found:");
                            System.out.println(book);
                            foundBook = true;
                            break;
                        }
                    }break;
                default:
                    System.out.println("Not one of the options");
                    break;
            }
            //if the book entered isnt in the collection, try again
            if(!foundBook && option != 0){
                System.out.println("This book was not found in your collection");
            }
        }
    }
    //main RUN HERE
    public static void main(String[] args){
        System.out.println("\nWelcome to BookVault! Your personal book collection!");
        System.out.println("\nPlease choose Option 1 to get started!\n");
        //options the user can choose from as an int(to get started they need to choose option 1)
        while(true){
            System.out.println("1.Add book");
            System.out.println("2.Edit book");
            System.out.println("3.Delete book");
            System.out.println("4.Show all books");
            System.out.println("5.Search for book");
            System.out.println("6.End Program");
            System.out.println("Choose your option: ");
            int option = sc.nextInt();
            sc.nextLine();  
            //switch case using functions for options
                switch(option){
                    case 1:
                        addBook();
                        break;
                    case 2:
                        editBook();
                        break;
                    case 3:
                        deleteBook();
                        break;
                    case 4:
                        showBooks();
                        break;
                    case 5:
                        searchBook();
                        break;
                    case 6:
                        System.out.println("Program Ended");
                        System.exit(0);
                    default:
                        System.out.println("Not one of the options");
                }
        }
    }
}
