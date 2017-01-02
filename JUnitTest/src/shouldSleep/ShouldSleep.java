package shouldSleep;

public class ShouldSleep {
	public boolean shouldSleep(boolean isWeekday,boolean isVocation){
		return !isWeekday || isVocation;
	}
}
