package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Item;
import PD.Store;
import PD.UPC;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UPCEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public UPCEditPanel(Store store, JFrame currentFrame, UPC upcSelected, Boolean isSelected, Item itemSelected, Boolean isItemSelected) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit UPC");
		lblNewLabel.setBounds(193, 11, 67, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UPC number: ");
		lblNewLabel_1.setBounds(34, 69, 89, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(133, 63, 172, 27);
		if(isSelected) {
			textField.setText(upcSelected.toString());
		}
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSelected) {
					itemSelected.removeUPC(upcSelected);
				}
				UPC upc = new UPC();
				upc.setUPC(textField.getText());
				itemSelected.addUPC(upc);
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(store, currentFrame, itemSelected, isItemSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(77, 223, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(store, currentFrame, itemSelected, isItemSelected));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(247, 223, 89, 23);
		add(btnNewButton_1);

	}
}
