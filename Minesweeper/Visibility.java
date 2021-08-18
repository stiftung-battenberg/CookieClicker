package Minesweeper;

public enum Visibility {
    COVERED(' '), FLAGGED('!'),DISCOVERED('n'),EXPLODED('x');

    private final char visibility;

    Visibility(final char visibility){
        this.visibility = visibility;
    }
    public char getVisibility(){
        return this.visibility;
    }
}
