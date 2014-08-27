package testing;

import core.SmokeCanvas;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("main start");

		int width = 800;
		int height = 600;
		int scale = 3;
				double nsPerTick = 1e9D / 100D;
		double nsPerRender = 1e9D / 60D;
		SmokeCanvas cs = new SmokeCanvas(width, height, scale, nsPerTick,
				nsPerRender);
		cs.start();
		// cs.stop();
		System.out.println("main end");
	}

}
