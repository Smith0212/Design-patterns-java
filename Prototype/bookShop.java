import java.util.ArrayList;
import java.util.List;

public class bookShop implements Cloneable{
    private String  shopName;
    List<Book> books = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    public List<Book> getBooks(){
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadDate(){
        for(int i=1; i<5; i++){
            Book b = new Book();
            b.setId(i);
            b.setBookname("Book " + i);
            books.add(b);
        }
    }
    //shallow copy
    // protected Object clone() throws CloneNotSupportedException {
    //     return super.clone();
    // }

    //deep copy
    protected bookShop clone() throws CloneNotSupportedException {
        bookShop shop = new bookShop();
        for(Book b : this.getBooks()){
            shop.getBooks().add(b);
        }
        return shop;
    }

    
    public String toString(){
        return "BookShop [shopName=" + shopName + ", books=" + books + "]";
    }
}
