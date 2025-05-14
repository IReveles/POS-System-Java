package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Store;
import PD.TaxCategory;
import PD.TaxRate;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TaxRateEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TaxRateEditPanel(Store store, JFrame currentFrame, TaxCategory selectedTaxCategory, TaxRate selectedTaxRate, Boolean isSelected, Boolean isTaxCategorySelected) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Tax Rate");
		lblNewLabel.setBounds(176, 21, 108, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rate: ");
		lblNewLabel_1.setBounds(48, 98, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setBounds(48, 163, 46, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(154, 95, 119, 20);
		if(isSelected) {
			textField.setText(selectedTaxRate.getTaxRate().toString());
		}
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 160, 119, 20);
		if(isSelected) {
			textField_1.setText(selectedTaxRate.getEffectiveDate().toString());
		}
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedTaxRate.setTaxRate(new BigDecimal(textField.getText()));
				selectedTaxRate.setEffectiveDate(LocalDate.parse(textField_1.getText()));
				if(!isSelected) {
					selectedTaxCategory.addTaxRate(selectedTaxRate);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryUpdatePanel(store, currentFrame, selectedTaxCategory, isTaxCategorySelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(78, 234, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(230, 234, 89, 23);
		add(btnNewButton_1);

	}
}

