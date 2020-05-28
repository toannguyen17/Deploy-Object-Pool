import java.util.LinkedList;

public class BulletPool {
	private LinkedList<Bullet> bool = new LinkedList<Bullet>();

	public void add(Bullet bullet){
		bool.addLast(bullet);
	};

	public Bullet create(){
		if (bool.size() == 0){
			return new Bullet();
		}
		return bool.removeLast();
	};

	public int size(){
		return bool.size();
	}
}
