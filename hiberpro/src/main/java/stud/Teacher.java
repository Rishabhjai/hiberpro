package stud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Teacher {

	private String t_name;
	@Id
	private int T_id;
	@OneToMany(mappedBy = "teacher")
	private List<Student> students;

	
	public Teacher(String t_name, int t_id, ArrayList<Student> students) {
		super();
		this.t_name = t_name;
		T_id = t_id;
		this.students = students;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public int getT_id() {
		return T_id;
	}

	public void setT_id(int t_id) {
		T_id = t_id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return t_name + T_id + students;
	}

}
