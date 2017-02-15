
public class FactRepository{
	public Fact addFact(Fact fact){
		return fact;
	}
	
	public Iterator getIterator()
	{
		return new FactIterator();
		
	}
	public class FactIterator implements Iterator {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
