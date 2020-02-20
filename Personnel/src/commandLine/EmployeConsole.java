package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.time.LocalDate;

import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;
import personnel.GestionPersonnel;


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

	private LocalDate getDate() {
		
		int dayOfMonth = 0 ;
		int month = 0;
		int year = 0;
		LocalDate date = LocalDate.of(year, month, dayOfMonth);
		return date;
	}

	private Option changerDateArrival(final Employe employe) {
		
		return new Option ("changer la date de départ ", "y",() ->  {employe.setDepart(getDate());});
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
	
	

}
