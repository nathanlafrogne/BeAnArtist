package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacer extends AbstractAction
{
	public static final String NOM_ACTION = "Effacer tout";
	private PanneauDessin panneauDessin;
	
	public ActionEffacer(PanneauDessin panneauDessin)
	{
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent action)
	{
		int n = JOptionPane.showConfirmDialog(this.panneauDessin,NOM_ACTION,NOM_ACTION,
				JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if(n==0)
			for(int k = this.panneauDessin.getVueFormes().size() - 1 ; k >= 0 ; k--)
				this.panneauDessin.getVueFormes().remove(k);
		this.panneauDessin.repaint();
	}

}
