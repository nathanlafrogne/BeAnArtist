package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirModeRemplissage extends AbstractAction
{
	public static final String NOM_ACTION = "Choisir Mode Remplissage";
	private PanneauDessin panneauDessin;
	
	public ActionChoisirModeRemplissage(PanneauDessin panneauDessin , Remplissage remplissage)
	{
		super(remplissage.getMode());
		this.panneauDessin = panneauDessin; 
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand().equals(Remplissage.AUCUNE.getMode()))
			this.panneauDessin.setModeRemplissageCourant(Remplissage.AUCUNE);
		else if(event.getActionCommand().equals(Remplissage.UNIFORME.getMode()))
			this.panneauDessin.setModeRemplissageCourant(Remplissage.UNIFORME);
		else if(event.getActionCommand().equals(Remplissage.DIFFERENT.getMode()))
			this.panneauDessin.setModeRemplissageCourant(Remplissage.DIFFERENT);
		else if(event.getActionCommand().equals(Remplissage.DEGRADE.getMode()))
			this.panneauDessin.setModeRemplissageCourant(Remplissage.DEGRADE);
	}
}
