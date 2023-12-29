public class demoPrototype {
    public static void main (String []args) throws CloneNotSupportedException{
        bookShop bs = new bookShop();
        bs.setShopName("My Book Shop");
        bs.loadDate();

        bookShop bs1 = (bookShop)bs.clone();
        bs1.setShopName("My Book Shop 1");
        
        bs.getBooks().remove(1);
        bs1.getBooks().remove(2);
        
        System.out.println(bs);
        System.out.println(bs1);
    }
}
