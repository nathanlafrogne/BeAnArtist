package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class EllipseTest {

	@Test
	void testConstructeurs()
	{
		Coordonnees position = new Coordonnees(1.0,1.0);
		
		Ellipse onlyPosition = new Ellipse(position);
		assertEquals(10.0 , onlyPosition.getLargeur() , "getLargeur OK");
		assertEquals(10.0 , onlyPosition.getHauteur() , "getHauteur OK");
		assertEquals(position , onlyPosition.getPosition() , "getPosition OK");
		
		Ellipse tout = new Ellipse(position , 2.0 , 1.0);
		assertEquals(2.0 , tout.getLargeur() , "getLargeur OK");
		assertEquals(1.0 , tout.getHauteur() , "getHauteur OK");
		assertEquals(position , tout.getPosition() , "getPosition OK");
		
		Ellipse el = new Ellipse(2.0,1.0);
		assertEquals(2.0 , el.getLargeur() , "getLargeur");
		assertEquals(1.0 , el.getHauteur() , "getHauteur");
		assertEquals(0.0 , el.getPosition().getAbscisse() , "getPosition");
		assertEquals(0.0 , el.getPosition().getOrdonnee() , "getPosition");

		
		Ellipse rien = new Ellipse();
		assertEquals(10.0 , rien.getLargeur() , "getLargeur OK");
		assertEquals(10.0 , rien.getHauteur() , "getHauteur OK");
		assertEquals(0.0 , rien.getPosition().getAbscisse() , "getPosition (X) OK");
		assertEquals(0.0 , rien.getPosition().getOrdonnee() , "getPosition (Y) OK");
		
		Ellipse complet = new Ellipse(1.0,2.0,3.0,4.0);
		assertEquals(3.0 , complet.getLargeur() , "getLargeur OK");
		assertEquals(4.0 , complet.getHauteur() , "getHauteur OK");
		assertEquals(1.0 , complet.getPosition().getAbscisse() , "getPosition (X) OK");
		assertEquals(2.0 , complet.getPosition().getOrdonnee() , "getPosition (Y) OK");
		
		assertThrows(IllegalArgumentException.class , 
				()->new Ellipse(-1.0,1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , 
				()->new Ellipse(1.0,-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , 
				()->new Ellipse(-1.0,-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , 
				()->new Ellipse(position,-1.0,-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , 
				()->new Ellipse(position,1.0,-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , 
				()->new Ellipse(position,-1.0,1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , 
				()->new Ellipse(0.0,0.0,-1.0,-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , 
				()->new Ellipse(0.0,0.0,1.0,-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , 
				()->new Ellipse(0.0,0.0,-1.0,1.0) , "Accepte les negatifs");

	}
	
	@Test
	void testAirePerimetre()
	{
		Ellipse el = new Ellipse();
		assertEquals(el.perimetre() , Math.PI*10 , "Perimetre OK");
		assertEquals(el.aire() , Math.PI * 25, "Aire OK");
		
		el = new Ellipse(1.0,2.0);
		assertEquals(4.84 , el.perimetre() , 0.01 , "Perimetre OK");
		assertEquals(1.57 , el.aire(), 0.01 , "Aire OK");
	}

	@Test
	void testSetLargeurHauteurPosition()
	{
		Ellipse ellipse = new Ellipse(2.0,1.0);
		assertEquals(1.0 , ellipse.getHauteur() , "Mauvaise hauteur de base");
		assertEquals(2.0 , ellipse.getLargeur() , "Mauvaise largeur de base");
		
		ellipse.setHauteur(3.0);
		assertEquals(3.0 , ellipse.getHauteur() , "Mauvaise hauteur modifiée");
		assertEquals(2.0 , ellipse.getLargeur() , "Mauvaise largeur modifiée");
		
		ellipse.setLargeur(4.0);
		assertEquals(3.0 , ellipse.getHauteur() , "Mauvaise hauteur modifiée");
		assertEquals(4.0 , ellipse.getLargeur() , "Mauvaise largeur modifiée");
		
		assertThrows(IllegalArgumentException.class , ()->ellipse.setHauteur(-2.0) , 
				"Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->ellipse.setLargeur(-2.0) , 
				"Accepte les negatifs");
		
		ellipse.setPosition(new Coordonnees(3.0,4.0));
		assertEquals(3.0 , ellipse.getPosition().getAbscisse() , "Abscisse non modifiée");
		assertEquals(4.0 , ellipse.getPosition().getOrdonnee() , "Ordonnee non modifiée");
	}

	@Test
	void testToString()
	{
		String chaine = "[Ellipse uniforme] : pos (0,0 , 0,0) "
				+ "petit rayon 5,0 grand rayon 5,0 périmètre : 31,42 "
				+ "aire : 78,54 couleur = R51,V51,B51";
		Ellipse el = new Ellipse();
		el.setRemplissage(Remplissage.UNIFORME);
		assertEquals(chaine , el.toString() , "toString");
		
		el = new Ellipse(4.0,2.0);
		chaine = "[Ellipse aucune] : pos (0,0 , 0,0) "
				+ "petit rayon 1,0 grand rayon 2,0 périmètre : 9,69 "
				+ "aire : 6,28 couleur = R51,V51,B51";
		assertEquals(chaine , el.toString() , "toString");

	}
	
	@Test
	void testContient()
	{		
		Ellipse el = new Ellipse(20.0 , 10.0);
		assertTrue(el.contient(new Coordonnees(10.0,5.0)) , 
				"Ne contient pas le Centre");
		assertTrue(el.contient(new Coordonnees(10.0,0.0)) , 
				"Ne contient pas le Haut-Milieu");
		assertTrue(el.contient(new Coordonnees(10.0,5.0)) , 
				"Ne contient pas le Bas-Milieu");
		assertTrue(el.contient(new Coordonnees(0.0,5.0)) , 
				"Ne contient pas le Milieu-Gauche");
		assertTrue(el.contient(new Coordonnees(20.0,5.0)) , 
				"Ne contient pas le Milieu-Droite");
		assertFalse(el.contient(new Coordonnees(200.0,5.0)) , 
				"Ne contient pas le Milieu-Droite");
	}
	
	
	@Test
	void testDeplacerDeVers()
	{
		Ellipse el = new Ellipse(1.0,2.0,3.0,4.0);
		assertEquals(1.0 , el.getPosition().getAbscisse() , "getPosition (X) OK");
		assertEquals(2.0 , el.getPosition().getOrdonnee() , "getPosition (Y) OK");
		
		el.deplacerDe(1.0, 2.0);
		assertEquals(2.0 , el.getPosition().getAbscisse() , "getPosition (X) OK");
		assertEquals(4.0 , el.getPosition().getOrdonnee() , "getPosition (Y) OK");
		
		el.deplacerVers(5.0, 6.0);
		assertEquals(5.0 , el.getPosition().getAbscisse() , "getPosition (X) OK");
		assertEquals(6.0 , el.getPosition().getOrdonnee() , "getPosition (Y) OK");
	}
	
	@Test
	void testGetSetLocale()
	{
		Ellipse e = new Ellipse(2.0,4.0);
		e.setAbscisse(1.0);
		e.setOrdonnee(2.0);
		assertEquals(1.0,e.getAbscisse(),"Mauvais renvoi de getAbscisse de la pos");
		assertEquals(2.0,e.getOrdonnee(),"Mauvais renvoi de getOrdonnee de la pos");
		
		String chaine = "[Ellipse aucune] : pos (1,0 , 2,0) "
				+ "petit rayon 1,0 grand rayon 2,0 périmètre : 9,69 "
				+ "aire : 6,28 couleur = R51,V51,B51";
		assertEquals(chaine , e.toString() , "toString");
		
		Locale.setDefault(Locale.ENGLISH);
		chaine = "[Ellipse aucune] : pos (1.0 , 2.0) "
				+ "petit rayon 1.0 grand rayon 2.0 périmètre : 9.69 "
				+ "aire : 6.28 couleur = R51,G51,B51";
		assertEquals(chaine , e.toString() , "toString");
	}
	
	@Test
	void testCadre()
	{
		Ellipse ellipse = new Ellipse(5.0,10.0);
		assertEquals(0.0,ellipse.getCadreMinX(),"CadreMinX mauvaise valeur");
		assertEquals(0.0,ellipse.getCadreMinY(),"CadreMinY mauvaise valeur");
		assertEquals(5.0,ellipse.getCadreMaxX(),"CadreMaxX mauvaise valeur");
		assertEquals(10.0,ellipse.getCadreMaxY(),"CadreMaxY mauvaise valeur");
	}
	
	@Test
	void testCouleur()
	{
		Ellipse ellipse = new Ellipse();
		assertEquals(new Color(51,51,51),ellipse.getCouleur(),"Mauvaise couleur par defaut");
		ellipse.setCouleur(Color.BLUE);
		assertEquals(Color.BLUE,ellipse.getCouleur(),"Mauvaise couleur modifiée");
	}
}
