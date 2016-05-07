package tasktimer;

import static java.lang.System.out;

import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*; // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks using different programming
 * constructs.
 * 
 * @author Wisarut Boonnumma
 */
public class TaskTimer {
	/**
	 * Define a customer Consumer class that computes <b>both</b> the average
	 * and count of values. An IntConsumer is a special Consumer interface the
	 * has an 'int' parameter in accept().
	 */
	static class IntCounter implements IntConsumer {
		// count the values
		public int count = 0;
		// total of the values
		private long total = 0;

		/**
		 * accept consumes an int. In this method, count the value and add it to
		 * total.
		 */
		public void accept(int value) {
			count++;
			total += value;
		}

		/** Get the average of all the values consumed. */
		public double average() {
			return (count > 0) ? ((double) total) / count : 0.0;
		}

		public int getCount() {
			return count;
		}
	}
	/**
	 * execAndPrint print task, run task , and count time of run task
	 * @param task 
	 */
	public void execAndPrint(Runnable task) {
		StopWatch stopWatch = new StopWatch();
		out.println("Starting task:" + task);
		stopWatch.start();
		task.run();
		stopWatch.stop();
		out.printf("Elapsed time is %f sec\n", stopWatch.getElapsed());
	}

	/** Run all the tasks. */
	public static void main(String[] args) {
		TaskTimer taskTime = new TaskTimer();
		taskTime.execAndPrint(new Task1());
		taskTime.execAndPrint(new Task2());
		taskTime.execAndPrint(new Task3());
		taskTime.execAndPrint(new Task4());
		taskTime.execAndPrint(new Task5());
		taskTime.execAndPrint(new Task6());

	}

}
