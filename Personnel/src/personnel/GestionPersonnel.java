package personnel;

import java.io.Serializable;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Gestion du personnel. Un seul objet de cette classe existe.
 * Il n'est pas possible d'instancier directement cette classe, 
 * la méthode {@link #getGestionPersonnel getGestionPersonnel} 
 * 	le fait automatiquement et retourne toujours le même objet.
 * 
 */

public class GestionPersonnel implements Serializable
{
	private static final long serialVersionUID = -105283113987886425L;
	private static GestionPersonnel gestionPersonnel;
	private SortedSet<Ligue> ligues;
	private Employe root = new Employe(null, "root", "", "", "toor");
	
	/**
	 * Retourne l'unique instance de cette classe.
	 * Crée cet objet s'il n'existe déjà.
	 */
	
	public static GestionPersonnel getGestionPersonnel()
	{
		if (gestionPersonnel == null)
		{
			gestionPersonnel = new GestionPersonnel();
		}
		return gestionPersonnel;
	}
	
	private GestionPersonnel()
	{
		ligues = new TreeSet<>();
	}
	
	/**
	 * Reoturne la ligue dont administrateur est l'administrateur,
	 * null s'il n'est pas un administrateur.
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
	 */
	
	public SortedSet<Ligue> getLigues()
	{
		return Collections.unmodifiableSortedSet(ligues);
	}

	void add(Ligue ligue)
	{
		ligues.add(ligue);
	}
	

	void remove(Ligue ligue)
	{
		ligues.remove(ligue);
	}
	

	/**
	 * Retourne le root (super-utilisateur).
	 */
	
	public Employe getRoot()
	{
		return root;
	}
}
