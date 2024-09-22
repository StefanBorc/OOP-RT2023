package org.example;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.MouseEvent;

@Setter@Getter
public class Ciara {
    private int x;
    private int y;
    private int xK;
    private int yK;
    public Ciara(MouseEvent e) {
        this.x=e.getX();
        this.y=e.getY();
        this.xK=e.getX();
        this.yK=e.getY();
    }
    protected void nakresliCiaru(Graphics g){
       g.drawLine(x,y,xK,yK);
    }

}
