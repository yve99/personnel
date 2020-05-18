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
		try
		{
			
			String requete = "select * from employe";
			Statement instruction = connect.createStatement();
			ResultSet employes = instruction.executeQuery(requete);
			while (employes.next())
				  gestionPersonnel.addEmploye( employes.getInt(1), employes.getString(2),
			   employes.getString(3),employes.getString(4),employes.getString(5),
			    employes.getDate(6));	
		 
	}
		catch(SQLException e)
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
	public int insert(Employe employe) throws SauvegardeImpossible
	{
		try
		{
			PreparedStatement instruction;
			
			String nom=employe.getNom();String prenom=employe.getPrenom();
			String mail=employe.getMail();String password=employe.getPassword();
			LocalDate arrival=employe.getArrival();LocalDate depart=employe.getDepart();int level=0;
			if(depart == null) {
//				insert = "insert into employe (nom,prenom,mail,mdp,date_arrival,level) values(?,?,?,?,?,?)";
				instruction = connect.prepareStatement("insert into employe (nom,prenom,mail,mdp,date_arrival,level) values(?,?,?,?,?,?)", 
				Statement.RETURN_GENERATED_KEYS);
				 instruction.setString(1, employe.getNom());
				 instruction.setString(2, employe.getPrenom());		
				 instruction.setString(3, employe.getMail());
				 instruction.setString(2, employe.getPassword());		
				 instruction.setObject(4, employe.getArrival());
				 
			}
			else {
//				insert = "insert into employe (nom,prenom,mail,mdp,date_arrival,date_depart,level) values(?,?,?,?,?,?,?)";
				instruction = connect.prepareStatement("insert into employe (nom,prenom,mail,mdp,date_arrival,date_depart,level) values(?,?,?,?,?,?,?)", 
						Statement.RETURN_GENERATED_KEYS);
				instruction.setString(1, employe.getNom());
				instruction.setString(2, employe.getPrenom());		
				instruction.setString(3, employe.getMail());
				instruction.setString(2, employe.getPassword());		
				instruction.setObject(4, employe.getArrival());		
				instruction.setObject(5, employe.getDepart());		
			}
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}
	}
	public int update(Ligue ligue) throws SauvegardeImpossible 
	{
		
		try 
		{
			PreparedStatement instruction;
			 String sql = "UPDATE ligue " +
	                   "SET nom_ligue = ? WHERE id_ligue = ?";
		    instruction = connect.prepareStatement(sql);
		    instruction.executeUpdate();
		    ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
			
		}
		catch(Exception e){
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
		finally {
			       try {
			    	   if (connect != null)
				        connect.close();
			    	  
			       }
			       catch(SQLException e){
			    		e.printStackTrace();
			    		
			    	}
		}
		
	}
	public int update(Employe employe)throws SauvegardeImpossible
	{ 
		try 
		{
			String nom=employe.getNom();String prenom=employe.getPrenom();
			String mail=employe.getMail();String password=employe.getPassword();
			LocalDate arrival=employe.getArrival();LocalDate depart=employe.getDepart();int level=0;
			PreparedStatement instruction;
			if(depart==null) 
			{
				String sql="UPDATE employe" + "SET nom=?,prenom=?,mail=?,mdp=?,date_arrival=? WHERE id_employe=?";
				instruction = connect.prepareStatement(sql);
			}
			else
			{
				String sql="UPDATE employe" + "SET nom=?,prenom=?,mail=?,mdp=?,date_arrival=?,date_depart=? WHERE id_employe=?";
				instruction = connect.prepareStatement(sql);
			}
			 instruction.executeUpdate();
			 ResultSet id = instruction.getGeneratedKeys();
				id.next();
				return id.getInt(1);
			 
		}
		catch(Exception e){
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
		finally {
			       try {
			    	   if (connect != null)
				        connect.close();
			    	  
			       }
			       catch(SQLException e){
			    		e.printStackTrace();
			    		
			    	}
		}
		
	}
	public int delete(Ligue ligue) throws SauvegardeImpossible
	{
		try 
		{
			PreparedStatement instruction;
			String sql = "DELETE FROM  ligue WHERE nom_ligue=?";
			instruction = connect.prepareStatement(sql);
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
		finally 
		{
		       try {
		    	   if (connect != null)
			        connect.close();
		    	  
		       }
		       catch(SQLException e)
		       {
		    		e.printStackTrace();
		    		
		    	}
	}
	
}
	public int delete(Employe employe) throws SauvegardeImpossible
	{
		try {
			PreparedStatement instruction;
			int level = 0;
			if(employe.estAdmin(employe.getLigue())) {
				level=1;
			}
			if(employe.estRoot()) {
				level=2;
			}
			Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
			
			if(level==1)
			{
				String sql = "DELETE FROM employe WHERE nom=?,prenom=?,mail=?,mdp=?,date_arrival=?,level=?"; 
				instruction = connect.prepareStatement(sql);
				if(employe.estAdmin(employe.getLigue())){
						employe.getLigue().setAdministrateur(root);}		
			}
			else
			{
				String sql = "DELETE FROM employe WHERE nom=?,prenom=?,mail=?,mdp=?,date_arrival=?,level=?";
				instruction = connect.prepareStatement(sql);
			}
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
			
		}
		catch(Exception e){
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
		finally 
		{
		       try {
		    	   if (connect != null)
			        connect.close();
		    	  
		       }
		       catch(SQLException e)
		       {
		    		e.printStackTrace();
		    		
		    	}
	}
		
	}
}