package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleurContour extends AbstractAction
{
	public static final String NOM_ACTION = "Choisir couleur contour";
	private PanneauDessin panneauDessin;
	
	public ActionChoisirCouleurContour(PanneauDessin panneauDessin)
	{
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Color couleurChoisie = JColorChooser.showDialog(this.panneauDessin, NOM_ACTION, 
				this.panneauDessin.getCouleurCourante());
		if(couleurChoisie != null)
			this.panneauDessin.setCouleurContourCourante(couleurChoisie);
	}
}
