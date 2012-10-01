package quickfix;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

public class Test {

	/**
	 * @param args
	 * @throws ConfigError 
	 * @throws InvalidMessage 
	 */
	public static void main(String[] args) throws ConfigError, InvalidMessage {
		
		final DataDictionary dictionary = new DataDictionary("CQG_FIX_4.2.xml");
		
//		String messageString = 
//				"8=FIX.4.29=20135=UZR49=CQG_Gateway56=BarChartFIX134=257=Test FIX52=20120807-17:42:48.32120034=AuthAccountsRequest150893=Y" +
//						"20058=11=1680472320010=SIMBarChart120014=PSBarChart120053=220059=CQG Sim20060=N10=064" ;
////						+
////								 "1=1680472420010=SIMBarChart220014=PSBarChart220053=220059=CQG Sim20060=N";
//
//		System.out.println(dictionary.isGroup("UZR", 20058));
//		
//		final Message message = new Message(messageString, dictionary, true);
//		
//		System.out.println();
		
		final String execReport = "8=FIX.4.29=77335=849=CQG_Gateway56=BarChartFIX234=1657=Test FIX129=BarChartFIX252=20120926-14:38:02.567150=220=020026=FIX.4.21=1680472437=266538037198=CB9E-40E41B538308B91420111=20120926-14:38:02.49720029=26653803739=240=155=F.US.CLES2X1254=114=1.0000151=0.000038=1.000059=01028=Y17=50436237660=20120926-14:38:02.55050526=OrderID2665380376=-0.7600000031=-0.7600000032=1.000011=20120826~4442=320014=PSBarChart220010=SIMBarChart250555=250556=USD50600=F.US.CLEX1250624=150637=89.3800000050687=1.000020024=20120926-00:00:00.00020025=20120926-00:00:00.00020028=1556392150623=1.000050654=150556=USD50600=F.US.CLEF1350624=250637=90.1400000050687=1.000020024=20120926-00:00:00.00020025=20120926-00:00:00.00020028=1556392250623=1.000050654=210=134";
		
		Message fixMsg = null;
		
		try {
			
			fixMsg = new Message(execReport, dictionary);
			
			final List<Group> legs = fixMsg.getGroups(50555);
			
			printMessage(fixMsg);
			System.out.println(legs.size());
			assertTrue(legs.size() == 2);
			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	
		
	}
	
private static void printMessage(final Message m) {
		
		final Iterator<Field<?>> i = m.iterator();
		
		Field<?> f;
		while(i.hasNext()) {
			f = i.next();
			System.out.println(f.toString());
		}
		
	}

}
