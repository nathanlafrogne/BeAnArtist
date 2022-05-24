package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;



public class LigneTest {

	@Test
	public void testConstructeur()
	{
		Ligne ligneVide = new Ligne();
		assertEquals(ligneVide.getHauteur() , 10.0 , "Hauteur OK");
		assertEquals(ligneVide.getLargeur() , 10.0 , "Largeur OK");
		assertEquals(ligneVide.getPosition().getAbscisse() , 0.0 , "Abscisse Position OK");
		assertEquals(ligneVide.getPosition().getOrdonnee() , 0.0 , "Ordonnee Position OK");

		Ligne lignePos = new Ligne(new Coordonnees(1.0 , 1.0));
		assertEquals(lignePos.getHauteur() , 10.0 , "Hauteur OK");
		assertEquals(lignePos.getLargeur() , 10.0 , "Largeur OK");
		assertEquals(lignePos.getPosition().getAbscisse() , 1.0 , "Abscisse Position OK");
		assertEquals(lignePos.getPosition().getOrdonnee() , 1.0 , "Ordonnee Position OK");
		
		Ligne lignePosNeg = new Ligne(new Coordonnees(-1.0,-1.0));
		assertEquals(lignePosNeg.getHauteur() , 10.0 , "Hauteur OK");
		assertEquals(lignePosNeg.getLargeur() , 10.0 , "Largeur OK");
		assertEquals(lignePosNeg.getPosition().getAbscisse() , -1.0 , "Abscisse Position OK");
		assertEquals(lignePosNeg.getPosition().getOrdonnee() , -1.0 , "Ordonnee Position OK");
		
		Ligne ligneNeg = new Ligne(-1.0,-1.0);
		assertEquals(ligneNeg.getHauteur() , -1.0 , "Hauteur OK");
		assertEquals(ligneNeg.getLargeur() , -1.0 , "Largeur OK");
		assertEquals(ligneNeg.getPosition().getAbscisse() , 0.0 , "Abscisse Position OK");
		assertEquals(ligneNeg.getPosition().getOrdonnee() , 0.0 , "Ordonnee Position OK");

		Ligne ligneComplet = new Ligne(new Coordonnees(1.0 , 1.0) , 2.0 , 2.0);
		assertEquals(ligneComplet.getHauteur() , 2.0 , "Hauteur OK");
		assertEquals(ligneComplet.getLargeur() , 2.0 , "Largeur OK");
		assertEquals(ligneComplet.getPosition().getAbscisse() , 1.0 , "Abscisse Position OK");
		assertEquals(ligneComplet.getPosition().getOrdonnee() , 1.0 , "Ordonnee Position OK");
		
		Ligne tout = new Ligne(1.0 , 2.0 , 3.0 , 4.0);
		assertEquals(tout.getHauteur() , 4.0 , "Hauteur OK");
		assertEquals(tout.getLargeur() , 3.0 , "Largeur OK");
		assertEquals(tout.getPosition().getAbscisse() , 1.0 , "Abscisse Position OK");
		assertEquals(tout.getPosition().getOrdonnee() , 2.0 , "Ordonnee Position OK");
		
		Ligne l = new Ligne(1.0 , 2.0);
		assertEquals(l.getHauteur() , 2.0 , "Hauteur OK");
		assertEquals(l.getLargeur() , 1.0 , "Largeur OK");
		assertEquals(l.getPosition().getAbscisse() , 0.0 , "Abscisse Position OK");
		assertEquals(l.getPosition().getOrdonnee() , 0.0 , "Ordonnee Position OK");
	}
	
	@Test
	public void testAccesseurs()
	{
		Ligne ligneComplet = new Ligne(new Coordonnees(1.0 , 1.0) , 2.0 , 2.0);
		assertEquals(ligneComplet.getHauteur() , 2.0 , "Hauteur OK");
		assertEquals(ligneComplet.getLargeur() , 2.0 , "Largeur OK");
		assertEquals(ligneComplet.getPosition().getAbscisse() , 1.0 , "Abscisse Position OK");
		assertEquals(ligneComplet.getPosition().getOrdonnee() , 1.0 , "Ordonnee Position OK");
	}
	
	@Test
	public void testSet()
	{
		Ligne ligne = new Ligne(new Coordonnees(1.0 , 1.0) , 2.0 , 2.0);
		
		ligne.setHauteur(1.0);
		assertEquals(ligne.getHauteur() , 1.0 , "Modif Hauteur OK");
		
		ligne.setHauteur(-1.0);
		assertEquals(ligne.getHauteur() , -1.0 , "Modif Hauteur OK");
		
		ligne.setLargeur(1.0);
		assertEquals(ligne.getLargeur() , 1.0 , "Modif Hauteur OK");
		
		ligne.setLargeur(-1.0);
		assertEquals(ligne.getLargeur() , -1.0 , "Modif Hauteur OK");
		
		ligne.setPosition(new Coordonnees(0.0,0.0));
		assertEquals(ligne.getPosition().getAbscisse() , 0.0 , "Abscisse Position non modifiée");
		assertEquals(ligne.getPosition().getOrdonnee() , 0.0 , "Ordonnee Position non modifiée");
	}
	
