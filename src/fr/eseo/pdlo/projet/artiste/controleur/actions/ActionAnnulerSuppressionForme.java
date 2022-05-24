package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionAnnulerSuppressionForme extends AbstractAction
{
	public static final String NOM_ACTION = "Annuler Suppression";
	
	private PanneauDessin panneauDessin;
	
	public ActionAnnulerSuppressionForme(PanneauDessin panneauDessin)
	{
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		this.panneauDessin.ajouterVueForme(this.panneauDessin.getVueFormeSupprimee());
		this.panneauDessin.repaint();
	}
}
