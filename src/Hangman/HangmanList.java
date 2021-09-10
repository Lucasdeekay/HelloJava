package Hangman;

import StringCharacters.StringList;

import java.util.ArrayList;
import java.util.Arrays;

public class HangmanList {
    public static void main(String[] args) {
        // Empty
    }

    static ArrayList<String> getSecretWordList(String secretWord){
        ArrayList<String> secretWordList = new ArrayList<>();

        for (int index=0; index < secretWord.length(); index++) {
            char character = secretWord.charAt(index);
            secretWordList.add(String.valueOf(character));
        }
        return secretWordList;
    }

    static ArrayList<String> getSecretWordStringList(ArrayList<String> secretWordList){
        ArrayList<String> wordString = new ArrayList<>();
        char[] alphabet = StringList.alphabetList();

        for (String word: secretWordList){
            if (word.isBlank()) {
                wordString.add(" ");
            }
            else if (Arrays.toString(alphabet).contains(word)) {
                wordString.add("_");
            }
            else {
                wordString.add(word);
            }
        }
        return wordString;
    }

    static ArrayList<String> getCorrectOptionsList(String secretWord){
        ArrayList<String> secretWordList = new ArrayList<>();
        char[] alphabets = StringList.alphabetList();

        for (int index=0; index < secretWord.length(); index++) {
            char character = secretWord.charAt(index);
            if ((character != ' ') & (!secretWordList.contains(String.valueOf(character)))
                    & Arrays.toString(alphabets).contains(String.valueOf(character)) ){
                secretWordList.add(String.valueOf(character));
            }
        }
        return secretWordList;
    }

    static ArrayList<String> getWrongOptionsList(ArrayList<String> correctOptions) {
        ArrayList<String> wrongOptions = new ArrayList<>();

        char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        int NUMBER_OF_WRONG_OPTIONS = 5;
        int count = 0;

        do {
            char letter = alphabets[(int) (Math.random() * alphabets.length)];
            if (!correctOptions.contains(String.valueOf(letter)) & !wrongOptions.contains(String.valueOf(letter))) {
                wrongOptions.add(String.valueOf(letter));
                count++;
            }
        } while (count < NUMBER_OF_WRONG_OPTIONS);

        return wrongOptions;
    }

    static ArrayList<String> getOptionsList(ArrayList<String> correctOptions, ArrayList<String> wrongOptions){

        ArrayList<String> shuffledOptionsList = new ArrayList<>();

        String options = HangmanString.convertListToString(correctOptions) + HangmanString.convertListToString(wrongOptions);
        char[] optionsList = options.toCharArray();

        int count = 0;

        do{
            char character = optionsList[(int) (Math.random() * optionsList.length)];
            if (!shuffledOptionsList.contains(String.valueOf(character))){
                shuffledOptionsList.add(String.valueOf(character));
                count++;
            }
        }while (count < optionsList.length);

        return shuffledOptionsList;
    }
}
