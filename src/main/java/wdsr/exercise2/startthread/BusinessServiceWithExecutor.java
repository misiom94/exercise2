package wdsr.exercise2.startthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BusinessServiceWithExecutor {
	private NumericHelper helper;
	private ExecutorService ex_service = Executors.newSingleThreadScheduledExecutor();
	
	public BusinessServiceWithExecutor(NumericHelper helper) {
		this.helper = helper;
	
	}

	/**
	 * Calculates Fibonacci number asynchronously and invokes the callback when result is available.
	 * This method returns immediately. 
	 * @param n Which Fibonacci number should be computed.
	 * @param callback Callback to be invoked when Fibonacci number is found.
	 */
	public void computeFibonacci(int n, FibonacciCallback callback) {
		CustomRunnable custom = new CustomRunnable(n,callback,helper);
		ex_service.submit(custom);
		
	}
}
