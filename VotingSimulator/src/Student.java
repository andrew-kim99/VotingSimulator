import java.util.Random;
public class Student {
	//each student has an array with their ID, and a cell to submit their answer choices
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
	
	//this array will contain the students participating in the current simulation
	private static String[][] studentSet;
	
	static Random rng = new Random();
	
	public static void printStudents() {
		for (int i = 0; i < studentSet.length; i++) {
			System.out.println("Student " + (i+1) + ": " + studentSet[i][0]);
		}
	}
	
	//shuffle the order of studentID
	public static void randomizeInitialStudents() {
		for (int i = 0; i < studentID.length - 1; i++) {
			String[] temp = studentID[i];
			int swap = rng.nextInt((studentID.length-1)-i) + i;
			studentID[i] = studentID[swap];
			studentID[swap] = temp;
		}
	}
	
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
	
	public static void submitAnswersSCQ(String[] question) {
		
		//to vary the order in which students submit answers
		randomizeCurrentStudents();
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < studentSet.length; j++) {
				if (i > 0) {
					int rand = rng.nextInt(2);
					if(rand == 1) {
						studentSet[j][1] = "" + (rng.nextInt(7-2)+2);
						System.out.println(studentSet[j][0] + " has changed their answer(s).");
					}
				}
				else {
					studentSet[j][1] = "" + (rng.nextInt(7-2)+2);
					System.out.println(studentSet[j][0] + " has chosen their answer(s).");
				}
			}
		}
		Question q = new SCQ();
		q.verify(question, studentSet);
		
	}
	
	public static void submitAnswersMCQ(String[] question) {
		
		//to vary the order in which students submit answers
		randomizeCurrentStudents(); 
		
		/*this array is used to shuffle and randomize answer choices to prevent duplicate answers in one submission.
		the values are 2 through 6 because those are the cells in the question arrays that have the answer choices */
		String[] answerChoices = {"2", "3", "4", "5", "6"};
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < studentSet.length; j++) {
				if (i > 0) {
					int rand = rng.nextInt(2);
					if(rand == 1) {
						for (int k = 0; k < answerChoices.length - 1; k++) {
							String temp = answerChoices[k];
							int swap = rng.nextInt((answerChoices.length-1)-k)+k;
							answerChoices[k] = answerChoices[swap];
							answerChoices[swap] = temp;
						}
						int rand1 = (rng.nextInt(5-1) + 1);
						for (int k = 0; k < rand1; k++) {
							studentSet[j][1] =answerChoices[k] + " ";
						}
						System.out.println(studentSet[j][0] + " has changed their answer(s).");
					}
				}
				else {
					for (int k = 0; k < answerChoices.length - 1; k++) {
						String temp = answerChoices[k];
						int swap = rng.nextInt((answerChoices.length-1)-k)+k;
						answerChoices[k] = answerChoices[swap];
						answerChoices[swap] = temp;
					}
					int rand = (rng.nextInt(5-1) + 1);
					for (int k = 0; k < rand; k++) {
						studentSet[j][1] = answerChoices[k] + " ";
					}					
					System.out.println(studentSet[j][0] + " has chosen their answer(s).");
				}
			}
		}
		Question q = new MCQ();
		q.verify(question, studentSet);
		
	}
}
