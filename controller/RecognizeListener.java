package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import model.Matrix;
import model.Network;

public class RecognizeListener implements ActionListener
{
    private BufferedImage bufferedImage;
    private int bitmap[];


    public RecognizeListener(BufferedImage bufferedImage)
    {
        this.bufferedImage = bufferedImage;
    }

    private double grayPixel(int i, int j)
    {
        double pixelValue = 0;
        for (int y = i*16; y < (i*16 + 16); y++) {
            for (int x = j*16; x < (j*16 + 16); x++) {
                 pixelValue += bitmap[y*448 + x];
            }
        }

//        int p = (int)pixelValue;
//        System.out.print(" " + p + " " + p + " " + p);
        return (pixelValue / 256.0);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
      //  System.out.println("P3");
      //  System.out.println("28 28");
      //  System.out.println("255");

        bitmap = bufferedImage.getData().getPixels(0, 0, 448, 448, (int[])null);

        // Convert a 448x448 bitmap into a 784x1 graymap
        Matrix graymap = new Matrix(784, 1);
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 28; j++) {
                graymap.matrix[i*28 + j][0] = grayPixel(i, j);
            }
         //   System.out.println("");
        }

        System.out.println("The number is " + Network.feedforward(graymap));
    }
}
