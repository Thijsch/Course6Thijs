/**
 * @author Thijs Ermens
 * @date 24-11-2020
 * @function Script dat Game of Life simuleert
 */
package Afvink2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame implements ActionListener {
    private int[][] array = new int[10][10];
    private JPanel panel;

    public static void main(String[] args) {
        GameOfLife frame = new GameOfLife();
        frame.setSize(1000, 1000);
        frame.makeGUI();
        frame.setVisible(true);
    }

    public void makeGUI() {
        /**
         * Functie die de GUI maakt
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // aanmaken button
        JButton button = new JButton("Start");
        button.addActionListener(this);
        window.add(button);

        // Declareren van de zwarte vlakken
        array[1][0] = 1;
        array[2][1] = 1;
        array[2][2] = 1;
        array[1][2] = 1;
        array[0][2] = 1;

        // aanmaken panel
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.WHITE);
        window.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Functie die met de gedeclareerde waarden de Calc functie uitvoert na het klikken van de START-button.
         */
        try {
            Graphics tekenveld = panel.getGraphics();

            // for loop die de vlakken wit maakt als ze 0 zijn en zwart maakt als ze 1 zijn
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (array[i][j] == 1) {
                        tekenveld.setColor(Color.BLACK);
                        tekenveld.fillRect(i * 50, j * 50, 50, 50);
                    } else if (array[i][j] == 0) {
                        tekenveld.setColor(Color.WHITE);
                        tekenveld.fillRect(i * 50, j * 50, 50, 50);
                    }
                }
            }
            Calc nextcalc = new Calc();
            array = nextcalc.GetCalc(array);
        } catch (Exception event) {
            System.out.println("Fout bij kleur");
        }
    }
}