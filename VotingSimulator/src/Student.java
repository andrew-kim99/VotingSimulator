import java.util.Random;
public class Student {
	//each student has an array with their ID, and a cell to hold their answer choices
	private static String[] studentA = {"TetrisGod32", ""};
	private static String[] studentB = {"MapleWarrior", ""};
	private static String[] studentC = {"ValorantLoL", ""};
	private static String[] studentD = {"Tyler1", ""};
	private static String[] studentE = {"LebronJames23", ""};
	private static String[] studentF = {"LaKeRsIn4", ""};
	private static String[] studentG = {"RIPKobe", ""};
	private static String[] studentH = {"XXDeathSlayerXX", ""};
	private static String[] studentI = {"CoDKing99", ""};
	private static String[] studentJ = {"s1mple", ""};
	private static String[] studentK = {"CSMonster", ""};
	private static String[] studentL = {"OOPGOD", ""};
	private static String[] studentM = {"RedeemedMonkey", ""};
	private static String[] studentN = {"CookingMamaPro", ""};
	private static String[] studentO = {"DonkeyK0ng", ""};
	
	//this array is a set of all current students in the system
	private static String[][] studentID = {studentA, studentB, studentC, studentD, studentE, studentF, studentG, studentH, studentI, studentJ,
			studentK, studentL, studentM, studentN, studentO};
	
	//this array will contain the students participating in the current simulation after being randomly chosen
	private static String[][] studentSet;
	
	static Random rng = new Random();
	
	//print's the list of students participating in the current simulation
	public static void printStudents() {
		for (int i = 0; i < studentSet.length; i++) {
			System.out.println("Student " + (i+1) + ": " + studentSet[i][0]);
		}
	}
	
	//shuffles the order of studentID
	public static void randomizeInitialStudents() {
		for (int i = 0; i < studentID.length - 1; i++) {
			String[] temp = studentID[i];
			int swap = rng.nextInt((studentID.length-1)-i) + i;
			studentID[i] = studentID[swap];
			studentID[swap] = temp;
		}
	}
	
	//takes the shuffled order of students from studentID and fills up the studentSet array to be used for the current simulation
	public static void randomizeCurrentStudents() {
		for (int i = 0; i < studentSet.length - 1; i++) {
			String[] temp = studentSet[i];
			int swap = rng.nextInt((studentSet.length-1)-i) + i;
			studentSet[i] = studentSet[swap];
			studentSet[swap] = temp;
		}
	}
	
	//randomly determine how many students to use for the simulation from 10 to 15, then initialize studentSet and return the student count
	public static int getStudentSize() {
		studentSet = new String[rng.nextInt(15-10)+10][];
		
		for (int i = 0; i < studentSet.length; i++) 
			studentSet[i] = studentID[i];
		
		return studentSet.length;
	}
	
	//this method deals with all the answer submissions for a single choice question
	public static void submitAnswersSCQ(String[] question) {
		
		//to vary the order in which students submit answers
		randomizeCurrentStudents();
		//the first for loop runs twice, so students get a chance to change their answers in the second run through
		for(int i = 0; i < 2; i++) {
			//this for loop is split into a big if-else statement to separate between a student's first answer and if they want to override their answer
			for(int j = 0; j < studentSet.length; j++) {
				//this condition is if they have already answers before.
				if (i > 0) {
					int rand = rng.nextInt(2);
					//this random number generator is to determine if the student will submit a new answer or not. Chances are 50/50
					if(rand == 1) {
						studentSet[j][1] = "" + (rng.nextInt(7-2)+2);
						System.out.println(studentSet[j][0] + " has changed their answer(s).");
					}
				}
				//this condition is if they have no answered yet.
				else {
					studentSet[j][1] = "" + (rng.nextInt(7-2)+2);
					System.out.println(studentSet[j][0] + " has chosen their answer(s).");
				}
			}
		}
		//instantiates an SCQ object that inherits Question's attributes and methods
		Question q = new SCQ();
		//verify the submissions with the answer
		q.verify(question, studentSet);
		
	}
	
	
	//very similar to the method above, but this method deals with questions that allow multiple answers
	public static void submitAnswersMCQ(String[] question) {
		
		//to vary the order in which students submit answers
		randomizeCurrentStudents(); 
		
		/*this array is used to shuffle and randomize answer choices to prevent duplicate answers in one submission.
		the values are 2 through 6 because those are the cells in the question arrays that have the answer choices */
		String[] answerChoices = {"2", "3", "4", "5", "6"};
		
		//first for loop is to run through twice, allowing students a chance to change their answers the second time around
		for(int i = 0; i < 2; i++) {
			//second for loop split into big if else statement to see if a student has already answered.
			for(int j = 0; j < studentSet.length; j++) {
				//if student has already answered
				if (i > 0) {
					int rand = rng.nextInt(2);
					//they will change their answer
					if(rand == 1) {
						for (int k = 0; k < answerChoices.length - 1; k++) {
							String temp = answerChoices[k];
							int swap = rng.nextInt((answerChoices.length-1)-k)+k;
							answerChoices[k] = answerChoices[swap];
							answerChoices[swap] = temp;
						}
						//determine how many answers to choose
						int rand1 = (rng.nextInt(5-1) + 1);
						//send String of answers back into answer cell
						for (int k = 0; k < rand1; k++) {
							studentSet[j][1] =answerChoices[k] + " ";
						}
						System.out.println(studentSet[j][0] + " has changed their answer(s).");
					}
				}
				//first time answering question
				else {
					for (int k = 0; k < answerChoices.length - 1; k++) {
						String temp = answerChoices[k];
						int swap = rng.nextInt((answerChoices.length-1)-k)+k;
						answerChoices[k] = answerChoices[swap];
						answerChoices[swap] = temp;
					}
					//determine how many answers to choose
					int rand = (rng.nextInt(5-1) + 1);
					//send String of answers in answer cell
					for (int k = 0; k < rand; k++) {
						studentSet[j][1] = answerChoices[k] + " ";
					}					
					System.out.println(studentSet[j][0] + " has chosen their answer(s).");
				}
			}
		}
		//instantiate MCQ object that inherits Question's attributes and methods
		Question q = new MCQ();
		//verify submissions with answers
		q.verify(question, studentSet);
		
	}
}
