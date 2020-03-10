import java.sql.*;
public class database{
	
	public static void main(string agrs ) {
		
	}
}
 try {
	 //connexion a la base de données
	 connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8886/personnel","root","root");
	 //create statement
	 Statement my Stmt = MyConn.CreateStatement();
	 //execte sql query
	 ResultSet myRs = myStmt.exectueQuery("SELECT * FROM employe , ligue");
	 //results set
	 while (myRs.next()) {
		 System.out.print(myRs.getString("nom")+"."myRs.getString("prenom")+"."myRs.getString("mail")+"."myRs.getString("mdp")+"."
				 myRs.getString("date_arrival")+"."myRs.getString("date_depart")+"."myRs.getString("level")+".");
		 System.out.print(myRs.getString("nom"));
	 }
		 
 }
 catch (exception exe) {
	 exc.printStackTrace()();
 }