package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilChangerRemplissage extends Outil
{
	public static final String NOM = "Changer Remplissage";

	public void mouseClicked(MouseEvent event)
	{
		VueForme formesContenant = null;
		for(int k = 0 ; k < super.getPanneauDessin().getVueFormes().size() ; k++)
			if(super.getPanneauDessin().getVueFormes().get(k).getForme().contient(new Coordonnees(event.getX() , event.getY())))
			{
				formesContenant = super.getPanneauDessin().getVueFormes().get(k);
			}
		if(formesContenant != null)
			//Demander
		super.getPanneauDessin().repaint();
	}
	
	public String getNom()
	{
		return this.NOM;
	}
}
