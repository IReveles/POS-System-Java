package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PD.Register;
import PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterUpdatePanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RegisterUpdatePanel(Store store, JFrame currentFrame, Register selectedRegister, Boolean isSelected) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Register");
		lblNewLabel.setBounds(179, 23, 82, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Register number:");
		lblNewLabel_1.setBounds(63, 75, 87, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(160, 69, 113, 27);
		if(isSelected) {
			textField.setText(selectedRegister.toString());
		}
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedRegister.setNumber(textField.getText());
				if(!isSelected) {
					store.addRegister(selectedRegister);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(76, 207, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(273, 207, 89, 23);
		add(btnNewButton_1);
		
	}
}
