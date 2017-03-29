package wdsr.exercise2.startthread;

import java.util.concurrent.Callable;

public class CustomCallable implements Callable<Integer> {
	private NumericHelper helper;
	
	public CustomCallable(NumericHelper helper) {
		this.helper = helper;
	}
	
	@Override
	public Integer call() throws Exception {
		return helper.nextRandom();
	}
}
