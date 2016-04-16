package med;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class MedRoot extends DefaultMutableTreeNode {

	public MedRoot() {
		super(new DefaultMutableTreeNode("им. Склиф"));
	    DefaultMutableTreeNode cover = new DefaultMutableTreeNode("доктор Лифшиц");
		cover.insert(new DefaultMutableTreeNode("2x PEMS"), 0);
		cover.insert(new DefaultMutableTreeNode("2x SCREWS"), 0);
		cover.insert(new DefaultMutableTreeNode("2x SCREWS"), 0);

		DefaultMutableTreeNode base = new DefaultMutableTreeNode("доктор Гольдштейн");
		base.insert(new DefaultMutableTreeNode("4x SCREWS"), 0);
		base.insert(new DefaultMutableTreeNode("4x HANDLES"), 0);
		base.insert(new DefaultMutableTreeNode("4x HANDLES"), 0);
		base.insert(new DefaultMutableTreeNode("4x HANDLES"), 0);

		insert(cover, 0);
		insert(base, 0);
	}

	public MedRoot(Object userObject) {
		super(userObject);
		// TODO Auto-generated constructor stub
	}

	public MedRoot(Object userObject, boolean allowsChildren) {
		super(userObject, allowsChildren);
		// TODO Auto-generated constructor stub
	}

}
