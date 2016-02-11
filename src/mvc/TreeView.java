package mvc;


import med.Clinic;

import javax.swing.*;
import java.awt.*;

public class TreeView extends Box {
    public TreeView(int axis) {
		super(axis);
	}

	public JTree treeLeft = new JTree(new TreeModel());
    public JTree treeRight = new JTree();

    /**
     * @wbp.parser.constructor
     */
    public TreeView(Controller c) {
        super(BoxLayout.PAGE_AXIS);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        //panel.setSize(getWidth(), getHeight());

        treeLeft.setDragEnabled(true);
        treeLeft.setDropMode(DropMode.ON_OR_INSERT);
        treeLeft.setTransferHandler(new TreeTransferHandler());
        panel.add(treeLeft, BorderLayout.WEST);

        treeRight.setDragEnabled(true);
        treeRight.setDropMode(DropMode.ON_OR_INSERT);
        treeRight.setTransferHandler(new TreeTransferHandler());
        panel.add(treeRight, BorderLayout.EAST);

        JTable table = new JTable();
        TableModel m = new TableModel();
        //m.setHostURL("jdbc:mysql://localhost:3306/mysql?user=root&password=router");
        table.setModel(m);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        //panel.add(scrollPane, BorderLayout.CENTER);

        JToolBar toolBar = new JToolBar();
        panel.add(toolBar, BorderLayout.NORTH);

        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(c);
        toolBar.add(btnLoad);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(c);
        toolBar.add(btnSave);

        Clinic clinic = new Clinic("ОЦКБ");
        panel.add(clinic, BorderLayout.CENTER);

        c.view = this;
    }

}
