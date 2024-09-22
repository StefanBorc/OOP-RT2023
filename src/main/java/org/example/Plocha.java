package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Plocha extends JPanel {
    @Setter
    private TypUtvaru typ;
    @Getter
    private ArrayList<Ciara> retaz;
    @Getter
    private Ciara ciara;
    @Setter
    private int polomer;
    @Setter
    private int odstup;
    @Setter
    private int dlzka;
    private Color farba;
    public Plocha() {
        retaz=new ArrayList<>();
        typ=TypUtvaru.KRUH;
        polomer=5;
        odstup=5;
        farba=Color.RED;
        dlzka=50;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        spojCiary();
        var pocitadlo=0;
        for(Ciara ciara : retaz){
            g.setColor(Color.BLACK);
            ciara.nakresliCiaru(g);
            if(pocitadlo==retaz.size()-1 || pocitadlo%odstup==0) {
                farba=zmenFarbu(pocitadlo);
                g.setColor(farba);
                if (typ.equals(TypUtvaru.KRUH)) {
                    g.fillOval(ciara.getX() - polomer, ciara.getY() - polomer, polomer * 2, polomer * 2);
                } else if (typ.equals(TypUtvaru.STVOREC)) {
                    g.fillRect(ciara.getX() - polomer, ciara.getY() - polomer, polomer * 2, polomer * 2);
                } else if (typ.equals(TypUtvaru.HODINY)) {
                    int[] x = new int[]{ciara.getX() - polomer, ciara.getX() + polomer, ciara.getX(), ciara.getX() - polomer, ciara.getX() + polomer};
                    int[] y = new int[]{ciara.getY() - polomer, ciara.getY() - polomer, ciara.getY(), ciara.getY() + polomer, ciara.getY() + polomer};
                    g.fillPolygon(x, y, 5);
                }
            }
            pocitadlo++;
        }
    }
    private Color zmenFarbu(int i){
        float gradient = i / (this.dlzka - 1.0f);
        return Color.getHSBColor(gradient, 1, 1);
    }
    protected void pridajCiaru(MouseEvent e){
        ciara = new Ciara(e);
        retaz.add(ciara);
    }
    private void spojCiary(){
        for(int i=0;i<retaz.size()-2;i++){
            ciara=retaz.get(i);
            ciara.setXK(retaz.get(i+1).getX());
            ciara.setYK(retaz.get(i+1).getY());
        }
    }
}
