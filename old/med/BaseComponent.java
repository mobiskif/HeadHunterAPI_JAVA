package med;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.TransferHandler;

import mvc.TableModel;

public class BaseComponent extends JPanel implements ActionListener {
	public String name;
	public Hashtable params = new Hashtable();

	// Image img;
	// ImageIcon ii;
	// public JTable table;

	public BaseComponent(String name) {
		super();
		setSize(160, 186);
		setLayout(new FlowLayout());
		this.name = name;
		//params.put("Clinic", new Vector());
		//params.put("Pathology", new Vector());
		//params.put("Doctor", new Vector());
		//params.put("Patient", new Vector());

		createUIComponents();

	}

	private void createUIComponents() {
		JButton btnSave = new JButton("S");
		btnSave.addActionListener(this);
		btnSave.setTransferHandler(new TransferHandler("text"));
		add(btnSave);

		JLabel lbl = new JLabel(this.getClass().getSimpleName() + " " + this.name);
		JLabel lbl2 = new JLabel(this.name);
		add(lbl2);

		JTable table = new JTable();
		TableModel m = new TableModel();
		// m.setHostURL("jdbc:mysql://localhost:3306/mysql?user=root&password=router");
		table.setModel(m);
		table.setDragEnabled(true);
		// add(table);

		//LoadImg();
		lbl.setTransferHandler(new TransferHandler("text"));
	}

	public void LoadImg() {
		ImageIcon ii = new ImageIcon();
		BufferedImage img = null;
		try {
			//img = ImageIO.read(new File("/res/img.png"));
			img = ImageIO.read(new File(getClass().getResource("../res/img.png").toURI()));
			//ii = new ImageIcon("/res/img.png");
		} catch (Exception e) {
			e.printStackTrace();
		}

		AreaAveragingScaleFilter asf = new AreaAveragingScaleFilter(640 / 8, 426 / 8);
		Image averimg = createImage(new FilteredImageSource(img.getSource(), asf));
		ii.setImage(averimg);
		JLabel imageLabel = new JLabel(ii);
		add(imageLabel);
	}

	public void print(int i) {
		for (int l = 0; l < i; l++)
			System.out.print("  ");
		System.out.println(this.getClass().getSimpleName() + ": " + name);
		for (Enumeration e = params.elements(); e.hasMoreElements();) {
			Vector v = (Vector) e.nextElement();
			for (Enumeration ee = v.elements(); ee.hasMoreElements();) {
				BaseComponent m = (BaseComponent) ee.nextElement();
				m.print(i + 1);
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension d = new Dimension(this.getWidth(), this.getHeight());
		return d;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 8, 6);
	}

	/*
	 * public void add(BaseComponent m) { try { super.add(m); Vector v =
	 * (Vector) params.get(m.getClass().getSimpleName()); v.add(m); } catch
	 * (Exception e) { e.printStackTrace(); } } /*
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		try {
			ObjectOutputStream oos;
			if (e.getActionCommand().equalsIgnoreCase("S")) {
				oos = new ObjectOutputStream(new FileOutputStream(this
						.getClass().getName() + ".txt"));
				System.out.println(this.getClass().getName() + ".txt");
				oos.writeObject(this);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}
}
