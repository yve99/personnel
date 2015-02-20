package commandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Util
{
	static String saisieString(String message)	
	{
		System.out.println(message);
		while(true)
		{
			try
			{
				return new BufferedReader(new InputStreamReader(System.in)).readLine();
			} 
			catch (IOException e)
			{
				System.out.println("Erreur de saisie, veuillez recommencer :");;
			}
		}
	}

	static char saisieChar(String message)
	{
		return saisieString(message).charAt(0);
	}
	
	static int saisieInt(String message)
	{
		return Integer.parseInt(saisieString(message));
	}
}
