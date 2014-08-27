package core;

import myutils.Colors;
import myutils.Vector2D;

public class Particle {
	Vector2D location, acceleration, velocity;
	int color = Colors.get(1, 1, 1);

	public Particle(Vector2D location, Vector2D velocity) {
		this.location = location;
		this.velocity = velocity;
		acceleration = new Vector2D();
	}

	public Particle(Vector2D location) {
		this.location = location;
		this.velocity = new Vector2D();
		acceleration = new Vector2D();
	}

	public Particle() {
		this.location = new Vector2D();
		this.velocity = new Vector2D();
		acceleration = new Vector2D();
	}

	public void move() {
		velocity.add(acceleration);
		location.add(velocity);
	}

}
