package org.example;

import javax.swing.*;
import java.awt.*;

public class Aplikacia {
    public Aplikacia() {
        JFrame aplikacia=new JFrame("Retaz");
        aplikacia.setSize(700,700);
        aplikacia.setResizable(false);
        aplikacia.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Plocha plocha = new Plocha();
        JLabel dlzka=new JLabel("Length");
        JLabel polomer=new JLabel("Polomer");
        JLabel odstup=new JLabel("Odstup");

        JSlider dlzkaSlider=nastavSlider(10,200,20,50);
        JSlider polomerSlider=nastavSlider(1,20,1,5);
        JSlider odstupSlider=nastavSlider(1,20,1,5);

        String[] utvary=new String[]{"Circle","Square","Hourglass"};
        JComboBox vyberUtvaru=new JComboBox(utvary);
        vyberUtvaru.setSelectedItem(utvary[0]);

        Priebeh priebeh=new Priebeh(aplikacia,plocha,dlzkaSlider,polomerSlider,odstupSlider);

        dlzkaSlider.addChangeListener(priebeh);
        polomerSlider.addChangeListener(priebeh);
        odstupSlider.addChangeListener(priebeh);
        vyberUtvaru.addItemListener(priebeh);

        JPanel menuNazvy=new JPanel();
        menuNazvy.add(dlzka);
        menuNazvy.add(polomer);
        menuNazvy.add(odstup);

        JPanel menu=new JPanel();
        menu.setLayout(new GridLayout(1,3));
        menu.add(dlzkaSlider);
        menu.add(polomerSlider);
        menu.add(odstupSlider);
        JPanel velkeMenu=new JPanel();
        velkeMenu.setLayout(new GridLayout(3,1));
        velkeMenu.add(menuNazvy,BorderLayout.NORTH);
        velkeMenu.add(menu,BorderLayout.CENTER);
        velkeMenu.add(vyberUtvaru,BorderLayout.SOUTH);

        aplikacia.add(plocha, BorderLayout.CENTER);
        aplikacia.add(velkeMenu,BorderLayout.EAST);

        plocha.addMouseMotionListener(priebeh);
        plocha.addMouseListener(priebeh);

        aplikacia.setVisible(true);
    }
    private JSlider nastavSlider(int velkost,int max,int min,int zaciatok){
        JSlider slider=new JSlider(SwingConstants.VERTICAL,min,max,zaciatok);
        slider.setMinorTickSpacing(velkost);
        slider.setMajorTickSpacing(velkost);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        return slider;
    }
}
