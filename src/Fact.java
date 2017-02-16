import java.util.*;

public class Fact
{
	private String id;
	private String description;
	private HashMap<String, Boolean> fact = new HashMap<>();

	
	public Fact(String description)
	{
		this.description = description;
	}
    public void setId(String id)
    {
        this.id = id;
    }
	public void setFactValueByID(String id, boolean value)
	{
		fact.put(id, value);
	}
	
	public Set<String> getIDSet()
	{
		return fact.keySet();
		
	}
	public boolean getValueID(String id)
	{
		return fact.get(id);
		
	}
	
	public String getDescription()
	{
		return description;
		
	}
	
	
}
