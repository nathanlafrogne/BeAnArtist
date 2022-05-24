package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CercleTest {


	@Test
	void testConstructeurs()
	{
		Cercle c = new Cercle(1.0,2.0,3.0);
		assertEquals(3.0 , c.getHauteur() , "Cote");
		assertEquals(3.0 , c.getLargeur() , "Cote");
		assertEquals(1.0 , c.getPosition().getAbscisse() , "Position(X)");
		assertEquals(2.0 , c.getPosition().getOrdonnee() , "Position(Y)");
		
		Coordonnees pos = new Coordonnees(1.0,1.0);
		Cercle complet = new Cercle(pos , 2.0);
		assertEquals(2.0 , complet.getHauteur() , "Cote");
		assertEquals(2.0 , complet.getLargeur() , "Cote");
		assertEquals(1.0 , complet.getPosition().getAbscisse() , "Position(X)");
		assertEquals(1.0 , complet.getPosition().getOrdonnee() , "Position(Y)");
		
		Cercle onlyLarg = new Cercle(2.0);
		assertEquals(2.0 , onlyLarg.getHauteur() , "Cote OK");
		assertEquals(2.0 , onlyLarg.getLargeur() , "Cote OK");
		assertEquals(0.0 , onlyLarg.getPosition().getAbscisse() , "Position(X) OK");
		assertEquals(0.0 , onlyLarg.getPosition().getOrdonnee() , "Position(Y) OK");
		
		Cercle setNeg = new Cercle(1.0);
		assertThrows(IllegalArgumentException.class , ()->new Cercle(-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->new Cercle(pos , -1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->new Cercle(1.0 , 1.0 , -1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->setNeg.setHauteur(-2.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->setNeg.setLargeur(-2.0) , "Accepte les negatifs");
		
		Cercle onlyPos = new Cercle(pos);
		assertEquals(10.0 , onlyPos.getHauteur() , "Cote OK");
		assertEquals(10.0 , onlyPos.getLargeur() , "Cote OK");
		assertEquals(1.0 , onlyPos.getPosition().getAbscisse() , "Position(X) OK");
		assertEquals(1.0 , onlyPos.getPosition().getOrdonnee() , "Position(Y) OK");
		
		Cercle rien = new Cercle();
		assertEquals(10.0 , rien.getHauteur() , "Cote OK");
		assertEquals(10.0 , rien.getLargeur() , "Cote OK");
		assertEquals(0.0 , rien.getPosition().getAbscisse() , "Position(X) OK");
		assertEquals(0.0 , rien.getPosition().getOrdonnee() , "Position(Y) OK");
	}
	
	@Test
	void testAirePerimetre()
	{
		Cercle cercle = new Cercle();
		assertEquals(Math.PI * 25 , cercle.aire() , "Calcul aire OK");
		assertEquals(2 * Math.PI * 5 , cercle.perimetre() , "Calcul perimetre OK");
	}
	
	@Test
	void testToString()
	{
		Cercle cercle = new Cercle();
		String chaine = "[Cercle aucune] : pos (0,0 , 0,0) rayon 5,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51";
		assertEquals(chaine , cercle.toString() , "toString");
		
		Locale.setDefault(Locale.ENGLISH);
		chaine = "[Cercle aucune] : pos (0.0 , 0.0) rayon 5.0 périmètre : 31.42 aire : 78.54 couleur = R51,G51,B51";
		assertEquals(chaine , cercle.toString() , "toString");
		Locale.setDefault(Locale.FRENCH);
	}
	
	@Test
	void testSet()
	{
		Cercle cercle = new Cercle();
		assertEquals(10.0 , cercle.getHauteur() , "Mauvaise hauteur base");
		assertEquals(10.0 , cercle.getLargeur() , "Mauvaise largeur base");
		
		cercle.setHauteur(5.0);
		assertEquals(5.0 , cercle.getHauteur() , "Mauvaise hauteur modifiée");
		assertEquals(5.0 , cercle.getLargeur() , "Mauvaise largeur modifiée");
		
		cercle.setLargeur(3.0);
		assertEquals(3.0 , cercle.getHauteur() , "Mauvaise hauteur modifiée");
		assertEquals(3.0 , cercle.getLargeur() , "Mauvaise largeur modifiée");
		
		cercle.setPosition(new Coordonnees(1.0,2.0));
		assertEquals(1.0 , cercle.getPosition().getAbscisse() , "Mauvaise abscisse modifiée");
		assertEquals(2.0 , cercle.getPosition().getOrdonnee() , "Mauvaise abscisse modifiée");
		
		cercle.setAbscisse(15.0);
		assertEquals(15.0 , cercle.getAbscisse() , "Mauvaise abscisse modifiée");
		assertEquals(2.0 , cercle.getOrdonnee() , "Mauvaise abscisse modifiée");
		
		cercle.setOrdonnee(16.0);
		assertEquals(15.0 , cercle.getPosition().getAbscisse() , "Mauvaise abscisse modifiée");
		assertEquals(16.0 , cercle.getPosition().getOrdonnee() , "Mauvaise abscisse modifiée");
	}

	
	@Test
	void testDeplacerDeVers()
	{
		Cercle cercle = new Cercle();
		cercle.deplacerVers(2.0, 3.0);
		assertEquals(2.0 , cercle.getAbscisse() , "Pas deplacé au bon endroit");
		assertEquals(3.0 , cercle.getOrdonnee() , "Pas deplacé au bon endroit");
		
		cercle.deplacerDe(1.0, 2.0);
		assertEquals(3.0 , cercle.getAbscisse() , "Pas deplacé au bon endroit");
		assertEquals(5.0 , cercle.getOrdonnee() , "Pas deplacé au bon endroit");
	}

}
