package Project_1;
//project 1 student class: get grades
public class Student {
	private String studentID;
	private String name;
	private int quiz1;
	private int quiz2;
	private int midterm;
	private int finalexam;
	private double avg;
	private String grade;

	public Student() {
		studentID = "na";
		name = "na";
		quiz1 = 0;
		quiz2 = 0;
		midterm = 0;
		finalexam = 0;
		avg = 0.0;
		grade = "na";
	}

	public Student(String id, String n, int q1, int q2, int m, int f) {
		studentID = id;
		name = n;
		quiz1 = q1;
		quiz2 = q2;
		midterm = m;
		finalexam = f;
	}

	public Student(String id, String n, int q1, int q2, int m, int f, double a, String g) {
		studentID = id;
		name = n;
		quiz1 = q1;
		quiz2 = q2;
		midterm = m;
		finalexam = f;
		avg = a;
		grade = g;

	}

	public void set(String id, String n, int q1, int q2, int m, int f, double a, String g) {
		this.studentID = id;
		this.name = n;
		this.quiz1 = q1;
		this.quiz2 = q2;
		this.midterm = m;
		this.finalexam = f;
		this.avg = a;
		this.grade = g;

	}

	public void calcAvg() {
		avg = 0;
		avg += (quiz1) * 10.0 * .125;
		avg += (quiz2) * 10.0 * .125;
		avg += (midterm) * .25;
		avg += (finalexam) * .50;

	}

	public void calcGrade() {
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		} else {
			grade = "F";

		}
	}

	public String getID() {
		return studentID;
	}

	public String getName() {
		return name;
	}

	public int getQuiz1() {
		return quiz1;
	}

	public int getQuiz2() {
		return quiz2;
	}

	public int getMidterm() {
		return midterm;
	}

	public int getFinalexam() {
		return finalexam;
	}

	public double getAvg() {
		calcAvg();
		return avg;
	}

	public String getGrade() {
		calcGrade();
		return grade;
	}

}
