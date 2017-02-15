
public class RuleRepository{
	public Question addQuestion(String id, Question question)
	{
		return question;
		
	}
	
	public Iterator getIterator()
	{
		return new QuestionIterator();
	}
	
	public class QuestionIterator implements Iterator{

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
