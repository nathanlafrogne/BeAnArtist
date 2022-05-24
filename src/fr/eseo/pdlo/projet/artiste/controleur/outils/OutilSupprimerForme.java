package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilSupprimerForme extends Outil
{
	public static final String NOM = "Supprimer forme";

	public void mouseClicked(MouseEvent event)
	{
		Forme formesContenant = null;
		int index = 0;
		for(int k = 0 ; k < super.getPanneauDessin().getVueFormes().size() ; k++)
			if(super.getPanneauDessin().getVueFormes().get(k).getForme().contient(new Coordonnees(event.getX() , event.getY())))
			{
				formesContenant = super.getPanneauDessin().getVueFormes().get(k).getForme();
				index = k;
			}
		if(formesContenant != null)
		{
			int n = JOptionPane.showConfirmDialog(super.getPanneauDessin(), 
					"Voulez-vous supprimer la forme :\n" + formesContenant.toString()
					, ActionSelectionner.NOM_ACTION, JOptionPane.YES_NO_OPTION);
			if(n == 0)
			{
				super.getPanneauDessin().setVueFormeSupprimee(super.getPanneauDessin().getVueFormes().get(index));
				super.getPanneauDessin().getVueFormes().remove(index);
			}
		}
		this.getPanneauDessin().repaint();
	}
	
	public String getNom()
	{
		return this.NOM;
	}
}
