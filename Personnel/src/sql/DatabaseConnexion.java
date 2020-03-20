package sql;
import java.sql.*;
import java.time.LocalDate;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.SauvegardeImpossible;

public class DatabaseConnexion implements personnel.Passerelle{

	@Override
	public GestionPersonnel getGestionPersonnel() {
		return null;
	}
	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible {
		
	}
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  

	 
	public static void main(String[] args) {
		
//		informations d'accès à la base de données
		Connection con = null;
	    Statement st =null;
	    ResultSet result=null;
	    
		try {
			// register jdbc driver
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			//open a connection
			 System.out.println("Connecting to  database...");
			 con=DBConnect.getConnection();  
			 System.out.print("Database is connected !");
			 
			 //execute a query
			 st=con.createStatement(); 
			
			 //select	
			 result=st.executeQuery("SELECT * FROM employe");		   	    
		    while(result.next()) {
		    	System.out.println(result.getInt("id_employe")+"\t"+result.getString("nom")+"\t"+
		    result.getString("prenom")+"\t"+result.getString("mail")+"\t"+result.getString("mdp")+
		    "\t"+result.getDate("date_arrival")+"\t"+result.getDate("date_depart")+"\t"+result.getInt("level"));
		    }
		   
		    String select = "SELECT * FROM ligue";
		       result = st.executeQuery(select);
		    while(result.next()) {
		    	System.out.println(result.getInt("id_ligue")+"\t"+result.getString("nom_ligue"));
		    }
		    
		    String sql = "SELECT nom, prenom, mail FROM employe" +
	                   " ORDER BY nom ASC";
		    result = st.executeQuery(sql);
		    while(result.next()) {
		    	System.out.println(result.getString("nom")+"\t"+result.getString("prenom")+"\t"+result.getString("mail"));
		    }
			 
//		  //insertion
		    System.out.println("Inserting records into the table...");
		    String insert = "INSERT INTO employe " +"(nom,prenom,mail,mdp,date_arrival)"+
	                   "VALUES ('lebron', 'James', 'lebron@gmail.com','qwerty', '2000-01-20')";
		    			st.executeUpdate(insert);
		    System.out.println("Inserted records into the table...");
		    
		    String insert_ligue = "INSERT INTO ligue " +"(nom_ligue)"+
	                   "VALUES ('justicier')";
		    st.executeUpdate(insert_ligue);
		    // updating
		    System.out.println("Updating records into the table...");
		    String update = "UPDATE employe " +
	                   "SET mail = 'james@gmail.fr' WHERE id_employe = 4";
		    st.executeUpdate(update);
		    System.out.println("Update complete");
		    
		    //delete
		    String delete = "DELETE FROM employe " +
	                   "WHERE id_employe = 5";
		    st.executeUpdate(delete);
		    System.out.println("Delete complete");
		          
		    
	/*	    
		    ResultSetMetaData rsmd = result.getMetaData();
		     for(int i=1; i<=rsmd.getColumnCount();i++) {
		    	 System.out.println(rsmd.getColumnClassName(i)+"\t");
		     }
		     System.out.println();
		     
		     while(result.next()) {
		    	 for(int i=1; i<=rsmd.getColumnCount();i++) {
		    		 System.out.println(result.getString(i)+"\t");
	    	 }
		    	 System.out.println();
   }*/
		// Handle errors for JDBC
			} catch (SQLException se) {
			
				System.out.print("Do not connect to DB - Error:"+se);
				se.printStackTrace();
		// Handle errors for class.forName
			}catch(Exception e){
				
					e.printStackTrace();
			}
         
		    finally {
		    	try {
		    		if(result != null) {
						result.close();	
					}
		    		if(st != null) {
						st.close();
					}
		    		if (con != null) {
						con.close();
					}		
						
		    	}catch(Exception e){
		    		e.printStackTrace();
		    	}
		    }
		}
	}
