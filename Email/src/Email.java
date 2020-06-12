import java.util.Scanner;

public class Email {
	
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity =500;
	private int passwordLength=10;
	private int mailboxCapacity;
	private String alternateEmail;
	private String companySuffix="code.com";
	
	
	public Email(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		
	
		this.department=setDepartment();
		
		this.password = randomPassword(passwordLength);
		System.out.println("YOUR PASSWORD:" + this.password);
		
		// Email creation
		email =  firstname.toLowerCase() +"."+lastname.toLowerCase() +"@"+department+"."+companySuffix;
		
	}
	
	
	private String setDepartment() {
		System.out.println("DEPARTNENT CODE \n1 for Sales\n2 for Dev\n3 for accounting\n0 for none");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice==1) {return "sales";}
		else if (depChoice==2) {return "dev";}
		else if (depChoice==3) {return "account";}
		else {return " ";}
	}
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
				char[] password = new char[length];
				for(int i=0;i<length; i++) {
					int rand= (int) (Math.random() * passwordSet.length());
					password[i]=passwordSet.charAt(rand);
				}
				return new String(password);
				
	}
	
	// Set mail box capacity -> e1.setmailboxcapacity()
	public void setmailboxcapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	// Set alternative mail -> e1.setAltMail()
	public void setAltMail(String altmail) {
		this.alternateEmail=altmail;
	}
	// Change password -> e1.ChangePAssword()
	public void changePassworg(String password) {
		this.password=password;
	}
	
	public int getMailBoxCapacity() {return mailboxCapacity;}
	public String getAltMail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return  "Name:" + firstname + " "  +lastname +
				"\nCompany Email: "+ email + 
				"\nMailBox capacity:" + mailboxCapacity+"mb";
	}
}
