public class Library {
    public static void main(String[] args) {
        // Create regular books
        Book book1 = new Book("1984", "George Orwell", 328);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 281);

        // Create a textbook
        Textbook textbook = new Textbook("Introduction to Java", "John Doe", 500, "Computer Science", 3);

        // Borrow and return some books
        book1.borrowBook();
        book1.borrowBook(); // try borrowing again
        book1.returnBook();

        // Display info for all books
        System.out.println("\nBook 1 Info:");
        book1.displayInfo();

        System.out.println("\nBook 2 Info:");
        book2.displayInfo();

        System.out.println("\nTextbook Info:");
        textbook.displayInfo();
    }
}
