/**
 * @author Thijs Ermens
 * @date 25-11-2020
 * @function Functie dat met een ingegeven array
 * het 'Game of Life' van Conway kan berekenen
 */
package Afvink2;

public class Calc {
    public int[][] GetCalc(int[][] array) {
        int[][] nieuwearray = new int[10][10];
        int omliggendeBlokjes;

        // for loops die kijken hoeveel blokken er om elk blokje heen liggen
        try {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i == 0 && j == 0) {
                        omliggendeBlokjes = array[i + 1][j] + array[i][j + 1] + array[i + 1][j + 1];
                    } else if (i == 0 && j == 9) {
                        omliggendeBlokjes = array[i + 1][j] + array[i][j - 1] + array[i + 1][j - 1];
                    } else if (i == 9 && j == 0) {
                        omliggendeBlokjes = array[i - 1][j] + array[i][j + 1] + array[i - 1][j + 1];
                    } else if (i == 9 && j == 9) {
                        omliggendeBlokjes = array[i - 1][j] + array[i][j - 1] + array[i - 1][j - 1];
                    } else if (i == 9) {
                        omliggendeBlokjes = array[i][j + 1] + array[i - 1][j] + array[i][j - 1] + array[i - 1][j - 1]
                                + array[i - 1][j + 1];
                    } else if (i == 0) {
                        omliggendeBlokjes = array[i + 1][j] + array[i][j + 1] + array[i][j - 1] + array[i + 1][j + 1]
                                + array[i + 1][j - 1];
                    } else if (j == 0) {
                        omliggendeBlokjes = array[i + 1][j] + array[i][j + 1] + array[i - 1][j] + array[i + 1][j + 1]
                                + array[i - 1][j + 1];
                    } else if (j == 9) {
                        omliggendeBlokjes = array[i + 1][j] + array[i - 1][j] + array[i][j - 1] + array[i - 1][j - 1]
                                + array[i + 1][j - 1];
                    } else {
                        omliggendeBlokjes = array[i + 1][j] + array[i][j + 1] + array[i - 1][j] + array[i][j - 1]
                                + array[i - 1][j - 1] + array[i + 1][j + 1] + array[i - 1][j + 1] +
                                array[i + 1][j - 1];
                    }

                    // statement dat de waardes van 1 naar 0 veranderd als er niet het juiste aantal blokjes om het
                    // blokje heen liggen en van 0 naar 1 veranderd als er wel het juiste aantal blokjes om het blokje
                    // heen liggen
                    if (array[i][j] == 1 && omliggendeBlokjes == 2) {
                        nieuwearray[i][j] = 1;
                    } else if (omliggendeBlokjes == 3) {
                        nieuwearray[i][j] = 1;
                    } else {
                        nieuwearray[i][j] = 0;
                    }
                }
            }
        } catch (Exception event) {
            System.out.println("Out of bounds");
        }
        return nieuwearray;
    }
}