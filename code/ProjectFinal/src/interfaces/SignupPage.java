package interfaces;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;

class SignupPage extends DBHandler { 

	// Components of the Form 
	JFrame c=new JFrame(); 
	private JLabel title; 
	private JLabel name; 
	private JTextField tname; 
	private JLabel mno; 
	private JTextField tmno; 
	private JLabel email; 
	private JTextField temail; 
	private JLabel pass; 
	private JTextField tpass;
	private JLabel add; 
	private JTextArea tadd; 
	private JCheckBox term; 
	private JButton sub; 
	private JButton reset; 
	private JTextArea tout; 
	private JLabel res; 
	private JLabel logoLabel;
	ActionListener action;
	

	// constructor, to initialize the components 
	// with default values. 
	public SignupPage()
	{ 
		
		c.setTitle("Sign Up for Handy Home Services"); 
		c.setBounds(300, 90, 650, 600); 
		//setDefaultCloseOperation(EXIT_ON_CLOSE); 
		//setResizable(false); 

		//c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Sign Up Here"); 
		title.setForeground(new Color(233, 150, 122));
		title.setFont(new Font("Broadway", Font.PLAIN, 43)); 
		title.setSize(300, 58); 
		title.setLocation(161, 20); 
		c.add(title); 
		c.setBackground(new Color(255, 228, 181));

		name = new JLabel("Name"); 
		name.setForeground(new Color(0, 0, 0));
		name.setFont(new Font("Broadway", Font.PLAIN, 20)); 
		name.setSize(130, 20); 
		name.setLocation(224, 92); 
		c.add(name); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(182, 31); 
		tname.setLocation(418, 89); 
		c.add(tname); 

		mno = new JLabel("Phone#"); 
		mno.setForeground(new Color(0, 0, 0));
		mno.setFont(new Font("Broadway", Font.PLAIN, 20)); 
		mno.setSize(100, 20); 
		mno.setLocation(224, 142); 
		c.add(mno); 

		tmno = new JTextField(); 
		tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tmno.setSize(182, 31); 
		tmno.setLocation(418, 139); 
		c.add(tmno); 
		
		email = new JLabel("Email Address"); 
		email.setForeground(new Color(0, 0, 0));
		email.setFont(new Font("Broadway", Font.PLAIN, 18)); 
		email.setSize(160, 20); 
		email.setLocation(220, 192); 
		c.add(email); 

		temail = new JTextField(); 
		temail.setFont(new Font("Arial", Font.PLAIN, 15)); 
		temail.setSize(182, 31); 
		temail.setLocation(418, 189); 
		c.add(temail); 
		
		
		
		
		pass = new JLabel("Password"); 
		pass.setForeground(new Color(0, 0, 0));
		pass.setFont(new Font("Broadway", Font.PLAIN, 20)); 
		pass.setSize(130, 20); 
		pass.setLocation(224, 244); 
		c.add(pass); 

		tpass = new JTextField(); 
		tpass.setSize(182, 36); 
		tpass.setLocation(418, 239); 
		c.add(tpass); 
		
		

		
		add = new JLabel("Address"); 
		add.setForeground(new Color(0, 0, 0));
		add.setFont(new Font("Broadway", Font.PLAIN, 20)); 
		add.setSize(106, 20); 
		add.setLocation(224, 299); 
		c.add(add); 

		tadd = new JTextArea(); 
		tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tadd.setSize(182, 75); 
		tadd.setLocation(418, 300); 
		tadd.setLineWrap(true); 
		c.add(tadd); 

		term = new JCheckBox("Accept Terms And Conditions."); 
		term.setForeground(new Color(0, 0, 0));
		term.setFont(new Font("Arial", Font.PLAIN, 17)); 
		term.setSize(255, 20); 
		term.setOpaque(false);
		term.setLocation(224, 398); 
		c.add(term); 

		sub = new JButton("Submit"); 
		sub.setBackground(new Color(0, 0, 0));
		sub.setForeground(new Color(255, 228, 181));
		sub.setFont(new Font("Broadway", Font.PLAIN, 15)); 
		sub.setSize(100, 34); 
		sub.setLocation(224, 441); 
		
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setForeground(new Color(255, 228, 181));
		reset.setBackground(new Color(0, 0, 0));
		reset.setFont(new Font("Broadway", Font.PLAIN, 15)); 
		reset.setSize(100, 34); 
		reset.setLocation(384, 441); 
		
		c.add(reset); 
		
		
		
		
		action=new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{ 
			if (e.getSource() == sub) { 
				if (term.isSelected()) { 
					try {
						String query="select user_id from user order by user_id desc limit 1";
						ResultSet result=_executeQuery(query);
						result.next();
						String userName=tname.getText()+result.getString("user_id");
						query="insert into user (`USER_NAME`, `PASSWORD`, `ACCOUNT_CREATED`) VALUES ('"+tname.getText()+result.getInt("user_id")+"','"+tpass.getText()+"','"+java.time.LocalDate.now()+"')";         
						_insertQuery(query);
						
						query="select user_id from user where user_name='"+userName+"'";
						result=_executeQuery(query);
						result.next();
						
						query="insert into customer (`USER_ID`,`NAME`, `EMAIL`, `PHONE_NO`,`ADDRESS`) VALUES ('"+result.getInt("user_id")+"','"+tname.getText()+"','"+temail.getText()+"','"+tmno.getText()+"','"+tadd.getText()+"')";
						_insertQuery(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					res.setText("Registration Successfully.."); 
				} 
				else { 
					tout.setText("");
					res.setText("Please accept the"
								+ " terms & conditions.."); 
				} 
			} 

			else if (e.getSource() == reset) { 
				String def = ""; 
				tname.setText(def); 
				tadd.setText(def); 
				tmno.setText(def);
				tpass.setText(def);
				temail.setText(def);
				res.setText(def); 
				term.setSelected(false); 
				 
			} 
		} 
		};
		
		
		

		tout = new JTextArea(); 
		tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tout.setSize(12, 11); 
		tout.setLocation(458, 48); 
		tout.setLineWrap(true); 
		tout.setEditable(false); 
		c.add(tout); 

		res = new JLabel(""); 
		res.setForeground(Color.WHITE);
		res.setBackground(Color.DARK_GRAY);
		res.setFont(new Font("Broadway", Font.PLAIN, 16)); 
		res.setSize(344, 42); 
		res.setLocation(117, 493); 
		c.add(res);
		
		logoLabel = new JLabel("New label");
		logoLabel.setBounds(-41, 120, 255, 170);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Handyhome.png"));
        logoLabel.setIcon(img);
		c.add(logoLabel);
		addActionEvent();
		c.setVisible(true); 
	} 

	
	
	public void addActionEvent()
    {
       //adding Action listener to components
		sub.addActionListener(action); 
		reset.addActionListener(action); 
    	
    }
 

	public static void main(String[] args)
	{ 
		new SignupPage();
	} 
}
