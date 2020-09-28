

public class VotingService {
	
	
	private static int questionCounter = 1;
	
	
	public static int getQuestionCounter() {
		return questionCounter;
	}
	
	
	public static void runSimulation(String[][] questionSet) {
		for(int i = 0; i < questionSet.length; i++) {
			if (Integer.parseInt(questionSet[i][0])==1) {
				runQuestionSCQ(questionSet[i]);
			}
			else
				runQuestionMCQ(questionSet[i]);
		}
	}
	
	
	//This method deals with questions that only allow single choice answers.
	public static void runQuestionSCQ(String[] question) {
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("QUESTION " + questionCounter++);
		System.out.println();
		System.out.println("Choose one answer: " + question[1]);
		System.out.println();
		System.out.println("A: " + question[2]);
		System.out.println("B: " + question[3]);
		System.out.println("C: " + question[4]);
		System.out.println("D: " + question[5]);
		System.out.println("E: " + question[6]);
		System.out.println("---------------------------------------");
		Student.submitAnswersSCQ(question);
	}
	
	//this method deals with questions that allow multiple answers
	public static void runQuestionMCQ(String[] question) {
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("QUESTION " + questionCounter++);
		System.out.println();
		System.out.println("You may choose multiple answers: " + question[1]);
		System.out.println();
		System.out.println("A: " + question[2]);
		System.out.println("B: " + question[3]);
		System.out.println("C: " + question[4]);
		System.out.println("D: " + question[5]);
		System.out.println("E: " + question[6]);
		System.out.println("---------------------------------------");
		Student.submitAnswersMCQ(question);
	}
	
	public static void finalOutput() {
		System.out.println("---------------------------------------");
		System.out.println("FINAL RESULTS");
		System.out.println();
		String[][] results = Question.getResults();
		for (int i = 0; i < results.length; i++) {
			System.out.println("Question " + (i+1) + " voting results:");
			System.out.println();
			for(int j = 0; j < 5; j++) {
				if(j == 0)
					System.out.println(Integer.parseInt(results[i][j]) + " students chose A.");
				else if (j == 1)
					System.out.println(Integer.parseInt(results[i][j]) + " students chose B.");
				else if (j == 2)
					System.out.println(Integer.parseInt(results[i][j]) + " students chose C.");
				else if (j == 3)
					System.out.println(Integer.parseInt(results[i][j]) + " students chose D.");
				else
					System.out.println(Integer.parseInt(results[i][j]) + " students chose E.");
				
				
			}
			System.out.println();
			System.out.println("---------------------------------------");
		}
	}
	
}
