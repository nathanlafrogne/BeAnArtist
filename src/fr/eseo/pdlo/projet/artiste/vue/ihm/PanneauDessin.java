package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends javax.swing.JPanel
{
	public static final int LARGEUR_PAR_DEFAUT = 1800;
	public static final int HAUTEUR_PAR_DEFAUT = 980;
	public static final java.awt.Color COULEUR_FOND_PAR_DEFAUT = Color.WHITE;
	private final List<VueForme> vueFormes;
	private Outil outilCourant;
	private Color couleurCourante;
	private Remplissage modeRemplissage;
	private Color couleurContourCourante;
	private VueForme vueFormeSupprimee;
	private boolean antiAlias;
	
	public PanneauDessin()
	{
		super();
		super.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT , HAUTEUR_PAR_DEFAUT));
		super.setBackground(COULEUR_FOND_PAR_DEFAUT);
		this.vueFormes = new ArrayList<VueForme>();
		this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
		this.modeRemplissage = Remplissage.AUCUNE;
		this.antiAlias = false;
	}
	
	public PanneauDessin(int hauteur , int largeur , Color couleur)
	{
		super();
		super.setPreferredSize(new Dimension(hauteur , largeur));
		super.setBackground(couleur);
		this.vueFormes = new ArrayList<VueForme>();
		this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
		this.modeRemplissage = Remplissage.AUCUNE;
	}
	
	public List<VueForme> getVueFormes()
	{
		return this.vueFormes;
	}
	
	public void ajouterVueForme(VueForme vueForme)
	{
		this.vueFormes.add(vueForme);
	}
	
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g.create();
		if(!this.getVueFormes().isEmpty())
			for(int k = 0 ; k < this.getVueFormes().size() ; k++)
			{
				this.getVueFormes().get(k).affiche(g2D);
			}
		g2D.dispose();
	}
	
	public void associerOutil(Outil nouvelOutil)
	{
		if(nouvelOutil != null)
		{
			if(this.outilCourant != null)
				this.dissocierOutil();
			this.setOutilCourant(nouvelOutil);
			nouvelOutil.setPanneauDessin(this);
			this.addMouseListener(nouvelOutil);
			this.addMouseMotionListener(nouvelOutil);
		}
	}
	
	public void setVueFormeSupprimee(VueForme vf)
	{
		this.vueFormeSupprimee = vf;
	}
	
	public VueForme getVueFormeSupprimee()
	{
		return this.vueFormeSupprimee;
	}
	
	public void dissocierOutil()
	{
		this.outilCourant.setPanneauDessin(null);
		this.removeMouseListener(outilCourant);
		this.removeMouseMotionListener(outilCourant);
		this.setOutilCourant(null);
	}
	
	public void setOutilCourant(Outil nouvelOutil)
	{
		this.outilCourant = nouvelOutil;
	}
	
	public Outil getOutilCourant()
	{
		return this.outilCourant;
	}
	
	public Color getCouleurCourante()
	{
		return this.couleurCourante;
	}
	
	public void setCouleurCourante(Color couleur)
	{
		this.couleurCourante = couleur;
	}
	
	public Remplissage getModeRemplissageCourant()
	{
		return this.modeRemplissage;
	}
	
	public void setModeRemplissageCourant(Remplissage remplissage)
	{
		this.modeRemplissage = remplissage;
	}
	
	public void setCouleurContourCourante(Color couleur)
	{
		this.couleurContourCourante = couleur;
	}
	
	public Color getCouleurContourCourante()
	{
		return this.couleurContourCourante;
	}
	
	public boolean aliasActif()
	{
		return this.antiAlias;
	}
	
	public void activeAntiAlias()
	{
		this.antiAlias = true;
	}
	
	public void removeLast()
	{
		if(this.getVueFormes().size()>0)
			this.getVueFormes().remove(this.getVueFormes().size()-1);
	}

}
