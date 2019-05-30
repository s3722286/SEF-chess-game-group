import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Board implements MouseListener{
	
	private Piece[] Pieces= new Piece[12];
	private Piece SelPiece;
	private JPanel[][] Squares=new JPanel[7][7];
	public JFrame F;
	private SimpleChessGame simpleChessGame;
	
	public Board(SimpleChessGame simpleChessGame) {
		this.simpleChessGame=simpleChessGame;
		
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
		F.setSize(720,720);
		F.setLocationRelativeTo(null);
		F.setResizable(false);
		F.setLayout(new GridLayout(6,6));
		F.setVisible(true);
		
		for(int i=6; i>0; i--) {
			for(int j=1; j<=6; j++) {
				JPanel tempPanel=new JPanel();
				tempPanel.setSize(120,120);
				tempPanel.addMouseListener(this);
				int tempOdd=i+j;
				if((tempOdd & 1) ==0) {
					tempPanel.setBackground(java.awt.Color.BLACK);
				}else tempPanel.setBackground(java.awt.Color.WHITE);
				tempPanel.add(new JLabel());
				
				Squares[i][j]=tempPanel;
				F.add(Squares[i][j]);
				
				}

			}
		
		
		SwingUtilities.invokeLater(new Runnable()
		 {
		 @Override
		 public void run(){draw();}});
		
		
		
		
		
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
	public boolean hasPieces(Color Color) {
		int count=0;
		for(int i=0;i<Pieces.length;i++) {
			if(Pieces[i].getColor()==Color&&Pieces[i].getX()!=0) {
				count++;
			}
		}
		if (count>0) {
			return true;
		} else return false;
		
		
		
		
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
					Squares[i][j].setBackground(java.awt.Color.darkGray);
				}else Squares[i][j].setBackground(java.awt.Color.WHITE);
				//Chess Piece pictures used for educational purposes from: https://en.wikipedia.org/wiki/Chess_piece 
				
				if(SelPiece!=null) {
					if(SelPiece.validMove(j,i)) {
						Squares[i][j].setBackground(java.awt.Color.MAGENTA);
					}
				if(containsPiece(j,i)) {//Loads picture file path for chess piece
					String imgPath="./";
					if(getPiece(j,i).getColor()==Color.WHITE) {
						imgPath=imgPath+"White";
					}else imgPath=imgPath+"Black";
					if(getPiece(j,i).getType().size()==1){
						if(getPiece(j,i).getType().get(0)==Type.ROOK) {imgPath=imgPath+"Rook.png";}
						else if(getPiece(j,i).getType().get(0)==Type.BISHOP) {imgPath=imgPath+"Bishop.png";}
						else if(getPiece(j,i).getType().get(0)==Type.KNIGHT) {imgPath=imgPath+"Knight.png";}
					}
					
					try { 
						Squares[i][j].removeAll(); //Loads picture for piece icon
						BufferedImage img=ImageIO.read(new File(imgPath));
						JLabel image=new JLabel(new ImageIcon(img));
						image.setVisible(false);
						image.setVisible(true);
						Squares[i][j].add(image);
						Squares[i][j].revalidate();
						Squares[i][j].repaint();
						Squares[i][j].setVisible(false);
						Squares[i][j].setVisible(true);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}else {
					Squares[i][j].removeAll();
					Squares[i][j].revalidate();
					Squares[i][j].repaint();
				}
					
				}

				
				}

			}
		
		F.setVisible(true);
		
		
		
		
	}
	
	public JFrame getBoardFrame() {
		return F;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		for (int i = 6; i > 0; i--) {
			for (int j = 1; j <= 6; j++) {

				if (Squares[i][j] == (JPanel) e.getComponent()) {//if there is a piece on this component that was clicked on
					if (SelPiece == null) {//if no piece is currently selected
						if (containsPiece(j, i)) {
							if (getPiece(j, i).getColor() == simpleChessGame.getCurrentPlayer().getColor()) {
								select(j, i);//selects piece

								SwingUtilities.invokeLater(new Runnable()
								 {
								 @Override
								 public void run(){draw();}});
							}
						}
					} else { // If there is a piece selected
						if (SelPiece == getPiece(j, i)) {//if selected piece is the same piece as clicked on it stops selecting the piece
							SelPiece = null;

							SwingUtilities.invokeLater(new Runnable()
							 {
							 @Override
							 public void run(){draw();}});
							
						} else {
							if (containsPiece(j, i) && SelPiece.validateMove(j, i)) {//if there is a piece and the selected piece can move there
								if (getPiece(j, i).getColor() != simpleChessGame.getCurrentPlayer().getColor()) {//if piece is of the opposite color it dies and gets removed.
									Piece deadPiece = getPiece(j, i);
									deadPiece.setX(0);
									deadPiece.setY(0);
									SelPiece.move(j, i);
									SelPiece = null;
									simpleChessGame.getCurrentPlayer()
											.setPoint(simpleChessGame.getCurrentPlayer().getPoint() + 5);
									
									SwingUtilities.invokeLater(new Runnable()
									 {
									 @Override
									 public void run(){draw();}});

									simpleChessGame.endTurn();
									
								} else if (getPiece(j, i).getColor() == simpleChessGame.getCurrentPlayer().getColor()){ //Combining pieces Impossible without adding more methods to player class
									//Piece comboPiece = getPiece(j, i);
									SelPiece = null;

									SwingUtilities.invokeLater(new Runnable()
									 {
									 @Override
									 public void run(){draw();}});
								}
							} else {//If piece can move and there are no pieces that it moved into
								if(SelPiece.validateMove(j, i)) {
								SelPiece.move(j, i);
								SelPiece = null;
								SwingUtilities.invokeLater(new Runnable()
								 {
								 @Override
								 public void run(){draw();}});
								simpleChessGame.endTurn();
								}
							}
						}

					}
				}

			}
		
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
