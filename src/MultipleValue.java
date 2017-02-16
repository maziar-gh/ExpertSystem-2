import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MultipleValue extends Value
{
	String[] trueValues;

    String[] falseValues;
    
	public MultipleValue(String param)
	{
		
	}
	

	@Override
	public String[] getInputPattern()
	{
		String[] pattern;
        List<String>patternList = new ArrayList<>(Arrays.asList(trueValues));
        for(int i = 0; i<falseValues.length; i++)
        {
            patternList.add(falseValues[i]);
        }
        pattern = patternList.toArray(new String[0]);
        return pattern;
	}

	@Override
	public String[] getFalseValue()
	{
		// TODO Auto-generated method stub
		return falseValues;
	}

	@Override
	public String[] getTrueValue()
	{
		// TODO Auto-generated method stub
		return trueValues;
	}
}
