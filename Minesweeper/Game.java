package Minesweeper;

public class Game {
    private final int nMines;
    private final int nRows, nColumns;
    private final Field[][] fields;
    private boolean alive;

    public Game(int nRows, int nColumns, int nMines){
        this.nColumns = nColumns;
        this.nMines = nMines;
        this.nRows = nRows;
        this.alive = true;

        fields = new Field[nRows][nColumns];
        for(int r = 0; r < nRows; ++r){
            for (int c = 0; c < nColumns; ++c){
                fields[r][c] = new Field();
            }
        }
    }
    public void mark(int row, int col) {
        this.fields[row][col].toggleMark();
    }

    public void guess(int row, int col) {
        final char response = this.fields[row][col].uncover();
        if(response == 'x') {
            this.alive = false;
        }else if ( response == '0') {
            // uncover all neighbors
            // up
            if (row > 0 && this.fields[row - 1][col].getVisibility() == Visibility.COVERED) {
                this.guess(row - 1, col);
            }
            // right
            if (col < this.nColumns - 1 && this.fields[row][col + 1].getVisibility() == Visibility.COVERED) {
                this.guess(row, col + 1);
            }
            // down
            if (row < this.nRows - 1 && this.fields[row + 1][col].getVisibility() == Visibility.COVERED) {
                this.guess(row + 1, col);
            }
            // left
            if (col > 0 && this.fields[row][col - 1].getVisibility() == Visibility.COVERED) {
                this.guess(row, col - 1);
            }
        }
    }

    public void prepareGame(int firstRow, int firstCol) {
        //set Mines
        while (this.countCoveredMines() < this.nMines) {
            final int row = Randomizer.getRandom(0, this.nRows);
            final int col = Randomizer.getRandom(0, this.nColumns);
            if (firstRow != row || firstCol != col) {
                this.fields[row][col].setBomb();
            }
        }       //Updates Field next to mine
        for (int r = 0; r < nRows; ++r) {
            for (int c = 0; c < nColumns; ++c) {
                if (fields[r][c].isBomb()) {
                    for (int r_ = -1; r_ <= 1; ++r_) {
                        for (int c_ = -1; c_ <= 1; ++c_) {
                            try {
                                fields[r + r_][c + c_].incrementValue();
                            } catch (Exception ignored) {

                            }
                        }
                    }
                }
            }
        }
        this.guess(firstRow, firstCol);
    }

    public int countCoveredMines(){
        int value = 0;
        for (int r = 0; r < nRows; ++r){
            for (int c = 0; c < nColumns; ++c){
                final Field f = fields[r][c];
                if (f.isBomb() && f.getVisibility() == Visibility.COVERED) ++value;
            }
        }
        return value;
    }

    public int countCoveredNeutral(){
        int value = this.nRows * this.nColumns;
        for (int r = 0; r < nRows; ++r){
            for (int c = 0; c < nColumns; ++c){
                final Field f = fields[r][c];
                final Visibility v = f.getVisibility();
                if (f.isBomb() || v == Visibility.DISCOVERED) --value;
            }
        }
        return value;
    }
    //Create Game field
    public void drawGame(){
        System.out.print(" |");
        StringBuilder sb = new StringBuilder("--+");
        for(int i = 0; i < this.nColumns; ++i) {
            System.out.print(" "+Character.toString((char)65+i)+" ");
            sb.append("---");
        }
        System.out.println();
        System.out.println(sb);
        for(int i = 1; i <= this.nRows; ++i){
            this.printLine(i);
        }
    }
    public void printLine(int lineNumber) {
        if (lineNumber < 10) {
            System.out.print(" ");
        }
        System.out.print(lineNumber + "|");
        for(int i = 0; i <this.nColumns; ++i){
            System.out.print(" "+ this.fields[lineNumber - 1][i].getLabel() + " ");
        }
        System.out.println();
    }

    public boolean isAlive(){
        return this.alive;
    }

}
