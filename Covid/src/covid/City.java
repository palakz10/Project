package covid;


public class City {
	
	private String date, nameOfCity;
	private int newCs, totCs, death, recovCs;
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getNameOfCity() {
		return nameOfCity;
	}
	
	public void setNameOfCity(String nameOfCity) {
		this.nameOfCity = nameOfCity;
	}
	
	public int getNewCs() {
		return newCs;
	}
	
	public void setNewCs(int newCs) {
		this.newCs = newCs;
	}
	
	public int getTotCs() {
		return totCs;
	}
	
	public void setTotCs(int totCs) {
		this.totCs = totCs;
	}
	
	public int getDeath() {
		return death;
	}
	
	public void setDeath(int death) {
		this.death = death;
	}
	
	public int getRecovCs() {
		return recovCs;
	}
	
	public void setRecovCs(int recovCs) {
		this.recovCs = recovCs;
	}
}
