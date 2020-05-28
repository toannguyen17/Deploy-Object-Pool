import java.util.ArrayList;
public class Halflife implements Game {
	private int countBullet;
	private int totalBullet;

	private BulletPool bulletPool;

	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	public Halflife(){
		countBullet = 1000;
		totalBullet = 0;
	}

	@Override
	public void fire() {
		for (int i = 0; i <= countBullet; i++) {
			Bullet bullet = new Bullet();
			totalBullet++;
			bullet.setPosition(0);
			bullets.add(bullet);

			StringBuilder status = new StringBuilder();
			for (int j = 0; j < bullets.size(); j++){
				status.append("-" + (j+1));
				bullet = bullets.get(j);
				int position = bullet.getPosition();

				if (position > 8){
					bullets.remove(j);
				}else
					bullet.setPosition(bullet.getPosition()+1);
			}

			System.out.println(status.toString());
		}
	}

	@Override
	public void firePool() {
		if (bulletPool == null){
			bulletPool = new BulletPool();
		}

		for (int i = 0; i <= countBullet; i++) {
			Bullet bullet = bulletPool.create();
			bullet.setPosition(0);
			bullets.add(bullet);

			StringBuilder status = new StringBuilder();
			for (int j = 0; j < bullets.size(); j++){
				status.append("-" + (j+1));
				bullet = bullets.get(j);
				int position = bullet.getPosition();

				if (position > 8){
					bulletPool.add(bullets.remove(j));
				}else
					bullet.setPosition(bullet.getPosition()+1);
			}

			System.out.println(status.toString());
		}
	}

	public int countBulletInBool() {
		if (bulletPool == null){
			return totalBullet;
		}
		return bullets.size() + bulletPool.size();
	}
}
