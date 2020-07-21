package covid;
import java.io.*;
import java.util.Scanner;

public class CityIO {
	
	private final String FILENAME = "CityData.txt";
	private File fileName = new File(FILENAME);
	
	public boolean saveCity(City city) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName, true));
			out.print(city.getDate()+" ");
			out.print(city.getNameOfCity()+" ");
			out.print(city.getNewCs()+" ");
			out.print(city.getTotCs()+" ");
			out.print(city.getDeath()+" ");
			out.print(city.getRecovCs()+" ");
			out.println();
			out.close();
			return true;	
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			return false;
		}
		
	}
	
	public City findCity(String citys,String cityn) throws IOException {
		
			Scanner in = new Scanner(fileName);
				City ct= new City();
				while(in.hasNext()) {
					ct.setDate(in.next());
					ct.setNameOfCity(in.next());
					ct.setNewCs(Integer.parseInt(in.next()));
	 				ct.setTotCs(Integer.parseInt(in.next()));
					ct.setDeath(Integer.parseInt(in.next()));
					ct.setRecovCs(Integer.parseInt(in.next()));
					//String abc = in.nextLine();
					
					if((ct.getDate().equalsIgnoreCase(citys) || ct.getNameOfCity().equalsIgnoreCase(citys) || Integer.toString(ct.getNewCs()).equalsIgnoreCase(citys)
							|| Integer.toString(ct.getTotCs()).equalsIgnoreCase(citys) || Integer.toString(ct.getDeath()).equalsIgnoreCase(citys) || Integer.toString(ct.getRecovCs()).equalsIgnoreCase(citys))
							&&
							(ct.getDate().equalsIgnoreCase(cityn) || ct.getNameOfCity().equalsIgnoreCase(cityn) || Integer.toString(ct.getNewCs()).equalsIgnoreCase(cityn)
							|| Integer.toString(ct.getTotCs()).equalsIgnoreCase(cityn) || Integer.toString(ct.getDeath()).equalsIgnoreCase(cityn) || Integer.toString(ct.getRecovCs()).equalsIgnoreCase(cityn))) {
						return ct;
					}
				}
			
			return null;
	}
	
	
}
