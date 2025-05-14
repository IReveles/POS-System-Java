package UI;

import javax.swing.JPanel;

import PD.Store;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreMaintenance extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public StoreMaintenance(Store store, JFrame currentFrame) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Store");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(314, 32, 176, 83);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(173, 141, 67, 43);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(237, 154, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input;
				input = textField.getText();
				store.setName(input);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainScreenPanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(173, 303, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainScreenPanel(store));
				currentFrame.getContentPane().revalidate();
				}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(315, 304, 85, 21);
		add(btnNewButton_1);

	}
}
