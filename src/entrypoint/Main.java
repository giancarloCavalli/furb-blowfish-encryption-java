package entrypoint;

import core.services.ActivityLoggingService;

public class Main {
	
	private static final ActivityLoggingService activityLogging = new ActivityLoggingService();

	public static void main(String[] args) {
		try {
			presentCases();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void presentCases() throws Exception {
		activityLogging.Case1();
		
		System.out.println("\n==============");
		activityLogging.Case2();
		
		System.out.println("\n==============");
		activityLogging.Case3();
		
		System.out.println("\n==============");
		activityLogging.Case4();
		
		System.out.println("\n==============");
		activityLogging.Case5();
		
		System.out.println("\n==============");
		activityLogging.Case5();
		
		System.out.println("\n==============");
		activityLogging.Case6();
		
		System.out.println("\n==============");
		activityLogging.Case7();
	}
	
}
