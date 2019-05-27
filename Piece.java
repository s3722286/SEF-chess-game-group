
public class Piece {
	private String pieceType;
	private String pieceColour;
	private int x;
	private int y;
	private boolean[][] array;

	public Piece(int x, int y, String pieceType, String pieceColour) {
		this.pieceType = pieceType;
		this.pieceColour = pieceColour;
		this.x = x;
		this.y = y;
		array = new boolean[7][7];
		updateArrayIni();
	}

	public String getType() {
		return this.pieceType;
	}

	public String getColor() {
		return this.pieceColour;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean validateMove(int x, int y) {
		if ((validateX(x) == true) && (validateY(y) == true)) {
			if (validateType(x, y) == true) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean move(int x, int y) {
		if (validateMove(x, y) == true) {
			setX(x);
			setY(y);
			return true;
		}
		return false;
	}

	public boolean validateX(int x) {
		if ((0 < x) && (x < 7)) {
			return true;
		} else
			return false;
	}

	public boolean validateY(int y) {
		if ((0 < y) && (y < 7)) {
			return true;
		} else
			return false;
	}

	public boolean validateType(int x, int y) {
		if (getType() == "Rook") {
			if ((this.x != x) && (this.y != y)) {
				return false;
			}
			if (this.x != x) {
				if (this.x > x) {
					if (this.x - 1 == x) {
						return true;
					} else if (this.x - 2 == x) {
						return true;
					} else
						return false;
				} else if (this.x < x) {
					if (this.x + 1 == x) {
						return true;
					} else if (this.x + 2 == x) {
						return true;
					} else
						return false;
				}
			}
			if (this.y != y) {
				if (this.y > y) {
					if (this.y - 1 == y) {
						return true;
					} else if (this.y - 2 == y) {
						return true;
					} else
						return false;
				} else if (this.y < y) {
					if (this.y + 1 == y) {
						return true;
					} else if (this.y + 2 == y) {
						return true;
					} else
						return false;
				}
			}
		}

		if (getType() == "Bishop") {
			if ((this.x != x) && (this.y != y)) { // Both need to change for it to move (validly).
				if (this.x > x) {
					if (this.x - 1 == x) {
						if (this.y > y) {
							if (this.y - 1 == y) {
								return true;
							} else
								return false;
						} else if (this.y < y) {
							if (this.y + 1 == y) {
								return true;
							} else
								return false;
						}
					} else if (this.x - 2 == x) {
						if (this.y > y) {
							if (this.y - 2 == y) {
								return true;
							} else
								return false;
						} else if (this.y < y) {
							if (this.y + 2 == y) {
								return true;
							} else
								return false;
						}
					} else
						return false;
				} else if (this.x < x) {
					if (this.x + 1 == x) {
						if (this.y > y) {
							if (this.y - 1 == y) {
								return true;
							} else
								return false;
						} else if (this.y < y) {
							if (this.y + 1 == y) {
								return true;
							} else
								return false;
						}
					} else if (this.x + 2 == x) {
						if (this.y > y) {
							if (this.y - 2 == y) {
								return true;
							} else
								return false;
						} else if (this.y < y) {
							if (this.y + 2 == y) {
								return true;
							} else
								return false;
						}
					} else
						return false;
				}

				return false;
			}
			return false;
		}

		if (getType() == "Knight") {
			if ((this.x != x) && (this.y != y)) { // Both need to change for it to move (validly).

				if (this.y + 2 == y) {
					if (this.x + 1 == x)
						return true;
					else if (this.x - 1 == x)
						return true;
					else
						return false;
				}
				if (this.y - 2 == y) {
					if (this.x + 1 == x)
						return true;
					else if (this.x - 1 == x)
						return true;
					else
						return false;
				}
				if (this.x + 2 == x) {
					if (this.y + 1 == y)
						return true;
					else if (this.y - 1 == y)
						return true;
					else
						return false;
				}
				if (this.x - 2 == x) {
					if (this.y + 1 == y)
						return true;
					else if (this.y - 1 == y)
						return true;
					else
						return false;
				}
			}
			return false;
		}
		return false;
	}

	public void updateArrayIni() {
		array[0][0] = false;

		array[0][1] = false;
		array[0][2] = false;
		array[0][3] = false;
		array[0][4] = false;
		array[0][5] = false;
		array[0][6] = false;

		array[1][0] = false;
		array[2][0] = false;
		array[3][0] = false;
		array[4][0] = false;
		array[5][0] = false;
		array[6][0] = false;

		updateArray();
	}

	public void updateArray() {
		int a = 1;
		int b = 1;

		while (a != 7) {
			while (b != 7) {
				if (validateMove(a, b) == true) {
					array[a][b] = true;
					//System.out.println("True: " + a + " " + b);
				} else {
					array[a][b] = false;
					//System.out.println("False: " + a + " " + b);
				}
				b += 1;
			}
			b = 1;
			a += 1;
		}
		// System.out.println("PIECE FINISHED");
	}

	public boolean validMove(int x, int y) {
		if (array[x][y] == true)
			return true;
		else
			return false;
	}
}