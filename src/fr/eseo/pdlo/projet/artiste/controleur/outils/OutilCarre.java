package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme 
{
	public static final String NOM = "Carr�";
	
	protected VueForme creerVueForme()
	{
		Coordonnees debut = super.getDebut();
		Coordonnees fin = super.getFin();
		
		double max = Math.max(Math.abs(fin.getOrdonnee() - debut.getOrdonnee()),Math.abs(fin.getAbscisse() - debut.getAbscisse()));
		Carre cercle;
		
		if(fin.getAbscisse() - debut.getAbscisse() < 0 && fin.getOrdonnee() - debut.getOrdonnee() > 0) //En bas a gauche
			cercle = new Carre(new Coordonnees(debut.getAbscisse() - max, debut.getOrdonnee()) , max);
		else if(fin.getAbscisse() - debut.getAbscisse() < 0 && fin.getOrdonnee() - debut.getOrdonnee() < 0) // En haut a gauche
			cercle = new Carre(new Coordonnees(debut.getAbscisse() - max, debut.getOrdonnee() - max) , max);
		else if(fin.getAbscisse() - debut.getAbscisse() > 0 && fin.getOrdonnee() - debut.getOrdonnee() < 0) // En haut a droite
			cercle = new Carre(new Coordonnees(debut.getAbscisse(), debut.getOrdonnee() - max ) , max);
		else if(fin.getAbscisse() - debut.getAbscisse() > 0 && fin.getOrdonnee() - debut.getOrdonnee() > 0) // En bas a droite
			cercle = new Carre(debut , max);
		else
			cercle = new Carre(debut);
		
		cercle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		cercle.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		cercle.setCouleurContour(this.getPanneauDessin().getCouleurContourCourante());
		VueCarre vueCercle = new VueCarre(cercle);
		if(!super.estPremier())
        	this.getPanneauDessin().removeLast();
		super.getPanneauDessin().ajouterVueForme(vueCercle);
		return vueCercle;
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
