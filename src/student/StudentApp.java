package student;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * 
 * @author Wisarut Boonnumma
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * 
	 * @param students
	 *            list of students
	 * @param month
	 *            the month to use in selecting bithdays
	 * @param filter
	 *            test something
	 * 
	 * @param action
	 *            do something
	 * @param sorter
	 *            sort by something
	 */
	public void filterAndPrint(List<Student> students,
			Predicate<Student> filter, Consumer<Student> action,
			Comparator<Student> sorter) {
		students.sort(sorter);
		students.stream().filter(filter).sorted(sorter).forEach(action);

	}

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		List<Student> students = Registrar.getInstance().getStudents();
		Predicate<Student> birthDateInMonth = s -> s.getBirthdate().getMonthValue() == localDate
				.getMonthValue();
		Predicate<Student> birthDayCoomingSoon = s -> s.getBirthdate().getDayOfYear() <= localDate
				.getDayOfYear() + 14
				&& s.getBirthdate().getDayOfYear() > localDate.getDayOfYear();
		Consumer<Student> action = (s) -> System.out.println(s.getFirstname()
				+ " " + s.getLastname() + " " + "will have birthday on "
				+ s.getBirthdate().getDayOfMonth() + " "
				+ s.getBirthdate().getMonth() + ".");

		Comparator<Student> byName = (a, b) -> (a.getFirstname().charAt(0) - b
				.getFirstname().charAt(0));
		Comparator<Student> byBirthday = (a, b) -> (a.getBirthdate()
				.getDayOfYear() - b.getBirthdate().getDayOfYear());

		StudentApp app = new StudentApp();
		app.filterAndPrint(students, birthDayCoomingSoon, action, byBirthday);
	}
}
