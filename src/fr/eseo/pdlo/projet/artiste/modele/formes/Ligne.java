package fr.eseo.pdlo.projet.artiste.modele.formes;
import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Ligne extends Forme
{	
	public static final double EPSILON = 0.99;
	
	public Ligne()
	{
		super();
	}
	
	public Ligne(Coordonnees position)
	{
		super(position);
	}
	
	public Ligne(Coordonnees position , double largeur , double hauteur)
	{
		super(position, largeur, hauteur);
	}
	
	public Ligne(double x , double y , double largeur , double hauteur)
	{
		super(x,y,largeur,hauteur);
	}
	
	public Ligne(double largeur , double hauteur)
	{
		super(hauteur,largeur);
	}
	
	public double getLargeur()
	{
		return super.getLargeur();
	}
	
	public void setLargeur(double newLargeur)
	{
		super.setLargeur(newLargeur);
	}
	
	public double getHauteur()
	{
		return super.getHauteur();
	}
	
	public void setHauteur(double newHauteur)
	{
		super.setHauteur(newHauteur);
	}
	
	public Coordonnees getPosition()
	{
		return super.getPosition();
	}
	
	public Coordonnees getC1()
	{
		return super.getPosition();
	}
	
	public Coordonnees getC2()
	{
		return new Coordonnees(super.getPosition().getAbscisse() + super.getLargeur() 
				, super.getPosition().getOrdonnee() + super.getHauteur());
	}

	public void setC1(Coordonnees newPosition)
	{
		Coordonnees coord = new Coordonnees(super.getPosition().getAbscisse() + super.getLargeur() 
							, super.getPosition().getOrdonnee() + super.getHauteur());
		super.setPosition(newPosition);
		super.setHauteur(coord.getOrdonnee() - super.getPosition().getOrdonnee());
		super.setLargeur(coord.getAbscisse() - super.getPosition().getAbscisse());
	}
	
	public void setC2(Coordonnees newPosition)
	{
		super.setHauteur(newPosition.getOrdonnee() - super.getPosition().getOrdonnee());
		super.setLargeur(newPosition.getAbscisse() - super.getPosition().getAbscisse());
	}

	public double aire()
	{
		return 0.0;
	}
	
	public double perimetre()
	{
		return super.getPosition().distanceVers(getC2());
	}

	public String toString()
	{
		DecimalFormat dec = new DecimalFormat("0.0#");
		String chaine = "[Ligne] c1 : (";
		chaine += dec.format(Math.rint(this.getC1().getAbscisse() * 100) / 100) + " , ";
		chaine += dec.format(Math.rint(this.getC1().getOrdonnee() * 100) / 100) + ") c2 : (";
		chaine += dec.format(Math.rint(this.getC2().getAbscisse() * 100) / 100) + " , ";
		chaine += dec.format(Math.rint(this.getC2().getOrdonnee() * 100) / 100) + ") longueur : ";
		chaine += dec.format(Math.rint(this.getC1().distanceVers(this.getC2()) * 100) / 100) + " angle : ";
		double angle = this.getC1().angleVers(getC2());
		angle = angle * 180 / Math.PI;
		if(angle < 0)
			angle = angle + 360;
		chaine += dec.format((Math.rint(angle * 100) / 100)) + "° ";
		chaine += "couleur = R" + super.getCouleur().getRed();
		if(Locale.getDefault().getLanguage().equals("fr"))
			chaine += ",V" + super.getCouleur().getGreen();
		else
			chaine += ",G" + super.getCouleur().getGreen();
		
		chaine += ",B" + super.getCouleur().getBlue();
		return chaine;
	}
	
	public boolean contient(Coordonnees pos)
	{
//		double mesure = Math.abs(this.getC1().distanceVers(pos) - this.getC1().angleVers(this.getC2()));*
		double mesure =   Math.abs(this.getC1().distanceVers(pos)) 
						+ Math.abs(this.getC2().distanceVers(pos)) 
						- Math.abs(this.getC1().distanceVers(this.getC2()));
		return (Math.abs(mesure)) <= EPSILON;
			
	}
	
	public Remplissage getRemplissage()
	{
		return Remplissage.AUCUNE;
	}
	
}