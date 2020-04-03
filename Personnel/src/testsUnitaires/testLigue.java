package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
class testLigue
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
        @Test
        void testCreateLigue() throws SauvegardeImpossible
        {       
        	Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
                assertEquals("Fléchettes", ligue.getNom());
//                System.out.println(ligue.getNom());
        }

        @Test
        void testAddEmploye() throws SauvegardeImpossible
        {
        	Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
                Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty", LocalDate.now());
                assertEquals(employe, ligue.getEmployes().first());
                assertEquals(ligue, employe.getLigue());
        }
        @Test
        void testSetNom() throws SauvegardeImpossible
        {
        	Ligue ligue = gestionPersonnel.addLigue("champion");
            String ligue1 = "fléchettes" ;
            ligue.setNom(ligue1);
            assertEquals(ligue1, ligue.getNom());
             System.out.println(ligue.getNom());
        }
        @Test
        void  testGetAdministrateur() throws SauvegardeImpossible
        {
        	Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
                Employe employe = GestionPersonnel.getGestionPersonnel().getRoot();
                ligue.setAdministrateur(employe);
                assertEquals(employe, ligue.getAdministrateur());
        }
        @Test
        void testRemove() throws SauvegardeImpossible
        {
                Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
                Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now());
                ligue.remove();
                assertFalse(ligue.getEmployes().contains(employe));
                assertNull(employe.getLigue());
              //  assertFalse(employe.getLigue().contains(ligue));
        }

	
	 @Test
     void testCompareTo() throws SauvegardeImpossible
     {
             Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
             Ligue ligue2 = gestionPersonnel.addLigue("champion");
             ligue.compareTo(ligue2);
             assertNotEquals(ligue.getNom() , ligue2.getNom());
             assertTrue(ligue.compareTo(ligue2) > 0);
             assertTrue(ligue.compareTo(ligue2)< 0);
     }
	 @Test 
	 void testGetEmployes() throws SauvegardeImpossible
	 {
		 
		 Ligue ligue = gestionPersonnel.addLigue ("champion");
		 Employe employe = ligue.addEmploye("selim", "delim", "sbd@gmail.com", "selim", LocalDate.now());
		 assertTrue(ligue.getEmployes().contains(employe));
		 ligue.getEmployes().size();
		// System.out.println(ligue.getEmployes().size());
	 }
	 @Test
	 void testToString() throws SauvegardeImpossible
	 {
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 String nom = "champion";
		 ligue.setNom(nom);
		 assertEquals(ligue.toString(), ligue.getNom());
		// System.out.println(ligue.getNom());
		  
	 }
     @Test
	 void testgetNom() throws SauvegardeImpossible
     {	 
		 Ligue ligue = gestionPersonnel.addLigue("champion");
		 String nom = "champion";
		 Employe employe = ligue.addEmploye("denim" ,"selima","sbk@gmail.com", "sbk", LocalDate.now());
		 ligue.setNom(nom);
         assertEquals(nom, ligue.getNom());
	  // System.out.println(ligue.getNom());	 
		 
	 }
     @Test
    void setAdministarateur() throws SauvegardeImpossible
     {
    	 Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
    	 Employe employe = ligue.addEmploye("denim" ,"selima","sbk@gmail.com", "sbk", LocalDate.now());
    	 ligue.setAdministrateur(employe);
    	 assertEquals(employe, ligue.getAdministrateur());
//    	System.out.println(ligue.getAdministrateur()); 	 
     }
	 
}


