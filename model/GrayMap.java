package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class GrayMap extends Matrix
{
    private int digit = -1;

    public GrayMap(int rows, int columns)
    {
        super(rows, columns);
    }

    public GrayMap(double[][] matrix, int rows, int columns)
    {
        super(matrix, rows, columns);
    }

    public GrayMap(Scanner sc, int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        digit = sc.nextInt();

        matrix = new double[rows][columns];
        for (int i = 0; i < 784; i++) {
            int got = sc.nextInt();
            matrix[i][0] = got;
            matrix[i][0] /= 255.0;
        }
    }

    public GrayMap(BufferedImage bufferedImage, Graphics2D g2D)
    {
        rows = 784;
        columns = 1;
        matrix = new double[rows][columns];

     //   try {
     //   FileWriter fw = new FileWriter("java.csv", true);
     //   BufferedWriter bw = new BufferedWriter(fw);

     //   bw.write("0");

        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 28; j++) {
                int shade = getTileValue(bufferedImage, j, i);
//                bw.write("," + shade);
                matrix[i*28 + j][0] = shade;
                g2D.setColor(new Color(shade, shade, shade));
                g2D.fillRect(j*16, i*16, 16, 16);
                matrix[i*28 + j][0] /= 255.0;
            }
        }
 //       bw.newLine();
  //      bw.close();
   // } catch (Exception e) {
    //    System.err.println(e);
   // }
    
        g2D.setColor(Color.white);
    }

    private int getTileValue(BufferedImage bufferedImage, int x, int y)
    {
        int tile[] = bufferedImage.getData().getPixels(x*16, y*16, 16, 16, (int[])null);
        double shade = 0;
        // normalize all '255' values to '1'
        for (int i : tile) {
            shade += i;
        }
        shade /= 256.0;
        return (int)shade;
    }

    public int getDigit()
    {
        return digit;
    }
}
