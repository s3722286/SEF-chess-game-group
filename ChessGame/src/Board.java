
public class Board {
	
	private Piece[] Pieces= new Piece[12];
	private Piece SelPiece;
	public Board() {
		
		
		Pieces[0]= new Piece(1,6,"Rook","Black");
		Pieces[1]= new Piece(2,6,"Bishop","Black");
		Pieces[2]= new Piece(3,6,"Knight","Black");
		Pieces[3]= new Piece(4,6,"Knight","Black");
		Pieces[4]= new Piece(5,6,"Bishop","Black");
		Pieces[5]= new Piece(6,6,"Rook","Black");
		
		Pieces[6]= new Piece(1,1,"Rook","White");
		Pieces[7]= new Piece(2,1,"Bishop","White");
		Pieces[8]= new Piece(3,1,"Knight","White");
		Pieces[9]= new Piece(4,1,"Knight","White");
		Pieces[10]= new Piece(5,1,"Bishop","White");
		Pieces[11]= new Piece(6,1,"Rook","White");
		
	}
	
	public Piece select(int x, int y) {
		SelPiece=null;
		for(int k=0; k<=Pieces.length-1;k++) {
		if(Pieces[k].getX()==x&&Pieces[k].getY()==y) {
			SelPiece=Pieces[k];
			System.out.println("Selected "+SelPiece.getType()+" at X="+SelPiece.getX()+" Y="+SelPiece.getY());
			SelPiece.setY(3);
			}
		}
		return SelPiece;
		
	}
	
	public void select(char x, int y) {
		
		
	}
	public void draw() {
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
		
		
	}

}
