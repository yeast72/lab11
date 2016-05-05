package student;

import java.util.List;

public class StudentApp {

	public void filterAndPrint( List<Student> students, int month ) {
		for(Student s : students ) {
			if (s.getBirthdate().getMonthValue() == month)
	                  System.out.println( s );
		}
	}
	
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		StudentApp app = new StudentApp();
		app.filterAndPrint(students, 5 /* may */);
	}
}
