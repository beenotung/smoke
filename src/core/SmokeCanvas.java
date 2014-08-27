package core;

import java.util.ArrayList;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

import sun.misc.Cleaner;
import myutils.CanvasShell;
import myutils.Colors;
import myutils.Utils;
import myutils.Vector2D;

public class SmokeCanvas extends CanvasShell {
	private static final long serialVersionUID = 1L;
	public static String TITLE = "Smoke Canvas 1.0";

	public ArrayList<Particle> particles;

	public SmokeCanvas(int width, int height, int scale, double nsPerTick, double nsPerRender) {
		super(width, height, scale, TITLE, nsPerTick, nsPerRender);
	}

	public void addParticle(int pl) {
		Vector2D l, v;
		for (int i = 0; i < pl; i++) {
			l = new Vector2D(0, this.cy);
			v = new Vector2D(Utils.random.nextFloat() * 2 - 1, -1);
			v.x = 0;
			particles.add(new Particle(l, v));
		}
	}

	@Override
	protected void init() {
		particles = new ArrayList<Particle>();
		addParticle(100);
	}

	@Override
	protected void myTick() {
		addParticle(1);
		for (int i = particles.size() - 1; i >= 0; i--)
			if (particles.get(i).location.y < -cy)
				particles.remove(i);
		for (Particle particle : particles) {
			//particle.location.x += Utils.random.nextFloat() * 2 - 1;
			//particle.velocity.x = Utils.random.nextFloat() * 2 - 1;
			particle.acceleration.x = (Utils.random.nextFloat() * 2 - 1) / 16f;
			particle.move();
		}
	}

	@Override
	protected void myRender() {
		screen.clear(Colors.get(0, 0, 0.5));
		for (Particle particle : particles) {
			screen.add(particle.location, particle.color);
		}
	}

	@Override
	protected void myDebugInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void myKeyHandling() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void myMouseHandling() {
		// TODO Auto-generated method stub

	}
}
