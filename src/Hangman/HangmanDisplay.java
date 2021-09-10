package Hangman;

import java.util.ArrayList;

public class HangmanDisplay {
    public static void main(String[] args) {
        // Empty
    }

    static void displayHangmanImage(int index){
        String[] imageList = {
                "    |\n",
                "    |\n",
                "    \\o \n",
                "    /|\\ \n" +
                        "    `/\\\\ \n" +
                        "     \\ \\ \n"};

        String imageString = "";
        for (int count = 1; count < index; count++) {
            imageString = imageString.concat(imageList[count]);
        }

        System.out.println("\nHANGMAN\n" + imageString);
    }

    static void displayWinnerImage(){
        String[] image = {
                "    \\o/ \n",
                "     | \n",
                "   ,`/\\, ,`\n",
                "   `,\\ \\ ,`\n"};
        System.out.println(image[0] + image[1] + image[2] + image[3]);
    }

    static void displayWordString(ArrayList<String> secretWordStringList, ArrayList<String> secretWordList, ArrayList<String> correctGuesses){

        for (int index = 0; index < secretWordList.size(); index++){
            String word = secretWordList.get(index);
            for (String character: correctGuesses){
                if (character.equalsIgnoreCase(word)) {
                    secretWordStringList.set(index, character);
                }
            }
        }
        System.out.println("Secret Word: " + String.join("", secretWordStringList));
    }

    static void displayOptions(ArrayList<String> allOptions){
        System.out.println("Options: " + String.join("|", allOptions));
    }

    static void displayUserCurrentStatus(ArrayList<String> guessesUserMade, int livesRemaining){
        String message = "Guesses Made: " + String.join("|", guessesUserMade) + "\n" +
                "Lives Remaining: " + livesRemaining;
        System.out.println(message);
    }

}
