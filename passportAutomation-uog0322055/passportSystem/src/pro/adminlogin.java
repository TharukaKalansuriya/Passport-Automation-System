package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class adminlogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JPasswordField password;
	private JCheckBox showPasswordCheckbox; // Added checkbox for Show Password

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin frame = new adminlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 100, 859, 622);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(171, 250, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBounds(157, 148, 535, 371);
		contentPane.add(panel);
		panel.setLayout(null);

		id = new JTextField();
		id.setBounds(169, 102, 310, 40);
		panel.add(id);
		id.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setForeground(new Color(176, 251, 251));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(36, 190, 123, 30);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setForeground(new Color(176, 251, 251));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(42, 112, 45, 13);
		panel.add(lblNewLabel_1_1);

		password = new JPasswordField();
		password.setBounds(169, 189, 310, 40);
		panel.add(password);

		showPasswordCheckbox = new JCheckBox("Show Password");
		showPasswordCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Toggle between showing and hiding the password
				if (showPasswordCheckbox.isSelected()) {
					password.setEchoChar((char) 0); // Show password
				} else {
					password.setEchoChar('*'); // Hide password
				}
			}
		});
		showPasswordCheckbox.setBounds(169, 230, 150, 20);
		panel.add(showPasswordCheckbox);

		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setBackground(new Color(176, 251, 251));
		btnNewButton.addActionListener(new ActionListener() {
			
			// Log in
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				// Make connection between DB and button
				mainconnection connect = new mainconnection();
				connect.establishConnection();

				admin login = new admin(connect.getConnection());

				String idd = id.getText();
				String pass = password.getText();

				login.loggin(idd, pass);
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(377, 293, 123, 40);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setLocation(new Point(700, 0));
		btnNewButton_1.setBackground(new Color(176, 251, 251));
		btnNewButton_1.addActionListener(new ActionListener() {
			// Back button
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				home nw = new home();
				nw.show();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(36, 293, 123, 40);
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("CLEAR");
		btnNewButton_1_1.setBackground(new Color(176, 251, 251));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			// Clear action
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(adminlogin.this, "Do you want to clear the fields?",
						"Confirmation", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					id.setText("");
					password.setText("");
				}
			}

		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(205, 293, 123, 40);
		panel.add(btnNewButton_1_1);

		JLabel lblNewLabel = new JLabel("ADMIN LOG-IN");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setBounds(335, 39, 190, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
	}
}
