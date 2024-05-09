
//book details class 
class BookDetails{
    //variables
    private String title;
    private String author;
    private String category;
    private String note;
    //getters and setters for books details
    public BookDetails(String title, String author, String category, String note){
        this.title = title;
        this.author = author;
        this.category = category;
        this.note = note;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note = note;
    }
    //allows added books to be displayed as a String
    public String toString(){
        return "\nTitle: " + title + ", Author: " + author + ", Category: " + category + ", Note: " + note + "\n";
    }
}
