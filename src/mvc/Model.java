package mvc;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Model {
    public Controller controller;
    public JScrollPane scrollPane;
	public JTextField textField;
	public JTextPane textPane;
	public JTable table;

	public Model(Controller controller) {
		this.controller = controller;
		controller.model = this;
        scrollPane = new JScrollPane();
       //setTable("help_topic");

	}
	public void setModel (String arg) {
		TableModel tmodel = new TableModel();
		tmodel.setTable(arg);
		table = new JTable();
        table.setModel(tmodel);
		//table.getColumnModel().getColumn(6).setMinWidth(450);
		table.addMouseListener(controller);
		table.addMouseMotionListener(controller);
		
      scrollPane.setViewportView(table);		
	}
}
