package studentManagement;

public class studentDatabaseApp {

	public static void main(String[] args)
	{
		student stu1 =  new student();	
		stu1.enroll();
		stu1.payTuation();
		System.out.println(stu1.toString());
		}
}
