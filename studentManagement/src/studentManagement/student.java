package studentManagement;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private String courses=null; 
	private int tuationBalance=0;
	private static int cost=600;
	private static int id=1000;
 
	
	public student() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Student first name");
		this.firstName = in.nextLine();
		
		System.out.println("Enter Student last name");
		this.lastName = in.nextLine();
		
		System.out.println("1-fresher \n2-Shophmore \n3-junior \n4-senior \nEnter Student class level");
		this.gradeYear = in.nextInt();
		

		setStudentID();
		//System.out.println(firstName+" "+ lastName+" "+gradeYear+" "+studentId);
		
		
		
	}
	
	private void setStudentID() {
		
		id++;
		this.studentId = gradeYear + "" + id ;
	}
	
	public void enroll() {
		do {
		System.out.println("Enter course to enroll (Q to quite)");
		Scanner in = new Scanner(System.in);
		String course = in.nextLine();
		
		if (!course.equals("Q")) {
			courses = courses + "\n" + course;
			tuationBalance = tuationBalance+cost;
		}
		else {
			break;
		}
		}while(1 != 0);
				
	}
	 public void viewBalance() {
		 System.out.println("your balance is: $" + tuationBalance);
	 }
	
	 public void payTuation() {
		 System.out.println("Enter amount:");
		 Scanner in = new Scanner(System.in);
		 int payment = in.nextInt();
		 tuationBalance = tuationBalance-payment;
		 System.out.println("Thank you for Payment of $ "+payment);
		 viewBalance();
	 }
	
	public String toString() {
		return "Name:" +firstName + lastName +
				"\n Gread:" + gradeYear +
				"\n StudentId" + studentId +
				"\n Course enrolled" + courses +
				"\n Balance"+ tuationBalance;
				}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			}

}
