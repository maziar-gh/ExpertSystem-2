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
		Scanner reader = new Scanner(System.in);  
		Question question;
		for(String ID : ruleRepo.getRuleMap().keySet())
		{
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
	
	public void printLogo() {
		String [] logo = new String [] {"  ___  __ __                                                       ",
                  		  " / _  \\/_ /_ |                                                      ",
                  		  "| (_) | | || |   ___ _ __ ___   ___ _ __ __ _  ___ _ __   ___ _   _ ",
                  		  " \\__, | | || |  / _ \\ '_ ` _ \\ / _ \\ '__/ _` |/ _ \\ '_ \\ / __| | | |",
                  		  "   / /  | || | |  __/ | | | | |  __/ | | (_| |  __/ | | | (__| |_| |",
                  		  "  /_/   |_||_|  \\___|_| |_| |_|\\___|_|  \\__, |\\___|_| |_|\\___|\\__, |",
                  		  "                                         __/ |                 __/ |",
                  		  "                                        |___/                 |___/ ",
                  		  "                            Expert system ™ \n\n"};
		for(String line: logo) {
  			System.out.println(line);
		}
	}
	
	public String evaluate()
	{
		for(Fact fact : factRepo.getFactsList())
		{
			if(fact.getFact().equals(resultMap))
			{
				System.out.println("");
				return fact.getDescription();
			}
		}
		return null;
		
	}
}
