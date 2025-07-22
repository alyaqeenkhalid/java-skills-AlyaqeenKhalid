public class TextProcessor {

    // Count the number of words in a sentence
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0; // no words
        }
        // Split by whitespace, count tokens
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Replace all occurrences of oldWord with newWord in the text
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null) {
            return null;
        }
        return text.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String testSentence = "Java is fun and Java is powerful";

        // Count words
        int wordCount = countWords(testSentence);
        System.out.println("Number of words: " + wordCount);

        // Replace "Java" with "Programming"
        String replacedText = replaceWord(testSentence, "Java", "Programming");
        System.out.println("Replaced text: " + replacedText);
    }
}
