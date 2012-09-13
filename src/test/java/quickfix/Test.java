package quickfix;

public class Test {

	/**
	 * @param args
	 * @throws ConfigError 
	 * @throws InvalidMessage 
	 */
	public static void main(String[] args) throws ConfigError, InvalidMessage {
		
		final DataDictionary dictionary = new DataDictionary("CQG_FIX_Custom1.0.xml");
		
		String messageString = 
				"8=FIX.4.29=20135=UZR49=CQG_Gateway56=BarChartFIX134=257=Test FIX52=20120807-17:42:48.32120034=AuthAccountsRequest150893=Y" +
						"20058=11=1680472320010=SIMBarChart120014=PSBarChart120053=220059=CQG Sim20060=N10=064" ;
//						+
//								 "1=1680472420010=SIMBarChart220014=PSBarChart220053=220059=CQG Sim20060=N";

		System.out.println(dictionary.isGroup("UZR", 20058));
		
		final Message message = new Message(messageString, dictionary, true);
		
		System.out.println();
		
	}

}