	@Test
	public void testC1C2()
	{
		Ligne ligne = new Ligne(new Coordonnees(1.0 , 1.0) , 2.0 , 2.0);
		assertEquals(ligne.getC1().getAbscisse() , 1.0, "C1 OK");
		assertEquals(ligne.getC1().getOrdonnee() , 1.0, "C1 OK");
		assertEquals(ligne.getC2().getAbscisse() , 3.0 , "C2 OK");
		assertEquals(ligne.getC2().getOrdonnee() , 3.0 , "C2 OK");

		ligne.setC1(new Coordonnees(0.0 , 0.0));
		assertEquals(ligne.getC1().getAbscisse() , 0.0, "C1 OK");
		assertEquals(ligne.getC1().getOrdonnee() , 0.0, "C1 OK");
		assertEquals(ligne.getC2().getAbscisse(), 3.0 , "C2 Pas modifié");
		assertEquals(ligne.getC2().getOrdonnee(), 3.0 , "C2 Pas modifié");
		assertEquals(ligne.getHauteur() , 3.0 , "Hauteur modifiée");
		assertEquals(ligne.getLargeur() , 3.0 , "Hauteur modifiée");

		ligne.setC2(new Coordonnees(2.0 , 2.0));
		assertEquals(ligne.getC1().getAbscisse() , 0.0 , "C1 Pas modifie");
		assertEquals(ligne.getC1().getOrdonnee() , 0.0 , "C1 Pas modifie");
		assertEquals(ligne.getC2().getAbscisse(), 2.0 , "C2 OK");
		assertEquals(ligne.getC2().getOrdonnee(), 2.0 , "C2 OK");
		assertEquals(ligne.getHauteur() , 2.0 , "Hauteur modifiée");
		assertEquals(ligne.getLargeur() , 2.0 , "Hauteur modifiée");
	}
	
	@Test
	public void testCadre()
	{
		Ligne ligne = new Ligne(new Coordonnees(1.0 , 1.0) , 2.0 , 2.0);
		assertEquals(ligne.getCadreMaxX(), 3.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMaxY(), 3.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinX(), 1.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinY(), 1.0 , "Abscisse Cadre OK");
		
		ligne.deplacerVers(0.0, 0.0);  // C1 au centre ; C2 en haut a droite
		assertEquals(ligne.getCadreMaxX(), 2.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMaxY(), 2.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinX(), 0.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinY(), 0.0 , "Abscisse Cadre OK");
		
		ligne.setC2(new Coordonnees(-1.0 , -1.0)); // C2 en bas a gauche)
		assertEquals(ligne.getCadreMaxX(), 0.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMaxY(), 0.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinX(), -1.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinY(), -1.0 , "Abscisse Cadre OK");
		
		ligne.setC2(new Coordonnees(-1.0 , 1.0));  // C2 en haut a gauche
		assertEquals(ligne.getCadreMaxX(), 0.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMaxY(), 1.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinX(), -1.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinY(), 0.0 , "Abscisse Cadre OK");
		
		ligne.setC2(new Coordonnees(1.0 , -1.0));  // C2 en bas a droite
		assertEquals(ligne.getCadreMaxX(), 1.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMaxY(), 0.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinX(), 0.0 , "Abscisse Cadre OK");
		assertEquals(ligne.getCadreMinY(), -1.0 , "Abscisse Cadre OK");
	}

	@Test
	public void testAirePerimetre()
	{
		Ligne ligne = new Ligne(new Coordonnees(0.0 , 0.0) , 1.0 , 1.0);
		assertEquals(0.0 , ligne.aire() , "Aire Ligne OK");
		assertEquals(Math.sqrt(2.0) , ligne.perimetre() , "Perimetre OK");		
	}
	
	@Test
	public void testContient()
	{
		Ligne ligne = new Ligne(new Coordonnees(0.0 , 0.0) , 0.0 , 1.0);
		Coordonnees c1 = new Coordonnees(0.0,2.0); // Non
		Coordonnees c2 = new Coordonnees(0.0,0.5); // Oui
		Coordonnees c3 = new Coordonnees(0.1,0.5); // Oui~~
		Coordonnees c4 = new Coordonnees(0.2 , 0.5); //Oui~~
		Coordonnees c6 = new Coordonnees(0.0 , -1.0); //Non
		
		assertTrue(ligne.contient(c2) , "doit pas etre dedans");
		assertTrue(ligne.contient(c3) , "doit pas etre dedans");
		assertTrue(ligne.contient(c4) , "doit pas etre dedans");
		
		assertFalse(ligne.contient(c1) , "doit pas etre dedans");
//		assertFalse(ligne.contient(c5) , "doit pas etre dedans");
		assertFalse(ligne.contient(c6) , "doit pas etre dedans");
	}
	
