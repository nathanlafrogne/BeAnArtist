package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme
{
	
	private boolean antiAlias = false;
	
	public VueEllipse(Ellipse ellipse)
	{
		super(ellipse);
	}
	
	public void affiche(Graphics2D g2D)
	{
		Color temp = g2D.getColor();
		g2D.setColor(super.getForme().getCouleur());
		if(this.antiAlias)
		{
			RenderingHints rh = new RenderingHints(
		             RenderingHints.KEY_ANTIALIASING,
		             RenderingHints.VALUE_ANTIALIAS_ON);
			g2D.setRenderingHints(rh);
		}
		if(super.getForme().getRemplissage().equals(Remplissage.UNIFORME))
		{
			g2D.fillOval( (int) Math.round(super.getForme().getAbscisse())
					, (int) Math.round(super.getForme().getOrdonnee())
					, (int) Math.round(super.getForme().getLargeur())
					, (int) Math.round(super.getForme().getHauteur()));
			g2D.drawOval( (int) Math.round(super.getForme().getAbscisse())
					, (int) Math.round(super.getForme().getOrdonnee())
					, (int) Math.round(super.getForme().getLargeur())
					, (int) Math.round(super.getForme().getHauteur()));
		}
		else if(super.getForme().getRemplissage().equals(Remplissage.AUCUNE))
			g2D.drawOval( (int) Math.round(super.getForme().getAbscisse())
					, (int) Math.round(super.getForme().getOrdonnee())
					, (int) Math.round(super.getForme().getLargeur())
					, (int) Math.round(super.getForme().getHauteur()));
		else if(super.getForme().getRemplissage().equals(Remplissage.DIFFERENT))
		{
			g2D.fillOval( (int) Math.round(super.getForme().getAbscisse())
					, (int) Math.round(super.getForme().getOrdonnee())
					, (int) Math.round(super.getForme().getLargeur())
					, (int) Math.round(super.getForme().getHauteur()));
			if(super.getForme().getRemplissage().equals(Remplissage.DIFFERENT))
				g2D.setColor(((Ellipse)super.getForme()).getCouleurContour());
			g2D.drawOval( (int) Math.round(super.getForme().getAbscisse())
					, (int) Math.round(super.getForme().getOrdonnee())
					, (int) Math.round(super.getForme().getLargeur())
					, (int) Math.round(super.getForme().getHauteur()));
		}
		else if(super.getForme().getRemplissage().equals(Remplissage.DEGRADE))
		{
			GradientPaint gradient = new GradientPaint((float)super.getForme().getAbscisse(),
						(float)super.getForme().getOrdonnee(),
						super.getForme().getCouleur(),
						(float)super.getForme().getAbscisse() 
						+ (float)super.getForme().getLargeur(),
						(float)super.getForme().getOrdonnee() 
						+ (float)super.getForme().getHauteur(),
						super.getForme().getCouleurDegrade());
			Paint tempPaint = g2D.getPaint();
			g2D.setPaint(gradient);
			g2D.fillOval( (int) Math.round(super.getForme().getAbscisse())
					, (int) Math.round(super.getForme().getOrdonnee())
					, (int) Math.round(super.getForme().getLargeur())
					, (int) Math.round(super.getForme().getHauteur()));
			g2D.setPaint(tempPaint);
		}
			
		g2D.setColor(temp);
	}
	
	public void setAlias(boolean e)
	{
		this.antiAlias = e;
	}
	
}
