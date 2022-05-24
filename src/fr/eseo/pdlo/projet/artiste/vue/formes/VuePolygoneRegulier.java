package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.PolygoneRegulier;

public class VuePolygoneRegulier extends VueForme
{
	public VuePolygoneRegulier(PolygoneRegulier ellipse)
	{
		super(ellipse);
	}
	
	public void affiche(Graphics2D g2D)
	{
		Color temp = g2D.getColor();
		g2D.setColor(super.getForme().getCouleur());
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
		g2D.setRenderingHints(rh);
		if(super.getForme().getRemplissage().equals(Remplissage.UNIFORME)||
				super.getForme().getRemplissage().equals(Remplissage.DIFFERENT))
		{
			g2D.fillPolygon(((PolygoneRegulier)super.getForme()).getXPoints(), 
							((PolygoneRegulier)super.getForme()).getYPoints(), 
							((PolygoneRegulier)super.getForme()).getNombreCote());
			if(super.getForme().getRemplissage().equals(Remplissage.DIFFERENT))
				g2D.setColor(((PolygoneRegulier)super.getForme()).getCouleurContour());
		}
		g2D.drawPolygon(((PolygoneRegulier)super.getForme()).getXPoints(), 
				((PolygoneRegulier)super.getForme()).getYPoints(), 
				((PolygoneRegulier)super.getForme()).getNombreCote());

		g2D.setColor(temp);
	}
}
