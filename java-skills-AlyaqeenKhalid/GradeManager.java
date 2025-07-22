public class GradeManager {

    // Reverse each student name individually, keep array order same
    public static String[] reverseStudentNames(String[] names) {
        String[] reversedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            reversedNames[i] = new StringBuilder(names[i]).reverse().toString();
        }
        return reversedNames;
    }

    // Convert numeric score to letter grade
    public static char getLetterGrade(int score) {
        if (score >= 90 && score <= 100) {
            return 'A';
        } else if (score >= 80 && score <= 89) {
            return 'B';
        } else if (score >= 70 && score <= 79) {
            return 'C';
        } else if (score >= 60 && score <= 69) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Find names of students who scored below 60 (failing)
    public static String[] findFailingStudents(String[] names, int[] scores) {
        // First count how many are failing
        int failCount = 0;
        for (int score : scores) {
            if (score < 60) failCount++;
        }

        // Create array of failing students
        String[] failingStudents = new String[failCount];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failingStudents[index] = names[i];
                index++;
            }
        }
        return failingStudents;
    }

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        // Test reverseStudentNames
        String[] reversed = reverseStudentNames(students);
        System.out.println("Reversed student names:");
        for (String name : reversed) {
            System.out.println(name);
        }

        // Test getLetterGrade
        System.out.println("\nStudent Grades:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + ": " + getLetterGrade(scores[i]));
        }

        // Test findFailingStudents
        String[] failing = findFailingStudents(students, scores);
        System.out.println("\nStudents who need to retake the exam:");
        for (String name : failing) {
            System.out.println(name);
        }
    }
}
