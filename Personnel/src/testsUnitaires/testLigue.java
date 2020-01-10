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
                Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty");
                assertEquals(employe, ligue.getEmployes().first());
        }
        @Test
        void testSetNom()
        {
                Ligue ligue = new Ligue("champion");
                String nom = "selima";
                Employe employe = ligue.addEmploye(nom, "selima", "sbk@gmail.com", "sbk");
                assertTrue(employe.getNom().contains(nom));
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
                Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
                employe.remove();
                assertFalse(ligue.getEmployes().contains(employe));
        }

	
	 @Test
     void testCompareTo()
     {
             Ligue ligue = new Ligue("Fléchettes");
             Ligue ligue2 = new Ligue("champion");
             ligue.getNom().compareTo(ligue2.getNom());
             assertNotEquals(ligue.getNom(), ligue2.getNom());
     }

}

