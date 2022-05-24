package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

public class OutilChangerCouleur extends Outil
{
	public static final String NOM = "Changer Couleur";

	public void mouseClicked(MouseEvent event)
	{
		Color couleurChoisie = null;
		Forme formesContenant = null;
		for(int k = 0 ; k < super.getPanneauDessin().getVueFormes().size() ; k++)
			if(super.getPanneauDessin().getVueFormes().get(k).getForme().contient(new Coordonnees(event.getX() , event.getY())))
			{
				formesContenant = super.getPanneauDessin().getVueFormes().get(k).getForme();
			}
		if(formesContenant != null)
			couleurChoisie = JColorChooser.showDialog(super.getPanneauDessin(), "Changer couleur", 
					super.getPanneauDessin().getCouleurCourante());
		if(couleurChoisie != null)
			formesContenant.setCouleur(couleurChoisie);
		super.getPanneauDessin().repaint();
	}
	
	public String getNom()
	{
		return this.NOM;
	}
}
