package guessingGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame implements Runnable{
    private boolean gameRunning;
    private int numberToGuess;
    private int numGuesses;

    public NumberGuessingGame() {
        gameRunning = true;
        numberToGuess = new Random().nextInt(100) + 1;
        numGuesses = 0;
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            System.out.print("Enter your guess (1-100): ");
            int guess = scanner.nextInt();
            numGuesses++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations, you guessed the number in " + numGuesses + " guesses!");
                gameRunning = false;
            }
        }


    }
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        Thread t = new Thread(game);
        t.start();
    }

}

