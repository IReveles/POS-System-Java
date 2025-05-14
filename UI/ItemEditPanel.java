package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Item;
import PD.Price;
import PD.PromoPrice;
import PD.Store;
import PD.TaxCategory;
import PD.UPC;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ItemEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ItemEditPanel(Store store, JFrame currentFrame, Item itemSelected, Boolean isSelected) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit item");
		lblNewLabel.setBounds(192, 11, 65, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item number:");
		lblNewLabel_1.setBounds(10, 47, 85, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item description:");
		lblNewLabel_2.setBounds(10, 85, 101, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(109, 44, 85, 20);
		if(isSelected) {
			textField.setText(itemSelected.getNumber());
		}
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 82, 129, 20);
		if(isSelected) {
			textField_1.setText(itemSelected.getDescription());
		}
		add(textField_1);
		textField_1.setColumns(10);
		
		DefaultListModel <UPC> upcDList = new DefaultListModel<UPC>();
		for(UPC upc : itemSelected.getuPCs().values()) {
			upcDList.addElement(upc);
		}
		
		JList <UPC> upcList = new JList<UPC>(upcDList);
		
		upcList.setBounds(278, 31, 148, 57);
		add(upcList);
		
		JLabel lblNewLabel_3 = new JLabel("Tax category:");
		lblNewLabel_3.setBounds(10, 130, 85, 14);
		add(lblNewLabel_3);
		
		DefaultComboBoxModel<TaxCategory> tcList = new DefaultComboBoxModel<TaxCategory>();
		
		for(TaxCategory taxCategory : store.getTaxCategories().values()) {
			tcList.addElement(taxCategory);
		}
		
		JComboBox<TaxCategory> comboBox = new JComboBox<TaxCategory>(tcList);
		comboBox.setBounds(109, 122, 129, 27);
		if(isSelected) {
			comboBox.setSelectedItem(itemSelected.getTaxCategory());;
		}
		add(comboBox);
		
		JButton addUpcButton = new JButton("Add");
		addUpcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UPC upc = new UPC();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(store, currentFrame, upc, false, itemSelected, isSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		addUpcButton.setBounds(278, 99, 65, 23);
		add(addUpcButton);
		
		JButton editUpcButton = new JButton("Edit");
		editUpcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(store, currentFrame, (UPC)upcList.getSelectedValue(), true, itemSelected, isSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		editUpcButton.setBounds(361, 99, 65, 23);
		editUpcButton.setEnabled(false);
		add(editUpcButton);
		
		JButton deleteUpcButton = new JButton("Delete");
		deleteUpcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSelected.removeUPC((UPC)upcList.getSelectedValue());
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(store, currentFrame, itemSelected, isSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		deleteUpcButton.setBounds(309, 126, 89, 23);
		deleteUpcButton.setEnabled(false);
		add(deleteUpcButton);
		
		DefaultListModel <Price> priceDList = new DefaultListModel<Price>();
		for(Price price : itemSelected.getPrices()) {
			priceDList.addElement(price);
		}
		
		JList <Price> priceList = new JList<Price>(priceDList);
		
		priceList.setBounds(278, 170, 148, 57);
		add(priceList);
		
		JButton addPriceButton = new JButton("Add");
		addPriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Price price = new Price();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(store, currentFrame, price, false, itemSelected, isSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		addPriceButton.setBounds(278, 238, 65, 23);
		add(addPriceButton);
		
		JButton editPriceButton = new JButton("Edit");
		editPriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(store, currentFrame, priceList.getSelectedValue(), true,  itemSelected, isSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		editPriceButton.setBounds(361, 238, 65, 23);
		editPriceButton.setEnabled(false);
		add(editPriceButton);
		
		JButton deletePriceButton = new JButton("Delete");
		deletePriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSelected.removePrice((Price)priceList.getSelectedValue());
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(store, currentFrame, itemSelected, isSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		deletePriceButton.setBounds(309, 266, 89, 23);
		deletePriceButton.setEnabled(false);
		add(deletePriceButton);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSelected.setNumber(textField.getText());
				itemSelected.setDescription(textField_1.getText());
				itemSelected.setTaxCategory((TaxCategory)comboBox.getSelectedItem());
				if(!isSelected) {
					store.addItem(itemSelected);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(20, 238, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(146, 238, 89, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("UPC");
		lblNewLabel_4.setBounds(340, 11, 46, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Prices");
		lblNewLabel_5.setBounds(338, 155, 70, 14);
		add(lblNewLabel_5);

		upcList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				editUpcButton.setEnabled(true);
				deleteUpcButton.setEnabled(true);
			}
		});
		priceList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				editPriceButton.setEnabled(true);
				deletePriceButton.setEnabled(true);
			}
		});
	}
}
