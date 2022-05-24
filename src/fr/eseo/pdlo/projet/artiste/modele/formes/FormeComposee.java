package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.util.ArrayList;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class FormeComposee extends Forme
{
	ArrayList<Forme> formes;
	
	public FormeComposee()
	{
		this.formes = new ArrayList<Forme>();
	}
	
	public ArrayList<Forme> getFormes()
	{
		return this.formes;
	}
	
	public void ajouterForme(Forme forme)
	{
		this.formes.add(forme);
		double maxX = this.getFormes().get(0).getAbscisse();
		double minX = this.getFormes().get(0).getAbscisse();
		double maxY = this.getFormes().get(0).getOrdonnee();
		double minY = this.getFormes().get(0).getOrdonnee();
		for (int k = 0 ; k < this.getFormes().size() ; k++)
		{
			if(this.getFormes().get(k).getAbscisse() > maxX)
				maxX = this.getFormes().get(k).getAbscisse();
			else if(this.getFormes().get(k).getAbscisse() < minX)
				minX = this.getFormes().get(k).getAbscisse();
			if(this.getFormes().get(k).getOrdonnee() > maxY)
				maxY = this.getFormes().get(k).getOrdonnee();
			else if(this.getFormes().get(k).getOrdonnee() < minY)
				minY = this.getFormes().get(k).getOrdonnee();
		}
		super.setPosition(new Coordonnees(minX,minY));
		super.setHauteur(maxY - minY);
		super.setLargeur(maxX - minX);
	}
	
	public void setPosition(Coordonnees pos)
	{
		double deltaX = pos.getAbscisse() - super.getPosition().getAbscisse();
		double deltaY = pos.getOrdonnee() - super.getPosition().getOrdonnee();
		for(int k = 0 ; k < this.formes.size() ; k++)
			this.getFormes().get(k).deplacerDe(deltaX , deltaY);
		super.setPosition(pos);
	}

	public void setAbscisse(double x)
	{
		this.setPosition(new Coordonnees(x , this.getPosition().getOrdonnee()));
	}
	
	public void setOrdonnee(double y)
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
		String chaine = "";
		if(!this.getFormes().isEmpty())
			for (int k = 0 ; k < this.getFormes().size() ; k++)
				chaine += this.getFormes().get(k).toString() + "\n";
		return chaine;
	}
	
	public double aire()
	{
		double compt = 0.0;
		if(this.getFormes().isEmpty())
			return 0.0;
		else
			for(int k = 0 ; k < this.formes.size() ; k++)
				compt += this.formes.get(k).aire();
			return compt;
	}
	
	public double perimetre()
	{
		return 0.0;
	}
	
	public void setHauteur(double hauteur)
	{
		double ratio = hauteur / this.getHauteur();
		for (int k = 0 ; k < this.getFormes().size() ; k++)
			this.getFormes().get(k).setOrdonnee(((this.getFormes().get(k).getOrdonnee() - this.getPosition().getOrdonnee()) * ratio) 
					+ this.getFormes().get(k).getOrdonnee());
	}
	
	public void setLargeur(double largeur)
	{
		double ratio = largeur / this.getLargeur();
		for (int k = 0 ; k < this.getFormes().size() ; k++)
			this.getFormes().get(k).setAbscisse(((this.getFormes().get(k).getAbscisse() 
					- this.getPosition().getAbscisse()) * ratio) + this.getFormes().get(k).getAbscisse());
	}
	
	public Remplissage getRemplissage()
	{
		return Remplissage.AUCUNE;
	}
	
	public boolean contient(Coordonnees pos)
	{
		boolean ret = false;
		for ( int k = 0 ; k < this.formes.size() ; k++)
			if(this.formes.get(k).contient(pos))
				ret = true;
		return ret;
	}
	
	
}
