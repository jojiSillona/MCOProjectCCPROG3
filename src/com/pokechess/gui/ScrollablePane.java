package com.pokechess.gui;

import com.pokechess.gui.graphics.Colors;

import javax.swing.*;
import java.awt.*;

public class ScrollablePane extends JScrollPane {

    private JPanel viewPort;

    public ScrollablePane(int width, int height){
        super();
        this.initComponents(width, height);
    }

    public void initComponents(int w, int h){
        this.initViewPort();
        this.setViewportView(this.viewPort);

        this.setVisible(true);
        this.getViewport().setOpaque(true);
        this.setBounds(0,0,w,h);
        //this.setBackground(Color.BLUE);

        this.setAutoscrolls(true);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    }

    public void initViewPort(){
        this.viewPort = new JPanel();
        this.viewPort.setBackground(Colors.TRANSLUCENT_BLACK);

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(10);

        this.viewPort.setLayout(flowLayout);
    }

    public void addItem(Component component){

        this.viewPort.add(component);
        this.repaint();
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        this.repaint();
    }
}
