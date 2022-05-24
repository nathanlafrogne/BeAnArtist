package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Ellipse extends Forme implements Remplissable
{   
	private Remplissage modeRemplissage;
	private Color couleurContour;
	
	public Ellipse(double x , double y , double largeur , double hauteur)
	{
		super(x,y,largeur,hauteur);
		if(hauteur < 0 || largeur < 0)
    		throw new IllegalArgumentException("Hauteur ou Largeur négative !");
    	else
    	{
        	this.setRemplissage(Remplissage.AUCUNE);
    	}
	}
	
	public Ellipse(Coordonnees pos , double largeur , double hauteur)
    {
    	super(pos,largeur,hauteur);
    	if(hauteur < 0 || largeur < 0)
    		throw new IllegalArgumentException("Hauteur ou Largeur négative !");
    	else
    	{
        	this.setRemplissage(Remplissage.AUCUNE);
    	}
    }
    
    public Ellipse(double largeur , double hauteur)
    {
    	super(hauteur,largeur);
    	if(hauteur < 0 || largeur < 0)
    		throw new IllegalArgumentException("Hauteur ou Largeur négative !");
    	else
    	{
        	this.setRemplissage(Remplissage.AUCUNE);
    	}
    }
    
    public Ellipse(Coordonnees position)
    {
    	super(position);
    	this.setRemplissage(Remplissage.AUCUNE);
    }

    public Ellipse()
    {
      super();
      this.setRemplissage(Remplissage.AUCUNE);
    }
	
    public void setLargeur(double largeur)
    {
    	if(largeur < 0)
    		throw new IllegalArgumentException("Largeur négative !");
    	else
    		super.setLargeur(largeur);
    }

    public void setHauteur(double hauteur)
    {
    	if(hauteur < 0)
    		throw new IllegalArgumentException("Hauteur négative !");
    	else
    		super.setHauteur(hauteur);
    }
    
	public double aire()
	{
		return Math.PI * super.getLargeur()/2 * super.getHauteur()/2;
	}
	
	public double perimetre()
	{
		double a = this.getHauteur()/2;
		double b = this.getLargeur()/2;
		double h = Math.pow((a-b)/(a+b), 2);
		double plus = (3*h) / (10 + Math.sqrt(4-3*h));
		return Math.PI * (a+b) * (1+plus);
	}

	public String toString()
	{
		DecimalFormat dec = new DecimalFormat("0.0#");
		String chaine = "[Ellipse " + this.getRemplissage().getMode() + "]";// + this.getRemplissage().getMode() + "]";
		chaine += " : pos (";
    	chaine += dec.format(super.getPosition().getAbscisse()) + " , ";
    	chaine += dec.format(super.getPosition().getOrdonnee()) + ") petit rayon ";
    	
    	if(super.getHauteur() < super.getLargeur())
    	{
    		chaine += dec.format(super.getHauteur()/2) + " grand rayon ";
    		chaine += dec.format(super.getLargeur()/2) + " périmètre : ";
    	}
    	else
    	{
    		chaine += dec.format(super.getLargeur()/2) + " grand rayon ";
    		chaine += dec.format(super.getHauteur()/2) + " périmètre : ";
    	}
    	chaine += dec.format(this.perimetre()) + " aire : ";
    	chaine += dec.format(this.aire());
    	chaine += " couleur = R" + super.getCouleur().getRed();
		if(Locale.getDefault().getLanguage().equals("fr"))
			chaine += ",V" + super.getCouleur().getGreen();
		else
			chaine += ",G" + super.getCouleur().getGreen();
		chaine += ",B" + super.getCouleur().getBlue();
    	return chaine;
	}
	
	public boolean contient(Coordonnees pos)
	{
		double a = this.getLargeur()/2;	
		double b = this.getHauteur()/2;
		Coordonnees centre = new Coordonnees(this.getPosition().getAbscisse() + this.getLargeur()/2 
				, this.getPosition().getOrdonnee() + this.getHauteur()/2);
		double x = pos.getAbscisse() - centre.getAbscisse();
		double y = pos.getOrdonnee() - centre.getOrdonnee();
		double mesure = Math.pow(x/a, 2) + Math.pow(y/b, 2);
		return (mesure) <= 1;
			
	}
	
	public Remplissage getRemplissage()
	{
		return this.modeRemplissage;
	}
	
	public void setRemplissage(Remplissage remplissage)
	{
		this.modeRemplissage = remplissage;
	}
	
	public void setAbscisse(double x)
	{
		super.setAbscisse(x);
	}
	
	public void setCouleurContour(Color couleur)
	{
		this.couleurContour = couleur;
	}
	
	public Color getCouleurContour()
	{
		return this.couleurContour;
	}
}
