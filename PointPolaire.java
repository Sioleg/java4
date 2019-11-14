/**
 * Décrit un point du plan décrit par des coarguments poliares
 * @version 1.1
 * @author Guillaume Santini
 */


public class PointPolaire
{
	// -----------------------------------------------------------
	// Les attributs sont privés

	private double module ;
	private double argument ;
	private final String NOM ;

	// -----------------------------------------------------------
	// Constructeurs

	/**
	 * Constructeur champ à champ
	 * @param mod le module du point
	 * @param arg l'argument du point
	 * @param nom le nom du point
	 */
	public PointPolaire( double mod, double arg, String nom) {
		this.setModule(mod) ;
		this.setArgument(arg) ;
		this.NOM = nom ;
	}

	/**
	 * Constructeur par defaut: le point est à l'origine et a pour nom `M`
	 */
	public PointPolaire() {
		this(0., 0., "M") ;
	}

	/**
	 * Le constructeur par copie
	 * @param p le point qui sert de modèle
	 */
	public PointPolaire( PointPolaire p) {
		this.module = p.module ;
		this.argument = p.argument ;
		this.NOM = new String( p.NOM ) ;
	} 
	// ----------------------------------------------------------
	// Accesseurs
	
	/**
	 * Retourne le module du point
	 * @return le module
	 */
	public double getModule() {
		return this.module ;
	}

	/**
	 * Fixe le module du point
	 * @param mod l'module
	 */
	public void setModule(double mod) {
		this.module = mod ;
	} 

	/**
	 * Retourne l'argument du point
	 * @return l'argument
	 */
	public double getArgument() {
		return this.argument ;
	}

	/**
	 * Fixe l'argument du point
	 * @param arg l'argument
	 */
	public void setArgument(double arg) {
		this.argument = arg ;
	} 

	/**
	 * Retourne le nom du point
	 * @return le nom
	 */
	public String getNom() {
		return this.NOM ;
	}

	// -----------------------------------------------------------
	// Autres méthodes


	/**
	 * Retourne la distance séparant le point de l'orirgine du repère
	 * @return la distance à l'origine
	 */
	private double distAOrigine(){
		return this.getModule();
	}


	// -----------------------------------------------------------
	// Redéfinition de méthodes
	
	/**
	 * Affichage du contenu de l’objet
	 * @return chaîne de caractère décrivant l'étaut courant de l'instance
	 */
	public String toString() { 
		return( this.NOM + 
				"(mod = " + this.getModule() + 
				", arg = " + this.getArgument() + ")" ) ;
	}

}

