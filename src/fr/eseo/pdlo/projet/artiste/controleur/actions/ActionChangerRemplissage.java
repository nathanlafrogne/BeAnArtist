package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilChangerCouleur;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChangerRemplissage extends AbstractAction
{
	public static final String NOM_ACTION = "Changer couleur";
	
	private PanneauDessin panneauDessin;
	
	public ActionChangerRemplissage(PanneauDessin panneauDessin)
	{
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		OutilChangerCouleur outil = new OutilChangerCouleur();
		this.panneauDessin.associerOutil(outil);
	}
}
