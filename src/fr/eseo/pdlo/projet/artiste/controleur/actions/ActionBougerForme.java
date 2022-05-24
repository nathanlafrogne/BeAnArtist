package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilBougerForme;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionBougerForme extends AbstractAction
{
	public static final String NOM_ACTION = "Bouger Forme";
	private PanneauDessin panneauDessin;
	
	public ActionBougerForme(PanneauDessin panneauDessin)
	{
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		OutilBougerForme outilSelectionner = new OutilBougerForme();
		this.panneauDessin.associerOutil(outilSelectionner);
		JOptionPane.showMessageDialog(this.panneauDessin , OutilBougerForme.FONCTIONNEMENT, 
				"Fonctionnement de l'Outil" ,JOptionPane.INFORMATION_MESSAGE);
	}

}
