import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<>();
        String line;
        int counter = 0;
        List<String> repetetiveLettersList = new ArrayList<>();
        String randomWord = "";

        System.out.println("Please enter words (press Enter on an empty line to finish):");

        while (true) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputList.add(line);
        }
        scanner.close();

        for(int i = 0; i < inputList.size(); i++) {
            if(counter<2){
                if(hasRepetitiveLetters((inputList.get(i)))){
                    counter++;
                    repetetiveLettersList.add(inputList.get(i));
                }
            }else break;
        }
        System.out.println("Words with repetitive letters list = " + repetetiveLettersList);

        for(int i = 0; i < repetetiveLettersList.size(); i++) {
            randomWord += repetetiveLettersList.get(i);
        }
        randomWord = randomizeString(randomWord);
        System.out.println("Random word = " + randomWord);
    }

    private static boolean hasRepetitiveLetters(String word) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String randomizeString(String input) {
        char[] characters = input.toCharArray();
        Random random = new Random();

        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}