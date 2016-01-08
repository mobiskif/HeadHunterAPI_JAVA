package mvc;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class TreeModel extends DefaultTreeModel {
	static MutableTreeNode root = new DefaultMutableTreeNode(
			"им. Склифасовского");

	public TreeModel() {
		super(root);
		DefaultMutableTreeNode cover = new DefaultMutableTreeNode(
				"доктор Лифшиц");
		DefaultMutableTreeNode base = new DefaultMutableTreeNode(
				"доктор Гольдштейн");
		root.insert(cover, 0);
		root.insert(base, 0);
		cover.insert(new DefaultMutableTreeNode("2x PEMS"), 0);
		cover.insert(new DefaultMutableTreeNode("2x SCREWS"), 0);
		cover.insert(new DefaultMutableTreeNode("2x SCREWS"), 0);
		base.insert(new DefaultMutableTreeNode("4x SCREWS"), 0);
		base.insert(new DefaultMutableTreeNode("4x HANDLES"), 0);
		base.insert(new DefaultMutableTreeNode("4x HANDLES"), 0);
		base.insert(new DefaultMutableTreeNode("4x HANDLES"), 0);

	}
}
