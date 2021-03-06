package dialog;

import java.util.Timer;
public class HourTimer implements ITimer {
	private IManager manager;
	
	public HourTimer(IManager manager) {
		this.manager = manager;
	}
	
    public void start(int time) {
        OneHourJob hourJob = new OneHourJob(this.manager);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(hourJob, 0, time);
    }
}