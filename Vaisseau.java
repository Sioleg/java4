/**
 * Décrit un Vaisseau
 * @version 1.1
 * @author Guillaume Santini
 */


// définition d’une classe pour un vaisseau
public class Vaisseau {
	
	// ---------------------------------------------------
	// Variables d'instance
	private int nbMaxPassagers; 	// Equipage + passager
	private String catégorie; 	// Classe du vaisseau
	private double altitude; 		// altitude effective de vol

	// ---------------------------------------------------
	// Variable de classe
	private static int prochainNuméroDeChâssis = 0 ;

	// ---------------------------------------------------
	// Constantes d'instance
	private final int NUMÉRO_DE_CHÂSSIS;

	// Constructeurs -------------------------------------
	/**
	 * Constructeur Champ à Champ : Initialise un nouveau
	 * Vaisseau
	 * @param cat la catégorie du vaisseau
	 * @param nbPass le nombre de passagers que peut emporter
	 *               la vaisseau
	 * @param alt l'altitude de vol du vaisseau
	 */
	public Vaisseau( String cat, int nbPass, double alt) {
		this.setCatégorie( cat) ;
		this.setNbMaxPassagers( nbPass) ;
		this.setAltitude( alt) ;
		this.NUMÉRO_DE_CHÂSSIS = Vaisseau.getProchainNuméroDeChâssis();
		Vaisseau.incrémenteProchainNuméroDeChâssis();
	}
	
	/**
	 * Constructeur par défaut : Initialise un nouveau
	 * vaisseau ayant pour catégorie "Vaisseau Léger"
	 * admettant 7 passagers et volant à une altitude 
	 * de 0 mètres.
	 */
	public Vaisseau() {
		this( "Vaisseau léger", 7, 0.);
	}
	
	/**
	 * Constreur par copie
	 * @param v le modèle de Vaisseau
	 */
	public Vaisseau( Vaisseau v ) {
		this.nbMaxPassagers = v.nbMaxPassagers ;
		this.catégorie = v.catégorie ;
		this.altitude = v.altitude ;
		this.NUMÉRO_DE_CHÂSSIS = v.NUMÉRO_DE_CHÂSSIS ;
		// on n'incrémente surtout pas le prochain numéro de châssis.
	}

	// Accesseur Getter/Setter  --------------------------
	/**
	 * Fixe la catégorie du vaisseau
	 * @param cat nom de la catégorie
	 */
	public void setCatégorie( String cat) {
		this.catégorie = cat;
	}

	/**
	 * Retourne la catégorie du vaisseau
	 * @return la catégorie du vaisseau
	*/
	public String getCatégorie() {
		return this.catégorie;
	}

	/**
	 * Fixe la capacité en nombre de passagers du vaisseau
	 * @param n nombre maximal de passagers 
	 */
	public void setNbMaxPassagers( int n) {
		this. nbMaxPassagers = n;
	}

	/**
	 * Retourne la capacité en nombre de passagers du vaisseau
	 * @return nombre maximal de passagers 
 	*/
	public int getNbMaxPassagers() {
		return this.nbMaxPassagers;
	}

	/**
	 * Fixe l'altitude de vol du vaisseau
	 * @param alt altitude de vol
	 */
	public void setAltitude( double alt) {
		this.altitude = alt;
	}

	/**
	 * Retourne le nombre de passagers du vaisseau
	 * @return l'altitude du vaisseau
	 */
	public double getAltitude() {
		return this.altitude;
	}

	/**
	 * Retourne le nombre du châssis du Vaisseau
	 * @return le numéro de châssis
	 */
	public int getNuméroDeChâssis()
	{
		return this.NUMÉRO_DE_CHÂSSIS ;
	}
	
	/**
	 * Affiche le départ
	 */
	public void départ()
	{
		System.out.println("Je parts.");
	}

	/**
	 * Reinitialise le vaisseau avec des valeurs alétoires
	 * 	- avec une catégorie formée d'une chaine aléatoire
	 * de 10 caractères
	 * - avec une capacité aléatoire comprise entre 1 et 20
	 * - avec une altitude comprise entre 0 etr 100000 mètres
	 **/
	public void initRandom()
	{
		this.setNbMaxPassagers( (int)(19*Math.random()+1));
		this.setAltitude( 100000.f * (double)( Math.random()));
		RandomStringGen rs = new RandomStringGen();
		this.setCatégorie( rs.nextRandomString(10));
	}

	// ---------------------------------------------------
	// Méthode de classe

	// Méthode d'accès privée (utilisée seulement dans le
	// constructeur) d'accès au prochain numéro de châssis
	private static int getProchainNuméroDeChâssis()
	{
		return Vaisseau.prochainNuméroDeChâssis;
	}

	// Méthode privée (sutilisée seulement dans le constructeur
	// d'incrémentation du prochain numéro de châssis
	private static void incrémenteProchainNuméroDeChâssis()
	{
		Vaisseau.prochainNuméroDeChâssis ++;
	}

	// -----------------------------------------------------------
	// Redéfinition de méthodes
	
	/**
	 * Affichage du contenu de l’objet
	 * @return chaîne de caractère décrivant l'état courant de l'instance
	 */
	public String toString()
	{
		String desc = "\n\n" ;
		desc += "		  /- Vaisseau - Châssis : " + getNuméroDeChâssis() + "\n" ;
		desc += "     -------------\n" ;
		desc += "  /  Capacité  = " + this.getNbMaxPassagers() + " passagers\n" ;
		desc += "<    Altitude  = " + this.getAltitude() + " mètres\n" ;
		desc += "  \\  Catégorie = " + this.getCatégorie() + "\n" ;
		desc += "     -------------\n" ;
		desc += "		  \\- Vaisseau - Châssis : " + getNuméroDeChâssis() + "\n" ;
		return desc ;
	}

	/**
	 * Comparaison de Vaisseau 
	 * @param o l'instance de Vaisseau à comparer à l'instance courante
	 */
	public boolean equals( Object o ) {
		if ( ! ( o instanceof Vaisseau ) ) 
			return false ;
		Vaisseau v = (Vaisseau) o ;
		// Attention les numéros de châssis ne peuvent
		// être les mêmes
		return (	this.getCatégorie().equals(v.getCatégorie()) &&
					this.getAltitude() == v.getAltitude() &&
					this.getNbMaxPassagers() == v.getNbMaxPassagers()) ;
	}
}

