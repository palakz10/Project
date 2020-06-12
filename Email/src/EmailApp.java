import java.io.ObjectInputStream.GetField;

public class EmailApp {

	public static void main(String[] args) {
		Email em1 = new Email ("palak","patel");
		
		em1.setAltMail("pal@gmail.com");
		System.out.println("Alter mail:"+ em1.getAltMail());
		
		System.out.println(em1.showInfo());

	}

}
