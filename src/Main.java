public class Main
{

	public static void main(String[] args)
	{
		ESProvider ESP = new ESProvider(new FactParser(), new RuleParser());
		ESP.printLogo();
		ESP.collectAnswers();
		System.out.println(ESP.evaluate());
	}

}
