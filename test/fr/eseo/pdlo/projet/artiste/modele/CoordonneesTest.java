package fr.eseo.pdlo.projet.artiste.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	public void testConstructeur()
	{
		Coordonnees coordVide = new Coordonnees();
		assertEquals(coordVide.getAbscisse() , 0.0 , "Abcisse OK");
		assertEquals(coordVide.getOrdonnee() , 0.0 , "Ordonnee OK");
		
		Coordonnees coord = new Coordonnees(1.0 , 1.0);
		assertEquals(coord.getOrdonnee() , 1.0 , "Ordonnee OK");
		assertEquals(coord.getAbscisse() , 1.0 ,"Abcisse OK");
		
		coord.deplacerDe(0.5 , 1.0);
		assertEquals(coord.getOrdonnee() , 2.0 , "Ordonnee Deplacée OK");
		assertEquals(coord.getAbscisse() , 1.5 ,"Abcisse Deplacée OK");
		
		coord.deplacerVers(0.0, 0.0);
		assertEquals(coordVide.getAbscisse() , 0.0 , "Abcisse OK");
		assertEquals(coordVide.getOrdonnee() , 0.0 , "Ordonnee OK");
		
		coord.setAbscisse(1.0);
		assertEquals(coord.getAbscisse() , 1.0 , "Abcisse OK");
		assertEquals(coord.getOrdonnee() , 0.0 , "Ordonnee OK");
		
		coord.setOrdonnee(2.0);
		assertEquals(coord.getAbscisse() , 1.0 , "Abcisse OK");
		assertEquals(coord.getOrdonnee() , 2.0 , "Ordonnee OK");
	}
	
	@Test
	public void testAnglesDistance()
	{
		Coordonnees c = new Coordonnees(0.0 , 0.0);
		Coordonnees coord = new Coordonnees(0.0 , 1.0);
		assertEquals(c.angleVers(coord) , Math.PI / 2 , "AngleVers OK");
		
		assertEquals(1.0 , c.distanceVers(coord) , " DistanceVers");
		assertEquals(1.0 , coord.distanceVers(c) , " DistanceVers");
		Coordonnees coo = new Coordonnees(1.0,0.0);
		assertEquals(1.0 , c.distanceVers(coo) , "DistanceVers");
		assertEquals(1.0 , coo.distanceVers(c) , "DistanceVers");
		
		assertEquals(0.0,c.distanceVers(c) , "DistanceVers lui meme");
		assertEquals(0.0,coord.distanceVers(coord) , "DistanceVers lui meme");
		assertEquals(0.0,coo.distanceVers(coo) , "DistanceVers lui meme");
	}
	
	@Test
	public void testToString()
	{
		Coordonnees coord = new Coordonnees();
		assertEquals("(0,0 , 0,0)" , coord.toString() , "toString OK");
		
		Coordonnees c = new Coordonnees(1.0,1.0);
		assertEquals("(1,0 , 1,0)" , c.toString() , "toString OK");
		
		Coordonnees precis = new Coordonnees(1.125 , 2.354);
		assertEquals("(1,12 , 2,35)" , precis.toString() , "toString OK");
	}

}
