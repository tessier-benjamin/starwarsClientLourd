package starWars;

public class gentil {
	boolean force;
	public gentil(boolean force)
	{
		this.force = force;
	}
	
	public boolean getForce()
	{
		return this.force;
	}
	
	void setForce(boolean force)
	{
		this.force=force;
	}
	
	public String toString() 
	{
		if(this.force == true){
			return "il possède la force";
		}
		return "il ne possede pas la force";
	}
}
