package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

class RectangleTest {
	
	/* Les noms ne correspondent pas avec le type etant donné que la structure est la meme que EllipseTest donc seuls 
	 * les type ont été modifié mais pas les noms des variable
	*/
	
	@Test
	void testConstructeurs()
	{
		Coordonnees position = new Coordonnees(1.0,1.0);
		
		Rectangle onlyPosition = new Rectangle(position);
		assertEquals(10.0 , onlyPosition.getLargeur() , "getLargeur OK");
		assertEquals(10.0 , onlyPosition.getHauteur() , "getHauteur OK");
		assertEquals(position , onlyPosition.getPosition() , "getPosition OK");
		
		Rectangle tout = new Rectangle(position , 2.0 , 1.0);
		assertEquals(2.0 , tout.getLargeur() , "getLargeur OK");
		assertEquals(1.0 , tout.getHauteur() , "getHauteur OK");
		assertEquals(position , tout.getPosition() , "getPosition OK");
		
		Rectangle el = new Rectangle(1.0,2.0);
		assertEquals(1.0 , el.getLargeur() , "getLargeur");
		assertEquals(2.0 , el.getHauteur() , "getHauteur");
		assertEquals(0.0 , el.getPosition().getAbscisse() , "getPosition");
		assertEquals(0.0 , el.getPosition().getOrdonnee() , "getPosition");

		
		Rectangle rien = new Rectangle();
		assertEquals(10.0 , rien.getLargeur() , "getLargeur OK");
		assertEquals(10.0 , rien.getHauteur() , "getHauteur OK");
		assertEquals(0.0 , rien.getPosition().getAbscisse() , "getPosition (X) OK");
		assertEquals(0.0 , rien.getPosition().getOrdonnee() , "getPosition (Y) OK");
		
		assertThrows(IllegalArgumentException.class , ()->new Rectangle(-1.0,1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->new Rectangle(1.0,-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->new Rectangle(-1.0,-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->new Rectangle(position,-1.0,-1.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->new Rectangle(position,1.0,-1.0) , "Accepte les negatifs");
	}
	
	@Test
	void testAirePerimetre()
	{
		Rectangle el = new Rectangle();
		assertEquals(40.0 , el.perimetre() , "Perimetre OK");
		assertEquals(100.0 , el.aire() , "Aire OK");
		
		el = new Rectangle(1.0,2.0);
		assertEquals(6.0 , el.perimetre() , 0.01 , "Perimetre OK");
		assertEquals(2.0 , el.aire(), 0.01 , "Aire OK");
	}
	
	@Test
	void testSetLargeurHauteurPosition()
	{
		Rectangle ellipse = new Rectangle(1.0,2.0);
		assertEquals(2.0 , ellipse.getHauteur() , "Mauvaise hauteur de base");
		assertEquals(1.0 , ellipse.getLargeur() , "Mauvaise largeur de base");
		
		ellipse.setHauteur(3.0);
		assertEquals(3.0 , ellipse.getHauteur() , "Mauvaise hauteur modifiée");
		assertEquals(1.0 , ellipse.getLargeur() , "Mauvaise largeur modifiée");
		
		ellipse.setLargeur(4.0);
		assertEquals(3.0 , ellipse.getHauteur() , "Mauvaise hauteur modifiée");
		assertEquals(4.0 , ellipse.getLargeur() , "Mauvaise largeur modifiée");
		
		assertThrows(IllegalArgumentException.class , ()->ellipse.setHauteur(-2.0) , "Accepte les negatifs");
		assertThrows(IllegalArgumentException.class , ()->ellipse.setLargeur(-2.0) , "Accepte les negatifs");
		
		ellipse.setPosition(new Coordonnees(3.0,4.0));
		assertEquals(3.0 , ellipse.getPosition().getAbscisse() , "Abscisse non modifiée");
		assertEquals(4.0 , ellipse.getPosition().getOrdonnee() , "Ordonnee non modifiée");
	}
	
	@Test
	void testToString()
	{
		String chaine = "[Rectangle uniforme] : pos (0,0 , 0,0) "
				+ "hauteur 10,0 largeur 10,0 périmètre : 40,0 "
				+ "aire : 100,0 couleur = R51,V51,B51";
		Rectangle el = new Rectangle();
		el.setRemplissage(Remplissage.UNIFORME);
		assertEquals(chaine , el.toString() , "toString");
	}
	
	@Test
	void testContient()
	{		
		Rectangle el = new Rectangle(10.0 , 20.0);
		assertTrue(el.contient(new Coordonnees(5.0,5.0)) , "Ne contient pas le Centre");
		assertTrue(el.contient(new Coordonnees(5.0,1.0)) , "Ne contient pas le Haut-Milieu");
		assertFalse(el.contient(new Coordonnees(-1.0,5.0)) , "Ne contient pas le Bas-Milieu");
		assertFalse(el.contient(new Coordonnees(1.0,-1.0)) , "Ne contient pas le Bas-Milieu");
		assertTrue(el.contient(new Coordonnees(1.0,5.0)) , "Ne contient pas le Milieu-Gauche");
		assertFalse(el.contient(new Coordonnees(200.0,5.0)) , "Ne contient pas le Milieu-Droite");
	}
}
