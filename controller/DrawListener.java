package controller;

import java.awt.event.*;

import model.GrayMap;
import model.Network;

import java.awt.*;

import view.Canvas;

public class DrawListener implements MouseListener, MouseMotionListener
{
    Canvas canvas;
    private Point prevPt;

    public DrawListener(Canvas canvas)
    {
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        prevPt = e.getPoint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {
        // kludge
        new GrayMap(canvas.bi, canvas.g2D);

        canvas.repaint();

    //    System.out.println("The number is " + Network.feedforward(graymap));
    //    canvas.g2D.setColor(Color.BLACK);
    //    canvas.g2D.fillRect(0, 0, 448, 448);
   //     canvas.repaint();
        canvas.g2D.setColor(Color.WHITE);
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        canvas.g2D.drawLine(prevPt.x, prevPt.y, e.getX(), e.getY());
        prevPt = e.getPoint();
        canvas.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}