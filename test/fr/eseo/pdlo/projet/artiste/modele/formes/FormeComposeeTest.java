package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

class FormeComposeeTest 
{

	@Test
	void testConstructeurNombreForme() 
	{
		FormeComposee formeCompo = new FormeComposee();
		Rectangle rectangle = new Rectangle(new Coordonnees(100.0,200.0), 10.0 , 20.0);
		Ellipse ellipse = new Ellipse(new Coordonnees(300.0,400.0));
		Cercle cercle = new Cercle();
		assertEquals(0,formeCompo.getFormes().size() , "Ajoute une forme dans le constructeur");
		formeCompo.ajouterForme(rectangle);
		assertEquals(100.0 , formeCompo.getAbscisse() , "Mauvaise abscisse Position");
		assertEquals(200.0 , formeCompo.getOrdonnee() , "Mauvaise ordonnee Position");
		assertEquals(1,formeCompo.getFormes().size() , "Pas le bon nombre de forme apres l'ajout");
		formeCompo.ajouterForme(ellipse);
		assertEquals(100.0 , formeCompo.getAbscisse() , "Abscisse pos modifi�e a tort");
		assertEquals(200.0 , formeCompo.getOrdonnee() , "Ordonnee pos modifi�e a tort");
		assertEquals(2,formeCompo.getFormes().size() , "Pas le bon nombre de forme apres l'ajout");
		formeCompo.ajouterForme(cercle);
		assertEquals(0.0 , formeCompo.getAbscisse() , "Abscisse pos mal modifi�e");
		assertEquals(0.0 , formeCompo.getOrdonnee() , "Ordonnee pos mal modifi�e");
		assertEquals(3,formeCompo.getFormes().size() , "Pas le bon nombre de forme apres l'ajout");
	}
	
	@Test
	void testSetGetDeplacerDeVers()
	{
		FormeComposee formeCompo = new FormeComposee();
		Rectangle rectangle = new Rectangle(new Coordonnees(100.0,200.0), 10.0 , 20.0);
		Ellipse ellipse = new Ellipse(new Coordonnees(300.0,400.0));
		Cercle cercle = new Cercle();
		formeCompo.ajouterForme(rectangle);
		formeCompo.ajouterForme(ellipse);
		formeCompo.ajouterForme(cercle);
		formeCompo.setPosition(new Coordonnees(10.0,20.0));
		assertEquals(10.0 , formeCompo.getAbscisse() , "Position A non modifi�e");
		assertEquals(20.0 , formeCompo.getOrdonnee() , "Position O non modifi�e");
		assertEquals(110.0 , rectangle.getAbscisse() , "Forme interne non modifi�e");
		assertEquals(220.0 , rectangle.getOrdonnee() , "Forme interne non modifi�e");
		assertEquals(310.0 , ellipse.getAbscisse() , "Forme interne non modifi�e");
		assertEquals(420.0 , ellipse.getOrdonnee() , "Forme interne non modifi�e");
		assertEquals(10.0 , cercle.getAbscisse() , "Forme interne non modifi�e");
		assertEquals(20.0 , cercle.getOrdonnee() , "Forme interne non modifi�e");
		formeCompo.setPosition(new Coordonnees(0.0,0.0));
		formeCompo.deplacerDe(10.0 , 20.0);
		assertEquals(10.0 , formeCompo.getAbscisse() , "Position A non modifi�e");
		assertEquals(20.0 , formeCompo.getOrdonnee() , "Position O non modifi�e");
		assertEquals(110.0 , rectangle.getAbscisse() , "Forme interne non modifi�e");
		assertEquals(220.0 , rectangle.getOrdonnee() , "Forme interne non modifi�e");
		assertEquals(310.0 , ellipse.getAbscisse() , "Forme interne non modifi�e");
		assertEquals(420.0 , ellipse.getOrdonnee() , "Forme interne non modifi�e");
		assertEquals(10.0 , cercle.getAbscisse() , "Forme interne non modifi�e");
		assertEquals(20.0 , cercle.getOrdonnee() , "Forme interne non modifi�e");
		
		formeCompo.deplacerDe(10.0, 10.0);
		formeCompo.deplacerVers(10.0, 20.0);
		assertEquals(10.0 , formeCompo.getAbscisse() , "Position A non modifi�e");
		assertEquals(20.0 , formeCompo.getOrdonnee() , "Position O non modifi�e");
		assertEquals(110.0 , rectangle.getAbscisse() , "Forme interne non modifi�e");
		assertEquals(220.0 , rectangle.getOrdonnee() , "Forme interne non modifi�e");
		assertEquals(310.0 , ellipse.getAbscisse() , "Forme interne non modifi�e");
		assertEquals(420.0 , ellipse.getOrdonnee() , "Forme interne non modifi�e");
		assertEquals(10.0 , cercle.getAbscisse() , "Forme interne non modifi�e");
		assertEquals(20.0 , cercle.getOrdonnee() , "Forme interne non modifi�e");
	}
	
//	@Test
//	void testDeplacerVersDe()
//	{
//		FormeComposee formeCompo = new FormeComposee();
//		Rectangle rectangle = new Rectangle(new Coordonnees(100.0,200.0), 10.0 , 20.0);
//		Ellipse ellipse = new Ellipse(new Coordonnees(300.0,400.0));
//		Cercle cercle = new Cercle();
//		formeCompo.ajouterForme(rectangle);
//		formeCompo.ajouterForme(ellipse);
//		formeCompo.ajouterForme(cercle);
//		
//		formeCompo.deplacerDe(10.0 , 20.0);
//		assertEquals(10.0 , formeCompo.getAbscisse() , "Position A non modifi�e");
//		assertEquals(20.0 , formeCompo.getOrdonnee() , "Position O non modifi�e");
//		assertEquals(110.0 , rectangle.getAbscisse() , "Forme interne non modifi�e");
//		assertEquals(220.0 , rectangle.getOrdonnee() , "Forme interne non modifi�e");
//		assertEquals(310.0 , ellipse.getAbscisse() , "Forme interne non modifi�e");
//		assertEquals(420.0 , ellipse.getOrdonnee() , "Forme interne non modifi�e");
//		assertEquals(10.0 , cercle.getAbscisse() , "Forme interne non modifi�e");
//		assertEquals(20.0 , cercle.getOrdonnee() , "Forme interne non modifi�e");
//		
//		formeCompo.deplacerDe(10.0, 10.0);
//		formeCompo.deplacerVers(10.0, 20.0);
//		assertEquals(10.0 , formeCompo.getAbscisse() , "Position A non modifi�e");
//		assertEquals(20.0 , formeCompo.getOrdonnee() , "Position O non modifi�e");
//		assertEquals(110.0 , rectangle.getAbscisse() , "Forme interne non modifi�e");
//		assertEquals(220.0 , rectangle.getOrdonnee() , "Forme interne non modifi�e");
//		assertEquals(310.0 , ellipse.getAbscisse() , "Forme interne non modifi�e");
//		assertEquals(420.0 , ellipse.getOrdonnee() , "Forme interne non modifi�e");
//		assertEquals(10.0 , cercle.getAbscisse() , "Forme interne non modifi�e");
//		assertEquals(20.0 , cercle.getOrdonnee() , "Forme interne non modifi�e");
//	}
	
	

}
