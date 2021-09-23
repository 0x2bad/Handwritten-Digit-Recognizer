package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.RecognizeListener;

public class MainWindow extends JFrame
{
    public MainWindow()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(28*16, 28*16);

        Canvas canvas = new Canvas();
        add(BorderLayout.CENTER, canvas);

        // South panel
        JPanel buttonPanel = new JPanel();
        JButton recognizeButton = new JButton("Recognize");
        buttonPanel.add(recognizeButton);
        add(BorderLayout.SOUTH, buttonPanel);
        recognizeButton.addActionListener(new RecognizeListener(canvas.bi));
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
