package entrypoint;

import core.domain.Cases;

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
		
		System.out.println("\n");
		Cases.Case2();
	}
	
}
