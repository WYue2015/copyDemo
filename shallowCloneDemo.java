public class shallowCloneDemo{
	
	public void shallowCopy(){
		
		StringBuffer engStrBuf=new StringBuffer("englishA");
		StringBuffer mathStrBuf=new StringBuffer("mathA");
		Teacher teacher=new Teacher(engStrBuf,mathStrBuf );
		Student stu=new Student(2016, "Mars", teacher);
		
		System.out.println("******************shallow copy******************\n");
		
		System.out.println("---before copying---");
		System.out.println(stu);
		System.out.println("---after copying---");
		Student stuCopy=(Student) stu.clone();
		System.out.println(stuCopy);
		
		System.out.println("\n------modify attribution of teacher------");
		engStrBuf.replace(0, engStrBuf.length(), "englishB");
		mathStrBuf.replace(0, mathStrBuf.length(), "mathB");
		System.out.println("---show stu and stuCopy---");
		System.out.println(stu);
		System.out.println(stuCopy);
	}
	
	public static void main(String[] args){
		
		new shallowCloneDemo().shallowCopy();
	}

}

class Student implements Cloneable{

	private int id;
	private String name;
	private Teacher teacher;
	
	//constructor
	public Student(int id,String name,Teacher teacher){
		this.id=id;
		this.name=name;
		this.teacher=teacher;
	}

	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", teacher: " + teacher + "]";
	}

	//shallow copy
	public Object clone(){
		Student stu=null;
		try {
			stu = (Student)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return stu;
	}
}

class Teacher{

	private StringBuffer englishTeacher;
	private StringBuffer mathTeacher;

	//constructor
	public Teacher(StringBuffer enTeach,StringBuffer maTeacher){
		this.englishTeacher=enTeach;
		this.mathTeacher=maTeacher;
	}

	public String toString() {
		return "englishTeacher=" + englishTeacher + ", mathTeacher=" + mathTeacher;
	}
	
}
