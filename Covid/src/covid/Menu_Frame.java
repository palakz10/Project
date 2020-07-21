package covid;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;

public class Menu_Frame extends JFrame {

	CityIO cIO = new CityIO();

	protected JDesktopPane desktop;
	protected JMenuBar mb;
	protected JMenu menuShow;
	protected JMenuItem menuItemDisplayAll;

	protected JLabel lblDt, lblCityNm, lblNwCs, lblTotCs, lblDeath, lblRecovCs;
	protected JTextField txtDt, txtCityNm, txtNwCs, txtTotCs, txtDeath, txtRecovCs;
	protected JButton btnSave, btnFind, btnDisplayDate, btnDisplayCity;

	protected JFrame displayFrame;
	protected JTable jdataTable;
	

	protected void intialize() {

		desktop = new JDesktopPane();
		this.setContentPane(desktop);

		mb = new JMenuBar();
		menuShow = new JMenu("Show Data");
		menuItemDisplayAll = new JMenuItem("Display All");
		

		menuShow.add(menuItemDisplayAll);
		

		mb.add(menuShow);

		this.setJMenuBar(mb);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		lblDt = new JLabel("Date");
		lblCityNm = new JLabel("City Name");
		lblNwCs = new JLabel("Number Of New Cases");
		lblNwCs.setBackground(Color.red);
		lblTotCs = new JLabel("Total Cases");
		lblTotCs.setBackground(Color.red);	
		lblDeath = new JLabel("Number of Deaths");
		lblRecovCs = new JLabel("Recovered cases");
		lblRecovCs.setBackground(Color.green);
		

		txtDt = new JTextField("");
		txtCityNm = new JTextField("");
		txtNwCs = new JTextField("");
		txtTotCs = new JTextField("");
		txtDeath = new JTextField("");
		txtRecovCs = new JTextField("");

		btnSave = new JButton("Save");
		btnSave.setBackground(Color.green);
		btnFind = new JButton("Find");
		btnFind.setBackground(Color.yellow);
		btnDisplayDate = new JButton("Display Date Specific Data");
		btnDisplayCity = new JButton("Display City Specific Data");

		

		this.setLayout(new GridLayout(8, 2));

		this.add(lblDt);
		this.add(txtDt);
		this.add(lblCityNm);
		this.add(txtCityNm);
		this.add(lblNwCs);
		this.add(txtNwCs);
		this.add(lblTotCs);
		this.add(txtTotCs);
		this.add(lblDeath);
		this.add(txtDeath);
		this.add(lblRecovCs);
		this.add(txtRecovCs);
		this.add(btnSave);
		this.add(btnFind);
		this.add(btnDisplayDate);
		this.add(btnDisplayCity);
		

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 400);
		

