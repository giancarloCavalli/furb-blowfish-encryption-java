package entrypoint;

import core.services.Cases;

public class Main {

	public static void main(String[] args) {
		try {
			presentCases();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void presentCases() throws Exception {
		Cases.Case1();
		
		System.out.println("\n==============");
		Cases.Case2();
		
		System.out.println("\n==============");
		Cases.Case3();
		
		System.out.println("\n==============");
		Cases.Case4();
		
		System.out.println("\n==============");
		Cases.Case5();
	}
	
}
