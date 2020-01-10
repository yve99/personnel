package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	@Test
	void createLigue() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void addEmploye() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	 @Test
     void testRemove()
     {
             Ligue ligue = new Ligue("Fl�chettes");
             Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty");
             employe.remove();
             assertFalse(ligue.getEmployes().contains(employe));
     }
}
