package personnel;

import java.io.Serializable;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Représente une ligue. Chaque ligue est reliée à une liste
 * d'employés dont un administrateur. Comme il n'est pas possible
 * de créer un employé sans l'affecter à une ligue, le root est 
 * l'administrateur de la ligue jusqu'à ce qu'un employé lui ait été affecté.
 */

public class Ligue implements Serializable, Comparable<Ligue>
{
	private static final long serialVersionUID = 1L;
	private String nom;
	private SortedSet<Employe> employes;
	private Employe administrateur;
	
	/**
	 * Crée une ligue.
	 */
	
	public Ligue(String nom)
	{
		this.nom = nom;
		employes = new TreeSet<>();
		administrateur = GestionPersonnel.getGestionPersonnel().getRoot();
		GestionPersonnel.getGestionPersonnel().add(this);
	}

	/**
	 * Retourne le nom.
	 */

	public String getNom()
	{
		return nom;
	}

	/**
	 * Change le nom.
	 */

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne l'administrateur de la ligue.
	 */
	
	public Employe getAdministrateur()
	{
		return administrateur;
	}

	/**
	 * Fait de administrateur l'administrateur de la ligue.
	 * Lève DroitsInsuffisants si l'administrateur n'est pas 
	 * un employé de la ligue. Révoque les droits de l'ancien 
	 * administrateur.
	 */
	
	public void setAdministrateur(Employe administrateur)
	{
		if (administrateur.getLigue() != this)
			throw new DroitsInsuffisants();
		this.administrateur = administrateur;
	}

	/**
	 * Retourne les employés de la ligue.
	 */
	
	public SortedSet<Employe> getEmployes()
	{
		return Collections.unmodifiableSortedSet(employes);
	}

	/**
	 * Ajoute un employé dans la ligue. Cette méthode 
	 * est le seul moyen de créer un employé.
	 */

	public void addEmploye(String nom, String prenom, String mail, String password)
	{
		employes.add(new Employe(this, nom, prenom, mail, password));
	}
	
	void remove(Employe employe)
	{
		employes.remove(employe);
	}
	
	/**
	 * Supprime une ligue, entraîne la suppression de tous les employés
	 * de la ligue.
	 */
	
	public void remove()
	{
		GestionPersonnel.getGestionPersonnel().remove(this);
	}
	

	@Override
	public int compareTo(Ligue autre)
	{
		return getNom().compareTo(autre.getNom());
	}
	
	@Override
	public String toString()
	{
		return nom;
	}
}
