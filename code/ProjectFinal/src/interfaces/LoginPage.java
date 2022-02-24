package interfaces;

import java.awt.*;  

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class LoginPage extends DBHandler {

	
	JFrame container=new JFrame();
	JLabel Logo =new JLabel("HandyHome Services");
	JLabel tagline=new JLabel("_NO JOB IS TOO BIG!");
	JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    String userText;
    String pwdText;
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
    JLabel notuser = new JLabel("Not a user? Sign Up here.");
    private final JLabel logoLabel = new JLabel("New label");
    //ActionListener action;
   
 
	
    LoginPage()
    {
    	//Calling setLayoutManger() method inside the constructor.
        
        addComponentsToContainer();
        addActionEvent();//calling addActionEvent() method
        
        setLayoutManager();
        setLocationAndSize();
        container.setTitle("Log In to Handy Home Services");
        container.setVisible(true);
        container.setBounds(10,10,650,600);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setResizable(true);
        
    }
    
    public void setLayoutManager()
    {
    	container.setForeground(new Color(233, 150, 122));
    	container.setBackground(new Color(255, 228, 181));
        container.setLayout(null);
        
    }
    public void setLocationAndSize()
    {
        //Setting location and Size of each components using setBounds() method.
    	Logo.setBounds(136,32,338,50);
    	Logo.setFont(new Font("Brush Script MT", Font.BOLD, 43));
    	Logo.setForeground(new Color(233, 150, 122));
    	tagline.setBounds(216,82,161,30);
    	tagline.setFont(new Font("Broadway", Font.PLAIN, 14));
    	tagline.setForeground(new Color(233, 150, 122));
        userLabel.setBounds(216,150,120,30);
        userLabel.setFont(new Font("Broadway", Font.PLAIN, 18));
        userLabel.setForeground(new Color(0, 0, 0));
        passwordLabel.setBounds(216,217,120,30);
        passwordLabel.setFont(new Font("Broadway", Font.PLAIN, 18));
        passwordLabel.setForeground(new Color(0, 0, 0));
        userTextField.setBounds(360,153,241,30);
        passwordField.setBounds(360,220,241,30);
        showPassword.setBounds(370,256,150,30);
        showPassword.setFont(new Font("Verdana", Font.PLAIN, 12));
        showPassword.setForeground(new Color(0, 0, 0));
        showPassword.setOpaque(false);
        loginButton.setForeground(new Color(255, 228, 181));
        loginButton.setBounds(260,339,106,41);
        loginButton.setFont(new Font("Broadway", Font.PLAIN, 14));
        loginButton.setBackground(new Color(0, 0, 0));
        resetButton.setForeground(new Color(255, 228, 181));
        resetButton.setBounds(406,339,106,41);
        resetButton.setFont(new Font("Broadway", Font.PLAIN, 14));
        resetButton.setBackground(new Color(0, 0, 0));
        notuser.setBounds(262, 402, 284, 30);
        notuser.setFont(new Font("Broadway", Font.PLAIN, 14));
        notuser.setForeground(new Color(0, 0, 0));
        logoLabel.setForeground(new Color(233, 150, 122));
        logoLabel.setBounds(-35, 135, 241, 142);
        ImageIcon img = new ImageIcon(this.getClass().getResource("/Handyhome.png"));
        logoLabel.setIcon(img);
        
  
  
    }
    public void addComponentsToContainer()
    {
       //Adding each components to the Container
    	container.add(Logo);
    	container.add(tagline);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(notuser);       
        container.add(logoLabel);
        
        //JLabel lblNewLabel = new JLabel("New label");
        //Image img =  new ImageIcon(this.getClass().getResource("/Handyhome,png")).getImage();
        //lblNewLabel.setIcon(new ImageIcon(img));
        //lblNewLabel.setBounds(34, 33, 325, 86);
        //getContentPane().add(lblNewLabel);
    }

    public void addActionEvent()
    {
       //adding Action listener to components
        loginButton.addActionListener(action);
        resetButton.addActionListener(action);
        showPassword.addActionListener(action);
    }

    @SuppressWarnings("deprecation")

    ActionListener action=new ActionListener() 
    {public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            String query="select user_name,password from user where user_name='"+userText+"' or password='"+pwdText+"'";	            		

   		 ResultSet result = _executeQuery(query);
   		 
            
            try {
            	result.next();
				if (userText.equalsIgnoreCase(result.getString("user_name")) && pwdText.equalsIgnoreCase(result.getString("password"))) {
				  JOptionPane.showMessageDialog(container, "Login Successful");
				} else {
				   JOptionPane.showMessageDialog(container, "Invalid Username or Password");
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
 
        }
            
        
    }};
    
   
};