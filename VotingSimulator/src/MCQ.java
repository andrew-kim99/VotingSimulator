
public class MCQ extends Question {
	int A, B, C, D, E;//counters for each answer choice
	
	String answer1, answer2, answer3, answer4;//with their possibly being up to 4 answers, each of these variables can hold an answer
	
	//an array that will contain all the correct answers
	String[] answers;
	
	
	
	
	
	
	void verify(String[] question, String[][] studentID) {
		A = 0;
		B = 0;
		C = 0;
		D = 0;
		E = 0;
		
		//split the string of integers into an array that will hold each String type integer in a different cell
		String[] strArr = question[question.length-1].split("\\s+");
		
		//initialize answers' size to be the length of the strArr array
		answers = new String[strArr.length];
		//store strArr's values into the answers array
		for(int i = 0; i < strArr.length; i++) {
			answers[i] = strArr[i];
		}
		//depending on how many answers are in the strArr array, place them into the appropriate number of answer variables
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
		

		//check each answer submitted by a student with the different answer choices and increment the counters each time an answer is picked
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
		//just converts the answers to letter form for printing purposes
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
		//prints the answers accordingly with correct punctuation in mind
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
		
		//set results depending on how many answers there are 
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
