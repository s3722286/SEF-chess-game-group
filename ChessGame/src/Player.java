public class Player {
	private String id;
	private String pw;
	private Color color;
	private int point;

	public Player(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.color = null;
		this.point = 0;
	}

	public String getId() {
		return this.id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public boolean checkPass(String pass) {
		if(pass.equals(this.pw)) {
			return true;
		}else return false;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	

}
