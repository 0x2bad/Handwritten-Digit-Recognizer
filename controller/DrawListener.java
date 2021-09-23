package controller;

import java.awt.event.*;
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
        canvas.g2D.fillOval(e.getX(), e.getY(), 8, 8);
        prevPt = e.getPoint();
        canvas.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e)
    {
        canvas.g2D.fillOval(e.getX(), e.getY(), 8, 8);
        canvas.repaint();
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