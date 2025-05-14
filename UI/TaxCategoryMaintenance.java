package UI;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import PD.Cashier;
import PD.Register;
import PD.Store;
import PD.TaxCategory;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaxCategoryMaintenance extends JPanel {

	/**
	 * Create the panel.
	 */
	public TaxCategoryMaintenance(Store store, JFrame currentFrame) {
		setLayout(null);
		
		DefaultListModel <TaxCategory> taxCategoryList = new DefaultListModel<TaxCategory>();
		for(TaxCategory taxCategory : store.getTaxCategories().values()) {
			taxCategoryList.addElement(taxCategory);
		}
		
		JList <TaxCategory> list = new JList<TaxCategory>(taxCategoryList);
		list.setBounds(151, 51, 134, 152);
		add(list);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryUpdatePanel(store, currentFrame, (TaxCategory)list.getSelectedValue(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(176, 230, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxCategory taxCategory = new TaxCategory();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryUpdatePanel(store, currentFrame, taxCategory, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(40, 230, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxCategory taxCategory = new TaxCategory();
				taxCategory = (TaxCategory)list.getSelectedValue();
				store.removeTaxCategory(taxCategory);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(322, 230, 89, 23);
		add(btnNewButton_2);

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list.getSelectedValue() != null) {
					btnNewButton.setEnabled(true);
				}
				if (list.getSelectedValue() == null || store.isTaxCategoryUsed((TaxCategory)list.getSelectedValue())){
						btnNewButton_2.setEnabled(false);
				}
				else {
					btnNewButton_2.setEnabled(true);
				}
			}
		});
		
	}
}

