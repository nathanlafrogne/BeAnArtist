package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme 
{
	
	private boolean antiAlias = false;
	
	public VueLigne(Ligne ligne) 
	{
		super(ligne);
	}

	public void affiche(Graphics2D g2d) 
	{
		Color temp = g2d.getColor();
		g2d.setColor(super.getForme().getCouleur());
		if(this.antiAlias)
		{
			RenderingHints rh = new RenderingHints(
		             RenderingHints.KEY_ANTIALIASING,
		             RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setRenderingHints(rh);
		}
		g2d.drawLine( (int) Math.round(super.getForme().getAbscisse())
					, (int) Math.round(super.getForme().getOrdonnee())
					, (int) Math.round(super.getForme().getAbscisse() + super.getForme().getLargeur())
					, (int) Math.round(super.getForme().getOrdonnee() + super.getForme().getHauteur()));
		g2d.setColor(temp);
	}
	
	public void setAlias(boolean b)
	{
		this.antiAlias = b;
	}

}
