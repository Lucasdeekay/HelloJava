package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        // Empty
        TicTacToe();
    }

    static void printInstruction() {
        String message = "\nTo play Tic-Tac-Toe, input the right index of the desired position\n" +
                "Index are shown below alongside diagram of the game board\n" +
                "\n" +
                "|0|1|2|\n" +
                "|3|4|5|\n" +
                "|6|7|8|\n" +
                "\n" +
                "Input the desired index to insert your avatar into the desired position\n\n" +
                "LET'S PLAY\n";
        System.out.println(message);
    }

    static byte getNumberOfPlayers(){
        byte numberOfPlayers = 0;
        do {
            try {
                Scanner user = new Scanner(System.in);
                System.out.print("NUMBER OF PLAYERS: ");
                numberOfPlayers = user.nextByte();

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid Input");
            }
        }while (numberOfPlayers < 1 || numberOfPlayers > 2);
        return numberOfPlayers;
    }

    static String getPlayerName() {
        Scanner user = new Scanner(System.in);

        System.out.print("Enter Name: ");
        return user.next().trim().strip();
    }

    static ArrayList<String> playerNames(int numberOfPlayers){
        ArrayList<String> players = new ArrayList<>();
        for (int count=0; count < numberOfPlayers; count++){
            String player = getPlayerName();
            players.add(player);
        }
        if (numberOfPlayers == 1){
            players.add(1, "Avatar");
        }
        return players;
    }

    static String[] boardStructure(){
        return new String[]{
                "_", "_", "_",
                "_", "_", "_",
                "_", "_", "_"
        };
    }

    static String displayGameBoard(String[] boardStructure){
        return "|" + boardStructure[0] + "|" + boardStructure[1] + "|" + boardStructure[2] + "|\n" +
                "|" + boardStructure[3] + "|" + boardStructure[4] + "|" + boardStructure[5] + "|\n" +
                "|" + boardStructure[6] + "|" + boardStructure[7] + "|" + boardStructure[8] + "|\n" ;
    }

    static void updateGameBoard(String[] boardStructure, byte index, String avatar){
        boardStructure[index] = avatar;
        System.out.println(displayGameBoard(boardStructure));
    }

    static byte changeCurrentPlayerIndex(byte currentIndex){
        if (currentIndex == 0){
            return 1;
        }
        else {
            return 0;
        }
    }

    static byte getUserInput(String currentPlayer){
        byte index;

        if (currentPlayer.equals("Avatar")){
            index = (byte) (Math.random() * 8);
        }
        else {
            do {
                Scanner user = new Scanner(System.in);
                System.out.print("Enter Position: ");
                index = user.nextByte();
            } while (index > 8);
        }

        return index;
    }

    static byte validateUserInput(String currentPlayer, String[] boardStructure){
        do {
            byte index = getUserInput(currentPlayer);
            if (boardStructure[index].equals("_")){
                return index;
            }
            else {
                if (!currentPlayer.equals("Avatar")) {
                    System.out.println("Position already filled");
                }
            }
        }while (true);
    }

    static boolean checkWinner(String[] boardStructure, int[]scoreList, ArrayList<String> playerList) {
        boolean game_on = true;

     // Player 1
        // Horizontal
        if ( (boardStructure[0].equals("X") & boardStructure[1].equals("X") & boardStructure[2].equals("X")) | (boardStructure[3].equals("X") & boardStructure[4].equals("X") & boardStructure[5].equals("X"))
        | (boardStructure[6].equals("X") & boardStructure[7].equals("X") & boardStructure[8].equals("X")) ) {
            System.out.println("\n" + playerList.get(0) + " wins");
            scoreList[0] += 1;
            game_on = false;
        }
    // Vertical
        else if ( (boardStructure[0].equals("X") & boardStructure[3].equals("X") & boardStructure[6].equals("X")) | (boardStructure[1].equals("X") & boardStructure[4].equals("X") & boardStructure[7].equals("X"))
        | (boardStructure[2].equals("X") & boardStructure[5].equals("X") & boardStructure[8].equals("X")) ) {
            System.out.println("\n" + playerList.get(0) + " wins");
            scoreList[0] += 1;
            game_on = false;
        }
    // Diagonal
        else if ( (boardStructure[0].equals("X") & boardStructure[4].equals("X") & boardStructure[8].equals("X")) | (boardStructure[2].equals("X") & boardStructure[4].equals("X") & boardStructure[6].equals("X")) ){
            System.out.println("\n" + playerList.get(0) + " wins");
            scoreList[0] += 1;
            game_on = false;
        }
    // Player 2
        // Horizontal
        else if ( (boardStructure[0].equals("O") & boardStructure[1].equals("O") & boardStructure[2].equals("O")) | (boardStructure[3].equals("O") & boardStructure[4].equals("O") & boardStructure[5].equals("O"))
        | (boardStructure[6].equals("O") & boardStructure[7].equals("O") & boardStructure[8].equals("O")) ) {
            System.out.println("\n" + playerList.get(1) + " wins");
            scoreList[1] += 1;
            game_on = false;
        }
    // Vertical
        else if ( (boardStructure[0].equals("O") & boardStructure[3].equals("O") & boardStructure[6].equals("O")) | (boardStructure[1].equals("O") & boardStructure[4].equals("O") & boardStructure[7].equals("O"))
        | (boardStructure[2].equals("O") & boardStructure[5].equals("O") & boardStructure[8].equals("O")) ){
            System.out.println("\n" + playerList.get(1) + " wins");
            scoreList[1] += 1;
            game_on = false;
        }
    // Diagonal
        else if ( (boardStructure[0].equals("O") & boardStructure[4].equals("O") & boardStructure[8].equals("O")) | (boardStructure[2].equals("O") & boardStructure[4].equals("O") & boardStructure[6].equals("O")) ){
            System.out.println("\n" + playerList.get(1) + " wins");
            scoreList[1] += 1;
            game_on = false;
        }

        else if (!Arrays.toString(boardStructure).contains("_")) {
            System.out.println("\nTie");
            game_on = false;
        }

        return game_on;
    }

    static void printScores(int[]scoreList, ArrayList<String> playerList){
        String message = playerList.get(0) + ": " + scoreList[0] + "\n" +
                playerList.get(1) + ": " + scoreList[1] + "\n";
        System.out.println(message);
    }

    static void TicTacToe(){
        printInstruction();

        byte numberOfPlayers = getNumberOfPlayers();

        ArrayList<String> players = playerNames(numberOfPlayers);
        String[] avatars = new String[] {"X", "O"};
        int[] scores = new int[]{0, 0};

        byte currentPlayerIndex = 0;

        String[] board = boardStructure();
        String gameBoard = displayGameBoard(board);
        System.out.println(gameBoard);

        boolean checkBoard = true;

        do {
            try {
                System.out.println(players.get(currentPlayerIndex) + "\n");

                byte position = validateUserInput(players.get(currentPlayerIndex), board);

                String currentAvatar = avatars[currentPlayerIndex];

                updateGameBoard(board, position, currentAvatar);
                currentPlayerIndex = changeCurrentPlayerIndex(currentPlayerIndex);

                checkBoard = checkWinner(board, scores, players);
            }
            catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid Input");
            }
        }while (checkBoard);

        printScores(scores, players);
    }
    
}
