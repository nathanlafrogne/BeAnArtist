package fr.eseo.pdlo.projet.artiste.modele;

public enum Remplissage 
{
	AUCUNE("aucune"),
	UNIFORME("uniforme"),
	DIFFERENT("diff�rent"),
	DEGRADE("d�grad�");
	
	private String mode;
	
	private Remplissage(String mode)
	{
		this.mode = mode;
	}
	
	public String getMode()
	{
		return this.mode;
	}
}
