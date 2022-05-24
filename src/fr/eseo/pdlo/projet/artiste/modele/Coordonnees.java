package fr.eseo.pdlo.projet.artiste.modele;

import java.text.DecimalFormat;

public class Coordonnees 
{
	public double x;
    public double y;
    public static final double ABSCISSE_PAR_DEFAUT = 0.0;
    public static final double ORDONNEE_PAR_DEFAUT = 0.0;

    public Coordonnees(double x , double y)
    {
        this.x = x;
        this.y = y;
    }

    public Coordonnees()
    {
        this.x = ABSCISSE_PAR_DEFAUT;
        this.y = ORDONNEE_PAR_DEFAUT;
    }

    public void deplacerVers(double abscisse , double ordonnee)
    {
        this.setAbscisse(abscisse);
        this.setOrdonnee(ordonnee);
    }

    public void deplacerDe(double deltaX , double deltaY)
    {
        this.x += deltaX;
        this.y += deltaY;
    }

    public double distanceVers(Coordonnees coord)
    {
        return Math.sqrt((coord.x - this.x)*(coord.x - this.x) + (coord.y - this.y)*(coord.y - this.y));
    }

    public double angleVers(Coordonnees coord)
    {
    	double temp = Math.atan2(coord.getOrdonnee() - this.getOrdonnee() 
    			, coord.getAbscisse() - this.getAbscisse());
        return temp;
    }
    
    public double getAbscisse()
    {
    	return this.x;
    }
    
    public double getOrdonnee()
    {
    	return this.y;
    }
    
    public void setAbscisse(double abscisse)
    {
    	this.x = abscisse;
    }
    
    public void setOrdonnee(double ord)
    {
    	this.y = ord;
    }
    
    public String toString()
    {
    	DecimalFormat dec = new DecimalFormat("0.0#");
    	return "(" + dec.format(this.getAbscisse()) + " , " + dec.format(this.getOrdonnee()) + ")";
    }

}