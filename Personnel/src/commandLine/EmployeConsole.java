package commandLine;
import static commandLineMenus.rendering.examples.util.InOut.getInt;

import static commandLineMenus.rendering.examples.util.InOut.getString;

 

import java.time.LocalDate;
import java.time.Month;

import commandLineMenus.List;
import commandLineMenus.Menu;

import commandLineMenus.Option;

import personnel.Employe;

import personnel.GestionPersonnel;
import personnel.Ligue;
 
public class EmployeConsole

{

	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employé", "l", () -> {System.out.println(employe);});
	}

	Menu editerEmploye(Employe employe)
	{
		Menu menu = new Menu("Gérer le compte " + employe.getNom(), "c");
		menu.add(afficher(employe));
		menu.add(changerNom(employe));
		menu.add(changerPrenom(employe));
		menu.add(changerMail(employe));
		menu.add(changerPassword(employe));
		menu.add(changerDateArrival(employe));
		menu.add(changerDateDepart(employe));
		menu.addBack("q");
		return menu;
	}

	private Option changerDateDepart( final Employe employe) {
		
		return new Option ("changer la date d'arrivée " , "z", () -> {employe.setArrival(getDate());});
	}

	private Option changerDateArrival(final Employe employe) {
		
		return new Option ("changer la date de départ ", "y",() ->  {employe.setDepart(getDate());});
	}
	 private LocalDate getDate() {

         int year = getInt("année  : ");

         int month = getInt("mois : ");

         int dayOfMonth = getInt(" jour :");

         LocalDate date = LocalDate.of(year,month, dayOfMonth);

         return date;   

}

	private Option changerNom(final Employe employe)
	{
		return new Option("Changer le nom", "n", 
				() -> {employe.setNom(getString("Nouveau nom : "));}
			);
	}
	
	private Option changerPrenom(final Employe employe)
	{
		return new Option("Changer le prénom", "p", () -> {employe.setPrenom(getString("Nouveau prénom : "));});
	}
	
	private Option changerMail(final Employe employe)
	{
		return new Option("Changer le mail", "e", () -> {employe.setMail(getString("Nouveau mail : "));});
	}
	
	private Option changerPassword(final Employe employe)
	{
		return new Option("Changer le password", "x", () -> {employe.setPassword(getString("Nouveau password : "));});
	}
	
	Menu selectEmployer(Employe employe) {
		Menu menu = new Menu("editer " + employe.getNom(), "f");
		menu.add(afficher(employe));
		menu.add(editerEmploye(employe));
//		menu.add(supprimerEmployes(employe));
		menu.addBack("q");
		return menu;
		
	}
	
	
}
