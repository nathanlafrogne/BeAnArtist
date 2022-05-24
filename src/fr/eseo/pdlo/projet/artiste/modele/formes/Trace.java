package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.util.ArrayList;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Trace extends Forme
{
	ArrayList<Coordonnees> points;
	
	
	public Trace(Coordonnees pos1 , Coordonnees pos2)
	{
		super();
		this.points = new ArrayList<Coordonnees>();
		this.ajouterPoint(pos1);
		this.ajouterPoint(pos2);
	}
	
	public void ajouterPoint(Coordonnees pos)
	{
		this.points.add(pos);
		double maxX = this.points.get(0).getAbscisse();
		double minX = this.points.get(0).getAbscisse();
		double maxY = this.points.get(0).getOrdonnee();
		double minY = this.points.get(0).getOrdonnee();
		for (int k = 0 ; k < this.points.size() ; k++)
		{
			if(this.points.get(k).getAbscisse() > maxX)
				maxX = this.points.get(k).getAbscisse();
			else if(this.points.get(k).getAbscisse() < minX)
				minX = this.points.get(k).getAbscisse();
			if(this.points.get(k).getOrdonnee() > maxY)
				maxY = this.points.get(k).getOrdonnee();
			else if(this.points.get(k).getOrdonnee() < minY)
				minY = this.points.get(k).getOrdonnee();
		}
		super.setPosition(new Coordonnees(minX,maxY));
		super.setHauteur(maxY - minY);
		super.setLargeur(maxX - minX);
	}
	
	public ArrayList<Coordonnees> getPoints()
	{
		return this.points;
	}
	
	public void setPosition(Coordonnees pos)
	{
		double deltaX = pos.getAbscisse() - super.getPosition().getAbscisse();
		double deltaY = pos.getOrdonnee() - super.getPosition().getOrdonnee();
		if(!this.points.isEmpty())
			for (int k = 0 ; k < this.points.size() ; k++)
				this.points.get(k).deplacerDe(deltaX, deltaY);
		super.setPosition(pos);
	}
	
	public void setX(double x)
	{
		this.setPosition(new Coordonnees(x , this.getPosition().getOrdonnee()));
	}
	
	public void setY(double y)
	{
		this.setPosition(new Coordonnees(this.getPosition().getAbscisse() , y));
	}
	
	public void deplacerVers(double nouvX , double nouvY)
	{
		this.setPosition(new Coordonnees(nouvX , nouvY));
	}
	
	public void deplacerDe(double deltaX , double deltaY)
	{
		this.setPosition(new Coordonnees(this.getPosition().getAbscisse() + deltaX , this.getPosition().getOrdonnee() + deltaY));
	}
	
	public String toString()
	{
		return "[Trace] pos : (" + super.getPosition().getAbscisse() + "," + super.getPosition().getOrdonnee() + ") dim : " 
				+ this.getHauteur() + "x" + this.getLargeur() 
				+ " longueur : " + this.perimetre() + " nbligne : " + (this.points.size());
	}
	
	public double aire()
	{
		return 0.0;
	}
	
	public double perimetre()
	{
		double compt = 0;
		if(!this.points.isEmpty() && this.points.size() >= 2)
			for (int k = 0 ; k < this.points.size() - 1 ; k++)
				compt += this.points.get(k).distanceVers(this.points.get(k+1));
		return Math.abs(compt*100)/100;
	}
	
	public void setHauteur(double hauteur)
	{
		double ratio = hauteur / this.getHauteur();
		for (int k = 0 ; k < this.points.size() ; k++)
			this.points.get(k).setOrdonnee(((this.points.get(k).getOrdonnee() - this.getPosition().getOrdonnee()) * ratio) 
					+ this.points.get(k).getOrdonnee());
	}
	
	public void setLargeur(double largeur)
	{
		double ratio = largeur / this.getLargeur();
		for (int k = 0 ; k < this.points.size() ; k++)
			this.points.get(k).setAbscisse(((this.points.get(k).getAbscisse() - this.getPosition().getAbscisse()) * ratio) 
					+ this.points.get(k).getAbscisse());
	}
	
	public Remplissage getRemplissage()
	{
		return Remplissage.AUCUNE;
	}
	
	public boolean contient(Coordonnees pos)
	{
		Ligne ligne;
		for (int k = 0 ; k < this.points.size() - 1 ; k++)
		{
			ligne = new Ligne();
			ligne.setC1(this.points.get(k));
			ligne.setC2(this.points.get(k+1));
			if(ligne.contient(pos))
				return true;
		}
		return false;
	}
	
	public void reset()
	{
		this.points = new ArrayList<Coordonnees>();
	}
	
}
