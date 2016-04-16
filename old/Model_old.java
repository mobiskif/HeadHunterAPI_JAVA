package mvc.old;

import java.util.function.Function;

import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import med.MedRoot;
import mvc.Controller;
import mvc.HHTableModel;
import mvc.old.TreeTransferHandler;

public class Model_old {//extends DefaultTreeModel {
	public JTree treeLeft;
    public JTree treeRight;
    public Controller controller;
    public JScrollPane scrollPane;
    private JTable table;
    private HHTableModel tmodel;

	public Model_old(Controller controller) {
		this.controller = controller;
		//controller.model = this;

		treeLeft = new JTree(new MedRoot());
        treeRight = new JTree();
        treeLeft.setDragEnabled(true);
        treeLeft.setDropMode(DropMode.ON_OR_INSERT);
        treeLeft.setTransferHandler(new TreeTransferHandler());
        treeRight.setDragEnabled(true);
        treeRight.setDropMode(DropMode.ON_OR_INSERT);
        treeRight.setTransferHandler(new TreeTransferHandler());
        scrollPane = new JScrollPane();
        table = new JTable();
        tmodel = new HHTableModel();
        //setTable("help_topic");

	}
	public void setTable (String tn) {
        tmodel.setTable(tn);
        table.setModel(tmodel);
        scrollPane.setViewportView(table);		
	}
}
