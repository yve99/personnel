package sql;
import java.sql.*;
import java.time.LocalDate;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;

public class DatabaseConnexion implements personnel.Passerelle{
	
	Connection connect;
	 
	              public DatabaseConnexion()
	              {
	            	  try {
	            		  Class.forName(DBConnect.getDriverClassName());
	          			connect = DriverManager.getConnection(DBConnect.getUrl(), DBConnect.getUser(), DBConnect.getPassword());
	            	  }
	            	  catch(ClassNotFoundException e) {
	            		  System.out.println("Pilote JDBC non installé.");
	            	  }
	            	  catch(SQLException e) {
	            		  System.out.println(e);
	            	  }
	              }	

	@Override
	public GestionPersonnel getGestionPersonnel() {
		GestionPersonnel gestionPersonnel = new GestionPersonnel();
		try 
		{
			String requete = "select * from ligue";
			Statement instruction = connect.createStatement();
			ResultSet ligues = instruction.executeQuery(requete);
			while (ligues.next())
				gestionPersonnel.addLigue(ligues.getInt(1), ligues.getString(2));
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
//		try
//		{
//			String requete = "select * from employe";
//			Statement instruction = connect.createStatement();
//			ResultSet result = instruction.executeQuery(requete);
//			while (result.next())
//				System.out.println(result.getInt("id_employe")+"\t"+result.getString("nom")+"\t"+
//			   result.getString("prenom")+"\t"+result.getString("mail")+"\t"+result.getString("mdp")+
//			    "\t"+result.getDate("date_arrival")+"\t"+result.getDate("date_depart")+"\t"+result.getInt("level"));	
//		 
//	}
//		catch(SQLException e)
//		{
//			System.out.println(e);
//		}
		return gestionPersonnel;
	}
	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible {
		close();
	}
	public void close() throws SauvegardeImpossible
	{
		try
		{
			if (connect != null)
				connect.close();
			
		}
		
		catch (SQLException e)
		{
			throw new SauvegardeImpossible(e);
		}
	}
	public int insert(Ligue ligue) throws SauvegardeImpossible 
	{
		try 
		{
			PreparedStatement instruction;
			instruction = connect.prepareStatement("insert into ligue (nom_ligue) values(?)", Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, ligue.getNom());		
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
		} 
		
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}	
		
			
	}
	public void update(Ligue ligue) throws SauvegardeImpossible 
	{
		
		try 
		{
			PreparedStatement instruction;
			 String sql = "UPDATE ligue " +
	                   "SET nom_ligue = ? WHERE id_ligue = ?";
		    instruction = connect.prepareStatement(sql);
		    instruction.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
	}
	public void delete(Ligue ligue) throws SauvegardeImpossible
	{
		try 
		{
			PreparedStatement instruction;
			String sql = "DELETE FROM  ligue WHERE nom_ligue=?";
			instruction = connect.prepareStatement(sql);
			instruction.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
	}
	
}