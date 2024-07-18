package pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class applicant {
    private Connection conn;  // Declare the Connection object
    private DefaultTableModel tblModel;
    
    // Constructor to receive the Connection object
    public applicant(Connection connection, DefaultTableModel tblModel) {
        this.conn = connection;
        this.tblModel = tblModel;
    }
    public applicant(Connection connection) {
        this.conn = connection;
       
    }

    // User Status
    public void searchStatus(int ApplicantID) {
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("Database connection is not established.");
                return;
            }

            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM applicants WHERE ApplicantID=" + ApplicantID;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("ID found!!");
                JOptionPane.showMessageDialog(null, "ID FOUND!!");

                do {
                    String message = "APPLICANT ID=" + rs.getInt("ApplicantID") + "\n" + "Name="
                            + rs.getString("Name") + "\n " + "Address=" + rs.getString("Address") + "\n"
                            + "Contact=" + rs.getInt("contact")+ "\n "+"Email="+rs.getString("email")+ "\n " +
                            "DocLink=" + rs.getString("DocLink")+ "\n " +"NIC=" + rs.getInt("NIC")
                            +"\n " + "Gender=" + rs.getString("Gender")+"\n"+""+"\n"+"----Document Status----"
                            +"\n"+"DocumentVerification="+rs.getString("DocumentVerification")+"\n"
                            +"Police Report Status="+rs.getString("PoliceReportVerification")+"\n"+""+"\n"+"---Available Dates----"
                            +"\n"+"Available Dates="+rs.getString("available");

                    System.out.println("Applicant ID: " + rs.getInt("ApplicantID"));
                    System.out.println("NAME: " + rs.getString("Name"));
                    System.out.println("Address: " + rs.getString("Address"));
                    System.out.println("Contact :"+rs.getInt("Contact"));
                    System.out.println("Email :"+ rs.getString("Email"));
                    System.out.println("NIC"+ rs.getInt("NIC"));
                    System.out.println("DocLink :"+ rs.getString("DocLink"));
                    System.out.println("Gender"+ rs.getString("gender"));

                    JOptionPane.showMessageDialog(null, message);

                } while (rs.next());
            } else {
                System.out.println("ID Not Found!!");
                JOptionPane.showMessageDialog(null, "ID not found!!");
            }

        } catch (SQLException e) {
            System.out.println("Search failed: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Search failed!!");
        }
    }
    
    public void tblshow() {
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT ApplicantID, Name FROM applicants";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ApplicantId = String.valueOf(rs.getInt("ApplicantID"));
                String Name = rs.getString("Name");

                tblModel.addRow(new Object[]{ApplicantId, Name});
            }

        } catch (SQLException e) {
            // Handle database-related exceptions
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    
     // Method to insert data into the database
        public void insertData(String name, String address, int contact, String email, int nic, String docLink, String gender) {
            try {
                String query = "INSERT INTO Applicants (Name, Address, Contact, email, NIC, DocLink, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, name);
                    pstmt.setString(2, address);
                    pstmt.setInt(3, contact);
                    pstmt.setString(4, email);
                    pstmt.setInt(5, nic);
                    pstmt.setString(6, docLink);
                    pstmt.setString(7, gender);
                    
                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Data inserted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to insert data. Please try again.");
                    }
                }
            } catch (SQLException e) {
                // Handle database-related exceptions
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            }
        
    }
        //date selection
        public void insertDate(String userdate) {
        	try {
                String query = "UPDATE Applicants SET userdate=?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, userdate);
                    
                    
                    
                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Data inserted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to insert data. Please try again.");
                    }
                }
            } catch (SQLException e) {
                // Handle database-related exceptions
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            }
        }
        
        public void updateData(String userdate, int applicantID) {
	        try {
	        	String query = "UPDATE Applicants SET userdate=? WHERE ApplicantID=?";
	        	try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	        	    pstmt.setString(1, userdate);  // Set userdate first
	        	    pstmt.setInt(2, applicantID);  // Set ApplicantID second

	                

	                int rowsUpdated = pstmt.executeUpdate();
	                if (rowsUpdated > 0) {
	                    JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Failed to update data. Please try again.");
	                }
	            }
	        } catch (SQLException e) {
	        	
	            // Handle database-related exceptions
	            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
	        }
	    }
    
}
