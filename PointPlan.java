/**
 * Décrit un point du plan decrit par des coordonnées cartésiennes
 * @version 1.1
 * @author Guillaume Santini
 */


public class PointPlan
{
	// -----------------------------------------------------------
	// Les attributs sont privés

	private double abscisse ;
	private double ordonnée ;
	private final String NOM ;

	// -----------------------------------------------------------
	// Constructeurs

	/**
	 * Constructeur Champ à Champ : Initialise un nouveau
	 * point avec les coordonnées passées en paramètre
	 * @param x abscisse du point
	 * @param y ordonnée du point
	 * @param nom nom du point 
	 */
	public PointPlan( double x, double y, String nom) {
		this.setAbscisse(x) ;
		this.setOrdonnée(y) ;
		this.NOM = nom ;
	}

	/**
	 * Constructeur par défaut : Initialise un nouveau point
	 * avec des coordonnées par défaut des coordonnées qui le
	 * place à l’origine du référentiel
	 */
	public PointPlan() {
		this(0., 0., "M") ;
	}

	/**
	 * Cosntructeur permettant d'initialiser un point sans avoir
	 * à lui donner un nom. Le nom est "M" par défaut
	 * @param x abscisse du point
	 * @param y ordonnée du point
	 */
	public PointPlan(double x, double y)
	{
		this( x, y, "M") ;
	}

	/**
	 * Constructeur par copie
	 * @param p le modèle de PointPlan
	 */
	public PointPlan(PointPlan p) {
		this.abscisse = p.abscisse ;
		this.ordonnée = p.ordonnée ;
		this.NOM = new String( p.NOM ) ;
	}
	
	// ----------------------------------------------------------
	// Accesseurs
	
	/**
	 * Retourne l'abscisse du point
	 * @return l'abscisse
	 */
	public double getAbscisse() {
		return this.abscisse ;
	}

	/**
	 * Fixe l'abscisse du point
	 * @param x l'abscisse
	 */
	public void setAbscisse(double x) {
		this.abscisse = x ;
	} 

	/**
	 * Retourne l'ordonnée du point
	 * @return l'ordonnée
	 */
	public double getOrdonnée() {
		return this.ordonnée ;
	}

	/**
	 * Fixe l'ordonnée du point
	 * @param y l'ordonnée
	 */
	public void setOrdonnée(double y) {
		this.ordonnée = y ;
	} 

	/**
	 * Retourne l'nom du point
	 * @return l'nom
	 */
	public String getNom() {
		return this.NOM ;
	}

	// -----------------------------------------------------------
	// Autres méthodes

	/**
	 * Translate un point
	 * @param δx translation selon l'axe des abscisses
	 * @param δy translation selon l'axe des ordonnées
	 */
	public void translate( double δx, double δy)
	{
		this.abscisse += δx ;
		this.ordonnée += δy ;
	}

	/**
	 * Retourne la distance séparant le point de l'orirgine du repère
	 * @return la distance à l'origine
	 */
	private double distAOrigine(){
		return Math.sqrt(Math.pow(this.getAbscisse(), 2) +
						Math.pow(this.getOrdonnée (), 2)  );
	}

	/**
	 * Retourne la distance à l’origine du point ainsi que
	 * l’angle que forme ce point avec l’axe des abscisses dans
	 * une PointPolaire
	 * @return le point polaire dont le module est la distance à l'origine du point
	 *			dont l'argument est l'angke que forme le point avec l'axe des
	 * 			abscisses.
	 */ 
	public PointPolaire coorPolaires() {
		// calcul du module
		double module = this.distAOrigine();

		// calcul de l’arguement
		double argument = Math.atan(this.getOrdonnée() / this.getAbscisse()) ;

		// Retour des résultats stockés dans un objet PointPlolaire 
		return new PointPolaire( module, argument, this.getNom()+"") ;
	}
	
	/**
	 * Retourne le point symétrique (par symétrie centrale relatif à l'origine
	 * du repère. Le nom donné au symétrique est celui du point courant 
	 * augmenté de "sym"
	 * @return le point symétrique
	 */
	public PointPlan symétrique() {
		return new PointPlan(-this.getAbscisse(),-this.getOrdonnée(), this.getNom()+"sym");
	}

	// -----------------------------------------------------------
	// Redéfinition de méthodes
	
	/**
	 * Affichage du contenu de l’objet
	 * @return chaîne de caractère décrivant l'état courant de l'instance
	 */
	public String toString()
	{
		return( this.NOM +
				" (x = " + this.getAbscisse() +
				", y = " + this.getOrdonnée() + ")" );
	}
}

