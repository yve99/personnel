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
			instruction = connect.prepareStatement("insert into ligue (nom) values(?)", Statement.RETURN_GENERATED_KEYS);
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
}