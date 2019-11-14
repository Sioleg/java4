/**
 * Décrit un Vol en formation composé de plusieurs Vaisseau
 * @version 1.1
 * @author Guillaume Santini
 */

public class VolEnFormation {

	// Variables d'instance
	private Vaisseau [] formation ;
	private PointPlan position ;
	private double altitudeFixée ;

	// ---------------------------------------------------
	// Constante de classe
	public final int TAILLE;

	// Constructeurs -------------------------------------
	/**
	 * Constructeur Champ à Champ : Initialise un nouveau
	 * vol en formation à partir de 2 vaisseaux passés en
	 * paramètre et à partir des coordonnées de la position
	 * de départ du vol
	 * @param tabV un tableau de Vaisseau pour définir les \
	 * membres de la formation.
	 * @param alt l'altitude de vol
	 * @param pos le point qui donne la position initiale de
	 * la formation.
	 */
	public VolEnFormation(Vaisseau [] tabV, PointPlan pos, double alt)
	{
		this.TAILLE = tabV.length;
		this.formation = tabV;
		this.setPosition(pos);
		this.setAltitudeFixée( alt);
	}
	
	/**
	 * Constructeur par copie
	 * @param v le modèle de vol en formation
	 */
	public VolEnFormation( VolEnFormation v)
	{
		this.position = new PointPlan( v.position);
		this.altitudeFixée = v.altitudeFixée;
		this.TAILLE = v.TAILLE;
		this.formation = new Vaisseau [ v.TAILLE ] ;
		for (int i = 0; i < v.TAILLE; i++ )
			this.formation[i] = new Vaisseau( v.formation[ i ] ) ;
	}

	// Accesseur Getter/Setter  --------------------------
	/**
	 * Retourne le tableau contenant les Vaisseau de la formation
	 * @return le tableau de Vaisseau
	 */
	public Vaisseau [] getFormation() {
		return this.formation ;
	}
	
	/**
	 * Fixe le tableau contenant les Vaisseau de la formation
	 * @param formation le tableau de Vaisseau
	 */
	public void setFormation( Vaisseau [] formation ) {
		this.formation = formation ;
	}

	/**
	 * Retourne le ième Vaisseau de la formation et null si i dépasse la taille du tableau
	 * @param i le numero du Vaisseau
	 * @return le Vaisseau numéro i
	 */
	public Vaisseau getVaisseau(int i) {
		if ( i < this.TAILLE )
			return this.formation[i] ;
		else
			return null;
	}
	
	/**
	 * Fixe le ième Vaisseau de la formation
	 * @param i le numero du Vaisseau que l'on souhaite fixer
	 * @param newV le nouveau Vaisseau
	 */
	public void setVaisseau( int i, Vaisseau newV ) {
		if ( i >= this.TAILLE )
			System.out.println( "Position d'insertion dans le tableau invalide");
		else
			this.formation[i] = newV ;
	}

	/**
	 * Retourne le point correspondant à la position de la formation
	 * @return la position de la formation
	 */
	public PointPlan getPosition() {
		return this.position;
	}

	/**
	 * Retourne l'abscisse de la position de la formation
	 * @return l'abscisse de la position de la formation
	 */
	public double getAbscisse() {
		return this.position.getAbscisse();
	}

	/**
	 * Retourne l'ordonnée de la position de la formation
	 * @return l'ordonnée de la position de la formation
	 */
	public double getOrdonnée() {
		return this.position.getOrdonnée();
	}

	/**
	 * Fixe la position de la formation
	 * @param newP le point correspondant à la nouvelle position de la formation
	 */
	public void setPosition( PointPlan newP ) {
		this.position = newP ;
	}
	
	/**
	 * Fixe l'abscisse de la position de la formation
	 * @param newX l'abscisse de la position de la formaiton
	 */
	public void setAbscisse( double newX) {
		this.position.setAbscisse( newX );
	}
	
	/**
	 * Fixe l'ordonnée de la position de la formation
	 * @param newY l'ordonnée de la position de la formaiton
	 */
	public void setOrdonnée( double newY) {
		this.position.setOrdonnée( newY );
	}
	
