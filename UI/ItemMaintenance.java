package UI;

import javax.swing.JPanel;

import PD.Item;
import PD.Store;
import PD.TaxCategory;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ItemMaintenance extends JPanel {

	/**
	 * Create the panel.
	 */
	public ItemMaintenance(Store store, JFrame currentFrame) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select item");
		lblNewLabel.setBounds(196, 23, 89, 14);
		add(lblNewLabel);
		
		DefaultListModel <Item> itemList = new DefaultListModel<Item>();
		for(Item item : store.getItems().values()) {
			itemList.addElement(item);
		}
		
		JList <Item> list = new JList<Item>(itemList);
	
		list.setBounds(41, 64, 360, 140);
		add(list);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = new Item();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(store, currentFrame, item, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(41, 226, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(store, currentFrame, (Item)list.getSelectedValue(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(177, 226, 89, 23);
		btnNewButton_1.setEnabled(false);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = new Item();
				item = (Item)list.getSelectedValue();
				store.removeItem(item);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(323, 226, 89, 23);
		btnNewButton_2.setEnabled(false);
		add(btnNewButton_2);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list.getSelectedValue() != null) {
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
				}
			}
		});

	}

}
