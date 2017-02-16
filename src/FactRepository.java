import java.util.*;

public class FactRepository{
	
	ArrayList<Fact> factsList = new ArrayList<>();
	
	public Fact addFact(Fact fact){
		return fact;
	}
	
	public Iterator getIterator()
	{
		return new FactIterator();
		
	}
	public class FactIterator implements Iterator {
		
		int index;
		
		@Override
		public boolean hasNext() {
			if (index < factsList.size()){
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
	         if(this.hasNext()){
	             return factsList.get(index++);
	          }
	          return null;
		}
		
	}
}
