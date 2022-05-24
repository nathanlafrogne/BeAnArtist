package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.PolygoneIrregulier;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VuePolygoneIrregulier;

public class OutilPolygoneIrregulier extends OutilForme
{
	ArrayList<Coordonnees> sommets;
	public static final String NOM = "Polygone irrégulier";
	
	protected VueForme creerVueForme()
	{
		PolygoneIrregulier ellipse = new PolygoneIrregulier(this.sommets);
		ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
		ellipse.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		ellipse.setCouleurContour(this.getPanneauDessin().getCouleurContourCourante());
		VuePolygoneIrregulier vueEllipse = new VuePolygoneIrregulier(ellipse);
		if(!super.estPremier())
        	this.getPanneauDessin().removeLast();
		super.getPanneauDessin().ajouterVueForme(vueEllipse);
		return vueEllipse;
	}
	
	public void mouseClicked(MouseEvent event) 
	{
		if(this.sommets == null)
			this.sommets = new  ArrayList<Coordonnees>();
		this.sommets.add(new Coordonnees(event.getX() , event.getY()));
		if(this.sommets.size() >= 2)
		{
			if(this.sommets.size() > 2)
				this.getPanneauDessin().getVueFormes().remove(this.getPanneauDessin().getVueFormes().size() - 1);
			this.creerVueForme();
			this.getPanneauDessin().repaint();
		}
	}
	
	public String getNom()
	{
		return this.NOM;
	}
}
