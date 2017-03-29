package wdsr.exercise2.startthread;

public class CustomRunnable implements Runnable {
	
	private int n;
	private NumericHelper helper;
	private FibonacciCallback callback;
	
	public CustomRunnable(int n, FibonacciCallback callback, NumericHelper helper) {
		this.n = n;
		this.callback = callback;
		this.helper = helper;
	}

	@Override
	public void run() {
		long value = helper.findFibonacciValue(n);
		callback.fibonacciComputed(value);
		
	}

}
