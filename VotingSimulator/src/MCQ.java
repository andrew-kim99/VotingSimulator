
public class MCQ extends Question {
	int A, B, C, D, E;
	
	String answer1, answer2, answer3, answer4;
	
	//an array that will contain all the correct answers
	String[] answers;
	
	
	
	
	
	
	void verify(String[] question, String[][] studentID) {
		A = 0;
		B = 0;
		C = 0;
		D = 0;
		E = 0;
		
		String[] strArr = question[question.length-1].split("\\s+");
		
		answers = new String[strArr.length];
		for(int i = 0; i < strArr.length; i++) {
			answers[i] = strArr[i];
		}
		if(strArr.length == 2) {
			answer1 = strArr[0];
			answer2 = strArr[1];
		}
		else if (strArr.length == 3) {
			answer1 = strArr[0];
			answer2 = strArr[1];
			answer3 = strArr[2];
		}
		else {
			answer1 = strArr[0];
			answer2 = strArr[1];
			answer3 = strArr[2];
			answer4 = strArr[3];
		}
		

		
		for (int i = 0; i < studentID.length; i++) {
			String[] ans = studentID[i][1].split("\\s+");
			
			for(int j = 0; j < ans.length; j++) {
				if(Integer.parseInt(ans[j]) == 2)
					A++;
				else if(Integer.parseInt(ans[j]) == 3)
					B++;
				else if(Integer.parseInt(ans[j]) == 4)
					C++;
				else if(Integer.parseInt(ans[j]) == 5)
					D++;
				else
					E++;
			}
			
		}
		
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("RESULTS");
		System.out.print("The correct answers were ");
		
		String[] letterAnswers = new String[strArr.length];
		for(int i = 0; i < strArr.length; i++) {
			if (Integer.parseInt(strArr[i]) == 2)
				letterAnswers[i] = "A";
			else if (Integer.parseInt(strArr[i]) == 3)
				letterAnswers[i] = "B";
			else if (Integer.parseInt(strArr[i]) == 4)
				letterAnswers[i] = "C";
			else if (Integer.parseInt(strArr[i]) == 5)
				letterAnswers[i] = "D";
			else 
			letterAnswers[i] = "E";
		}
	
		for(int i = 0; i < strArr.length; i++) {
			if(i != strArr.length-1 && strArr.length !=2) {
				System.out.print(letterAnswers[i] + ", ");
			}
			else if (i != strArr.length-1 && strArr.length == 2) {
				System.out.print(letterAnswers[i] + " ");
			}	
			else {
				System.out.print("and " + letterAnswers[i] + ".");
			}
		}
		System.out.println();
		
		System.out.println();
		System.out.println(A + " students chose A. " + question[2]);
		System.out.println(B + " students chose B. " + question[3]);
		System.out.println(C + " students chose C. " + question[4]);
		System.out.println(D + " students chose D. " + question[5]);
		System.out.println(E + " students chose E. " + question[6]);
		

		if(strArr.length==2) {
			//for if there are 2 correct answers
			String[] results2 = {Integer.toString(A), Integer.toString(B), Integer.toString(C), Integer.toString(D), 
					Integer.toString(E), answer1, answer2}; 
			setResults(VotingService.getQuestionCounter()-2, results2);
		}
		else if(strArr.length==3) {
			//for if there are 3 correct answers
			String[] results3 = {Integer.toString(A), Integer.toString(B), Integer.toString(C), Integer.toString(D), 
					Integer.toString(E), answer1, answer2, answer3};
			setResults(VotingService.getQuestionCounter()-2, results3);
		}
		else {
			//for if there are 4 correct answers
			String[] results4 = {Integer.toString(A), Integer.toString(B), Integer.toString(C), Integer.toString(D), 
					Integer.toString(E), answer1, answer2, answer3, answer4}; 
			setResults(VotingService.getQuestionCounter()-2, results4);
		}
		
	}
}
