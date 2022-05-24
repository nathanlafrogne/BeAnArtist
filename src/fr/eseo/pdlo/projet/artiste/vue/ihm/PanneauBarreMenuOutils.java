package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionBougerForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleurContour;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSupprimerForme;

public class PanneauBarreMenuOutils extends JPanel
{
	private PanneauDessin panneauDessin;
	
	public PanneauBarreMenuOutils(PanneauDessin panneauDessin)
	{
		this.panneauDessin = panneauDessin;
		this.setLayout(new BoxLayout(this , BoxLayout.X_AXIS));
		this.initComponents();
	}
	
	private void initComponents()
	{
		JMenuBar menuBar = new JMenuBar();
		ActionChoisirCouleurContour actionChoisirContour = new ActionChoisirCouleurContour(this.panneauDessin);
		ActionSupprimerForme actionSupprimer = new ActionSupprimerForme(this.panneauDessin);
		ActionBougerForme bougerForme = new ActionBougerForme(this.panneauDessin);
		
		JMenu menuOutil = new JMenu("Outils");
		
		menuOutil.add(actionChoisirContour);
		menuOutil.add(actionSupprimer);
		menuOutil.add(bougerForme);
		
		
		menuBar.add(menuOutil);

		this.add(menuBar);
	}
}
