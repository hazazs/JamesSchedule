package hu.hazazs.jamesschedule;

public class Period {

	private DayAndTime start;
	private DayAndTime end;

	public Period(DayAndTime time) {
		this.start = time;
		this.end = time;
	}

	public Period(DayAndTime start, DayAndTime end) {
		this.start = start;
		this.end = end;
	}

	public DayAndTime getStart() {
		return start;
	}

	public DayAndTime getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return String.format("%s %02d:%02d - %s %02d:%02d", start.getDay(), start.getHour(), start.getMinute(),
				end.getDay(), end.getHour(), end.getMinute());
	}

}