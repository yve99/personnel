package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue
{

        @Test
        void testCreateLigue()
        {       
                Ligue ligue = new Ligue("Fléchettes");
                assertEquals("Fléchettes", ligue.getNom());
        }

        @Test
        void testAddEmploye()
        {
                Ligue ligue = new Ligue("Fléchettess");
                Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty", null);
                assertEquals(employe, ligue.getEmployes().first());
                assertEquals(ligue, employe.getLigue());
        }
        @Test
        void testSetNom()
        {
        	Ligue ligue = new Ligue("champion");
            String nom = "fléchettes" ;
          //  Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty");
            ligue.setNom(nom);
            assertEquals(nom, ligue.getNom());
            // System.out.println(ligue.getNom());
        }
        @Test
        void  testGetAdministrateur()
        {
                Ligue ligue = new Ligue("Fléchettes");
                Employe employe = GestionPersonnel.getGestionPersonnel().getRoot();
                ligue.setAdministrateur(employe);
                assertEquals(employe, ligue.getAdministrateur());
        }
        @Test
        void testRemove()
        {
                Ligue ligue = new Ligue("Fléchettes");
                Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", null);
                employe.remove();
                assertFalse(ligue.getEmployes().contains(employe));
              //  assertFalse(employe.getLigue().contains(ligue));
        }

	
	 @Test
     void testCompareTo()
     {
             Ligue ligue = new Ligue("Fléchettes");
             Ligue ligue2 = new Ligue("champion");
             ligue.compareTo(ligue2);
             assertNotEquals(ligue.getNom(), ligue2.getNom());
     }
	 @Test 
	 void testGetEmployes() {
		 
		 Ligue ligue = new Ligue ("champion");
		 Employe employe = ligue.addEmploye("selim", "delim", "sbd@gmail.com", "selim", null);
		 assertTrue(ligue.getEmployes().contains(employe));
		 ligue.getEmployes().size();
		// System.out.println(ligue.getEmployes().size());
	 }
	 @Test
	 void testToString() {
		 Ligue ligue = new Ligue("champion");
		 String nom = "champion";
		 ligue.setNom(nom);
		 assertEquals(ligue.toString(), ligue.getNom());
		// System.out.println(ligue.getNom());
		  
	 }
     @Test
	 void testgetNom() {
		 
		 Ligue ligue = new Ligue("champion");
		 String nom = "champion";
		 Employe employe = ligue.addEmploye("denim" ,"selima","sbk@gmail.com", "sbk", null);
		 ligue.setNom(nom);
         assertEquals(nom, ligue.getNom());
	  // System.out.println(ligue.getNom());	 
		 
	 }
    // @Test
    //void setAdministarateur(){
    	// Ligue ligue = new Ligue("Fléchettes");
    	 //String administrateur = "administrateur";
    	 //Employe employe = GestionPersonnel.getGestionPersonnel().getRoot();
    	 //ligue.setAdministrateur(administrateur);
    	 //assertEquals(administrateur, ligue.getAdministrateur());
    	//System.out.println(ligue.getAdministrateur()); 	 
     //}
	 
}

