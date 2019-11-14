/**
 * Classe de test de la classe VolEnFormation
 * @version 1.1
 * @author Guillaume Santini
 */

public class TestVolEnFormation
{
	public static void main(String [] args)
	{
		Vaisseau [] vaisseaux = new Vaisseau [10] ;
		for(int i = 0;i < 10;i++){
			vaisseaux[i] = new Vaisseau("Chasseur Léger", 2,10000);
		}
		VolEnFormation vef = new VolEnFormation( vaisseaux, new PointPlan(0,0,"Origine"),10000);
		System.out.println(vef);
		vaisseaux[10] = new Vaisseau("Chasseur Léger", 2,10000);
	}
}




