import java.util.*;

public class RuleRepository{
	
	Map<Question, String> ruleMap = new HashMap<Question, String>();
	
	public Question addQuestion(String id, Question question)
	{
		ruleMap.put(question, id);
		return null;
		
	}
	
	public Iterator getIterator()
	{
		return new QuestionIterator();
	}
	
	public class QuestionIterator implements Iterator{

		int index;
		
		@Override
		public boolean hasNext() {
			if (index < ruleMap.size()){
				return true;
			}
			return false;

		}

		@Override
		public Object next() {
	         if(this.hasNext()){
	             return true;
	            		 // needs to implement;
	          }
	          return null;
		}
		
	}

}
