
public class Timer {
	private static long beginning = System.currentTimeMillis();
	private long end = 0;
	private boolean running = false; //par defaut le chrono est eteint 
	
	public boolean isRunning(){
		return running; //retourné false => le chrono n'a pas démarré
	}
	
	public void start(){
		
		this.running = true; //le chrono demarre 
	}
	public void stop(){
		this.end= System.currentTimeMillis();
		this.running=false; //le chorno s'arrete
	}
	public long getElapsedTime(){
		long elapsed = 0;
		if (running){
			elapsed = (System.currentTimeMillis() - beginning);
			System.out.println(elapsed);
		}
		 else{
			elapsed = (end - beginning);
		} 
		return elapsed;
	}



	
	
}