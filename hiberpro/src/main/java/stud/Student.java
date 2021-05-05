package stud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student_hib")
public class Student {
	@Column(name = "S_name")
	private String name;
	@Id
	@Column(name = "S_id")
	private int id;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@ManyToOne
	private Teacher teacher;

	public String getName() {
		return name;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student(String name, int id, Teacher teacher) {
		super();
		this.name = name;
		this.id = id;
		this.teacher = teacher;
	}

}
