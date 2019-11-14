

import java.util.Random;
import java.lang.StringBuilder;

public class RandomStringGen
{
	private static final String choixCaractères="1234567890_-+/*AZERTYUIOPQSDFGHJKLMWXCVBNazertyuiopqsdfghjklmwxcvbn";
	private Random rnd ;
	public RandomStringGen()
	{
		this.rnd = new Random();
	}
	public String nextRandomString(int len)
	{
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( choixCaractères.charAt( rnd.nextInt(choixCaractères.length()) ) );
		return sb.toString();
	}
}
