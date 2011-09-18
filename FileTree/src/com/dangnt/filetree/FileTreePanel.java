package com.dangnt.filetree;


import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;

public class FileTreePanel extends JPanel
{
	private JTree tree;

	public FileTreePanel()
	{
		this.setLayout(new BorderLayout());
		
		File[] roots = File.listRoots();
		FileTreeNode rootTreeNode = new FileTreeNode(roots);
		this.tree = new JTree(rootTreeNode);
		this.tree.setCellRenderer(new FileTreeCellRenderer());
		this.tree.setRootVisible(false);
		final JScrollPane jsp = new JScrollPane(this.tree);
		jsp.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(jsp, BorderLayout.CENTER);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new JFrame("File tree");
				frame.setSize(500, 400);
				frame.setLocationRelativeTo(null);
				frame.add(new FileTreePanel());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}