		menuItemDisplayAll.addActionListener(e -> {
			try {
				menuItemDisplayAction();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnDisplayDate.addActionListener(e -> menuItemDisplayDateAction());
		btnDisplayCity.addActionListener(e -> menuItemDisplayCityAction());
		

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					cIO.saveCity(Menu_Frame.this.getCity());
					Menu_Frame.this.clearData();
					JOptionPane.showMessageDialog(null, "City Data Saved");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Saving the Data");
				}
			}

		});

		btnFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					City ct = cIO.findCity(txtDt.getText(), txtCityNm.getText());
					if (ct == null) {
						JOptionPane.showMessageDialog(null, "No city found");
						Menu_Frame.this.clearData();
					}
			
					Menu_Frame.this.displayCity(ct);
				} catch (Exception ex) {
					System.out.println(ex);
					
				}
			}

		});
	}

	

	private void menuItemDisplayAction() throws IOException {
		// TODO Auto-generated method stub

		JFrame f = new JFrame("Display All");
		
		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setSize(380, 380);

		JTextArea textArea = new JTextArea();
		JScrollPane sp = new JScrollPane(textArea);
		 String getDate,getNameOfCity,getNewCs,getTotCs,getDeath,getRecovCs;
		 int count=1;
		try {
			Scanner in = new Scanner(new File("CityData.txt"));
			while(in.hasNext()) {
				
	        		getDate=in.next();
	        		getNameOfCity = in.next();
	        		getNewCs = in.next();
	        		getTotCs = in.next();
	        		getDeath = in.next();
	        		getRecovCs = in.next();
	        		
	        		textArea.append("City " + Integer.toString(count)+"\n");
	        		textArea.append("Date ="+getDate +"\n");
        			textArea.append("City Name = "+getNameOfCity+"\n");
        			textArea.append("No Of New Cases = "+getNewCs+"\n");
        			textArea.append("Total Cases = " + getTotCs+ "\n");
        			textArea.append("Total Death = "+ getDeath+ "\n");
        			textArea.append("Total No Of Recoveries ="+getRecovCs+"\n"+"\n");
        			
        			count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//panel.add(textArea);
		panel.add(sp);
		f.add(panel);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);

	}

	private void menuItemDisplayDateAction() {
		// TODO Auto-generated method stub
		JFrame f= new JFrame("Display Date Specific Date");    
        JPanel panel=new JPanel(new GridLayout(1,1)); 
        panel.setSize(380,380);
        JTextArea textArea = new JTextArea();
        JScrollPane sp = new JScrollPane(textArea);
        
        String date = txtDt.getText();
        textArea.append("Data for Date "+ date +"\n\n");
        
        String getDate,getNameOfCity,getNewCs,getTotCs,getDeath,getRecovCs;
       
        int count =1;
        
        
        try {
        	Scanner in = new Scanner(new File("CityData.txt"));
        	
        	while(in.hasNext()) {
        		getDate=in.next();
        		getNameOfCity = in.next();
        		getNewCs = in.next();
        		getTotCs = in.next();
        		getDeath = in.next();
        		getRecovCs = in.next();
        		if(getDate.equalsIgnoreCase(date) || getNameOfCity.equalsIgnoreCase(date) || getNewCs.equalsIgnoreCase(date)
					|| getTotCs.equalsIgnoreCase(date) || getDeath.equalsIgnoreCase(date) || getRecovCs.equalsIgnoreCase(date)){
        			
        			textArea.append("City " + Integer.toString(count)+"\n");
	        		//textArea.append("Date ="+getDate +"\n");
        			textArea.append("City Name = "+getNameOfCity+"\n");
        			textArea.append("No Of New Cases = "+getNewCs+"\n");
        			textArea.append("Total Cases = " + getTotCs+ "\n");
        			textArea.append("Total Death = "+ getDeath+ "\n");
        			textArea.append("Total No Of Recoveries ="+getRecovCs+"\n"+"\n");
        			
        			count++;
        		}

        	}
        }
        catch(Exception ex) {
        	System.out.println(ex);
        }

        panel.add(sp);
        f.add(panel);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
		
	}

	

	public void menuItemDisplayCityAction() {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Display City Specific Data");
		
		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setSize(380, 380);

		JTextArea textArea = new JTextArea();
		JScrollPane sp = new JScrollPane(textArea);
		 String getDate,getNameOfCity,getNewCs,getTotCs,getDeath,getRecovCs;
		 String ct = txtCityNm.getText();
		 textArea.append("Data for City "+ ct +"\n\n");
		 
		try {
			Scanner in = new Scanner(new File("CityData.txt"));
			while(in.hasNext()) {
				
	        		getDate=in.next();
	        		getNameOfCity = in.next();
	        		getNewCs = in.next();
	        		getTotCs = in.next();
	        		getDeath = in.next();
	        		getRecovCs = in.next();
	        		
	        		if(getDate.equalsIgnoreCase(ct) || getNameOfCity.equalsIgnoreCase(ct) || getNewCs.equalsIgnoreCase(ct)
	    					|| getTotCs.equalsIgnoreCase(ct) || getDeath.equalsIgnoreCase(ct) || getRecovCs.equalsIgnoreCase(ct)){
	            			
	            			
	    	        		textArea.append("Date ="+getDate +"\n");
	            			textArea.append("No Of New Cases = "+getNewCs+"\n");
	            			textArea.append("Total Cases = " + getTotCs+ "\n");
	            			textArea.append("Total Death = "+ getDeath+ "\n");
	            			textArea.append("Total No Of Recoveries ="+getRecovCs+"\n"+"\n");
	            		}
	        		
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel.add(sp);
		f.add(panel);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}

	private City getCity() throws ParseException {
		City city = new City();
		SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		Date date = sdfrmt.parse(txtDt.getText());

		if (!txtDt.getText().equals(sdfrmt.format(date))) {
			JOptionPane.showMessageDialog(null, "Enter date in MM/dd/yyyy format");
			return null;
		} else if (Integer.parseInt(txtNwCs.getText()) <= 0 || Integer.parseInt(txtTotCs.getText()) <= 0
				|| Integer.parseInt(txtDeath.getText()) <= 0 || Integer.parseInt(txtRecovCs.getText()) <= 0) {
			JOptionPane.showMessageDialog(null, "Enter value greater than zero");
			return null;
		} else {
			city.setDate(txtDt.getText());
			city.setNameOfCity(txtCityNm.getText());
			city.setNewCs(Integer.parseInt(txtNwCs.getText()));
			city.setTotCs(Integer.parseInt(txtTotCs.getText()));
			city.setDeath(Integer.parseInt(txtDeath.getText()));
			city.setRecovCs(Integer.parseInt(txtRecovCs.getText()));
			return city;
		}

	}

	private void displayCity(City ct) {
		if (ct != null) {
			txtDt.setText(ct.getDate());
			txtCityNm.setText(ct.getNameOfCity());
			txtNwCs.setText(Integer.toString(ct.getNewCs()));
			txtTotCs.setText(Integer.toString(ct.getTotCs()));
			txtDeath.setText(Integer.toString(ct.getDeath()));
			txtRecovCs.setText(Integer.toString(ct.getRecovCs()));
		}
	}

	private void clearData() {
		txtDt.setText("");
		txtCityNm.setText("");
		txtNwCs.setText("");
		txtTotCs.setText("");
		txtDeath.setText("");
		txtRecovCs.setText("");
	}

	public Menu_Frame() {
		this.setTitle("Covid-19");
		this.intialize();
	}

}
