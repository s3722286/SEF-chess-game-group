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
	
	private int turn=0;
	private int p1Turns=0;
	private int p2Turns=0;
	private int maxTurns;
	
	

	public SimpleChessGame() {
		
		
		name.setBounds(25,10,200,40);
		pass.setBounds(25,60,200,40);
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
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setTitle("Login To Simple Chessgame");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		players.add(new Player("P1","chess"));
		players.add(new Player("P2","ness"));
		pass.addActionListener(this);


	}
	public Player getCurrentPlayer() {
		if((turn & 1) == 1) {
			return p1;
		} else return p2;
	}
	
	public void endTurn() {
		turn=turn+1;
		if(turn>maxTurns) {
			endGame();
		}
		if(Board.hasPieces(Color.WHITE)&&Board.hasPieces(Color.BLACK)) {
		}else {
			endGame();
		}
		Board.getBoardFrame().setTitle("Turn= "+turn+" Current player is "+getCurrentPlayer().getId()+"("+getCurrentPlayer().getColor()+")  Playing for a maximum of "+maxTurns+" turns.");
	}
	public void endGame() { // we're out of the end game now. Ends the game and displays result.
		Player winner=null;
		Player looser=null;
		if(Board.hasPieces(Color.WHITE)&&Board.hasPieces(Color.BLACK)) {
		if(p1.getPoint()==p2.getPoint()) {
			JOptionPane.showMessageDialog(Board.getBoardFrame(),"The Game Has Ended in a tie. Both "+p1.getId()+" and "+p1.getId()+" got "+p1.getPoint()+" Points");
		}else if(p1.getPoint()>p2.getPoint()) {
			winner=p1;
			looser=p2;
		} else {
			winner=p2;
			looser=p1;
		}
		}else {
			if(Board.hasPieces(Color.WHITE)) {
				winner=p1;
				looser=p2;
			}else {
				winner=p2;
				looser=p1;
			}
		}
		
		if(winner!=null&&looser!=null) {
		JOptionPane.showMessageDialog(Board.getBoardFrame(),""+winner.getId()+" Won the game with "+winner.getPoint()+" Points.  "+looser.getId()+" lost with "+looser.getPoint()+" Points.");
		}
		f.dispose();
		Board.getBoardFrame().dispose();
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
						if(this.getPlayer(name.getText()).equals(p1.getId())) {// checks if player 2 is not the same as player 1
						p2=this.getPlayer(name.getText());
						p2.setColor(Color.BLACK);
						
						
						while(p2Turns<=0) {
							p2Turns=Integer.parseInt(JOptionPane.showInputDialog("Enter the maximum amount of turns you wish to play for"));
						}
						JOptionPane.showMessageDialog(f,"Welcome "+name.getText()+". You are now logged and ready to play.");
					   maxTurns=(p1Turns+p2Turns)/2;
					   f.setVisible(false);
						Board=new Board(this);
						Board.draw();
						endTurn();
						}else JOptionPane.showMessageDialog(f,"Error: You cannot login twice into the same game");
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

			
		}
		
		
		

		
		
		
	}
	


}


