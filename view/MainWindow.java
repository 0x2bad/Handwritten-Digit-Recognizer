package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.RecognizeListener;

public class MainWindow extends JFrame
{
    public Canvas canvas = new Canvas();
    public JButton recognizeButton = new JButton("feedforward");
    public MainWindow()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 100);
        setVisible(true);
        setSize(28*16, 28*16+50);

        add(BorderLayout.CENTER, canvas);

        // South panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(recognizeButton);
        add(BorderLayout.SOUTH, buttonPanel);
        recognizeButton.addActionListener(new RecognizeListener(this));
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
