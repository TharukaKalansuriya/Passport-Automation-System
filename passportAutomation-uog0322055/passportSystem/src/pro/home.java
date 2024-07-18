package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    home frame = new home();
                    
                    // Set the frame to be maximized
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    
                    // Set the default close operation
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                    // Make the frame visible
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
	public home() {
		setLocation(new Point(10, 10));
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1600, 1000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1240, 918);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(149, 224, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-66, 0, 622, 845);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(63, -47, 559, 906);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tharu\\OneDrive\\Desktop\\New folder (3)\\a6eed79e59bb562ed502c56f710b1eb6.jpg"));
		
		JLabel lblNewLabel_2 = new JLabel("Passport Automation System");
		lblNewLabel_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(751, 152, 595, 82);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			
			//register
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				reg nw= new reg();
				nw.show();
				dispose();
				     
			}
		});
		btnNewButton.setFocusTraversalPolicyProvider(true);
		btnNewButton.setBackground(new Color(1, 106, 137));
		btnNewButton.setForeground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(839, 244, 417, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Status");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			//view stats
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				status nw= new status();
				nw.show();
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(1, 106, 137));
		btnNewButton_1.setForeground(new Color(128, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(839, 346, 417, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Admin Log In");
		btnNewButton_2.setBackground(new Color(1, 106, 137));
		btnNewButton_2.setForeground(new Color(128, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			
			//admin log in
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				adminlogin nw= new adminlogin();
				nw.show();
				dispose();
			}
		});
		btnNewButton_2.setBounds(839, 442, 417, 52);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Terms & Conditions");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			//terms and conditions
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				terms nw= new terms();
				nw.show();
				dispose();
				     
			}
		});
		btnNewButton_3.setBackground(new Color(1, 106, 137));
		btnNewButton_3.setForeground(new Color(128, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(839, 540, 417, 52);
		contentPane.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 106, 137));
		panel_1.setBounds(552, 0, 988, 101);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME!");
		lblNewLabel_1.setBounds(343, 25, 415, 66);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(128, 255, 255));
		lblNewLabel_1.setForeground(new Color(128, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.PLAIN, 55));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(1, 106, 137));
		panel_1_1.setBounds(1509, 98, 31, 747);
		contentPane.add(panel_1_1);
	}
}
