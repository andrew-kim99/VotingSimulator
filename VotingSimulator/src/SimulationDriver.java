
public class SimulationDriver {
	public static void main (String[] args) {
		
		System.out.println("Welcome to the Voting Simulator!");
		
		//grab a randomized set of 5 questions 
		Question.setQuestions();
		
		//get a randomized amount of students from 10 to 15 based on a predetermined set of 15 students
		Student.randomizeInitialStudents();
		System.out.println("There are currently " + Student.getStudentSize() + " students in this simulation.");
		
		Student.printStudents();
		
		VotingService.runSimulation(Question.getQuestions());
		
		System.out.println();
		
		VotingService.finalOutput();
	}
}
