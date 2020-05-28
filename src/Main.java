public class Main {
	public static void main(String[] args) {
		System.out.println("Start Game.");
		Game game = new Halflife();
		//game.fire();
		game.firePool();
		System.out.println("End Game.");
		System.out.println("Number of bullets created: " + game.countBulletInBool());
	}
}
