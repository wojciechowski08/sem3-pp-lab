package Book;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
    public String getName() {
        return name;
    }
    public Author getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQty() {
        return qty;
    }
    public boolean setQty(int qty) throws NegativeQtyException {
        if (qty >= 0) {
            this.qty = qty;
            return true;
        } else {
            throw new NegativeQtyException("Cant set " + qty + " quantity.");
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + " Author: " + author.toString() + " Price: " + price;
    }
}

public static void main(String[] args) {
    Author danBrown = new Author("Dan Brown", "contact@dbown.com", 'm');
    Book b = new Book("Inferno", danBrown, 39.99);


}
