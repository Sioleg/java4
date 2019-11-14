public class FormationInsertionException extends Exception{
	private int rangSouhait;
	private int rangMax;

	public FormationInsertionException(String message, int rangSouhait, int rangMax){
		super(message);
		this.setRangSouhait(rangSouhait);
		this.setRangMax(rangMax);
	}
	
	public int getRangSouhait(){
		return this.rangSouhait;
	}
	
	public void setRangSouhait(int rangSouhait){
		this.rangSouhait = rangSouhait;
	}
	
	public int getRangMax(){
		return this.rangMax;
	}
	
	public void setRangMax(int rangMax){
		this.rangMax = rangMax;
	}
	
	public String toString(){
		return super().toString()+" : "+rangSouhait+">"+"rangMax";
	}
}


