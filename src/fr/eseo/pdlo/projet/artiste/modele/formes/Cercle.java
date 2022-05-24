package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse
{	
	 public Cercle(double x , double y , double largeur)
	    {
	    	super(x , y , largeur,largeur);
	    	if(largeur < 0)
	    		throw new IllegalArgumentException("Hauteur négative !");
	    }
	
    public Cercle(double largeur)
    {
    	super(largeur,largeur);
    	if(largeur < 0)
    		throw new IllegalArgumentException("Hauteur négative !");
    }
    
    public Cercle(Coordonnees pos , double taille)
    {
    	super(pos,taille,taille);
    	if(taille < 0)
    		throw new IllegalArgumentException("Hauteur négative !");
    }
    
    public Cercle(Coordonnees position)
    {
    	super(position);
    }

    public Cercle()
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
    	return Math.PI * Math.pow(super.getHauteur()/2, 2);
    }

    public double perimetre()
    {
    	return 2 * Math.PI * super.getLargeur()/2;
    }
    
    public String toString()
    {
    	DecimalFormat dec = new DecimalFormat("0.0#");
    	String chaine = "[Cercle " + this.getRemplissage().getMode() + "]";// + this.getRemplissage().getMode() + "]";
		chaine += " : pos (";
    	chaine += dec.format(super.getPosition().getAbscisse()) + " , ";
    	chaine += dec.format(super.getPosition().getOrdonnee()) + ") rayon ";
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
    
    public void setCouleurContour(Color couleur)
    {
    	super.setCouleurContour(couleur);
    }
    
    public Color getCouleurContour()
    {
    	return super.getCouleurContour();
    }
}
