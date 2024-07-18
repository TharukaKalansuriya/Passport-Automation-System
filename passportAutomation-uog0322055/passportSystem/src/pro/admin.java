package pro;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




@SuppressWarnings("unused")
public class admin {
	 private  Connection conn; 
	 private DefaultTableModel tblModel;
	    private javax.swing.JTable jTable2;
	    
	    
	    
	    
	    // Constructor to receive the Connection object
	    public admin(Connection connection, DefaultTableModel tblModel) {
	        this.conn = connection;
	        this.tblModel = tblModel;
	    }

	 
	// Constructor to receive the Connection object

	    public admin(Connection connection) {
	        this.conn = connection;
	       
	    }
	
	// Admin Log in
	    @SuppressWarnings("deprecation")
		public void loggin(String id,String pass) {
	        try {
	            if (conn == null || conn.isClosed()) {
	                System.out.println("Database connection is not established.");
	                return;
	            }
	            String sql = "SELECT * FROM admin WHERE ID=? AND Password=?";
	               PreparedStatement statement = conn.prepareStatement(sql);
	            		   
	            		  
	             
	              

	   			// Set values for parameters 
	   			statement.setString(1, id);
	   			statement.setString(2, pass); 
	   			 
	   			ResultSet rs = statement.executeQuery();
	   			
	   			
	   			
	            if(rs.next()) {
	            	//IF USERNAME PASSWORD CORRECT
	                       System.out.println("Login successful");
	                       JOptionPane.showMessageDialog(null, "Admin Verified!!");
                      do {
                      adminpanel nw = new adminpanel();
                      nw.show();
                      
                    	  
                      } while(rs.next());
                    	   
                       
                 
	        } else {    
	            	//if username or password incorret
	            	
                           System.out.println("Login failed!!");
                           JOptionPane.showMessageDialog(null, "LOG IN FAILED!\nCheck your ID and Password.");

	            }
	        
	               System.out.println("Completion Successful");}
	     catch (SQLException ex) {
	        System.out.println("Error during login:");
	        ex.printStackTrace();
	    }
	        }
	    
	    
	    //admin delete table data
	    public void deleteData(int apid) {
	        try {
	            if (conn == null || conn.isClosed()) {
	                System.out.println("Database connection is not established.");
	                return;
	            }

	            String sql = "DELETE FROM applicants WHERE applicantID=?";
	            PreparedStatement statement = conn.prepareStatement(sql);

	            // Set the parameter value
	            statement.setInt(1, apid);

	            // Execute the delete operation
	            int rowsAffected = statement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Delete successful");
	                JOptionPane.showMessageDialog(null, "Successfully Deleted!!");
	            } else {
	                System.out.println("Error While Deleting");
	                JOptionPane.showMessageDialog(null, "Error Occurred While Deleting!");
	            }

	            System.out.println("Completion Successful");
	        } catch (SQLException ex) {
	            System.out.println("Error during Deleting:");
	            ex.printStackTrace();
	        }
	    }
	    
	    
	    //update operation in admin panel
	    public void updateData(String name, String address, int contact, String email, int nic, String docLink, String gender, String DocumentVerification, String DocumentVerificationb, String Dateavailable,String dtstatus,int applicantID) {
	        try {
	            String query = "UPDATE Applicants SET Name=?, Address=?, Contact=?, email=?, NIC=?, DocLink=?, gender=?, DocumentVerification=?, PoliceReportVerification=?, available=?,DateStatus=? WHERE ApplicantID=?";
	            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	                pstmt.setString(1, name);
	                pstmt.setString(2, address);
	                pstmt.setInt(3, contact);
	                pstmt.setString(4, email);
	                pstmt.setInt(5, nic);
	                pstmt.setString(6, docLink);
	                pstmt.setString(7, gender);
	                pstmt.setString(8, DocumentVerification);
	                pstmt.setString(9, DocumentVerificationb);
	                pstmt.setString(10, Dateavailable);
	                pstmt.setString(11, dtstatus);
	                pstmt.setInt(12, applicantID);
	                

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

	    //show database details in admin panel
	    public void tblshow() {
	        try {
	            java.sql.Statement st = conn.createStatement();
	            String sql = "SELECT * FROM applicants";
	            ResultSet rs = st.executeQuery(sql);

	            while (rs.next()) {
	                String ApplicantId = String.valueOf(rs.getInt("ApplicantID"));
	                String Name = rs.getString("Name");
	                String Address = rs.getString("Address");
	                String Contact = rs.getString("Contact");
	                String Email = rs.getString("email");
	                String Gender = rs.getString("gender");
	                String NIC = rs.getString("NIC");
	                String DocLink = rs.getString("DocLink");
	                String docver = rs.getString("DocumentVerification");
	                String police = rs.getString("PoliceReportVerification");
	                String dateuser = rs.getString("userdate");
	                

	                tblModel.addRow(new Object[]{ApplicantId, Name,Address,Contact,Email,NIC,DocLink,Gender,docver,police,dateuser});
	            }

	        } catch (SQLException e) {
	            // Handle database-related exceptions
	            System.out.println("Database error: " + e.getMessage());
	        }
	    }
	    }
	    	  
	        	
