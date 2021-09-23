package view;

import java.awt.*;
import javax.swing.JPanel;  
import java.awt.image.BufferedImage;

import controller.DrawListener;
 
public class Canvas extends JPanel
{
    private BufferedImage bi = new BufferedImage(28*16, 28*16, BufferedImage.TYPE_BYTE_BINARY);
    public Graphics2D g2D = bi.createGraphics();

    public Canvas()
    {
        g2D.setStroke(new BasicStroke(8.0f));

        DrawListener drawListener = new DrawListener(this);
        addMouseListener(drawListener);
        addMouseMotionListener(drawListener);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, this);
    }
}
