package ce.core;

public class Time {
	
	private static double lastFrame;
	private static int delta = 1;
	
	public static int setDelta()
	{
		long time = getTime();
		delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}
	
	public static int getDelta()
	{
		return delta;
	}
	
	public static long getTime()
	{
		return System.nanoTime() / 1000000;
	}

}
