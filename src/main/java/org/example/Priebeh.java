package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;


public class Priebeh extends UniverzalnyAdapter {
    public static final String CIRCLE="Circle";
    public static final String SQUARE="Square";
    public static final String HOURGLASS="Hourglass";
    private Plocha plocha;
    private JFrame aplikacia;
    private JSlider dlzkaSlider;
    private JSlider polomerSlider;
    private JSlider odstupSlider;
    private TypUtvaru typUtvaru;
    private int dlzka;
    private int polomer ;
    private int odstup;

    public Priebeh(JFrame aplikacia, Plocha plocha, JSlider dlzkaSlider, JSlider polomerSlider, JSlider odstupSlider) {
        this.aplikacia = aplikacia;
        this.plocha = plocha;
        this.dlzkaSlider = dlzkaSlider;
        this.polomerSlider = polomerSlider;
        this.odstupSlider = odstupSlider;
        dlzka=dlzkaSlider.getValue();
        polomer=polomerSlider.getValue();
        odstup=odstupSlider.getValue();
        typUtvaru= TypUtvaru.KRUH;
    }

    @Override
    public void mousePressed(MouseEvent e){
        plocha.pridajCiaru(e);
    }
    @Override
    public void mouseDragged(MouseEvent e){
        if(dlzka>plocha.getRetaz().size()){
            plocha.pridajCiaru(e);
        }
        else{
            plocha.getRetaz().remove(0);
        }
        plocha.repaint();
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        if((e.getSource().equals(dlzkaSlider))){
            dlzka=dlzkaSlider.getValue();
            plocha.setDlzka(dlzka);
            var rozdiel=plocha.getRetaz().size()-dlzka-1;
            for(int i=0;i<rozdiel;i++){
                plocha.getRetaz().remove(0);
            }
        }
        else if((e.getSource().equals(polomerSlider))){
            polomer=polomerSlider.getValue();
            plocha.setPolomer(polomer);
        }
        else if((e.getSource().equals(odstupSlider))){
            odstup=odstupSlider.getValue();
            plocha.setOdstup(odstup);
        }
        plocha.repaint();

    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getItem().equals(CIRCLE)){
            typUtvaru=TypUtvaru.KRUH;
        }
        else if(e.getItem().equals(SQUARE)){
            typUtvaru=TypUtvaru.STVOREC;
        }
        else if(e.getItem().equals(HOURGLASS)){
            typUtvaru=TypUtvaru.HODINY;
        }
        plocha.setTyp(typUtvaru);
        plocha.repaint();
    }
}
