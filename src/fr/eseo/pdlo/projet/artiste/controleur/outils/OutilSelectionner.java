package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

public class OutilSelectionner extends Outil
{
	public static final String NOM = "Sélectionner";

	public void mouseClicked(MouseEvent event)
	{
		Forme formesContenant = null;
		for(int k = 0 ; k < super.getPanneauDessin().getVueFormes().size() ; k++)
			if(super.getPanneauDessin().getVueFormes().get(k).getForme().contient(new Coordonnees(event.getX() , event.getY())))
			{
				formesContenant = super.getPanneauDessin().getVueFormes().get(k).getForme();
			}
		if(formesContenant != null)
			JOptionPane.showMessageDialog(super.getPanneauDessin(), formesContenant.toString()
					, ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String getNom()
	{
		return this.NOM;
	}
}
