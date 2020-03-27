package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import personnel.*;

 class testEmploye {
	 
	 GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	 @Test
     void testSetMail() throws SauvegardeImpossible
     {
             Ligue ligue = gestionPersonnel.addLigue("champion");
             String mail = "fifa@gmail.com" ;
             Employe employe = ligue.addEmploye("denim" ,"selima", "sbk@gmail.com", "sbk",LocalDate.now() );
             employe.setMail(mail);
             assertEquals(mail, employe.getMail());
            // System.out.println(employe.getMail());
     }
	 @Test
	 void testgetMail() throws SauvegardeImpossible
	 {
		 
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 String mail =  "sbk@gmail.com";
		 Employe employe = ligue.addEmploye("denim" ,"selima",mail, "sbk", LocalDate.now());
         assertEquals(mail, employe.getMail());
	//System.out.println(employe.getMail());	 
		 
	 }
	  
	 @Test
	 void testSetPassword() throws SauvegardeImpossible
	 {
		 
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 String password = "million";
		 Employe employe = ligue.addEmploye("d�nim", "selima", "sbk@gmail.com","qwerty", LocalDate.now());
		 employe.setPassword(password);
		 assertTrue(employe.checkPassword(password));
	 }
	 @Test
	 void testsetPrenom() throws SauvegardeImpossible
	 {
		 
		 Ligue ligue = gestionPersonnel.addLigue ("champion"); 
		 String prenom = "lebron";
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com", "qwerty", LocalDate.now());
		 employe.setPrenom(prenom);
		 assertEquals(prenom, employe.getPrenom());	 
		 
	 }
	 @Test
	 void testgetPrenom() throws SauvegardeImpossible
	 {
		 
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 String prenom = "selima" ;
		 Employe employe = ligue.addEmploye("denim" ,prenom,"sbk@gmail.com", "sbk", LocalDate.now());
         assertEquals(prenom, employe.getPrenom());
	   //System.out.println(employe.getPrenom());	 
		 
	 }
	
	 @Test
	 void testSetNom() throws SauvegardeImpossible
	 {
		 
		 Ligue ligue = gestionPersonnel.addLigue ("champion");
		 String nom = "james" ;
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com", "qwerty", LocalDate.now());
		 employe.setNom(nom);
		 assertEquals(nom, employe.getNom());	 
		  
	 }
	 @Test
	 void testgetNom() throws SauvegardeImpossible
	 {
		 
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 String nom = "denim" ;
		 Employe employe = ligue.addEmploye(nom ,"selima","sbk@gmail.com", "sbk",LocalDate.now());
         assertEquals(nom, employe.getNom());
	 //  System.out.println(employe.getNom());	 
		 
	 }
	 @Test
	 void testgetLigue() throws SauvegardeImpossible
	 {
		 
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 Employe employe = ligue.addEmploye("denim"  ,"selima","sbk@gmail.com", "sbk", LocalDate.now());
		 employe.getLigue();
         assertEquals(ligue, employe.getLigue());
	  // System.out.println(employe.getLigue());	 
		 
	 }
	 
	 @Test
	 void testcheckPassword() throws SauvegardeImpossible
	 {
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 String password = "qwerty";
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com",password, LocalDate.now());
		 employe.checkPassword(password);
		 assertTrue(employe.checkPassword(password));
		 
		// System.out.println(employe.checkPassword(password));
		  
	 }
	 @Test
	 void testEstRoot() throws SauvegardeImpossible
	 {
		 
		 Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		 Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com","qwerty", LocalDate.now());
         assertTrue(root.estRoot());
         assertFalse(employe.estRoot());
		 
      // System.out.println(employe.estRoot());
		 
	 }
	 @Test
	 void testEstAdmin() throws SauvegardeImpossible
	 {
		 Ligue ligue = gestionPersonnel.addLigue ("champion");
		 Ligue ligue1 = gestionPersonnel.addLigue("Fléchettes");
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com","qwerty", LocalDate.now());
		 Employe employe2 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now());
		ligue.setAdministrateur(employe);
		 assertTrue(employe.estAdmin(ligue));
		 assertFalse(employe.estAdmin(ligue1));
		 assertFalse(employe2.estAdmin(ligue)); 
		//System.out.println(employe.estAdmin(ligue)); 
		 
		 
	 }
	 @Test
     void testCompareTo() throws SauvegardeImpossible
     {
             Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
             Employe employe = ligue.addEmploye("d�nim", "selima", "sbk@gmail.com", "qwerty", LocalDate.now());
             Employe employe2 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now());
             employe.compareTo(employe2);
             assertNotEquals(employe.getNom(), employe2.getNom());
     }
	 @Test
     void testRemove() throws SauvegardeImpossible
     {
             Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
             Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
             Employe employe2 = GestionPersonnel.getGestionPersonnel().getRoot();
             ligue.setAdministrateur(employe);
             employe.remove();
             assertFalse(ligue.getEmployes().contains(employe));
             assertNull(employe.getLigue());
             assertTrue(ligue.getAdministrateur().equals(employe2));
            
     }
	 @Test
	 void testToString() throws SauvegardeImpossible
	 {
		 Ligue ligue =gestionPersonnel.addLigue("champion");
		 Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now());
		 
		 assertEquals(ligue.toString(), ligue.getNom());
		// System.out.println(ligue.getNom());
		  
	 } 
	 @Test
	 void testSetArrival() throws SauvegardeImpossible
	 {
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 LocalDate arrival = LocalDate.of(2017, 12, 15);
		 Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		 employe.setArrival(arrival);
		 assertEquals(arrival, employe.getArrival());
		// System.out.println(arrival); 
		 
	}
	
	 @Test
		void testGetDepart() throws SauvegardeImpossible
	 {
			Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
			LocalDate arrival = LocalDate.of(2019, 01, 20);
			LocalDate today = LocalDate.of(2020, 01, 20);
			Employe employe = ligue.addEmploye("selima", "bk", "sbk@gmail.com", "pass", arrival);
			assertEquals(employe.getDepart(), today);
			//System.out.println(employe.getDepart());
		}
	 
	 @Test
		void testGetArrival() throws SauvegardeImpossible
	 {
			Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
			LocalDate date = LocalDate.of(2019,02 ,20);
			Employe employe = ligue.addEmploye("selima", "bk", "sbk@gmail.com", "pass", date);	
			assertEquals(employe.getArrival(), date);
		//System.out.println(employe.getArrival());	
		}
	 @Test
	 void testSetDepart() throws SauvegardeImpossible
	 {
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 LocalDate depart = LocalDate.of(2017, 12, 15);
		 Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		 employe.setDepart(depart);
		 assertEquals(depart, employe.getDepart());
		// System.out.println(depart); 
		 
	}
}

