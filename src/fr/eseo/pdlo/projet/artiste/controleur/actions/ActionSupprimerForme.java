package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSupprimerForme;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionSupprimerForme extends AbstractAction
{
	public static final String NOM_ACTION = "Supprimer Forme";
	
	private PanneauDessin panneauDessin;
	
	public ActionSupprimerForme(PanneauDessin panneauDessin)
	{
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		OutilSupprimerForme outil = new OutilSupprimerForme();
		this.panneauDessin.associerOutil(outil);
	}
}
