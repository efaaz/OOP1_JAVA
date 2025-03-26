public class Start {
    public static void main(String[] args) {
        Book book1 = new Book("6767", "Java", "Jahid", 700.0, 5);
        book1.showDetails();
        book1.addQuantity(10);
        book1.showDetails();
        book1.sellQuantity(5);
        book1.showDetails();

        System.out.println();
        System.out.println();
        System.out.println();

        Book book2 = new Book();
        book2.setIsbn("5678");
        book2.setBookTitle("Python");
        book2.setAuthorName("Shubin");
        book2.setPrice(500.0);
        book2.setAvailableQuantity(10);
        book2.showDetails();
        book2.addQuantity(5);
        book2.showDetails();
        book2.sellQuantity(10);
        book2.showDetails();
    }  
}
