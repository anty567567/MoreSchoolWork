/* ReviewAssignment.java
Description: A review of various types of programs having to do with strings
Name: Anthony De Luca
Date Created: 12th February 2018
Last Modified: 22nd February 2018
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringsAssignment {

    public static InputStreamReader inStream = new InputStreamReader(System.in);
    public static BufferedReader sysin = new BufferedReader(inStream);

    public static void main(String[] args) throws IOException {
        int choice;
        boolean properSelection;

        while (true) {
            System.out.print("Please select the program you would like to run (10-20, 0 to exit):\n0.Exit\n10.Remove Vowels\n11.Remove Consonants\n12.X's To The End\n13.Pairs\n14.ABCABA\n15.Clean Word\n16.Sub In String\n17.Guess Subs\n18.Stars After Vowels\n19.Count Sub Words\n20.Remove Sub Words\nChoice:");
            choice = Integer.parseInt(sysin.readLine());
            do {
                properSelection = true;
                switch (choice) {
                    case 0:
                        System.exit(1);
                    case 10:
                        removeAllVowels();
                        break;
                    case 11:
                        removeAllConsonants();
                        break;
                    case 12:
                        xAtEnd();
                    case 13:
                        pairs();
                        break;
                    case 14:
                        abcaba();
                        break;
                    case 15:
                        cleanStrings();
                        break;
                    case 16:
                        subInString();
                        break;
                    case 17:
                        guessSubs();
                        break;
                    case 18:
                        starsAfterVowels();
                        break;
                    case 19:
                        countSubWords();
                        break;
                    case 20:
                        removeSubWords();
                        break;
                    default:
                        properSelection = false;
                        System.out.print("Please input an acceptable choice (10-20, 0 to exit):\n0.Exit\n10.Remove Vowels\n11.Remove Consonants\n12.X's To The End\n13.Pairs\n14.ABCABA\n15.Clean Word\n16.Sub In String\n17.Guess Subs\n18.Stars After Vowels\n19.Count Sub Words\n20.Remove Sub Words\nChoice:");
                        choice = Integer.parseInt(sysin.readLine());
                        break;
                }
            } while (!properSelection);
        }
    }

    public static void removeAllVowels() throws IOException {
        String originalWord;
        StringBuilder noVowels = new StringBuilder();
        System.out.print("Please input a word to have all the vowels removed: ");
        originalWord = sysin.readLine();
        for (int i = 0; i < originalWord.length(); i++) {
            if (!(originalWord.substring(i, i + 1).equalsIgnoreCase("a") || originalWord.substring(i, i + 1).equalsIgnoreCase("e") || originalWord.substring(i, i + 1).equalsIgnoreCase("i") || originalWord.substring(i, i + 1).equalsIgnoreCase("o") || originalWord.substring(i, i + 1).equalsIgnoreCase("u"))) {
                noVowels.append(originalWord.substring(i, i + 1));
            }
        }
        System.out.println("The word without vowels is: " + noVowels + "\n");
    }

    public static void removeAllConsonants() throws IOException {
        String originalWord;
        StringBuilder noConsonants = new StringBuilder();
        System.out.print("Please input a word to have all the vowels removed: ");
        originalWord = sysin.readLine();
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.substring(i, i + 1).equalsIgnoreCase("a") || originalWord.substring(i, i + 1).equalsIgnoreCase("e") || originalWord.substring(i, i + 1).equalsIgnoreCase("i") || originalWord.substring(i, i + 1).equalsIgnoreCase("o") || originalWord.substring(i, i + 1).equalsIgnoreCase("u")) {
                noConsonants.append(originalWord.substring(i, i + 1));
            }
        }
        System.out.println("The word without consonants is: " + noConsonants + "\n");
    }

    public static void xAtEnd() throws IOException {
        int numOfX = 0;
        String word;
        StringBuilder newWord = new StringBuilder();

        System.out.print("Please input a word to have all the x's sent to the end of the word: ");
        word = sysin.readLine();
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i + 1).equals("x")) {
                numOfX++;
            } else {
                newWord.append(word.substring(i, i + 1));
            }
        }
    }

    public static void pairs() throws IOException {
        String word;
        int pairs = 0;
        System.out.print("Please input a word to determine the number of pairs there are(3 or more characters): ");
        word = sysin.readLine();
        for (int i = 0; i < word.length() - 2; i++) {
            if (word.substring(i, i + 1).equals(word.substring(i + 2, i + 3)) && !word.substring(i, i + 1).equals(word.substring(i + 1, i + 2))) {
                pairs++;
            }
        }
        System.out.println("There are " + pairs + " pairs in the word\n");
    }

    public static void abcaba() throws IOException {
        String word;
        int numOfAbcaba = 0;

        System.out.print("Please input a word to find out how many times 'aba' or 'abc' appears: ");
        word = sysin.readLine();
        for (int i = 0; i < word.length() - 2; i++) {
            if (word.substring(i, i + 3).equals("abc") || word.substring(i, i + 3).equals("aba")) {
                numOfAbcaba++;
            }
        }
        System.out.println("There are " + numOfAbcaba + " groups of aba or abc\n");
    }

    public static void cleanStrings() throws IOException {
        String word;

        System.out.print("Please enter a word to be cleaned: ");
        word = sysin.readLine();
        System.out.println(cleaning(word));
    }

    public static String cleaning(String word) {
        String cleanedWord;
        StringBuilder cleanedWordBuilder = new StringBuilder();
        Boolean clean = true;

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.substring(i, i + 1).equals(word.substring(i + 1, i + 2))) {
                cleanedWordBuilder.append(word.substring(i, i + 1));
            } else if (i == 0) {
                cleanedWordBuilder.append(word.substring(i, i + 1));
            } else if (!word.substring(i, i + 1).equals(word.substring(i - 1, i))) {
                cleanedWordBuilder.append(word.substring(i, i + 1));
            }
            if (i == word.length() - 2 && !word.substring(word.length() - 1, word.length()).equals(word.substring(word.length() - 2, word.length() - 1))) {
                cleanedWordBuilder.append(word.substring(word.length() - 1, word.length()));
            }
        }

        cleanedWord = cleanedWordBuilder.toString();

        for (int i = 0; i < cleanedWord.length() - 1; i++) {
            if (cleanedWord.substring(i, i + 1).equals(cleanedWord.substring(i + 1, i + 2))) {
                clean = false;
                i = cleanedWord.length() + 12421;
            } else {
                clean = true;
            }
        }

        if (!clean) {
            cleanedWord = cleaning(cleanedWord);
        }
        return cleanedWord;
    }

    public static void subInString() throws IOException {
        String word, subWord;
        int numOfSubs = 0;
        System.out.print("Please input the initial word: ");
        word = sysin.readLine();
        System.out.print("Please input the substring: ");
        subWord = sysin.readLine();
        for (int i = 0; i < word.length() - subWord.length() + 1; i++) {
            if (word.substring(i, i + subWord.length()).equals(subWord)) {
                numOfSubs++;
                if (i > subWord.length() - 1 && word.substring(i - subWord.length(), i).equals(subWord)) {
                    numOfSubs--;
                }
            }

        }
        System.out.println("There are " + numOfSubs + " subs in the word\n");
    }

    public static void guessSubs() throws IOException {
        String word, subWord;
        int numOfSubs = 0, guess;
        System.out.print("Please input the initial word: ");
        word = sysin.readLine();
        System.out.print("Please input the substring: ");
        subWord = sysin.readLine();
        System.out.print("How many times will the sub appear: ");
        guess = Integer.parseInt(sysin.readLine());
        for (int i = 0; i < word.length() - subWord.length() + 1; i++) {
            if (word.substring(i, i + subWord.length()).equals(subWord)) {
                numOfSubs++;
                i += subWord.length() - 1;
            }
        }
        if (guess == numOfSubs) {
            System.out.println("True\n");
        } else {
            System.out.println("False\n");
        }
    }

    public static void starsAfterVowels() throws IOException {
        String word, starredWord = "";
        boolean vowels = false;
        System.out.print("Please input a word to have stars inserted into it: ");
        word = sysin.readLine();

        for (int i = 0; i < word.length(); i++) {
            if ((word.substring(i, i + 1).equals("a") || word.substring(i, i + 1).equals("e") || word.substring(i, i + 1).equals("i") || word.substring(i, i + 1).equals("o") || word.substring(i, i + 1).equals("u")) && (word.substring(i + 1, i + 2).equals("a") || word.substring(i + 1, i + 2).equals("e") || word.substring(i + 1, i + 2).equals("i") || word.substring(i + 1, i + 2).equals("o") || word.substring(i + 1, i + 2).equals("u"))) {
                vowels = true;
            }
            if (!(word.substring(i, i + 1).equals("a") || word.substring(i, i + 1).equals("e") || word.substring(i, i + 1).equals("i") || word.substring(i, i + 1).equals("o") || word.substring(i, i + 1).equals("u")) && vowels) {
                starredWord = starredWord.concat("*");
                starredWord = starredWord.concat(word.substring(i, i + 1));
                vowels = false;
            } else {
                starredWord = starredWord.concat(word.substring(i, i + 1));
            }
            if ((i == word.length() - 2) && (word.substring(i, i + 1).equals("a") || word.substring(i, i + 1).equals("e") || word.substring(i, i + 1).equals("i") || word.substring(i, i + 1).equals("o") || word.substring(i, i + 1).equals("u")) && (word.substring(i + 1, i + 2).equals("a") || word.substring(i + 1, i + 2).equals("e") || word.substring(i + 1, i + 2).equals("i") || word.substring(i + 1, i + 2).equals("o") || word.substring(i + 1, i + 2).equals("u"))) {
                starredWord = starredWord.concat(word.substring(i + 1, i + 2));
                starredWord = starredWord.concat("*");
                break;
            }
        }
        System.out.println(starredWord + "\n");
    }

    public static void countSubWords() throws IOException {
        String word, subWord;
        int numOfSubs = 0;
        System.out.print("Please input the initial word: ");
        word = sysin.readLine();
        System.out.print("Please input the substring: ");
        subWord = sysin.readLine();
        for (int i = 0; i < word.length() - subWord.length() + 1; i++) {
            if (word.substring(i, i + subWord.length()).equals(subWord)) {
                numOfSubs++;
            }
        }
        System.out.println(numOfSubs + "\n");
    }

    public static void removeSubWords() throws IOException {
        String word, subWord, cleanedWord = "";
        int counter = 0;
        System.out.print("Please input the initial word: ");
        word = sysin.readLine();
        System.out.print("Please input the substring: ");
        subWord = sysin.readLine();
        for (int i = 0; i < word.length() - subWord.length() + 1; i++) {
            if (word.substring(i, i + subWord.length()).equals(subWord)) {
                counter = subWord.length();
            } else if (counter <= 0) {
                cleanedWord = cleanedWord.concat(word.substring(i, i + 1));
            }
            if (i == word.length() - subWord.length() && counter <= 0) {
                for (int j = 0; j < subWord.length() - 1; j++) {
                    cleanedWord = cleanedWord.concat(word.substring(word.length() - subWord.length() + j + 1, word.length() - subWord.length() + j + 2));
                }
            }
            counter--;
        }
        System.out.println(cleanedWord + "\n");
    }
}
