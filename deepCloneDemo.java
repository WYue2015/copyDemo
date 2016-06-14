public class deepCloneDemo{
	
	public void deepCopy(){
		
		StringBuffer engStrBuf=new StringBuffer("englishA");
		StringBuffer mathStrBuf=new StringBuffer("mathA");
		Teacher teacher=new Teacher(engStrBuf,mathStrBuf );
		Student stu=new Student(2016, "Mars", teacher);
		
		System.out.println("******************deep copy******************\n");
		
		System.out.println("---before copying---");
		System.out.println(stu);
		System.out.println("---after copying---");
		Student stuCopy=(Student)stu.clone();
		System.out.println(stuCopy);
		
		System.out.println("\n------modify attribution of teacher------");
		engStrBuf.replace(0, engStrBuf.length(), "englishB");
		mathStrBuf.replace(0, mathStrBuf.length(), "mathB");
		System.out.println("---show stu---");
		System.out.println(stu);
		System.out.println("---show stuCopy---");
		System.out.println(stuCopy);
	}
	
	public static void main(String[] args){
		
		new deepCloneDemo().deepCopy();
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

	public Teacher getTeacher() {
		return teacher;
	}

	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", teacher: " + teacher + "]";
	}

	//deep copy
	public Object clone(){
		Student stu=null;
		try {
			stu = (Student)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		stu.teacher=(Teacher) this.getTeacher().clone();
		return stu;
	}
}

class Teacher implements Cloneable{

	private StringBuffer englishTeacher;
	private StringBuffer mathTeacher;

	//constructor
	public Teacher(StringBuffer enTeach,StringBuffer maTeacher){
		this.englishTeacher=enTeach;
		this.mathTeacher=maTeacher;
	}
	
	public StringBuffer getEnglishTeacher() {
		return englishTeacher;
	}

	public StringBuffer getMathTeacher() {
		return mathTeacher;
	}

	//deep copy
	public Object clone(){
		
		Teacher teacher=null;
		try {
			teacher=(Teacher)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		teacher.englishTeacher=new StringBuffer(this.getEnglishTeacher().toString());
		teacher.mathTeacher=new StringBuffer(this.getMathTeacher().toString());
		
		return teacher;
	}

	public String toString() {
		return "englishTeacher=" + englishTeacher + ", mathTeacher=" + mathTeacher;
	}
}
