package Hangman;

import java.util.*;

public class PlayHangman {
    public static void main(String[] args) {
        // Empty
        HangmanMain();
    }


    static boolean verifyUserGuess(String guessMade, ArrayList<String> allOptions, ArrayList<String> correctOptions, ArrayList<String> guessesUserMade,
                               ArrayList<String> correctGuesses, ArrayList<String> secretWordList, ArrayList<String> secretWordStringList,
                               int livesRemaining){

        boolean status = true;

        if (guessMade.length() == 1) {
            if (allOptions.contains(guessMade) & correctOptions.contains(guessMade)) {
                correctGuesses.add(guessMade);
                guessesUserMade.add(guessMade);
                allOptions.remove(guessMade);
                System.out.println("Correct\n");
            }
            else if (allOptions.contains(guessMade) & !correctOptions.contains(guessMade)){
                guessesUserMade.add(guessMade);
                allOptions.remove(guessMade);
                System.out.println("Wrong\n");
                livesRemaining--;
                status = false;
            }
            else {
                System.out.println("Word not included in options\n");
            }

            HangmanDisplay.displayWordString(secretWordStringList, secretWordList, correctGuesses);
            HangmanDisplay.displayUserCurrentStatus(guessesUserMade, livesRemaining);
        }
        else{
            System.out.println("Invalid Guess\n");
        }

        return status;

    }

    static boolean checkForWin(ArrayList<String> secretWordStringList, String player){
        if (!secretWordStringList.contains("_")) {
            System.out.println("\n" + player + " Wins\n");
            System.out.println("HANGMAN\n");
            HangmanDisplay.displayWinnerImage();
            return true;
        }
        else
            return false;
    }

    static int runGame(String player, int level) {

        String category = HangmanString.getSecretWordCategory().toUpperCase();
        String secretWord = HangmanString.getSecretWord(category).toUpperCase();
        ArrayList<String> secretWordList = HangmanList.getSecretWordList(secretWord);
        ArrayList<String> secretWordStringList = HangmanList.getSecretWordStringList(secretWordList);

        ArrayList<String> correctOptions = HangmanList.getCorrectOptionsList(secretWord);
        ArrayList<String> wrongOptions = HangmanList.getWrongOptionsList(correctOptions);
        ArrayList<String> allOptions = HangmanList.getOptionsList(correctOptions, wrongOptions);

        int livesRemaining = 3;
        int displayIndex = 1;

        ArrayList<String> guessesUserMade = new ArrayList<>();
        ArrayList<String> correctGuesses = new ArrayList<>();

        System.out.println("LEVEL " + level);

        System.out.println("Player: " + player + "\n");
        System.out.println("Category: " + category + "\n");

        HangmanDisplay.displayWordString(secretWordStringList, secretWordList, correctGuesses);
        HangmanDisplay.displayUserCurrentStatus(guessesUserMade, livesRemaining);

        int levelUp = 0;

        while (livesRemaining != 0) {

            HangmanDisplay.displayOptions(allOptions);
            String guessMade = HangmanString.getUserGuess().toUpperCase();

            boolean rightGuess = verifyUserGuess(guessMade, allOptions, correctOptions, guessesUserMade, correctGuesses,
                    secretWordList, secretWordStringList, livesRemaining);

            boolean winStatus = checkForWin(secretWordStringList, player);

            if (winStatus) {
                levelUp = 1;
                break;
            }
            else {
                if (!rightGuess) {
                    livesRemaining--;
                    displayIndex++;
                    if (livesRemaining == 0) {
                        System.out.println("\nFarewell " + player);
                        System.out.println("Secret Word: " + secretWord);
                    }
                }
                HangmanDisplay.displayHangmanImage(displayIndex);
            }
        }

        return levelUp;
    }


    public static void HangmanMain(){
        HangmanString.welcomeMessage();
        String player = HangmanString.getPlayerName();
        int level = 1;
        while (level > 0) {
            int gameStatus = runGame(player, level);
            if (gameStatus == 1)
                level++;
            else
                break;
        }
    }

}
