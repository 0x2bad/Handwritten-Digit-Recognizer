package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame
{
    public MainWindow()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(28*16, 28*16);

        add(BorderLayout.CENTER, new Canvas());
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });
    }
}
