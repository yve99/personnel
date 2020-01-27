package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import personnel.*;

 class testEmploye {
	 
	 
	 @Test
     void testSetMail()
     {
             Ligue ligue = new Ligue("champion");
             String mail = "fifa@gmail.com" ;
             Employe employe = ligue.addEmploye("d�nim" ,"selima", "sbk@gmail.com", "sbk",null );
             employe.setMail(mail);
             assertEquals(mail, employe.getMail());
            // System.out.println(employe.getMail());
     }
	 @Test
	 void testgetMail() {
		 
		 Ligue ligue = new Ligue("champion");
		 String mail =  "sbk@gmail.com";
		 Employe employe = ligue.addEmploye("d�nim" ,"selima",mail, "sbk", null);
         assertEquals(mail, employe.getMail());
	//System.out.println(employe.getMail());	 
		 
	 }
	  
	 @Test
	 void testSetPassword()
	 {
		 
		 Ligue ligue = new Ligue("champion");
		 String password = "million";
		 Employe employe = ligue.addEmploye("d�nim", "selima", "sbk@gmail.com","qwerty", null);
		 employe.setPassword(password);
		 assertTrue(employe.checkPassword(password));
	 }
	 @Test
	 void testsetPrenom() {
		 
		 Ligue ligue = new Ligue ("champion");
		 String prenom = "lebron";
		 Employe employe = ligue.addEmploye("d�nim", "selima", "sbk@gmail.com", "qwerty", null);
		 employe.setPrenom(prenom);
		 assertEquals(prenom, employe.getPrenom());	 
		 
	 }
	 @Test
	 void testgetPrenom() {
		 
		 Ligue ligue = new Ligue("champion");
		 String prenom = "selima" ;
		 Employe employe = ligue.addEmploye("d�nim" ,prenom,"sbk@gmail.com", "sbk", null);
         assertEquals(prenom, employe.getPrenom());
	   //System.out.println(employe.getPrenom());	 
		 
	 }
	
	 @Test
	 void testSetNom() {
		 
		 Ligue ligue = new Ligue ("champion");
		 String nom = "james" ;
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com", "qwerty", null);
		 employe.setNom(nom);
		 assertEquals(nom, employe.getNom());	 
		  
	 }
	 @Test
	 void testgetNom() {
		 
		 Ligue ligue = new Ligue("champion");
		 String nom = "denim" ;
		 Employe employe = ligue.addEmploye(nom ,"selima","sbk@gmail.com", "sbk", null);
         assertEquals(nom, employe.getNom());
	 //  System.out.println(employe.getNom());	 
		 
	 }
	 @Test
	 void testgetLigue() {
		 
		 Ligue ligue = new Ligue("champion");
		 Employe employe = ligue.addEmploye("denim"  ,"selima","sbk@gmail.com", "sbk", null);
		 employe.getLigue();
         assertEquals(ligue, employe.getLigue());
	  // System.out.println(employe.getLigue());	 
		 
	 }
	 
	 @Test
	 void testcheckPassword() {
		 Ligue ligue = new Ligue("champion");
		 String password = "qwerty";
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com",password, null);
		 employe.checkPassword(password);
		 assertTrue(employe.checkPassword(password));
		 
		// System.out.println(employe.checkPassword(password));
		  
	 }
	 @Test
	 void testEstRoot() {
		 
		 Ligue ligue = new Ligue("Fléchettes");
		 Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com","qwerty", null);
         assertTrue(root.estRoot());
         assertFalse(employe.estRoot());
		 
      // System.out.println(employe.estRoot());
		 
	 }
	 @Test
	 void testEstAdmin() {
		 Ligue ligue = new Ligue ("champion");
		 Ligue ligue1 = new Ligue("Fléchettes");
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com","qwerty", null);
		 Employe employe2 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", null);
		ligue.setAdministrateur(employe);
		 assertTrue(employe.estAdmin(ligue));
		 assertFalse(employe.estAdmin(ligue1));
		 assertFalse(employe2.estAdmin(ligue)); 
		//System.out.println(employe.estAdmin(ligue)); 
		 
		 
	 }
	 @Test
     void testCompareTo()
     {
             Ligue ligue = new Ligue("Fléchettes");
             Employe employe = ligue.addEmploye("d�nim", "selima", "sbk@gmail.com", "qwerty", null);
             Employe employe2 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", null);
             employe.compareTo(employe2);
             assertNotEquals(employe.getNom(), employe2.getNom());
     }
	 @Test
     void testRemove()
     {
             Ligue ligue = new Ligue("Fléchettes");
             Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", null);
             Employe employe2 = GestionPersonnel.getGestionPersonnel().getRoot();
             ligue.setAdministrateur(employe);
             employe.remove();
             assertFalse(ligue.getEmployes().contains(employe));
             assertNull(employe.getLigue());
             assertTrue(ligue.getAdministrateur().equals(employe2));
            
     }
	 @Test
	 void testToString() {
		 Ligue ligue = new Ligue("champion");
		 Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", null);
		 
		 assertEquals(ligue.toString(), ligue.getNom());
		// System.out.println(ligue.getNom());
		  
	 } 
	 @Test
	 void testSetArrival() {
		 Ligue ligue = new Ligue("champion");
		 LocalDate arrival = LocalDate.of(2017, 12, 15);
		 Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",null);
		 employe.setArrival(arrival);
		 assertEquals(arrival, employe.getArrival());
		// System.out.println(arrival); 
		 
	}
	
	 @Test
		void testGetDepart() {
			Ligue ligue = new Ligue("Fléchettes");
			LocalDate arrival = LocalDate.of(2019, 01, 20);
			LocalDate today = LocalDate.of(2020, 01, 20);
			Employe employe = ligue.addEmploye("selima", "bk", "sbk@gmail.com", "pass", arrival);
			assertEquals(employe.getDepart(), today);
			//System.out.println(employe.getDepart());
		}
	 
	 @Test
		void testGetArrival() {
			Ligue ligue = new Ligue("Fléchettes");
			LocalDate date = LocalDate.of(2019,02 ,20);
			Employe employe = ligue.addEmploye("selima", "bk", "sbk@gmail.com", "pass", date);	
			assertEquals(employe.getArrival(), date);
		//System.out.println(employe.getArrival());	
		}
	 @Test
	 void testSetDepart() {
		 Ligue ligue = new Ligue("champion");
		 LocalDate depart = LocalDate.of(2017, 12, 15);
		 Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",null);
		 employe.setDepart(depart);
		 assertEquals(depart, employe.getDepart());
		// System.out.println(depart); 
		 
	}
}
