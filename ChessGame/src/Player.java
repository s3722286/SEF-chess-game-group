
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Player {
	private String id;
	private String pw;
	private Color color;
	private int point;
	private Collection<Player> players = new ArrayList<Player>();
	private Scanner in = new Scanner(System.in);

	public Player(String id, String pw, Color color, int point) {
		this.id = id;
		this.pw = pw;
		this.color = color;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public void logID() {
		System.out.println("Enter player id: ");
		while (in.hasNext()) {
			setId(id);
		}

	}
	public void logPassword() {
		System.out.println("Enter player password: ");
		while (in.hasNext()) {
			setPw(id);
		}

	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
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

	public void register(Player player) {
		players.add(player);
	}

}
