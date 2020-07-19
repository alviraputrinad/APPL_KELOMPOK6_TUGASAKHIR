import java.util.Timer;
import java.util.TimerTask;

public class QuizTimer extends TimerTask{
	private int i;
	Timer timer = new Timer();
	
    void StartTimer(int time){
        TimerTask task = new QuizTimer();
        long period = time*60000;
        timer.schedule(new RemindTask(), period);
    }
    
    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
        }
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
