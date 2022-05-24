package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.Coloriable;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public abstract class Forme implements Coloriable
{
	public static final double LARGEUR_PAR_DEFAUT = 10.0;
	public static final double HAUTEUR_PAR_DEFAUT = 10.0;
	public static final Coordonnees POSITION_PAR_DEFAUT = new Coordonnees(0.0,0.0);
	public static final Color COULEUR_PAR_DEFAUT = new Color(51,51,51);
	
	private double hauteur;
	private double largeur;
	private Coordonnees position;
	private Color couleur;
	private Color couleurContour;
	private Color couleurDegrade;
	
	public Forme()
	{
		this.hauteur = HAUTEUR_PAR_DEFAUT;
		this.largeur = LARGEUR_PAR_DEFAUT;
		this.position = POSITION_PAR_DEFAUT;
		this.couleur = COULEUR_PAR_DEFAUT;
	}
	
	public Forme(Coordonnees position)
	{
		this.hauteur = HAUTEUR_PAR_DEFAUT;
		this.largeur = LARGEUR_PAR_DEFAUT;
		this.position = position;
		this.couleur = COULEUR_PAR_DEFAUT;
	}
	
	public Forme(Coordonnees position , double largeur , double hauteur)
	{
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.position = position;
		this.couleur = COULEUR_PAR_DEFAUT;
	}
	
	public Forme(double x , double y , double largeur , double hauteur)
	{
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.position = new Coordonnees(x,y);
		this.couleur = COULEUR_PAR_DEFAUT;
	}
	
	public Forme(double hauteur , double largeur)
	{
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.position = POSITION_PAR_DEFAUT;
		this.couleur = COULEUR_PAR_DEFAUT;
	}
	
	public void deplacerVers(double nouvX , double nouvY)
    {
        this.position.deplacerVers(nouvX, nouvY);
    }

	public void setPosition(Coordonnees pos)
	{
		this.position = pos;
	}
	
    public void deplacerDe(double deltaX , double deltaY)
    {
        this.position.deplacerDe(deltaX, deltaY);
    }

    public void setHauteur(double hauteur)
    {
        this.hauteur = hauteur;
    }

    public void setLargeur(double largeur)
    {
        this.largeur = largeur;
    }
    
    public double getHauteur()
    {
    	return this.hauteur;
    }
    
    public double getLargeur()
    {
    	return this.largeur;
    }
    
    public Coordonnees getPosition()
    {
    	return this.position;
    }
    
    public double getAbscisse()
    {
    	return this.position.getAbscisse();
    }
    
    public double getOrdonnee()
    {
    	return this.position.getOrdonnee();
    }

    public void setAbscisse(double x)
    {
    	this.position.setAbscisse(x);
    }
    
    public void setOrdonnee(double y)
    {
    	this.position.setOrdonnee(y);
    }
    
    public double getCadreMinX()
	{
		return Math.min(this.getAbscisse(), this.getAbscisse() + this.getLargeur());
	}
	
	public double getCadreMinY()
	{
		return Math.min(this.getOrdonnee(), this.getOrdonnee() + this.getHauteur());
	}
	
	public double getCadreMaxX()
	{
		return Math.max(this.getAbscisse(), this.getAbscisse() + this.getLargeur());
	}
	
	public double getCadreMaxY()
	{
		return Math.max(this.getOrdonnee(), this.getOrdonnee() + this.getHauteur());
	}
	
	public void setCouleur(Color couleur)
	{
		this.couleur = couleur;
	}
	
	public Color getCouleur()
	{
		return this.couleur;
	}
	
	public Color getCouleurContour()
	{
		return this.couleurContour;
	}
	public void setCouleurContour(Color color)
	{
		this.couleurContour = color;
	}
	
	public Color getCouleurDegrade()
	{
		return this.couleurDegrade;
	}
	
	public void setCouleurDegrade(Color color)
	{
		this.couleurDegrade = color;
	}

    public abstract double aire();
    
    public abstract double perimetre();
    
    public abstract String toString();
    
    public abstract boolean contient(Coordonnees pos);
    
    public abstract Remplissage getRemplissage();
}