	/**
	 * Retourne l'altitude fixée pour la formation
	 *  @return l'altitude fixée pour la formation
	 */
	public double getAltitudeFixée() {
		return this.altitudeFixée;
	}
	
	/**
	 * Fixe l'altitude de la formation
	 * @param newAlt l'altitude fixée
	 */
	public void setAltitudeFixée( double newAlt ) {
		this.altitudeFixée = newAlt ;
		if ( ! this.altitudeValide() )
			this.setAltitudeFixée( 1000. );
	}  

	// -----------------------------------------------------------
	// Autres méthodes
	/**
	 * Retourne le nombre de Vaisseau constituant la formation
	 * @return le nombre de Vaisseau de la formation
	 **/
	public int nbDeVaisseaux() {
		return this.TAILLE;
	}

	/**
	 * Méthode publique de test de l'altitude. Permet de
	 * savoir si l'altitude de vol prévue pour la formation
	 * est au dessus du sol!
	 * @return true si l'altitde de la formation est au
	 *         dessus de l'altitude 0.
	 */
	public boolean altitudeValide() {
		return ( 0. < this.getAltitudeFixée());
	}

	/**
	 * Répercute l'altitude de vol (transmet) aux
	 * vaisseaux qui composent la formation de vol
	 **/
	public void appliqueAltitudeDeVol() {
		for( int i = 0 ; i < this.nbDeVaisseaux(); i++)
			this.getVaisseau( i ).setAltitude(this.getAltitudeFixée()) ;
	}
	
	/**
	 * Retourne le tableau des altitudes de chaque vaisseau
	 * composant la formation
	 * @return un tableau d''altitudes
	 */
	public double [] altitudesDesVaisseaux() {
		double [] tab = new double [ this.nbDeVaisseaux() ] ;
		for( int i = 0 ; i < tab.length ; i++ )
			tab[i] = this.getVaisseau(i).getAltitude();
		return tab ;
	}
	
	/**
	 * Déplace la formation.
	 * @param dx valeur du déplacement selon l'axe des abscisses
	 * @param dy valeur du déplacement selon l'axe des ordonnées
	**/
	void déplacement( double dx, double dy ) {
		this.setAbscisse( this.getAbscisse() + dx );
		this.setOrdonnée( this.getOrdonnée() + dy );
	}
	
	/**
	 * 
	 **/
	void destruction( int position) {
		this.setVaisseau( position, null );
	}

	// -----------------------------------------------------------
	// Redéfinition de String toString()
	/**
	 * Affichage du contenu de l’objet
	 * @return chaîne de caractère décrivant l'état courant de l'instance
	 */
	public String toString() {
		String desc = "";
		desc += "--------------------------------------\n";
		desc += "+- Vol En Formation\n";
		desc += "   |- Altitude : " + this.getAltitudeFixée() + "\n" ;
		desc += "   |- Position : (" + this.getAbscisse() + "," + this.getOrdonnée() + ")\n" ;
		for (int i = 0; i < this.nbDeVaisseaux(); i++) {
			desc += "   |- Vaisseau " + i + " : " + "\n" ;
			desc += this.getVaisseau(i) + "\n";
		}
		desc += "+- Vol En Formation\n";
		desc += "--------------------------------------\n";
		return desc ;
	}
	
	// -----------------------------------------------------------
	// Redéfinition de boolean equals( Object o )
	public boolean equals( Object o)
	{
		if ( ! ( o instanceof VolEnFormation ) )
			return false;

		VolEnFormation v = (VolEnFormation) o;

		if (    this.TAILLE != v.TAILLE ||
				( ! this.position.equals(v.position)) ||
				this.getAltitudeFixée() != v.getAltitudeFixée() )
			return false;
		boolean all = true ;
		for (int i = 0; i < this.formation.length; i++)
			all = all && ( this.getVaisseau(i).equals(v.getVaisseau(i))) ;
		return all;

	}

}


