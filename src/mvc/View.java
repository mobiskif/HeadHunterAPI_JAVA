package mvc;


import med.Clinic;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {

    public View(Controller c) {
        super();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        //getContentPane().add(panel);
        add(panel);

        JToolBar toolBar = new JToolBar();
        panel.add(toolBar, BorderLayout.NORTH);

        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(c);
        toolBar.add(btnLoad);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(c);
        toolBar.add(btnSave);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(c);
        //panel.add(btnExit, BorderLayout.SOUTH);
        toolBar.add(btnExit);


        //c.view = this;
        setVisible(true);
        setSize(640, 480);
    }

}
