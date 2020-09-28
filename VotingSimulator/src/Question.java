import java.util.Random;

public abstract class Question {
	/*each question has its own array, where the first cell is the question type, (1 = single choice, 2 = multiple choice),
	the second cell is the question, then the next 5 cells are answer choice. The last cell will contain the array cell
	that has the correct answer. If it has more than one answer, I will use a split method and then parseInt to get each cell*/
	private static String[] questionA = {"1", "What city is the Capital of California?", "Los Angeles", "San Diego", "Pomona", 
			"Sacramento", "Redding", "5"};
	private static String[] questionB = {"1", "Which NBA team won the 2019 Championship?", "LA Lakers", "Boston Celtics", "Golden State Warriors", 
			"Milwaukee Bucks", "Toronto Raptors", "6"};
	private static  String[] questionC = {"2", "Who was a part of the song I'm the One by DJ Khaled?", "Travis Scott", "Justin Bieber", "Lil Wayne", 
			"Chance the Rapper", "Drake", "3 4 5"};
	private static String[] questionD = {"1", "Who is the current President of the US?", "Barack Obama", "Hillary Clinton", "Donald Trump", 
			"Joe Rogan", "Joe Biden", "4"};
	private static String[] questionE = {"2", "Which food provider is located on campus?", "Roundtable", "Chipotle", "Qdoba", 
			"McDonald's", "In-n-Out", "2 4"};
	private static String[] questionF = {"1", "Which company sells the gaming console, PlayStation?", "Sony", "Apple", "Microsoft", 
			"Dell", "LG", "2"};
	private static String[] questionG = {"1", "How many states are in the United States?", "44", "7", "52", "50", "35", "5"};
	private static String[] questionH = {"2", "Which of these brands are known for burgers?", "In-n-Out", "McDonald's", "Taco Bell", 
			"Chipotle", "Dominos", "2 3"};
	private static String[] questionI = {"2", "Which of these countries are located in Asia?", "Korea", "Mexico", "Canada", 
			"Japan", "China", "2 5 6"};
	private static String[] questionJ = {"1", "What state is Miami located in?", "Lousiana", "Texas", "Florida", "New York", "California", "4"};
	
	private static String[][] questions = {questionA, questionB, questionC, questionD, questionE, questionF, questionG, questionH, questionI, questionJ};
	
	private static String[][] questionSet = new String[5][];
	
	private static String[][] totalResults = new String[5][];
	
	
	public static String[][] getResults() {
		return totalResults;
	}
	public void setResults(int counter, String[] results) {
		totalResults[counter] = results;
	}
	
	//randomize and initialize a set of questions to be used for the simulation
	public static void setQuestions(){
		Random rng = new Random();
		for (int i = 0; i < questions.length - 1; i ++) {
			String[] temp = questions[i];
			int swap = rng.nextInt((questions.length-1) - i) + i;
			questions[i] = questions[swap];
			questions[swap] = temp;					
		}
		
		for(int i = 0; i < 5; i++) {
			questionSet[i] = questions[i];
		}
	};
	
	//method to get the set of questions for the simulation
	public static String[][] getQuestions(){
		return questionSet;
	}
	
	
	abstract void verify(String[] questions, String[][] studentSet);
	
}
