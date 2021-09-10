package PasswordGenerator;

import StringCharacters.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratePassword {
    public static void main(String[] args) {
        printInformation();
        getPassword();
    }

    // Method prints program's information
    public static void printInformation(){
        System.out.println("This program generates a 9-character password\n");
    }

    // Method gets random character from a list and add it to another new list
    public static void getRandomCharacters(char[] listToPickFrom, List<Character> listToAddTo){
        Random random = new Random();

        // Initialize list
        List<Character> randomCharacterList = new ArrayList<>();

        for (int loop = 1; loop <= 3; loop++){
            int randomIndex = random.nextInt(listToPickFrom.length);
            char randomPick = listToPickFrom[randomIndex];
            // Add list of new character to the initialized list
            randomCharacterList.add(randomPick);
        }

        // Add initialized list to the list for collecting random characters
        listToAddTo.addAll(randomCharacterList);
    }

    // Method randomly shuffles the generated list
    public static List<Character> shuffleList(){
        Random random = new Random();

        char[] alphabetList = StringList.alphabetList();
        char[] numberList = StringList.numberList();
        char[] symbolList = StringList.symbolList();

        // Initialize a list to store the shuffled version of the random characters collected
        List<Character> shuffledPasswordList = new ArrayList<>();

        // Initialized a list to store all random characters from the different lists
        List<Character> generatedPasswordList = new ArrayList<>();

        // Call method to add random characters from each list to the same general list
        getRandomCharacters(alphabetList, generatedPasswordList);
        getRandomCharacters(numberList, generatedPasswordList);
        getRandomCharacters(symbolList, generatedPasswordList);


        for (int count = generatedPasswordList.size(); count > 0; count--){
            int randomIndex = random.nextInt(generatedPasswordList.size());
            char randomPick = generatedPasswordList.get(randomIndex);
            // Add character to the list of shuffled characters
            shuffledPasswordList.add(randomPick);
            // Remove character from the list of previously generated characters
            generatedPasswordList.remove(randomIndex);
        }

        return shuffledPasswordList;
    }

    // Method prints the password string
    public static String getPassword(){
        List<Character> passwordList = shuffleList();

        String passwordString = "";
        for (char character : passwordList) {
            passwordString = passwordString.concat(String.valueOf(character));
        }

        System.out.println("Password: " + passwordString);

        return passwordString;
    }
}