	@Test
	void testToString()
	{
		String chaine = "[Ligne] c1 : (0,0 , 0,0) c2 : (0,0 , 1,0) longueur : 1,0 angle : 90,0° couleur = R51,V51,B51";
		Ligne ligne = new Ligne(new Coordonnees(0.0 , 0.0) , 0.0 , 1.0);
		assertEquals(chaine , ligne.toString() , "Mauvais String");
		
		chaine = "[Ligne] c1 : (0,0 , 0,0) c2 : (1,0 , 0,0) longueur : 1,0 angle : 0,0° couleur = R51,V51,B51";
		ligne = new Ligne(new Coordonnees(0.0 , 0.0) , 1.0 , 0.0);
		assertEquals(chaine , ligne.toString() , "Mauvais String");
		
		chaine = "[Ligne] c1 : (0,0 , 0,0) c2 : (1,0 , 1,0) longueur : 1,41 angle : 45,0° couleur = R51,V51,B51";
		ligne = new Ligne(new Coordonnees(0.0 , 0.0) , 1.0 , 1.0);
		assertEquals(chaine , ligne.toString() , "Mauvais String");
		
		chaine = "[Ligne] c1 : (0,0 , 0,0) c2 : (-1,0 , -1,0) longueur : 1,41 angle : 225,0° couleur = R51,V51,B51";
		ligne = new Ligne(new Coordonnees(0.0 , 0.0) , -1.0 , -1.0);
		assertEquals(chaine , ligne.toString() , "Mauvais String");
		
		chaine = "[Ligne] c1 : (0,0 , 0,0) c2 : (-1,0 , 0,0) longueur : 1,0 angle : 180,0° couleur = R51,V51,B51";
		ligne = new Ligne(new Coordonnees(0.0 , 0.0) , -1.0 , 0.0);
		assertEquals(chaine , ligne.toString() , "Mauvais String");
		
		chaine = "[Ligne] c1 : (0,0 , 0,0) c2 : (0,0 , -1,0) longueur : 1,0 angle : 270,0° couleur = R51,V51,B51";
		ligne = new Ligne(new Coordonnees(0.0 , 0.0) , 0.0 , -1.0);
		assertEquals(chaine , ligne.toString() , "Mauvais String");
	}
	
	@Test
	void testLocal()
	{
		String chaineFR = "[Ligne] c1 : (0,0 , 0,0) c2 : (0,0 , 1,0) longueur : 1,0 angle : 90,0° couleur = R51,V51,B51";
		Ligne ligne = new Ligne(new Coordonnees(0.0 , 0.0) , 0.0 , 1.0);
		assertEquals(chaineFR,ligne.toString(),"Ne renvoie pas la couleur en FR");
		
		Locale.setDefault(Locale.ENGLISH);
		String chaineUK = "[Ligne] c1 : (0.0 , 0.0) c2 : (0.0 , 1.0) longueur : 1.0 angle : 90.0° couleur = R51,G51,B51";
		assertEquals(chaineUK,ligne.toString(),"Ne renvoie pas la couleur en UK");
		Locale.setDefault(Locale.FRENCH);
	}
	
	@Test
	void testRemplissage()
	{
		Ligne ligne = new Ligne();
		assertEquals(Remplissage.AUCUNE , ligne.getRemplissage(),"Ne renvoie pas un remplissage aucun");
	}
	
	@Test
	void deplacerDeVersSetAbscisseOrdonnee()
	{
		Ligne ligne = new Ligne();
		ligne.deplacerDe(1.0, 2.0);
		assertEquals(1.0,ligne.getAbscisse(),"Mauvais deplacement DE abscisse");
		assertEquals(2.0,ligne.getOrdonnee(),"Mauvais deplacement DE ordonnee");
		ligne.deplacerVers(0, 0);
		assertEquals(0.0,ligne.getAbscisse(),"Mauvais deplacement DE abscisse");
		assertEquals(0.0,ligne.getOrdonnee(),"Mauvais deplacement DE ordonnee");
		ligne.setAbscisse(1.0);
		ligne.setOrdonnee(2.0);
		assertEquals(1.0,ligne.getAbscisse(),"Mauvais deplacement DE abscisse");
		assertEquals(2.0,ligne.getOrdonnee(),"Mauvais deplacement DE ordonnee");
	}
	
	@Test
	void testCouleur()
	{
		Ligne ellipse = new Ligne();
		assertEquals(new Color(51,51,51),ellipse.getCouleur(),"Mauvaise couleur par defaut");
		ellipse.setCouleur(Color.BLUE);
		assertEquals(Color.BLUE,ellipse.getCouleur(),"Mauvaise couleur modifiée");
	}

}
