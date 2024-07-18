package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class terms extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    terms frame = new terms();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public terms() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1554, 815);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(200, 251, 251));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 64, 128));
        panel.setBounds(0, 0, 1581, 88);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Terms And Conditions");
        lblNewLabel.setForeground(new Color(171, 250, 243));
        lblNewLabel.setBackground(new Color(171, 250, 243));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel.setBounds(10, 10, 464, 73);
        panel.add(lblNewLabel);

        JLabel lblTermsConditions = new JLabel("Terms and Conditions");
        lblTermsConditions.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTermsConditions.setBounds(10, 108, 251, 30);
        contentPane.add(lblTermsConditions);

        JLabel lblHeading1 = new JLabel("1. Passport Application Process");
        lblHeading1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHeading1.setBounds(20, 160, 300, 20);
        contentPane.add(lblHeading1);

        JLabel lblDescription1 = new JLabel(" Applicants must provide accurate and truthful information during the application process");
        lblDescription1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDescription1.setBounds(30, 190, 800, 40);
        contentPane.add(lblDescription1);

        JLabel lblHeading2 = new JLabel("2. Document Submission");
        lblHeading2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHeading2.setBounds(20, 240, 200, 20);
        contentPane.add(lblHeading2);

        JLabel lblDescription2 = new JLabel(" Applicants are required to submit scanned copies of necessary documents for verification.s");
        lblDescription2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDescription2.setBounds(30, 270, 800, 40);
        contentPane.add(lblDescription2);

        JButton btnNewButton = new JButton("ACCEPT");
        btnNewButton.addActionListener(new ActionListener() {
            // TERMS ACCEPT
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
                home nw = new home();
                nw.show();
                dispose();
            }
        });
        btnNewButton.setForeground(new Color(128, 255, 255));
        btnNewButton.setBackground(new Color(0, 64, 128));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(418, 713, 611, 36);
        contentPane.add(btnNewButton);
    }
}
