package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueRectangle;

public class OutilRectangle extends OutilForme
{
	public static final String NOM = "Rectangle";
	
	protected VueForme creerVueForme()
	{
		Coordonnees debut = super.getDebut();
        Coordonnees fin = super.getFin();
        double largeur = fin.getAbscisse() - debut.getAbscisse();
        double hauteur = fin.getOrdonnee() - debut.getOrdonnee();
        double xPos;
        double yPos;
        Rectangle ellipse;
        if(largeur < 0) {
            xPos = debut.getAbscisse()+largeur;
            largeur = -largeur;
        }
        else
            xPos = debut.getAbscisse();
        if(hauteur < 0) {
            yPos = debut.getOrdonnee()+hauteur;
            hauteur = -hauteur;
        }
        else
            yPos = debut.getOrdonnee();
        ellipse = new Rectangle(xPos,yPos,largeur,hauteur);
		ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
		ellipse.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		ellipse.setCouleurContour(this.getPanneauDessin().getCouleurContourCourante());
		VueRectangle vueEllipse = new VueRectangle(ellipse);
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
