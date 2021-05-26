package hu.hazazs.jamesschedule;

public class DayAndTime {

	private final static DayAndTime START_OF_WEEK = new DayAndTime("Mon", 0, 0);
	private final static DayAndTime END_OF_WEEK = new DayAndTime("Sun", 24, 0);
	private String day;
	private int hour;
	private int minute;

	public DayAndTime(String day, int hour, int minute) {
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	public static DayAndTime getStartOfWeek() {
		return START_OF_WEEK;
	}

	public static DayAndTime getEndOfWeek() {
		return END_OF_WEEK;
	}

	public String getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getInSeconds() {
		return dayInSeconds() + hour * 3600 + minute * 60;
	}

	private int dayInSeconds() {
		return switch (day) {
		case "Mon" -> 0;
		case "Tue" -> 1 * 24 * 60 * 60;
		case "Wed" -> 2 * 24 * 60 * 60;
		case "Thu" -> 3 * 24 * 60 * 60;
		case "Fri" -> 4 * 24 * 60 * 60;
		case "Sat" -> 5 * 24 * 60 * 60;
		case "Sun" -> 6 * 24 * 60 * 60;
		default -> throw new RuntimeException("Illegal day of the week.");
		};
	}

}
