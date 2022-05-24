package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Rectangle extends Forme implements Remplissable
{   
	private Remplissage modeRemplissage;
	
	public Rectangle(double x , double y , double largeur , double hauteur)
    {
    	super(new Coordonnees(x,y),largeur,hauteur);
    	if(hauteur < 0 || largeur < 0)
    		throw new IllegalArgumentException("Hauteur ou Largeur négative !");
    	else
        	this.setRemplissage(Remplissage.AUCUNE);
    }
	
	public Rectangle(Coordonnees pos , double largeur , double hauteur)
    {
    	super(pos,largeur,hauteur);
    	if(hauteur < 0 || largeur < 0)
    		throw new IllegalArgumentException("Hauteur ou Largeur négative !");
    	else
        	this.setRemplissage(Remplissage.AUCUNE);
    }
    
    public Rectangle(double largeur , double hauteur)
    {
    	super(largeur,hauteur);
    	if(hauteur < 0 || largeur < 0)
    		throw new IllegalArgumentException("Hauteur ou Largeur négative !");
    	else
        	this.setRemplissage(Remplissage.AUCUNE);
    }
    
    public Rectangle(Coordonnees position)
    {
    	super(position);
    	this.setRemplissage(Remplissage.AUCUNE);
    }

    public Rectangle()
    {
        super();
      this.setRemplissage(Remplissage.AUCUNE);
//		this.modeRemplissage = Remplissage.AUCUNE;
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
		return super.getLargeur()*super.getHauteur();
	}
	
	public double perimetre()
	{
		return 2*super.getHauteur() + 2*super.getLargeur();
	}

	public String toString()
	{
		DecimalFormat dec = new DecimalFormat("0.0#");
		String chaine = "[Rectangle " + this.getRemplissage().getMode() + "]";// + this.getRemplissage().getMode() + "]";
		chaine += " : pos (";
    	chaine += dec.format(super.getPosition().getAbscisse()) + " , ";
    	chaine += dec.format(super.getPosition().getOrdonnee());
    	chaine += ") hauteur " + dec.format(this.getHauteur());
    	chaine += " largeur " + dec.format(this.getLargeur());
    	chaine += " périmètre : " + dec.format(this.perimetre());
    	chaine += " aire : " + dec.format(this.aire());
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
		boolean hauteur;
		boolean largeur;
		if(pos.getAbscisse() - this.getAbscisse() > 0 && pos.getAbscisse() - this.getAbscisse() < this.getLargeur())
			largeur = true;
		else
			return false;
		
		if(pos.getOrdonnee() - this.getOrdonnee() > 0 && pos.getOrdonnee() - this.getOrdonnee() < this.getHauteur())
			hauteur = true;
		else
			return false;
		return (hauteur && largeur);
	}
	
	public Remplissage getRemplissage()
	{
		return this.modeRemplissage;
	}
	
	public void setRemplissage(Remplissage remplissage)
	{
		this.modeRemplissage = remplissage;
	}
	

}
