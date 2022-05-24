package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Carre extends Rectangle
{	
	
    public Carre(double largeur)
    {
    	super();
    	if(largeur < 0)
    		throw new IllegalArgumentException("Hauteur négative !");
    	else
    	{
    		super.setHauteur(largeur);
    		super.setLargeur(largeur);
    	}
    }
    
    public Carre(Coordonnees pos , double taille)
    {
    	super();
    	if(taille < 0)
    		throw new IllegalArgumentException("Hauteur négative !");
    	else
    	{
    		super.setPosition(pos);
    		super.setHauteur(taille);
    		super.setLargeur(taille);
    	}
    }
    
    public Carre(Coordonnees position)
    {
    	super(position);
    }

    public Carre()
    {
    	super();
    }
    
    public void setLargeur(double largeur)
    {
    	if(largeur < 0)
    		throw new IllegalArgumentException("Hauteur négative !");
    	else
    		super.setLargeur(largeur);
    		super.setHauteur(largeur);
    }
    
    public void setHauteur(double hauteur)
    {
    	if(hauteur < 0)
    		throw new IllegalArgumentException("Hauteur négative !");
    	else
    		super.setHauteur(hauteur);
    		super.setLargeur(hauteur);
    }
    
    public double aire()
    {
    	return super.aire();
    }

    public double perimetre()
    {
    	return super.perimetre();
    }
    
    public String toString()
    {
    	DecimalFormat dec = new DecimalFormat("0.0#");
    	String chaine = "[Carré " + this.getRemplissage().getMode() + "]";// + this.getRemplissage().getMode() + "]";
		chaine += " : pos (";
    	chaine += dec.format(super.getPosition().getAbscisse()) + " , ";
    	chaine += dec.format(super.getPosition().getOrdonnee()) + ") côté ";
    	chaine += dec.format(super.getLargeur() / 2) + " périmètre : ";
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
}
