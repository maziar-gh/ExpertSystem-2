import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ESProvider
{
	FactParser factParser;
	RuleParser ruleParser;
	FactRepository factRepo;
	RuleRepository ruleRepo;
	private HashMap<String, Boolean> resultMap = new HashMap<>();
	
	
	public ESProvider(FactParser factParser, RuleParser ruleParser)
	{
		this.factParser = factParser;
		this.ruleParser = ruleParser;
		factRepo = this.factParser.getFactRepository();
		ruleRepo = this.ruleParser.getRuleRepository();
	}

	public void collectAnswers()
	{
		System.out.println("shit");
		System.out.println(ruleRepo.getRuleMap().size());
		Scanner reader = new Scanner(System.in);  
		Question question;
		for(String ID : ruleRepo.getRuleMap().keySet())
		{
			System.out.println("anyad");
			question = ruleRepo.getRuleMap().get(ID);
			boolean goodInput = false;
			while(goodInput == false)
			{
				System.out.println(question.getQuestion());
				System.out.println("Please Enter Your Answer !");
				String answer = reader.nextLine();
				if(Arrays.asList(question.getInputPattern()).contains(answer))
				{
					boolean evalValue = question.getEvaluatedAnswer(answer);
					resultMap.put(ID, evalValue);
					goodInput = true;
				}
				
			}
		}
		
	}
	
	public boolean getAnswerByQuestion(String questionID)
	{
		return false;
		
	}
	
	public String evaluate()
	{
		System.out.println(factRepo.getFactsList().size());
		System.out.println(resultMap.size());
		for(String id: resultMap.keySet())
		{
			System.out.println(resultMap.get(id).toString() + "     " + id);
		}
		for(Fact fact : factRepo.getFactsList())
		{
			System.out.println(fact.getFact().size());
			if(fact.getFact().equals(resultMap))
			{
				return fact.getDescription();
			}
		}
		return null;
		
	}
}
