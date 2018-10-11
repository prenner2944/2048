package edu.purdue.prenner.myapplication;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TwentyFortyEight {
    //This instance variable represents the board. Use this to make changes.
    private int[][] board;
    //This variable keeps
    // track of the current score.
    private int score;
    public int boardWidth;

    //Constructor
    public TwentyFortyEight(int boardWidth) {
        this.boardWidth = boardWidth;
        reset();

        // TODO
    }

    //This function resets the board to its initial state
    public void reset() {
        board = new int[boardWidth][boardWidth];
        score = 0;
        placeRandom();
        // TODO
    }

    //This function returns the total number of blank spaces on the board
    public int numBlanks() {
        int blank = 0;
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (board[i][j] == 0) {
                    blank++;
                }
            }
        }
        return blank;
        // TODO
    }

    //This function places a 2 at a random blank space on the board.
    //It does nothing if there are no blank spaces.
    public void placeRandom() {
        if (numBlanks() == 0) {
            return;
        }
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (board[i][j] == 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        Random random = new Random();
        int xtemp = random.nextInt(x.size());
        int ytemp = random.nextInt(y.size());
        int col = x.get(xtemp);
        int row = y.get(ytemp);
        board[col][row] = 2;
        // TODO
    }

    //This function attempts to move a cell at coordinates fromRow,fromCol to
    //the cell toRow,toCol. Refer to the handout for movement rules.
    public boolean moveTo(int fromRow, int fromCol, int toRow, int toCol) {

        if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0) {
            return false;
        }
        if (fromRow > boardWidth || fromCol > boardWidth || toRow > boardWidth || toCol > boardWidth) {
            return false;
        }
        if (Math.abs((fromRow + fromCol) - (toRow + toCol)) != 1) {
            return false;
        }
        if (board[fromRow][fromCol] == 0) {
            return false;
        }
        if (board[fromRow][fromCol] == board[toRow][toCol]) {
            board[toRow][toCol] *= 2;
            board[fromRow][fromCol] = 0;
            return true;
        }
        if (board[toRow][toCol] == 0) {
            board[toRow][toCol] = board[fromRow][fromCol];
            board[fromRow][fromCol] = 0;
            return true;
        }
        if (board[fromRow][fromCol] < 0) {
            return false;
        }
        if (board[toRow][toCol] < 0) {
            return false;
            // TODO
        }
        if (board[fromRow][fromCol] != board[toRow][toCol] && board[toRow][toCol] != 0) {
            return false;
        }
        return true;
    }

    public void calcScore() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (board[i][j] > score) {
                    score = board[i][j];
                }
            }
        }
    }

    //The following four functions move the board in a single direction.
    public boolean moveUp() {
        boolean temp = false;
        for (int x = 1; x < boardWidth; x++) {
            for (int y = 0; y < boardWidth; y++) {
                if (moveTo(x, y, x - 1, y) == true) {
                    temp = true;
                    calcScore();
                }
            }
        }
        /*
        for (int i = boardWidth - 1; i > 0; i--) {
            for (int j = 0; j < boardWidth; j++) {
                moveTo(i, j, i - 1, j);
                temp = moveTo(i, j, i - 1, j);
                calcScore();
            }
        }*/
        return temp;
        // TODO
    }

    public boolean moveDown() {
        // TODO
        boolean temp = false;
        for (int x = 2; x >= 0; x-- ) {
            for (int y = 0; y < boardWidth; y++) {
                if (moveTo(x, y, x + 1, y )) {
                    temp = true;
                    calcScore();
                }

            }
        }
        /*for (int i = 0; i < boardWidth - 1; i++) {
            for (int j = 0; j < boardWidth; j++) {
                moveTo(i, j, i + 1, j);
                temp = moveTo(i, j, i + 1, j);
                calcScore();
            }
        }*/
        return temp;
    }

    public boolean moveRight() {
        // TODO
        boolean temp = false;
        for (int x = 0; x < boardWidth; x++) {
            for (int y = 2; y >= 0; y--) {
                if (moveTo(x, y, x, y + 1)) {
                    temp = true;
                    calcScore();
                }
            }
        }
        /*
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth - 1; j++) {
                moveTo(i, j, i, j + 1);
                temp = moveTo(i, j, i, j + 1);
                calcScore();
            }
        }*/
        return temp;
    }

    public boolean moveLeft() {
        // TODO
        boolean temp = false;
        for (int x = 0; x < boardWidth; x++) {
            for (int y = 1; y < boardWidth; y++) {
                if (moveTo(x, y , x, y - 1)) {
                    temp = true;
                    calcScore();
                }
            }
        }
        /*
        for (int i = 0; i < boardWidth; i++) {
            for (int j = boardWidth - 1; j > 0; j--) {
                moveTo(i, j, i, j - 1);
                temp = moveTo(i, j, i, j - 1);
                calcScore();
            }
        }*/
        return temp;

    }

    ////////////////////////////////////////////////////////////////////////
    // Do not edit the methods below, they are for testing and running the
    // program.
    ////////////////////////////////////////////////////////////////////////
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] newBoard) {
        board = newBoard;
    }


    /**
     * The main will allow you to play the game.
     *
     * @param args
     */
    public static void main(String args[]) {
        TwentyFortyEight tfe = new TwentyFortyEight(4);


        Scanner s = new Scanner(System.in);
        int bestScore = 0;
        boolean resetFlag = false;

        while (true) {
            System.out.println("Current score: " + tfe.getScore() + " | Best score: " + bestScore);
            tfe.showBoard();

            System.out.println("Enter up, down, left or right to move in that direction.");
            System.out.println("Enter reset to reset the game or quit to exit.");
            String line = s.nextLine();

            switch (line) {
                case "up":
                    while (tfe.moveUp()) {
                        // do nothing
                    }
                    break;
                case "down":
                    while (tfe.moveDown()) {
                        // do nothing
                    }
                    break;
                case "left":
                    while (tfe.moveLeft()) {
                        // do nothing
                    }
                    break;
                case "right":
                    while (tfe.moveRight()) {
                        // do nothing
                    }
                    break;
                case "reset":
                    tfe.reset();
                    resetFlag = true;
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Invalid move, Please try again!!!!\n");
                    continue;

            }

            bestScore = Math.max(bestScore, tfe.getScore());
            if (!resetFlag) {
                tfe.placeRandom();
                resetFlag = false;
            }
        }
    }


    public void showBoard() {
        for (int x = 0; x < boardWidth * 6 + 1; x++) {
            System.out.print("-");
        }
        System.out.println();

        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardWidth; y++) {
                String square = (board[x][y] == 0) ? "" : board[x][y] + "";
                System.out.printf("|%5s", square);
            }
            System.out.println("|");

            for (int y = 0; y < boardWidth * 6 + 1; y++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public int getScore() {
        return score;
    }

}
