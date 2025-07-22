public class VisitorCounter {
    // Static variable to count total visitors
    private static int totalVisitors = 0;

    // Non-static variable for individual session visits
    private int sessionVisits;
    private String visitorName;

    // Constructor
    public VisitorCounter(String name) {
        this.visitorName = name;
        this.sessionVisits = 0;
        totalVisitors++;  // Increment total visitors when a new visitor is created
    }

    // Non-static method: record a visit for this visitor
    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " + sessionVisits);
    }

    // Static method: display total visitors today
    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }

    // Static getter for totalVisitors (optional)
    public static int getTotalVisitors() {
        return totalVisitors;
    }

    public static void main(String[] args) {
        // Create three visitors
        VisitorCounter visitor1 = new VisitorCounter("Alice");
        VisitorCounter visitor2 = new VisitorCounter("Bob");
        VisitorCounter visitor3 = new VisitorCounter("Charlie");

        // Each visitor records some visits
        visitor1.recordVisit();
        visitor1.recordVisit();

        visitor2.recordVisit();

        visitor3.recordVisit();
        visitor3.recordVisit();
        visitor3.recordVisit();

        // Display total visitors
        VisitorCounter.displayTotalVisitors();
    }
}
