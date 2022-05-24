package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionSelectionner extends AbstractAction
{
	public static final String NOM_ACTION = "Selectionner Forme";
	public static final String NOM_FONCTIONNEMENT = "Cliquer sur une forme pour voir ses caracteristiques";
	private PanneauDessin panneauDessin;
	
	public ActionSelectionner(PanneauDessin panneauDessin)
	{
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		OutilSelectionner outilSelectionner = new OutilSelectionner();
		this.panneauDessin.associerOutil(outilSelectionner);
		if(this.panneauDessin.aliasActif())
			JOptionPane.showMessageDialog(this.panneauDessin , this.NOM_FONCTIONNEMENT, 
					"Fonctionnement de l'Outil" ,JOptionPane.INFORMATION_MESSAGE);
	}

}
