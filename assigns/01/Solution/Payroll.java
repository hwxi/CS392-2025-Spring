/*
**
** Solution to Assignment 1, CAS CS112, Spring 2010
** Author: Rui Shi (?) // TA: CAS CS112, Spring 2007
**
*/
public class Payroll {
	public static final int INITIAL_MAXIMUM_SIZE = 1024;
	public Payroll() {
		people = new Employee[INITIAL_MAXIMUM_SIZE];
		maximum_size = INITIAL_MAXIMUM_SIZE;
		current_size = 0;
	};
	public int size() { return current_size; };
	public void print() {
		Employee p;
		for (int i = 0; i < current_size ; i++) {
			p = people[i];
			System.out.println("No." + (i+1) + "\t" + p.name + "(" + p.ID + ")");
		}
	}
	public void add_employee(Employee newbie) {
		if (maximum_size > current_size) {
			people[current_size++] = newbie ;
		} else {
			double_maximum_size ();
			people[current_size++] = newbie ;
		}
		return;
	}
	public void remove_employee(int i) throws EmployeeIndexException {
		if (i < 0) throw (new EmployeeIndexException());
		if (i >= current_size) throw (new EmployeeIndexException());
		for (int k = i+1; k < current_size; k++) {
		    people[k-1] = people[k];
		}
		current_size-- ;
		return ;
	}
	public int find_employee(String name) throws EmployeeNotFoundException {
		for (int i = 0; i < current_size; i++) {
			if (name.equals(people[i].name)) return i;
		}
		throw (new EmployeeNotFoundException ());
	}
	
	public void add_payroll(Payroll source) {
		Employee p[] = people;
		int sz = current_size + source.current_size ;

		if (maximum_size >= sz) {
			for (int i = current_size; i < source.current_size; i++)
				people[i] = source.people[i] ;
		} else { // need to allocate enough space to hold both payrolls
			while (maximum_size < sz) maximum_size *= 2;
			people = new Employee[maximum_size];
			for (int i = 0; i < current_size; i++) people[i] = p[i];
			for (int i = 0; i < source.current_size; i++)
				people[i+current_size] = source.people[i];
		}	  
		return ;
	}
	
	public void copy_payroll(Payroll source) {
		current_size = 0;
		add_payroll(source);
		return;
	}

	private Employee people[];
	private int maximum_size;
	private int current_size;
	private void double_maximum_size() {
		maximum_size *= 2 ;
		Employee p[] = new Employee[maximum_size];
		for (int i = 0; i < current_size; i++) {
			p[i] = people[i]; // copy current payroll
		}
		people = p; // the original array in [people] now becomes garbage
		return;
	}
}
