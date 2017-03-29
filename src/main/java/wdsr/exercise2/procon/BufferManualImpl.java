package wdsr.exercise2.procon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Task: implement Buffer interface without using any *Queue classes from java.util.concurrent package.
 * Any combination of "synchronized", *Lock, *Semaphore, *Condition, *Barrier, *Latch is allowed.
 */
public class BufferManualImpl implements Buffer {
	private List<Order> orders = new LinkedList<>();
	private Semaphore s_semaphore = new Semaphore(0);
	private Semaphore s_mut = new Semaphore(1);
	public void submitOrder(Order order) throws InterruptedException {
		s_mut.acquire();
		orders.add(order);
		s_mut.release();
		s_semaphore.release();
	}
	
	public Order consumeNextOrder() throws InterruptedException {
		Order order = null;
		s_semaphore.acquire(1);
		s_mut.acquire();
		order = orders.remove(0);
		s_mut.release();
		return order;
	}
}
