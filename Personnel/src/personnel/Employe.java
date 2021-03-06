package personnel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;


/**

* Employé d'une ligue hébergée par la M2L. Certains peuvent

 * être administrateurs des employés de leur ligue.

* Un seul employé, rattaché à aucune ligue, est le root.

* Il est impossible d'instancier directement un employé,

 * il faut passer la méthode {@link Ligue#addEmploye addEmploye}.

*/

 

public class Employe implements Serializable, Comparable<Employe>

{
             private static final long serialVersionUID = 4795721718037994734L;

             private String nom, prenom, password, mail;
             private LocalDate arrival;
             private LocalDate depart;
             private int id = -1;
             private Ligue ligue;
             private GestionPersonnel gestionPersonnel;

             public Employe(GestionPersonnel gestionPersonnel, String nom, String prenom, String mail, String password,LocalDate arrival) throws SauvegardeImpossible  {
        		this(gestionPersonnel, -1, nom, prenom,mail,password,arrival);
        		this.id = gestionPersonnel.insert(this);
        	}
        	 public Employe(GestionPersonnel gestionPersonnel, int id, String nom, String prenom,
        			 String mail, String password, LocalDate arrival) {
        		 this.nom=nom;
        		 this.prenom = prenom;
                 this.password = password;
                 this.mail = mail;
                 this.arrival= arrival;
                 this.ligue=ligue;
                 this.gestionPersonnel = gestionPersonnel;
                 this.id=id;
        		
        	} 
                
             
             
//public Employe(GestionPersonnel gestionPersonnel, Ligue ligue, String nom, String prenom, String mail, String password, LocalDate arrival) { 
//
//                           this.nom = nom;
//                           this.prenom = prenom;
//                           this.password = password;
//                           this.mail = mail;
//                           this.ligue = ligue;
//                           this.arrival= arrival;
//                          this.gestionPersonnel = gestionPersonnel;
//            }
             /**
             * Retourne vrai ssi l'employé est administrateur de la ligue
              * passée en paramètre.
             * @return vrai ssi l'employé est administrateur de la ligue
              * passée en paramètre.
             * @param ligue la ligue pour laquelle on souhaite vérifier si this
              * est l'admininstrateur.
             */

             public boolean estAdmin(Ligue ligue)
             {

                           return ligue.getAdministrateur() == this;

             }
             /**

             * Retourne vrai ssi l'employé est le root.
             * @return vrai ssi l'employé est le root.
             */

             public boolean estRoot()

             {

                           return GestionPersonnel.getGestionPersonnel().getRoot() == this;

             }

            

             /**
             * Retourne le nom de l'employé.
             * @return le nom de l'employé.
              */

             public String getNom()

             {
                           return nom;
             }


             /**
             * Change le nom de l'employé.
             * @param nom le nouveau nom.
             */

             public void setNom(String nom)

             {
                           this.nom = nom;
             }
             
             /**
             * Retourne le prénom de l'employé.
             * @return le prénom de l'employé.
             */

             public String getPrenom()

             {

                           return prenom;

             }

            

             /**

             * Change le prénom de l'employé.

             * @param prenom le nouveau prénom de l'employé.

              */

 

             public void setPrenom(String prenom)

             {

                           this.prenom = prenom;

             }

 

             /**

             * Retourne le mail de l'employé.

             * @return le mail de l'employé.

             */

            

             public String getMail()

             {

                           return mail;

             }

            

             /**

             * Change le mail de l'employé.

             * @param mail le nouveau mail de l'employé.

             */

 

             public void setMail(String mail)

             {

                           this.mail = mail;

             }

 

             /**

             * Retourne vrai ssi le password passé en paramètre est bien celui

             * de l'employé.

             * @return vrai ssi le password passé en paramètre est bien celui

             * de l'employé.

             * @param password le password auquel comparer celui de l'employé.

             */

            

             public boolean checkPassword(String password)

             {

                           return this.password.equals(password);

             }

 

             /**

             * Change le password de l'employé.

             * @param password le nouveau password de l'employé.

              */

            

             public void setPassword(String password)

             {

                           this.password= password;

             }

             /**

             * Retourne la ligue à laquelle l'employé est affecté.

             * @return la ligue à laquelle l'employé est affecté.

             */
             public Ligue getLigue()

             {

                           return ligue;

             }

             /**

             * Supprime l'employé. Si celui-ci est un administrateur, le root

             * récupère les droits d'administration sur sa ligue.

             */
             public void remove()

             {

                           Employe root = GestionPersonnel.getGestionPersonnel().getRoot();

                           if (this != root)

                           {

                                        if (estAdmin(getLigue()))

                                                     getLigue().setAdministrateur(root);

                                        ligue.remove(this);

                           }

                           else

                                        throw new ImpossibleDeSupprimerRoot();

             }
             @Override

             public int compareTo(Employe autre)

             {

                           int cmp = getNom().compareTo(autre.getNom());

                           if (cmp != 0)

                                        return cmp;

                           return getPrenom().compareTo(autre.getPrenom());

             }
             @Override

             public String toString()

             {
                 String res = prenom + " " + nom + " " + mail + " " + arrival + " " + depart +" (";

                           if (estRoot())

                                        res += "super-utilisateur";

                           else

                                        res += ligue.toString();

                           return res + ")";
             }

/**
* retourne la date d'arrivée de l'employé
* @return la date de depart de l'employé*/

             public LocalDate getArrival() {

                           return arrival;
             }
/**
* change la date d'arrivée de l'employé
* @param la date d'arrivée de l'employé*/
             public void setArrival(LocalDate Arrival) {

                           this.arrival = arrival;
             }
/**
* retourne la date de depart de l'employé
* @return la date de depart de l'employé*/
             public LocalDate getDepart() {

                           return depart;
             }
/**
 * change la date de depart de l'employé
 * @param la date de depart de l'employé*/
             public void setDepart(LocalDate depart) {

                           this.depart = depart;
             }
             /** retourne le mot de passe de l'employé
              * @return le mot de passe de l'employé */
             public String getPassword() {
	
	             return password;
             }

}

 