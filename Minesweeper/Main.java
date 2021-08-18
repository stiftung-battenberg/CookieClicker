package Minesweeper;

class Main {
    public static final int nMines = 10;
    public static final int nRows = 9,nColumns = 9;

    public static void main (String[] args) {
    Game game = new Game(nRows,nColumns,nMines);
    GuessHandler guessHandler = new GuessHandler(nRows,nColumns);


        game.drawGame();
        Guess g = guessHandler.getGuess();

        game.prepareGame(g.row, g.col);

        game.drawGame();

        while(game.isAlive() && game.countCoveredNeutral() > 0) {
            g = guessHandler.getGuess();
            if(g.hardtest) {
                game.guess(g.row, g.col);
            } else {
                game.mark(g.row, g.col);
            }
            game.drawGame();
        }
        if (game.isAlive()) {
            System.out.println("NICE!");
        } else {
            System.out.println("You Lose!");
        }
    }
}


