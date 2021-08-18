package Minesweeper;

import java.util.Random;

public class Randomizer {
    public static int getRandom(int lowerBound, int upperBound) {
        return new Random().nextInt(upperBound - lowerBound)+ lowerBound;
    }
}
