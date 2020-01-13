package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

 class testEmploye {
	 
	 
	 @Test
     void testSetMail()
     {
             Ligue ligue = new Ligue("champion");
             String mail = "sbk@gmail.com";
             Employe employe = ligue.addEmploye("dénim" ,"selima", mail , "sbk");
             employe.setMail(mail);
             assertEquals(mail, employe.getMail());
     }
	  
	 @Test
	 void testSetPassword()
	 {
		 
		 Ligue ligue = new Ligue("champion");
		 String password = "qwerty";
		 Employe employe = ligue.addEmploye("dénim", "selima", "sbk@gmail.com", password);
		 employe.setPassword(password);
		 assertTrue(employe.checkPassword(password));
	 }
	 @Test
	 void testSetPrenom() {
		 
		 Ligue ligue = new Ligue ("champion");
		 String prenom = "selima";
		 Employe employe = ligue.addEmploye("dénim", prenom, "sbk@gmail.com", "qwerty");
		 employe.setPrenom(prenom);
		 assertEquals(prenom, employe.getPrenom());
		 
		 
		 
		 
		 
	 }
}
