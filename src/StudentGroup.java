import java.util.Date;

/**
 * A fix-sized array of students array length should always be equal to the
 * number of stored elements after the element was removed the size of the array
 * should be equal to the number of stored elements after the element was added
 * the size of the array should be equal to the number of stored elements null
 * elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given
 * class, interface or method DO NOT PUT any classes into packages
 * 
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;


	/**
	 * DO NOT remove or change this constructor, it will be used during task
	 * check
	 * 
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	public void setStudents(Student[] students) throws IllegalArgumentException {
		if (students == null) {
			throw new IllegalArgumentException();
		}
		this.students = students;
	}

	public Student getStudent(int index) {
		if (index < 0 || index >= getStudentsLength()) {
			throw new IllegalArgumentException();
		}
		return this.students[index];
	}

	public void setStudent(Student student, int index)
			throws IllegalArgumentException {
		if (student == null) {
			throw new IllegalArgumentException();
		} else if (index < 0 || index >= getStudentsLength()) {
			throw new IllegalArgumentException();
		}
		this.students[index] = student;
	
	}

	public void addFirst(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if (student == null)
			throw new IllegalArgumentException();
		this.students[0] = student;
	}

	public void addLast(Student student) {
		// Add your implementation here
		if (student == null)
			throw new IllegalArgumentException();
		/*
		 * int index = 0; while(this.students[index]!=null){ index++; }
		 */
		// this.students[index] = student;
		// add(student, index);
		add(student, getStudentsLength());
	}

	public void add(Student student, int index) throws IllegalArgumentException {
		if (student == null) {
			throw new IllegalArgumentException();
		} else if (index < 0 || index >= getStudentsLength()) {
			throw new IllegalArgumentException();
		}
		this.students[index] = student;
		
	}

	public void remove(int index) throws IllegalArgumentException {
		// Add your implementation here
		int i;
		if (index < 0 || index >= getStudentsLength()) {
			throw new IllegalArgumentException("Student not exist");
		}
		for (i = index; i < getStudentsLength(); i++) {
			students[index] = students[index + 1];
		}
		students[i - 1] = null;

	}

	public void remove(Student student) throws IllegalArgumentException {
		// Add your implementation here
		int index = 0;
		if (student == null) {
			throw new IllegalArgumentException();
		}
		while (index < getStudentsLength()) {
			if (student.getId() == students[index].getId()) {
				remove(index);
			}
			index++;
		}

	}

	public void removeFromIndex(int index) throws IllegalArgumentException {
		// Add your implementation here
		if (index < 0 || index >= getStudentsLength()) {
			throw new IllegalArgumentException();
		}
		for (int i = index + 1; i < getStudentsLength(); i++) {
			remove(i);
		}

	}

	public void removeFromElement(Student student)
			throws IllegalArgumentException {
		// Add your implementation here
		int index = 0;
		if (student == null) {
			throw new IllegalArgumentException();
		}
		while (index < getStudentsLength()) {
			if (student.getId() == students[index].getId()) {
				removeFromIndex(index);
			}
			index++;
		}
	}

	public void removeToIndex(int index) throws IllegalArgumentException {
		// Add your implementation here
		if (index < 0 || index >= getStudentsLength()) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < index; i++) {
			remove(i);
		}
	}

	public void removeToElement(Student student) {
		// Add your implementation here
		int index = 0;
		if (student == null) {
			throw new IllegalArgumentException();
		}
		while (index < getStudentsLength()) {
			if (student.getId() == students[index].getId()) {
				removeToIndex(index);
			}
			index++;
		}
	}

	public void bubbleSort() {
		for (int i = getStudentsLength() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (students[j + 1] == null) {
					continue;
				}
				if (students[j] == null
						|| students[j + 1].compareTo(students[j]) < 0) {
					Student temp = students[j + 1];
					students[j + 1] = students[j];
					students[j] = temp;
				}
			}
		}
	}

	public Student[] getByBirthDate(Date date) throws IllegalArgumentException {
		// Add your implementation here
		Student [] bornBeforeDateStudents = new Student[getStudentsLength()];
		int k = 0;
		if(date==null)
			throw new IllegalArgumentException();
		else{
			for(int i=0;i<getStudentsLength();i++){
				if(students[i].getBirthDate().compareTo(date)<=0){
					bornBeforeDateStudents[k]=students[i];
					k++;
				}
			}
		}
		return bornBeforeDateStudents;
	}

	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		Student [] bornBetweenDatesStudents = new Student[getStudentsLength()];
		int k = 0;
		if(firstDate == null || lastDate == null)
			throw new IllegalArgumentException();
		else{
			for(int i=0;i<getStudentsLength();i++){
				if(students[i].getBirthDate().compareTo(firstDate)>=0 || students[i].getBirthDate().compareTo(lastDate)<=0){
					bornBetweenDatesStudents[k]=students[i];
					k++;
				}
			}
		}
		return bornBetweenDatesStudents;
	}

	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}

	private int getStudentsLength() {
		int length = 0;
		while (this.students[length] != null) {
			length++;
		}
		return length;
	}
}
