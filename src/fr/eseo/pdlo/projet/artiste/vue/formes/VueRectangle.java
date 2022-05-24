package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;

public class VueRectangle extends VueForme
{
	public VueRectangle(Rectangle ellipse)
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
			g2D.fillRect( (int) Math.round(super.getForme().getAbscisse())
					, (int) Math.round(super.getForme().getOrdonnee())
					, (int) Math.round(super.getForme().getLargeur())
					, (int) Math.round(super.getForme().getHauteur()));
			if(super.getForme().getRemplissage().equals(Remplissage.DIFFERENT))
				g2D.setColor(((Rectangle)super.getForme()).getCouleurContour());
		}
		g2D.drawRect( (int) Math.round(super.getForme().getAbscisse())
				, (int) Math.round(super.getForme().getOrdonnee())
				, (int) Math.round(super.getForme().getLargeur())
				, (int) Math.round(super.getForme().getHauteur()));

		g2D.setColor(temp);
	}
}
