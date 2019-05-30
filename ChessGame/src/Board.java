import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class Board implements MouseListener{
	
	private Piece[] Pieces= new Piece[12];
	private Piece SelPiece;
	private JPanel[][] Squares=new JPanel[7][7];
	public JFrame F;
	
	public Board() {
		
		
		Pieces[0]= new Piece(1,6,Type.ROOK,Color.BLACK);
		Pieces[1]= new Piece(2,6,Type.BISHOP,Color.BLACK);
		Pieces[2]= new Piece(3,6,Type.KNIGHT,Color.BLACK);
		Pieces[3]= new Piece(4,6,Type.KNIGHT,Color.BLACK);
		Pieces[4]= new Piece(5,6,Type.BISHOP,Color.BLACK);
		Pieces[5]= new Piece(6,6,Type.ROOK,Color.BLACK);
		
		Pieces[6]= new Piece(1,1,Type.ROOK,Color.WHITE);
		Pieces[7]= new Piece(2,1,Type.BISHOP,Color.WHITE);
		Pieces[8]= new Piece(3,1,Type.KNIGHT,Color.WHITE);
		Pieces[9]= new Piece(4,1,Type.KNIGHT,Color.WHITE);
		Pieces[10]= new Piece(5,1,Type.BISHOP,Color.WHITE);
		Pieces[11]= new Piece(6,1,Type.ROOK,Color.WHITE);
		
		F=new JFrame();
		F.setVisible(false);
		F.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		F.setSize(600,600);
		F.setLocationRelativeTo(null);
		F.setResizable(false);
		F.setLayout(new GridLayout(6,6));
//		for(int i=1;i<7;i++) {
//			
//		}
		
		for(int i=6; i>0; i--) {
			for(int j=1; j<=6; j++) {
				JPanel tempPanel=new JPanel();
				tempPanel.setSize(90,90);
				tempPanel.addMouseListener(this);
				int tempOdd=i+j;
				if((tempOdd & 1) ==0) {
					tempPanel.setBackground(java.awt.Color.BLACK);
				}else tempPanel.setBackground(java.awt.Color.WHITE);
				Squares[i][j]=tempPanel;
				F.add(Squares[i][j]);
				
				}

			}
		//F.pack();
		draw();
		
		
		
		
		
	}
	public Piece getPiece(int x, int y) {
		Piece tempPiece=null;
		for(int k=0; k<=Pieces.length-1;k++) {
		if(Pieces[k].getX()==x&&Pieces[k].getY()==y) {
			tempPiece=Pieces[k];
			}
		}
		return tempPiece;
		
	}
	
	public Piece select(int x, int y) {
		SelPiece=null;
		for(int k=0; k<=Pieces.length-1;k++) {
		if(Pieces[k].getX()==x&&Pieces[k].getY()==y) {
			SelPiece=Pieces[k];
			}
		}
		return SelPiece;
		
	}
	
	public boolean containsPiece(int x, int y) {
		for(int k=0; k<=Pieces.length-1;k++) {
		if(Pieces[k].getX()==x&&Pieces[k].getY()==y) {
			return true;
			}
		}
		return false;
		
	}
	

	public void draw() {
		
		for(int i=6; i>0; i--) {
			
			for(int j=1; j<=6; j++) {
				int tempOdd=i+j;
				if((tempOdd & 1) ==0) {
					Squares[i][j].setBackground(java.awt.Color.BLACK);
				}else Squares[i][j].setBackground(java.awt.Color.WHITE);
				if(SelPiece!=null) {
					if(SelPiece.validMove(j,i)) {
						Squares[i][j].setBackground(java.awt.Color.YELLOW);
					}
				}

				
				}

			}
		
		
		//F.setVisible(false);
		F.setVisible(true);
		
		
		/*
		boolean gotPiece=false;
		
		for(int i=6; i>0; i--) {
			for(int j=1; j<=6; j++) {
				
				
				for(int k=0; k<=Pieces.length-1&&gotPiece==false;k++) {
					if(Pieces[k].getX()==j&&Pieces[k].getY()==i) {
						System.out.print(" "+Pieces[k].getType().charAt(0));
						gotPiece=true;
					}
				}
				if(gotPiece==false) {System.out.print(" -");}
				gotPiece=false;
			}
			System.out.println();
		}
		*/
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//((JComponent) e.getSource()).setBackground(java.awt.Color.BLUE);
		//System.out.println(e.getSource());
		
		for(int i=6; i>0; i--) {
			for(int j=1; j<=6; j++) {
				
				if(Squares[i][j] == (JPanel) e.getComponent()){
					if(SelPiece==null) {
					if(containsPiece(j,i)) {
					select(j,i);
					draw();
					}
				}else {
					if(SelPiece==getPiece(j,i)) {
						SelPiece=null;
						draw();
					} else {
						SelPiece.move(j, i);
						SelPiece=null;
						draw();
					}
					
				}
				}
				
				}

			}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
