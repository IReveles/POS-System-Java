package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Cashier;
import PD.Register;
import PD.Store;
import PD.TaxCategory;
import PD.TaxRate;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TaxCategoryUpdatePanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TaxCategoryUpdatePanel(Store store, JFrame currentFrame, TaxCategory selectedTaxCategory, Boolean isSelected) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Tax Category");
		lblNewLabel.setBounds(186, 26, 123, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category :");
		lblNewLabel_1.setBounds(10, 72, 84, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(82, 69, 132, 20);
		if(isSelected) {
			textField.setText(selectedTaxCategory.getCategory());
		}
		add(textField);
		textField.setColumns(10);
		
		DefaultListModel <TaxRate> taxRatesList = new DefaultListModel<TaxRate>();
		for(TaxRate taxRate : selectedTaxCategory.getTaxRates()) {
			taxRatesList.addElement(taxRate);
		}
		
		JList <TaxRate> list = new JList<TaxRate>(taxRatesList);
		
		list.setBounds(265, 107, 156, 95);
		add(list);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxRate taxRate = new TaxRate();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(store, currentFrame, selectedTaxCategory, taxRate, false, isSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(245, 213, 57, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(store, currentFrame, selectedTaxCategory, (TaxRate)list.getSelectedValue(), true, isSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		
		btnNewButton_1.setBounds(312, 213, 57, 23);
		btnNewButton_1.setEnabled(false);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxRate taxRate = new TaxRate();
				taxRate = (TaxRate)list.getSelectedValue();
				selectedTaxCategory.removeTaxRate(taxRate);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(379, 213, 71, 23);
		btnNewButton_2.setEnabled(false);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedTaxCategory.setCategory(textField.getText());
				if(!isSelected) {
					store.addTaxCategory(selectedTaxCategory);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setBounds(31, 252, 89, 23);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cancel");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_4.setBounds(157, 252, 89, 23);
		add(btnNewButton_4);
		
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
