package tasktimer;

public class StopWatch {
	private long startTime;
	private long stopTime;
	private boolean running;

	/**
	 * start star count time.
	 */
	public void start() {
		startTime = System.nanoTime();
	}

	/**
	 * stop count time.
	 */
	public void stop() {
		stopTime = System.nanoTime();
	}

	/**
	 * 
	 * @return count time.
	 */
	public double getElapsed() {
		return ((stopTime - startTime) * 1.0E-9);

	}
}
