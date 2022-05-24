package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class PolygoneRegulier extends Forme implements Remplissable
{   
	private Remplissage modeRemplissage;
	private int nbPoints;
	private double[] xPoints;
	private double[] yPoints;
	
	public PolygoneRegulier(Coordonnees debut , Coordonnees fin , int nbPoints)
	{
		super();
		this.nbPoints = nbPoints;
		this.setRemplissage(Remplissage.AUCUNE);
		this.xPoints= new double[nbPoints];
		this.yPoints = new double[nbPoints];
		this.creerPoints(debut, fin, nbPoints);
		super.setLargeur(this.trouveLargeur());
		super.setHauteur(this.trouveHauteur());
		super.setPosition(this.trouvePosition());
	}
	
	private void creerPoints(Coordonnees debut , Coordonnees fin , int np)
	{
		Coordonnees centre = new Coordonnees(fin.getAbscisse() - debut.getAbscisse() ,
												fin.getOrdonnee() - debut.getOrdonnee());
		double ecartAngulaire = Math.PI*2/np;
		double angleBase = centre.angleVers(debut);
		double rayon = centre.distanceVers(debut);
		double x;
		double y;
		for (int k = 0 ; k < np ; k++)
		{
			x = rayon * Math.cos(angleBase + (ecartAngulaire*k));
			y = rayon * Math.sin(angleBase + (ecartAngulaire*k));
			this.xPoints[k] = x;
			this.yPoints[k] = y;
		}
	}
	
	private double trouveHauteur()
	{
		double min = this.yPoints[0];
		double max = this.yPoints[0];
		for(int k = 0 ; k < this.yPoints.length ; k++)
		{
			if(this.yPoints[k] < min)
				min = this.yPoints[k];
			if(this.yPoints[k] > max)
				max = this.yPoints[k];
		}
		return max - min;
	}
	
	private double trouveLargeur()
	{
		double min = this.xPoints[0];
		double max = this.xPoints[0];
		for(int k = 0 ; k < this.xPoints.length ; k++)
		{
			if(this.xPoints[k] < min)
				min = this.xPoints[k];
			if(this.xPoints[k] > max)
				max = this.xPoints[k];
		}
		return max - min;
	}
	
	private Coordonnees trouvePosition()
	{
		double xMin = this.xPoints[0];
		double yMin = this.yPoints[0];
		for (int k = 0 ; k < this.nbPoints ; k++)
		{
			if(this.xPoints[k] < xMin)
				xMin = this.xPoints[k];
			if(this.yPoints[k] < yMin)
				yMin = this.yPoints[k];
		}
		return new Coordonnees(xMin,yMin);
	}
	
	public int[] getXPoints()
	{
		int[] ret = new int[this.nbPoints];
		for(int k = 0 ; k < this.nbPoints ; k++)
			ret[k] = (int) Math.round(this.xPoints[k]);
		return ret;
	}
	
	public int[] getYPoints()
	{
		int[] ret = new int[this.nbPoints];
		for(int k = 0 ; k < this.nbPoints ; k++)
			ret[k] = (int) Math.round(this.yPoints[k]);
		return ret;
	}
	
	public int getNombreCote()
	{
		return this.nbPoints;
	}
	
    public void setLargeur(double largeur)
    {
    	if(largeur < 0)
    		throw new IllegalArgumentException("Largeur négative !");
    	else
    		super.setLargeur(largeur);
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
