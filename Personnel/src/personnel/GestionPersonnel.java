package personnel;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import personnel.Employe;

/**
 * Gestion du personnel. Un seul objet de cette classe existe.
 * Il n'est pas possible d'instancier directement cette classe, 
 * la méthode {@link #getGestionPersonnel getGestionPersonnel} 
 * le fait automatiquement et retourne toujours le même objet.
 * Dans le cas où {@link #sauvegarder()} a été appelé lors 
 * d'une exécution précédente, c'est l'objet sauvegardé qui est
 * retourné.
 */

public class GestionPersonnel implements Serializable
{
	private static final long serialVersionUID = -105283113987886425L;
	private static GestionPersonnel gestionPersonnel = null;
	private SortedSet<Ligue> ligues;
	private SortedSet<Employe> employes;
	private Employe root = new Employe(this, -1 , "root", "", "", "toor", null);
	public final static int SERIALIZATION = 1, DatabaseConnexion = 2, 
			TYPE_PASSERELLE = DatabaseConnexion;  
	private static Passerelle passerelle = TYPE_PASSERELLE == DatabaseConnexion ? new sql.DatabaseConnexion() : new serialisation.Serialization();	
	
	/**
	 * Retourne l'unique instance de cette classe.
	 * Crée cet objet s'il n'existe déjà.
	 * @return l'unique objet de type {@link GestionPersonnel}.
	 */
	
	public static GestionPersonnel getGestionPersonnel()
	{
		if (gestionPersonnel == null)
		{
			gestionPersonnel = passerelle.getGestionPersonnel();
			if (gestionPersonnel == null)
				gestionPersonnel = new GestionPersonnel();
		}
		return gestionPersonnel;
	}

	public GestionPersonnel()
	{
		if (gestionPersonnel != null)
			throw new RuntimeException("Vous ne pouvez créer qu'une seuls instance de cet objet.");
		    ligues = new TreeSet<>();
	}
	
	public void sauvegarder() throws SauvegardeImpossible
	{
		passerelle.sauvegarderGestionPersonnel(this);
	}
	
	/**
	 * Retourne la ligue dont administrateur est l'administrateur,
	 * null s'il n'est pas un administrateur.
	 * @param administrateur l'administrateur de la ligue recherchée.
	 * @return la ligue dont administrateur est l'administrateur.
	 */
	
	public Ligue getLigue(Employe administrateur)
	{
		if (administrateur.estAdmin(administrateur.getLigue()))
			return administrateur.getLigue();
		else
			return null;
	}

	/**
	 * Retourne toutes les ligues enregistrées.
	 * @return toutes les ligues enregistrées.
	 */
	
	public SortedSet<Ligue> getLigues()
	{
		return Collections.unmodifiableSortedSet(ligues);
	}

	public Ligue addLigue(String nom) throws SauvegardeImpossible
	{
		Ligue ligue = new Ligue(this, nom); 
		ligues.add(ligue);
		return ligue;
	}
	public Ligue addLigue(int id, String nom)
	{
		Ligue ligue = new Ligue(this, id, nom);
		ligues.add(ligue);
		return ligue;
	}

	void remove(Ligue ligue)
	{
		ligues.remove(ligue);
	}
	int insert(Ligue ligue) throws SauvegardeImpossible
	{
		return passerelle.insert(ligue);
	}
	int insert(Employe employe)throws SauvegardeImpossible
	{
		return passerelle.insert(employe);
	}
	int update(Ligue ligue) throws SauvegardeImpossible{
		return passerelle.update(ligue);
		
	}
	int delete(Ligue ligue) throws SauvegardeImpossible{
		return passerelle.delete(ligue);
	}
	int update (Employe employe)throws SauvegardeImpossible{
		return passerelle.update(employe);
		
	}
	int delete (Employe employe)throws SauvegardeImpossible{
		return passerelle.delete(employe);
		
	}
	
	/**
	 * Retourne le root (super-utilisateur).
	 * @return le root.
	 */
	
	public Employe getRoot()
	{
		return root;
	}

	public void addEmploye(int id, String nom, String prenom, String mail, String mdp, Date arrival) {
		
		
	}

//	public Employe addEmploye(String nom, String prenom, String mail, String password, LocalDate arrival) throws SauvegardeImpossible
//	{
//		Employe employe = new Employe(id,nom, prenom, mail, password, arrival);
//		employes.add(employe);
//		return employe;
//	}
//
//	public Employe addEmploye(int id,String nom, String prenom, String mail, String password, LocalDate arrival) {
//		Employe employe = new Employe(this,id,nom, prenom, mail, password, arrival);
//		employes.add(employe);
//		return employe;
//		
//	}
}
