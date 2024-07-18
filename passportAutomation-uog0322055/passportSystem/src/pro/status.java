package pro;

import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("deprecation")
public class status extends javax.swing.JFrame {
	private mainconnection connect;
    private static final long serialVersionUID = 1L;

    public status() {
    	// Create an instance of mainconnection
        connect = new mainconnection();
        // Establish the database connection
        connect.establishConnection();
        new admin(connect.getConnection());
    	setFont(null);
    	setLocation(new Point(450, 0));
    	getContentPane().setBackground(new Color(179, 249, 251));
    	setMinimumSize(new Dimension(700, 800));
        getContentPane().setPreferredSize(new Dimension(500, 400));
        getContentPane().setMinimumSize(new Dimension(400, 400));
        getContentPane().setLocation(new Point(100, 0));
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(new Color(128, 255, 255));
        jLabel1.setBounds(21, 10, 305, 57);
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButton1.setBounds(484, 609, 176, 46);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Arial", Font.BOLD, 30));
        jLabel1.setText("VIEW STATUS");

        jButton1.setText("VIEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JToggleButton back = new JToggleButton("BACK");
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(39, 611, 176, 43);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 64, 128));
        panel.setBounds(100, 132, 489, 267);
        
        table = new JTable();
        table.setBounds(503, 162, 0, 0);
        panel.setLayout(null);
        
        login = new JLabel("LOG IN");
        login.setForeground(new Color(179, 249, 251));
        login.setBackground(new Color(179, 249, 251));
        login.setBounds(226, 10, 88, 31);
        panel.add(login);
        login.setFont(new Font("Tahoma", Font.BOLD, 14));
        name = new javax.swing.JTextField();
        name.setBounds(146, 51, 274, 40);
        panel.add(name);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setForeground(new Color(179, 249, 251));
        jLabel2.setBounds(49, 54, 81, 28);
        panel.add(jLabel2);
        jLabel2.setFont(new Font("Arial", Font.BOLD, 18));
        
                jLabel2.setText("Name");
                jLabel3 = new javax.swing.JLabel();
                jLabel3.setForeground(new Color(179, 249, 251));
                jLabel3.setBounds(49, 110, 63, 40);
                panel.add(jLabel3);
                jLabel3.setFont(new Font("Arial", Font.BOLD, 18));
                
                        jLabel3.setText("ID");
                        idg = new javax.swing.JTextField();
                        idg.setBounds(146, 113, 274, 40);
                        panel.add(idg);
                        
                                idg.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        actionPerformed(evt);
                                    }
                                });
        
                name.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jTextField1ActionPerformed(evt);
                    }
                });
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        getContentPane().add(panel);
        jButton2 = new javax.swing.JButton();
        jButton2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButton2.setBounds(59, 214, 371, 31);
        panel.add(jButton2);
        
                jButton2.setText("CLEAR");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton2ActionPerformed1(evt);
                    }
                });
        getContentPane().add(back);
        getContentPane().add(jButton1);
        getContentPane().add(table);
        
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 64, 128));
        panel_1.setBounds(0, 0, 699, 70);
        getContentPane().add(panel_1);
        
        JLabel lblNewLabel = new JLabel("Select A Date");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(100, 519, 123, 25);
        getContentPane().add(lblNewLabel);
        
        dateu = new JTextField();
        dateu.setBounds(206, 516, 194, 36);
        getContentPane().add(dateu);
        dateu.setColumns(10);
        
        JButton btnNewButton = new JButton("SUBMIT");
        btnNewButton.addActionListener(new ActionListener() {
        	
        	//DATE SELECTION
        	public void actionPerformed(ActionEvent e) {
        		String userdate = dateu.getText();
        		int applicantID = Integer.parseInt(idg.getText());
        		
        		applicant updatetable = new applicant(connect.getConnection());
        	    updatetable.updateData(userdate,applicantID);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnNewButton.setBounds(435, 516, 154, 36);
        getContentPane().add(btnNewButton);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(196, 253, 234));
        panel_2.setBounds(39, 409, 615, 174);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("After checking the available dates from status panel, \r\n");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(133, 10, 409, 56);
        panel_2.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Please type the selected date in Text Field");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(162, 53, 368, 31);
        panel_2.add(lblNewLabel_2);

        pack();
    }

   
    	
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Make connection between DB and button
        mainconnection connect = new mainconnection();
        connect.establishConnection(); 
       
        // Data validation
        applicant search = new applicant(connect.getConnection());
        
        // Get the text from the idg field and convert it to integer
        String id = idg.getText();
        int ApplicantID = Integer.parseInt(id);
      
       
        search.searchStatus(ApplicantID);
    }

    	
    

    private void jButton2ActionPerformed1(java.awt.event.ActionEvent evt) {
        int dialogResult = JOptionPane.showConfirmDialog(this, "Do you want to clear the fields?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            name.setText("");
            idg.setText("");
        }
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your code here
    }

    @SuppressWarnings("unused")
	private void actionPerformed(java.awt.event.ActionEvent evt) {
        // Add your code here
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        home nw = new home();
        nw.show();
        dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new status().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField name;
    private javax.swing.JTextField idg;
    private JLabel login;
    private JTable table;
    private JPanel panel_1;
    private JTextField dateu;
    private JLabel lblNewLabel_2;
}


