package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class PolygoneIrregulier extends Forme implements Remplissable
{   
	private Remplissage modeRemplissage;
	private int nbPoints;
	private int[] xPoints;
	private int[] yPoints;
	
	public PolygoneIrregulier(ArrayList<Coordonnees> points)
	{
		super();
		this.xPoints = new int[points.size()];
		this.yPoints = new int[points.size()];
		this.nbPoints = points.size();
		for(int k = 0 ; k < points.size() ; k++)
		{
			xPoints[k] = (int) Math.round(points.get(k).getAbscisse());
			yPoints[k] = (int) Math.round(points.get(k).getOrdonnee());
		}
		super.setHauteur(this.trouveHauteur());
		super.setLargeur(this.trouveLargeur());
		super.setPosition(this.trouvePosition());
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
	
	public void deplacerVers(double nouvX , double nouvY)
	{
		double deltaX;
		double deltaY;
		for(int k = 0 ; k < this.nbPoints ; k++)
		{
			deltaX = this.xPoints[k] - super.getPosition().getAbscisse();
			deltaY = this.yPoints[k] - super.getPosition().getOrdonnee();
			this.xPoints[k] +=  nouvX + deltaX;
			this.yPoints[k] +=  nouvY + deltaY;
		}
		super.setPosition(new Coordonnees(nouvX , nouvY));
	}
	
	public int[] getXPoints()
	{
		return this.xPoints;
	}
	
	public int[] getYPoints()
	{
		return this.yPoints;
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
