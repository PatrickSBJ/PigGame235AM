package com.example.piggame;

import java.util.Random;

public class PigGame {
    final private int WINNING_SCORE = 100;

    private Random rand = new Random();
    private int player1Score;
    private int player2Score;
    private int turnPoints;
    private String player1Name = "";
    private String player2Name = "";
    private int turn;
    private boolean firstTurn;

    public void PigGame()
    {
        player1Score = 0;
        player2Score = 0;
        turnPoints = 0;
        turn = 1; // player 1 goes first
        firstTurn = true;
    }

    public void PigGame(int p1Score, int p2Score, int tPoints, int t)
    {
        player1Score = p1Score;
        player2Score = p2Score;
        turnPoints = tPoints;
        turn = t;
        firstTurn = true;

    }

    public void setPlayer1Name(String n)
    {
        player1Name = n;
    }

    public String getPlayer1Name()
    {
        return player1Name;
    }

    public void setPlayer2Name(String n)
    {
        player2Name = n;
    }

    public String getPlayer2Name()
    {
        return player2Name;
    }

    public int getTurn() {
        return turn;
    }

    public int getPlayer1Score()
    {
        return player1Score;
    }


    public int getPlayer2Score()
    {
        return player2Score;
    }

    public void resetGame()
    {
        player1Score = 0;
        player2Score = 0;
        turnPoints = 0;
        turn = 1;
        firstTurn = true;
    }

    public int rollDie()
    {
        int roll = rand.nextInt(9);

        if(roll != 8)
        {
            turnPoints += roll;
        }
        else
        {
            turnPoints = 0;
        }

        return roll;
    }

    public int getTurnPoints()
    {
        return turnPoints;
    }

    public String getCurrentPlayer()
    {
        if(turn % 2 == 1)
            return player1Name;
        else
            return player2Name;
    }

    public int changeTurn()
    {
        if(turn % 2 == 1)
            player1Score += turnPoints;
        else
            player2Score += turnPoints;

        turnPoints = 0;

        if(turn == 1)
            turn = 2;
        else
            turn = 1;

        firstTurn = false;

        return turn;
    }

    public String checkForWinner()
    {
        String winnerMessage = "";
        if (player1Score >= WINNING_SCORE || player2Score >= WINNING_SCORE) {
            if (player2Score > player1Score) {
                winnerMessage = String.format("%s wins!", player2Name);
            }
            // Player 1 can only win after player 2 has had thier turn
            // This is so both players can have an equal number of turns
            else if (player1Score > player2Score && !firstTurn) {
                winnerMessage = String.format("%s wins!", player1Name);
            } else if (player1Score == player2Score) {
                winnerMessage = "Tie";
            }
        }
        return winnerMessage;
    }
}
