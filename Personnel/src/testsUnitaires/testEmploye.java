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
             Employe employe = ligue.addEmploye(mail, "selima", "sbk@gmail.com", "sbk");
             assertTrue(employe.getMail().contains(mail));
     }
}
