package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.PolygoneIrregulier;
import fr.eseo.pdlo.projet.artiste.modele.formes.PolygoneRegulier;

public class VuePolygoneIrregulier extends VueForme
{
	public VuePolygoneIrregulier(PolygoneIrregulier ellipse)
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
			g2D.fillPolygon(((PolygoneIrregulier)super.getForme()).getXPoints(), 
							((PolygoneIrregulier)super.getForme()).getYPoints(), 
							((PolygoneIrregulier)super.getForme()).getNombreCote());
			if(super.getForme().getRemplissage().equals(Remplissage.DIFFERENT))
				g2D.setColor(((PolygoneIrregulier)super.getForme()).getCouleurContour());
		}
		g2D.drawPolygon(((PolygoneIrregulier)super.getForme()).getXPoints(), 
				((PolygoneIrregulier)super.getForme()).getYPoints(), 
				((PolygoneIrregulier)super.getForme()).getNombreCote());

		g2D.setColor(temp);
	}
}
