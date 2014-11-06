package com.nacorpio.nutilities.threading;

public abstract class BaseThread implements Runnable {

	public abstract static class Task {
		
		private int id;
		private int tick_fire;
		
		public Task(int par1, int par2) {
			this.tick_fire = par2;
			this.id = par1;
		}
		
		public abstract void run();
		
		public final int id() {
			return id;
		}
		
	}
	
	private boolean running = true;
	
	private int tickrate; 
	private int ticklimit = -1;
	private int ticks = 0;
	
	private Task[] tasks = new Task[] {};
	private long[] durations = new long[32]; 
	
	private final int default_tickrate = 1;
	
	public BaseThread() {
		new Thread(this).start();
		tickrate = default_tickrate;
	}
	
	public BaseThread(int par1, int par2) {
		new Thread(this).start();
		tickrate = par1;
		ticklimit = par2;
	}
	
	public BaseThread(int par1, int par2, Task... par3) {
		this(par1, par2);
		tasks = par3;
	}
	
	/**
	 * Switch the state to a new state.<br>
	 * The new state depends on the current state.
	 */
	public final BaseThread switchState () {
		running = !running;
		return this;
	}
	
	private final void runTasks(int par1) {
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i].tick_fire == par1)
				tasks[i].run();
		}
	}
	
	@Override
	public void run() {
		while (running == true) {
			
			try {
				Thread.sleep(tickrate);
			}
			
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			long start = System.currentTimeMillis();
			
			runTasks(ticks);
			
			if (durations.length + 1 <= 32) {
				durations[durations.length - 1] = System.currentTimeMillis() - start;
			}
		
			if (ticks == 0) {	
				firstTick();			
			} 
			
			tick(ticks, (ticklimit == -1 ? -1 : ticklimit - ticks));	
			
			if (ticks == ticklimit) {		
				if (!(ticklimit == -1)) 
					lastTick(); running = false;				
			}
			
			if (running)
				ticks++;
			
		}
	}
	
	/**
	 * Fires when the first tick has come.
	 */
	public abstract void firstTick();
	
	/**
	 * Fires when the last tick has come.
	 */
	public abstract void lastTick();
	
	/**
	 * This event gets fired every tick which is set in the tick-rate variable.
	 * The default tick-rate is set to every 1/20 of a second. If a limit has been
	 * set, the thread will be stopped when the limit is reached.
	 * @param par1 the current tick.
	 * @param par2 how many ticks remaining (if available, if not; -1).
	 */
	public abstract void tick(int par1, int par2);

	/**
	 * Returns the average duration of a tick.
	 * @return
	 */
	public float getAverageTick() {
		float var1 = 0;
		for (long var: durations) {
			var1 += var;
		}
		return var1 / durations.length;
	}
	
	public int getTicks() {
		return ticks;
	}
	
	/**
	 * Returns the tickrate of the thread.
	 * @return the tickrate.
	 */
	public int getTickrate() {
		return tickrate;
	}
	
	public final boolean running() {
		return running;
	}
	
}
