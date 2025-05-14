package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import PD.Item;
import PD.Price;
import PD.PromoPrice;
import PD.Store;

import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class PriceEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Price price = new Price();
	private PromoPrice promoPrice = new PromoPrice();
	Boolean isPromoPrice = false;

	/**
	 * Create the panel.
	 */
	public PriceEditPanel(Store store, JFrame currentFrame, Object priceSelected, Boolean isSelected, Item itemSelected, Boolean isItemSelected) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Price");
		lblNewLabel.setBounds(193, 22, 109, 14);
		add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Promo price");
		chckbxNewCheckBox.setBounds(165, 43, 97, 23);
		add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("End Date: ");
		lblNewLabel_3.setBounds(39, 174, 83, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Effective Date: ");
		lblNewLabel_2.setBounds(39, 130, 108, 14);
		add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 171, 145, 20);
		add(textField_2);
		
		lblNewLabel_3.setVisible(false);
		textField_2.setVisible(false);
		
		if(priceSelected.getClass() == price.getClass() && isSelected) {
			price = (Price) priceSelected;
			isPromoPrice = false;
		}else if(isSelected) {
			promoPrice = (PromoPrice) priceSelected;
			chckbxNewCheckBox.setSelected(true);
			isPromoPrice = true;
			lblNewLabel_3.setVisible(true);
			textField_2.setVisible(true);
			
		}
		
		
		if(isPromoPrice && isSelected) {
			textField_2.setText(promoPrice.getEndDate().toString());
		}
		textField_2.setColumns(10);
	
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(39, 88, 46, 14);
		add(lblNewLabel_1);
	
		
		textField = new JTextField();
		textField.setBounds(157, 85, 145, 20);
		if(isSelected && !isPromoPrice) {
			textField.setText(price.getPrice().toString());
		}else if(isSelected && isPromoPrice){
			textField.setText(promoPrice.getPrice().toString());
		}
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 127, 145, 20);
		if(isSelected && !isPromoPrice) {
			textField_1.setText(price.getEffectiveDate().toString());
		}else if(isSelected && isPromoPrice){
			textField_1.setText(promoPrice.getEffectiveDate().toString());
		}
		add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isPromoPrice && isSelected) {
					itemSelected.removePrice(promoPrice);
				}else if(isSelected) {
					itemSelected.removePrice(price);
				}
				
				if(chckbxNewCheckBox.isSelected()) {
					promoPrice.setPrice(new BigDecimal(textField.getText()));
					LocalDate localDate = LocalDate.parse(textField_1.getText());
					promoPrice.setEffectiveDate(localDate);
					LocalDate endDate = LocalDate.parse(textField_2.getText());
					promoPrice.setEndDate(endDate);
					itemSelected.addPrice(promoPrice);
					
				}else {
					price.setPrice(new BigDecimal(textField.getText()));
					LocalDate localDate = LocalDate.parse(textField_1.getText());
					price.setEffectiveDate(localDate);
					itemSelected.addPrice(price);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(store, currentFrame, itemSelected, isItemSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(62, 237, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(store, currentFrame, itemSelected, isItemSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(245, 237, 89, 23);
		add(btnNewButton_1);

		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblNewLabel_3.isVisible()) {
					textField_2.setVisible(false);
					lblNewLabel_3.setVisible(false);
				}else {
					textField_2.setVisible(true);
					lblNewLabel_3.setVisible(true);
				}
			}
		});
	}
}
