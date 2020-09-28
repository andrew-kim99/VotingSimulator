
public class SCQ extends Question{
	
	int A, B, C, D, E;
	String finalAnswer;
	
		
	
	
	
	
	void verify(String[] question, String[][] studentID) {
		A = 0;
		B = 0;
		C = 0;
		D = 0;
		E = 0;
		
		int answer = Integer.parseInt(question[question.length-1]);
		finalAnswer = "";
		if (answer == 2)
			finalAnswer = "A";
		else if (answer == 3)
			finalAnswer = "B";
		else if (answer == 4)
			finalAnswer = "C";
		else if (answer == 5)
			finalAnswer = "D";
		else
			finalAnswer = "E";

		
		for (int i = 0; i < studentID.length; i++) {
			if (Integer.parseInt(studentID[i][1]) == 2) {
				A++;
			}
			else if (Integer.parseInt(studentID[i][1]) == 3) {
				B++;
			}
			else if (Integer.parseInt(studentID[i][1]) == 4) {
				C++;
			}
			else if (Integer.parseInt(studentID[i][1]) == 5) {
				D++;
			}
			else {
				E++;
			}
		}
		
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("RESULTS");
		System.out.println("The correct answer was " + finalAnswer + ". " + question[answer]);
		
		System.out.println();
		System.out.println(A + " students chose A. " + question[2]);
		System.out.println(B + " students chose B. " + question[3]);
		System.out.println(C + " students chose C. " + question[4]);
		System.out.println(D + " students chose D. " + question[5]);
		System.out.println(E + " students chose E. " + question[6]);
		
		String[] results = {Integer.toString(A), Integer.toString(B), Integer.toString(C), Integer.toString(D), 
				Integer.toString(E), finalAnswer}; 
		setResults(VotingService.getQuestionCounter()-2, results);
	}
	
}
