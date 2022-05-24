package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.PolygoneRegulier;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VuePolygoneRegulier;

public class OutilPolygoneRegulier extends OutilForme
{
	public static final String NOM = "Polygone régulier";
	
	protected VueForme creerVueForme()
	{
		Coordonnees debut = super.getDebut();
        Coordonnees fin = super.getFin();
//        double largeur = fin.getAbscisse() - debut.getAbscisse();
//        double hauteur = fin.getOrdonnee() - debut.getOrdonnee();
//        double xPos;
//        double yPos;
        PolygoneRegulier ellipse;
        
        ellipse = new PolygoneRegulier(	debut,fin,6);
		ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
		ellipse.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		ellipse.setCouleurContour(this.getPanneauDessin().getCouleurContourCourante());
		VuePolygoneRegulier vueEllipse = new VuePolygoneRegulier(ellipse);
		if(!super.estPremier())
        	this.getPanneauDessin().removeLast();
		super.getPanneauDessin().ajouterVueForme(vueEllipse);
		return vueEllipse;
	}
	
	public void mouseClicked(MouseEvent event) 
	{
		if(event.getClickCount() == 2) 
		{
			this.creerVueForme();
			super.getPanneauDessin().repaint();
		}
	}
	
	public String getNom()
	{
		return this.NOM;
	}
}
