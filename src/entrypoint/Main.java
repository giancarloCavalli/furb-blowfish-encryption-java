package entrypoint;

import core.services.ActivityLoggingService;

public class Main {
	
	private ActivityLoggingService activityLogging = new ActivityLoggingService();

	public void main(String[] args) {
		try {
			presentCases();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void presentCases() throws Exception {
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
	}
	
}
