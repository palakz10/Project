import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class exam extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[] = new int[10];
	
	exam(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg = new ButtonGroup();
		
		for (int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);		
		}
		b1 = new JButton("Next");
		b2 = new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2);
		set();
		l.setBounds(30,40,450,20);
	    jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
        
	}
	
	public void actionPerformed(ActionEvent e)
	{
		   if(e.getSource()==b1)  
	        {  
	            if(check())  
	                count=count+1;  
	            current++;  
	            set();    
	            if(current==9)  
	            {  
	                b1.setEnabled(false);  
	                b2.setText("Result");  
	            }  
	        }  
	        if(e.getActionCommand().equals("Bookmark"))  
	        {  
	            JButton bk=new JButton("Bookmark"+x);  
	            bk.setBounds(480,20+30*x,100,30);  
	            add(bk);  
	            bk.addActionListener(this);  
	            m[x]=current;  
	            x++;  
	            current++;  
	            set();    
	            if(current==9)  
	                b2.setText("Result");  
	            setVisible(false);  
	            setVisible(true);  
	        }  
	        
	        for(int i=0,y=1;i<x;i++,y++);
	        {
	        	if(e.getActionCommand().equals("Bookmarks"+y))
	        	{
	        	       if(check())  
	                       count=count+1;  
	                   now=current;  
	                   current=m[y];  
	                   set();  
	                   ((JButton)e.getSource()).setEnabled(false);  
	                   current=now; 
	        	}
	        	
	        }
	        if(e.getActionCommand().equals("Result"))
	        {
	        	if(check())  
	                count=count+1;  
	            current++;  
	            //System.out.println("correct ans="+count);  
	            JOptionPane.showMessageDialog(this,"correct ans="+count);  
	            System.exit(0);  
	        }
	        
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Q: which datatype is use as container?");
			jb[0].setText("int");jb[1].setText("str");jb[2].setText("array");jb[3].setText("bool");
			
		}
		if(current==1)
		{
			l.setText("Q: which of folloeing is not java features?");
		jb[0].setText("Dynamic");jb[1].setText("Artictural neutral");jb[2].setText("Pointer");jb[3].setText("OOP");
					
		}
		if(current==2)
		{
			l.setText("Q: ___ is use to find and fix bug in java");
		jb[0].setText("JVM");jb[1].setText("JRE");jb[2].setText("JDB");jb[3].setText("JDK");
					
		}
		if(current==3)
		{
			l.setText("Q: What is return type of hashcode()");
		jb[0].setText("int");jb[1].setText("obj");jb[2].setText("long");jb[3].setText("void");
					
		}
		if(current==4)
		{
			l.setText("Q: Which package contains the Random class??");
		jb[0].setText("java.util package");jb[1].setText(" java.lang package");jb[2].setText("java.awt package");jb[3].setText("java.io package");
					
		}
		if(current==5)
		{
			l.setText("Q: In which memory a String is stored, when we create a string using new operator?");
		jb[0].setText("int");jb[1].setText("stack");jb[2].setText("heap");jb[3].setText("rendom");
					
		}
		if(current==6)
		{
			l.setText("Q:Which of the following is a reserved keyword in Java?");
		jb[0].setText("obj");jb[1].setText("main");jb[2].setText("reserv");jb[3].setText("system");
					
		}
		if(current==7)
		{
			l.setText("Q: Which keyword is used for accessing the features of a package?");
		jb[0].setText("pack");jb[1].setText("import");jb[2].setText("export");jb[3].setText("extend");
					
		}
		 if(current==8)  
	        {  
	            l.setText("Que9: which function is not present in Applet class?");  
	            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");  
	        }  
	        if(current==9)  
	        {  
	            l.setText("Que10: Which one among these is not a valid component?");  
	            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");  
	                        jb[3].setText("JTextArea");  
	        }  
	        l.setBounds(30,40,450,20);
	        for(int i=0,j=0;i<=90;i+=30,j++)  
	            jb[j].setBounds(50,80+i,200,20);
	
	}
	boolean check()
	{
		if(current==0)  
            return(jb[2].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[1].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[0].isSelected());  
        if(current==7)  
            return(jb[1].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[3].isSelected());  
        return false;  	
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new exam("JAVA EXAM");
	}

}
