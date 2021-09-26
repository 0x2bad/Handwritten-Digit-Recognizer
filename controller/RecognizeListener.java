package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import model.GrayMap;
import model.Network;
import view.MainWindow;

public class RecognizeListener implements ActionListener
{
    private MainWindow window;
    int state = 0;

    public RecognizeListener(MainWindow window)
    {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // kludge
        if (state == 0) {
            state = 1;
            GrayMap graymap = new GrayMap(window.canvas.bi, window.canvas.g2D);

            window.recognizeButton.setText("" + Network.feedforward(graymap));

            window.canvas.repaint();

        } else {
            state = 0;
            window.recognizeButton.setText("feedforward");
            window.canvas.g2D.setColor(Color.BLACK);
            window.canvas.g2D.fillRect(0, 0, 448, 448);
            window.canvas.repaint();
            window.canvas.g2D.setColor(Color.WHITE);
        }
    }
}
