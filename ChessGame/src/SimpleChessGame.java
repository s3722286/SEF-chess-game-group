import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class SimpleChessGame implements ActionListener{
	private ArrayList<Player> players = new ArrayList<Player>();

	JFrame f=new JFrame();
	private JTextField name=new JTextField("Name");
	private JTextField pass=new JPasswordField("Password");
	private Player p1=null;
	private Player p2=null;
	private Board Board;
	
	private int p1Turns=0;
	private int p2Turns=0;
	private int maxTurns;
	
	

	public SimpleChessGame() {
		
		
		name.setBounds(25,10,200,40);
		pass.setBounds(25,60,200,40);
		//pass.setEchoChar((char) 0);
		pass.addActionListener(this);
		JButton loginButton=new JButton("Login");
		loginButton.setActionCommand("Login");
		loginButton.setBounds(25,110,200,30);
		loginButton.addActionListener(this);
		JButton registerButton=new JButton("Register");
		registerButton.setActionCommand("Register");
		registerButton.setBounds(60,160,125,30);
		registerButton.addActionListener(this);
		f.add(loginButton);
		f.add(registerButton);
		f.add(name);
		f.add(pass);
		f.setSize(275,250);
		f.setLayout(null);
		f.setVisible(true);
		f.setTitle("Login To Simple Chessgame");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		players.add(new Player("P1","chess"));
		players.add(new Player("P2","ness"));
		pass.addActionListener(this);
		
		
		//delete this after finishing board
		maxTurns=15;
		Board=new Board();
		Board.draw();
		

	}
	
	public boolean checkPlayer(String name) {
		for(int i=0;i<players.size();i++) {
			
			if(name.equals(players.get(i).getId())){
				
			return true;
			}
			
		}
		return false;
	}
	public Player getPlayer(String name) {
		//name=name.toLowerCase();
		for(int i=0;i<players.size();i++) {
			if(players.get(i).getId().equals(name)) return players.get(i);
		}
		return null;
	}
	public void register(Player player) {
		players.add(player);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Login")) {
			
			//try {
			if(checkPlayer(name.getText())) {

				if(getPlayer(name.getText()).checkPass(pass.getText().toString())) {
					
					if(p1==null) {
						p1=this.getPlayer(name.getText());
						p1.setColor(Color.WHITE);
						
						while(p1Turns<=0) {
							p1Turns=Integer.parseInt(JOptionPane.showInputDialog("Enter the maximum amount of turns you wish to play for"));
						}
						JOptionPane.showMessageDialog(f,"Welcome "+name.getText()+". You are now logged and ready to play.");
					} else if(p2==null) {
						p1=this.getPlayer(name.getText());
						p1.setColor(Color.BLACK);
						
						while(p2Turns<=0) {
							p2Turns=Integer.parseInt(JOptionPane.showInputDialog("Enter the maximum amount of turns you wish to play for"));
						}
						JOptionPane.showMessageDialog(f,"Welcome "+name.getText()+". You are now logged and ready to play.");
					   maxTurns=(p1Turns+p2Turns)/2;
					   System.out.println(p1Turns);
					   System.out.println(p2Turns);
					   System.out.println(maxTurns);
					   f.setVisible(false);
						Board=new Board();
						Board.draw();
					}
					
				} else JOptionPane.showMessageDialog(f,"Error: Incorrect Password");
				
			} else JOptionPane.showMessageDialog(f,"Error: Incorrect Name");
			
		}
		
			
		if(e.getActionCommand().equals("Register")){
			boolean nameTaken=true;
			String regName=JOptionPane.showInputDialog("Enter the Name you wish to register with");
			
			
			while(nameTaken) {
			for(int i=0;i<players.size();i++) {
				if(regName.equals(players.get(i).getId())) {
					nameTaken=true;
					regName=JOptionPane.showInputDialog("Error: That name is already taken. Please enter another.");
					i=0;
				} else nameTaken=false;
			}
			
			
			}
			

			String regPass=JOptionPane.showInputDialog("Enter a strong Password");
			
			players.add(new Player(regName,regPass));
			//input = scanner.nextLine();
			//pass3 = input;
			
		}
		
		
		
//		}
//		catch(NullPointerException e1) {
//			JOptionPane.showMessageDialog(f,"Error: Please enter both your name and password");
//			//System.out.println("Error: Please enter both your name and password");
//			e1.printStackTrace();
		
		
		
	}
	
	//WRONG
//
//	@Override
//	public void insertUpdate(DocumentEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void removeUpdate(DocumentEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void changedUpdate(DocumentEvent e) {
//		pass.setEchoChar('*');
//		
//	}
		
		/*Dmitris code:
		import java.util.Scanner;

		public class LoginLoops {
			public static void main(String[] args) {

				// Initialize
				Scanner scanner = new Scanner(System.in);
				String user1 = "username1";
				String pass1 = "123";
				int navigationInput = 0;
				String input = "";
				int state = 0;

				String user2 = "username2";
				String pass2 = "abc";

				String user3 = null;
				String pass3 = null;

				// Loops
				while (state == 0) {
					System.out.println("Choose one:\n1. Login\n2. Register.");
					navigationInput = scanner.nextInt();
					scanner.nextLine();
					state = navigationInput;
					System.out.println();

					while (state == 1) { // Login
						System.out.println("Enter username:");
						input = scanner.next();
						System.out.println();
						while (input.equals(user1) || input.equals(user2)) {
							System.out.println("Enter password:");
							scanner.nextLine();
							input = scanner.nextLine();
							System.out.println();
							while (input.equals(pass1) || input.equals(pass2)) {
								System.out.println("Login successful.");
								state = 3;
								input = "";
							}
						}
					}
					while (state == 2) { // Register
						System.out.println("Pick a username:\n");
						input = scanner.next();
						scanner.nextLine();

						user3 = input;

						System.out.println("Pick a password:\n");
						input = scanner.nextLine();
						pass3 = input;

						state = 0;

					}
				}
				System.out.println("You can play the game!");
			}
		}
		*/

}


