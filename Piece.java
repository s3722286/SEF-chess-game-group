
public class Piece {
	private int x = 0;
	private int y = 0;
	private String type = null;
	private String Color = null;

	public Piece(int x, int y, String type, String Color) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.Color = Color;

	}

	public int getX() {
		return this.x;
	}

	public void setX(int X) {
		this.x = X;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int Y) {
		this.y = Y;
	}

	public String getType() {
		return this.type;
	}

	public String getColor() {
		return this.Color;
	}

	//
	public boolean move(int x, int y) {
		if ((validateX(x) == true) && (validateY(y) == true)) {
			if (validateType(x, y) == true) {
				setX(x);
				setY(y);
				return true;
			}
		}
		return false;
	}

	public boolean validateX(int x) {
		if (this.x > x) {
			if (this.x - x > 0) {
				if (this.x - x < 7) {
					return true;
				}
			}
		} else if (this.x < x) {
			if (x - this.x > 0) {
				if (x - this.x < 7) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean validateY(int y) {
		if (this.y > y) {
			if (this.y - y > 0) {
				if (this.y - y < 7) {
					return true;
				}
			}
		} else if (this.y < y) {
			if (y - this.y > 0) {
				if (y - this.y < 7) {
					return true;
				}
			}
		}
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
					} else if (this.x - 2 == 2) {
						return true;
					} else
						return false;
				} else if (this.x < x) {
					if (this.x + 1 == x) {
						return true;
					} else if (this.x + 2 == 2) {
						return true;
					} else
						return false;
				}
			}
			if (this.y != y) {
				if (this.y > y) {

					if (this.y - 1 == y) {
						return true;
					} else if (this.y - 2 == 2) {
						return true;
					} else
						return false;
				} else if (this.y < y) {
					if (this.y + 1 == y) {
						return true;
					} else if (this.y + 2 == 2) {
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
						return true;
					} else if (this.x - 2 == 2) {
						return true;
					} else
						return false;
				} else if (this.x < x) {
					if (this.x + 1 == x) {
						return true;
					} else if (this.x + 2 == 2) {
						return true;
					} else
						return false;
				}

				if (this.y > y) {
					if (this.y - 1 == y) {
						return true;
					} else if (this.y - 2 == 2) {
						return true;
					} else
						return false;
				} else if (this.y < y) {
					if (this.y + 1 == y) {
						return true;
					} else if (this.y + 2 == 2) {
						return true;
					} else
						return false;
				}
				return false;

			}
		}

		if (getType() == "Knight") {
			if ((this.x != x) && (this.y != y)) { // Both need to change for it to move (validly).
				if (this.x > x) {
					if (this.x - 1 == x) {
						return true;
					} else
						return false;
				} else if (this.x < x) {
					if (this.x + 1 == x) {
						return true;
					} else
						return false;
				}

				if (this.y > y) {
					if (this.y - 1 == y) {
						return true;
					} else if (this.y - 2 == 2) {
						return true;
					} else
						return false;
				} else if (this.y < y) {
					if (this.y + 1 == y) {
						return true;
					} else if (this.y + 2 == 2) {
						return true;
					} else
						return false;
				}
				return false;
			}
		}
		
		return false;
	}

	// public Collection<int> validMovesArray() {
	// TODO This batch of code.
	// return collectionName;
	// }

}