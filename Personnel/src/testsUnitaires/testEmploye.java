package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

 class testEmploye {
	 
	 
	 @Test
     void testSetMail()
     {
             Ligue ligue = new Ligue("champion");
             String mail = "fifa@gmail.com" ;
             Employe employe = ligue.addEmploye("d�nim" ,"selima", "sbk@gmail.com", "sbk");
             employe.setMail(mail);
             assertEquals(mail, employe.getMail());
            // System.out.println(employe.getMail());
     }
	 @Test
	 void testgetMail() {
		 
		 Ligue ligue = new Ligue("champion");
		 String mail =  "sbk@gmail.com";
		 Employe employe = ligue.addEmploye("d�nim" ,"selima",mail, "sbk");
		 employe.setMail(mail);
         assertEquals(mail, employe.getMail());
	//System.out.println(employe.getMail());	 
		 
	 }
	  
	 @Test
	 void testSetPassword()
	 {
		 
		 Ligue ligue = new Ligue("champion");
		 String password = "million";
		 Employe employe = ligue.addEmploye("d�nim", "selima", "sbk@gmail.com","qwerty");
		 employe.setPassword(password);
		 assertTrue(employe.checkPassword(password));
	 }
	 @Test
	 void testsetPrenom() {
		 
		 Ligue ligue = new Ligue ("champion");
		 String prenom = "lebron";
		 Employe employe = ligue.addEmploye("d�nim", "selima", "sbk@gmail.com", "qwerty");
		 employe.setPrenom(prenom);
		 assertEquals(prenom, employe.getPrenom());	 
		 
	 }
	 @Test
	 void testgetPrenom() {
		 
		 Ligue ligue = new Ligue("champion");
		 String prenom = "selima" ;
		 Employe employe = ligue.addEmploye("d�nim" ,prenom,"sbk@gmail.com", "sbk");
		 employe.setPrenom(prenom);
         assertEquals(prenom, employe.getPrenom());
	   //System.out.println(employe.getPrenom());	 
		 
	 }
	
	 @Test
	 void testSetNom() {
		 
		 Ligue ligue = new Ligue ("champion");
		 String nom = "james" ;
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com", "qwerty");
		 employe.setNom(nom);
		 assertEquals(nom, employe.getNom());	 
		  
	 }
	 @Test
	 void testgetNom() {
		 
		 Ligue ligue = new Ligue("champion");
		 String nom = "denim" ;
		 Employe employe = ligue.addEmploye(nom ,"selima","sbk@gmail.com", "sbk");
		 employe.setNom(nom);
         assertEquals(nom, employe.getNom());
	 //  System.out.println(employe.getNom());	 
		 
	 }
	 @Test
	 void testgetLigue() {
		 
		 Ligue ligue = new Ligue("champion");
		 Employe employe = ligue.addEmploye("denim"  ,"selima","sbk@gmail.com", "sbk");
		 employe.getLigue();
         assertEquals(ligue, employe.getLigue());
	  // System.out.println(employe.getLigue());	 
		 
	 }
	 
	 @Test
	 void testcheckPassword() {
		 Ligue ligue = new Ligue("champion");
		 String password = "qwerty";
		 Employe employe = ligue.addEmploye("denim", "selima", "sbk@gmail.com",password);
		 employe.checkPassword(password);
		 assertTrue(employe.checkPassword(password));
		 
		// System.out.println(employe.checkPassword(password));
		  
	 }
	 @Test
	 void testEstRoot() {
		 
		 Ligue ligue = new Ligue("Fléchettes");
		 Employe employe = GestionPersonnel.getGestionPersonnel().getRoot();
         employe.estRoot();
         assertTrue(employe.estRoot());
		 
      // System.out.println(employe.estRoot());
		 
	 }
	 @Test
	 void testEstAdmin() {
		 Ligue ligue = new Ligue ("champion");
		 Employe employe = GestionPersonnel.getGestionPersonnel().getRoot();
		 employe.estAdmin(ligue);
		 assertTrue(employe.estAdmin(ligue));
		 
		//System.out.println(employe.estAdmin(ligue)); 
		 
		 
	 }
	 @Test
     void testCompareTo()
     {
             Ligue ligue = new Ligue("Fléchettes");
             Employe employe = ligue.addEmploye("d�nim", "selima", "sbk@gmail.com", "qwerty");
             Employe employe2 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
             employe.compareTo(employe2);
             assertNotEquals(employe.getNom(), employe2.getNom());
     }
	 @Test
     void testRemove()
     {
             Ligue ligue = new Ligue("Fléchettes");
             Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
           employe.remove();
             assertFalse(ligue.getEmployes().contains(employe));
           //  assertFalse(employe.getLigue().contains(ligue));
     }
	 @Test
	 void testToString() {
		 Ligue ligue = new Ligue("champion");
		 Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		 
		 assertEquals(ligue.toString(), ligue.getNom());
		// System.out.println(ligue.getNom());
		  
	 } 
	 
}
