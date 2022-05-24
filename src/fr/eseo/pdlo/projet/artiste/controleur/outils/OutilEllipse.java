package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme
{
	public static final String NOM = "Ellipse";
	
	protected VueForme creerVueForme()
    {
        Coordonnees debut = super.getDebut();
        Coordonnees fin = super.getFin();
        double largeur = fin.getAbscisse() - debut.getAbscisse();
        double hauteur = fin.getOrdonnee() - debut.getOrdonnee();
        double xPos;
        double yPos;
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
        Ellipse ellipse = new Ellipse(xPos,yPos,largeur,hauteur);
        ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
        ellipse.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
        ellipse.setCouleurContour(this.getPanneauDessin().getCouleurContourCourante());
        if(super.getPanneauDessin().getModeRemplissageCourant().equals(Remplissage.DEGRADE))
        {
	        Color couleurDegrade = JColorChooser.showDialog(super.getPanneauDessin(), "Changer couleur", 
					super.getPanneauDessin().getCouleurCourante());
	        if(couleurDegrade == null)
	        	ellipse.setCouleurDegrade(Color.WHITE);
	        else
	        	ellipse.setCouleurDegrade(couleurDegrade);
        }
        VueEllipse vueEllipse = new VueEllipse(ellipse);
        vueEllipse.setAlias(this.getPanneauDessin().aliasActif());
        if(!super.estPremier())
        	this.getPanneauDessin().removeLast();
        super.getPanneauDessin().ajouterVueForme(vueEllipse);
        return vueEllipse;
    }
	
	public void mouseClicked(MouseEvent event) 
	{
		if(event.getClickCount() == 2) 
		{
			super.setDebut(new Coordonnees(event.getX(),event.getY()));
			super.setFin(new Coordonnees(event.getX() + Forme.LARGEUR_PAR_DEFAUT , 
											event.getY() + Forme.HAUTEUR_PAR_DEFAUT));
			this.creerVueForme();
			super.getPanneauDessin().repaint();
		}
	}
	
	public String getNom()
	{
		return this.NOM;
	}
	
}
