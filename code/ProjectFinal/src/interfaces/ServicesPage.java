package interfaces;


import java.awt.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.sql.*;

import java.awt.event.*;

public class ServicesPage extends DBHandler {


	JFrame container=new JFrame();
	JLabel Logo =new JLabel("HandyHome Services");
	JLabel tagline=new JLabel("_NO JOB IS TOO BIG!");
	JLabel statement=new JLabel("Select Required Handyman Service:");
	
	final JLabel label = new JLabel();
	JButton showbutton = new JButton("SHOW");
	private final JLabel logoLabel = new JLabel("New label");
	ActionListener action;
	
	ServicesPage()
    {
       
       
        
       
        String query="SELECT service_name from services";
        ResultSet result=_executeQuery(query);
        
        
        
            final DefaultListModel<String> l1 = new DefaultListModel<>();   
            try {
				//result.next(); 
            	int i=1;
				while(result.next()) {
					
				l1.addElement((i++)+". "+result.getString("service_name"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 

        final JList<String> list1 = new JList<>(l1);  
        list1.setBackground(new Color(245, 222, 179));
        list1.setToolTipText("");
        list1.setFont(new Font("Brush Script MT", Font.PLAIN, 28));
        list1.setForeground(new Color(0, 0, 0));
        list1.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(233, 150, 122)));
        list1.setBounds(19,150,596,310);
        showbutton.setForeground(new Color(255, 228, 181));
        action=new ActionListener() {  
            public void actionPerformed(ActionEvent e) {   
                String data = "";  
                if (list1.getSelectedIndex() != -1) {                       
                   data = "HandyMan Service Selected: " + list1.getSelectedValue();   
                   label.setText(data);  
                   label.setBounds(23, 465, 500, 30);
                   label.setFont(new Font("Brush Script MT",Font.PLAIN,26));
                   
                }    
                label.setText(data);  
             }  
          };
      
        
        
        
    	container.add(list1);
        addComponentsToContainer();
        addActionEvent();
        setLayoutManager();
        setLocationAndSize();
        container.setTitle("Select Service");
        container.setVisible(true);
        container.setBounds(10,10,650,600);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(false);
       
    }
    
    public void setLayoutManager()
    {
    	container.setBackground(new Color(255, 228, 181));
        container.setLayout(null);
    }
    public void setLocationAndSize()
    {
        //Setting location and Size of each components using setBounds() method.
    	Logo.setBounds(214,25,298,50);
    	Logo.setFont(new Font("Brush Script MT", Font.BOLD, 36));
    	Logo.setForeground(new Color(233, 150, 122));
    	tagline.setBounds(214,64,144,38);
    	tagline.setFont(new Font("Broadway", Font.PLAIN, 13));
    	tagline.setForeground(new Color(233, 150, 122));
    	statement.setBounds(23,113,313,38);
    	statement.setFont(new Font("Brush Script MT", Font.PLAIN, 23));
    	statement.setForeground(new Color(0, 0, 0));
    	
    	
    	showbutton.setBounds(256,510,80,30);
    	showbutton.setFont(new Font("Broadway", Font.PLAIN, 14));
    	showbutton.setBackground(new Color(0, 0, 0));
    	
    	logoLabel.setBounds(-25, 11, 229, 122);
    	ImageIcon img = new ImageIcon(this.getClass().getResource("/Handyhome.png"));
        logoLabel.setIcon(img);
  
    }
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(statement);
    	label.setFont(new Font("Brush Script MT", Font.PLAIN, 26));
    	label.setForeground(new Color(0, 0, 0));
    	label.setSize(500, 30);
    	label.setLocation(23, 445);
    	container.add(label);
    	container.add(showbutton);
    	container.add(Logo);
    	container.add(tagline);
    	container.add(logoLabel);

    }


    public void addActionEvent()
    {
       //adding Action listener to components
       
    	showbutton.addActionListener(action);
    }
    
    public static void main(String[] a)
    {
        //Creating object of LoginFrame class and setting some of its properties
    	new ServicesPage();


    }

	
};




