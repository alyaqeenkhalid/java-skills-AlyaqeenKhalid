public class UserProfile {
    // Variables for user data
    private String fullName;
    private int userAge;
    private String userEmail;
    private boolean activeStatus;

    // Constructor to initialize all variables
    public UserProfile(String fullName, int userAge, String userEmail, boolean activeStatus) {
        this.fullName = fullName;
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.activeStatus = activeStatus;
    }

    // Getters - methods to read each variable
    public String getFullName() {
        return fullName;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public boolean isActive() {
        return activeStatus;
    }

    // Setters - methods to update variables
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    // Method to print user information in a clear way
    public void showUserDetails() {
        System.out.println("User Details:");
        System.out.println("Name: " + fullName);
        System.out.println("Age: " + userAge);
        System.out.println("Email: " + userEmail);
        System.out.println("Active User: " + activeStatus);
        System.out.println("-----------------------");
    }

    // Main method to test UserProfile class
    public static void main(String[] args) {
        UserProfile person1 = new UserProfile("Sara Ahmed", 28, "sara@email.com", true);
        UserProfile person2 = new UserProfile("Omar Ali", 34, "omar@email.com", false);
        UserProfile person3 = new UserProfile("Nadia Saleh", 21, "nadia@email.com", true);

        person1.showUserDetails();
        person2.showUserDetails();
        person3.showUserDetails();

        // Change Omar’s email and show updated details
        person2.setUserEmail("omar.newemail@email.com");
        System.out.println("Updated Email for Omar: " + person2.getUserEmail());
    }
}
