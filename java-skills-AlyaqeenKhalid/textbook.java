public class Textbook extends Book {
    private String subject;
    private int edition;

    // Constructor calls parent constructor with super()
    public Textbook(String title, String author, int pages, String subject, int edition) {
        super(title, author, pages);
        this.subject = subject;
        this.edition = edition;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // call Book’s displayInfo
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }

    // Getters
    public String getSubject() {
        return subject;
    }

    public int getEdition() {
        return edition;
    }
}
