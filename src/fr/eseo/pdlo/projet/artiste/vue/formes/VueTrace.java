package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import fr.eseo.pdlo.projet.artiste.modele.formes.Trace;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueTrace extends VueForme 
{
	private Trace trace;
	public VueTrace(Trace trace) 
	{
		super(trace);
		this.trace = trace;
	}

	public void affiche(Graphics2D g2d) 
	{
		Color temp = g2d.getColor();
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);
		int[] xPoints = new int[this.trace.getPoints().size()];
		int[] yPoints = new int[this.trace.getPoints().size()];
		for(int k = 0 ; k < this.trace.getPoints().size() ; k++)
		{
			xPoints[k] = (int) this.trace.getPoints().get(k).getAbscisse();
			yPoints[k] = (int) this.trace.getPoints().get(k).getOrdonnee();
		}
		g2d.setColor(super.getForme().getCouleur());
		g2d.drawPolyline(xPoints, yPoints, xPoints.length);
		g2d.setColor(temp);
	}

}
