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
import java.lang.reflect.Array;

public class GameOfLife extends JFrame implements ActionListener {
    static int[][] array = new int[10][10];
    private JPanel panel;
    private JButton button;

    public static void main(String[] args) {

        GameOfLife frame = new GameOfLife();
        frame.setSize(1000, 1000);
        frame.makeGUI();
        frame.setVisible(true);

    }

    public void makeGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("Klik hier");
        button.addActionListener(this);
        window.add(button);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(550, 550));
        panel.setBackground(Color.WHITE);
        window.add(panel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics tekenveld = panel.getGraphics();

        array[0][0] = 1;
//        tekenveld.fillRect(0*50,0*50,50,50);
//        tekenveld.fillRect(1*50,0*50,50,50);
        array[1][3] = 1;
//        tekenveld.fillRect(1*50,3*50,50,50);
        array[1][9] = 1;
//        tekenveld.fillRect(1*50,9*50,50,50);
        array[9][1] = 1;
//        tekenveld.fillRect(9*50,1*50,50,50);
        array[5][5] = 1;
//        tekenveld.fillRect(5*50,5*50,50,50);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (array[i][j] == 1) {
                    tekenveld.setColor(Color.BLACK);
                    tekenveld.fillRect(i * 50, j * 50, 50, 50);
//                    array = new Calc(array);
//                    Calc calc = new Calc();

                }
            }
        }
    }
}
