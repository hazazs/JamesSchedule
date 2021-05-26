package hu.hazazs.jamesschedule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(findLongestPeriodForSleep());
	}

	public static Period findLongestPeriodForSleep() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src\\JamesSchedule.txt"));
		List<Period> periods = new ArrayList<>();
		periods.add(new Period(DayAndTime.getStartOfWeek()));
		while (scanner.hasNext()) {
			String meeting = scanner.nextLine();
			String day = meeting.substring(0, 3);
			DayAndTime start = new DayAndTime(day, Integer.parseInt(meeting.substring(4, 6)),
					Integer.parseInt(meeting.substring(7, 9)));
			DayAndTime end = new DayAndTime(day, Integer.parseInt(meeting.substring(10, 12)),
					Integer.parseInt(meeting.substring(13, 15)));
			periods.add(new Period(start, end));
		}
		periods.add(new Period(DayAndTime.getEndOfWeek()));
		periods.sort((p1, p2) -> Integer.compare(p1.getStart().getInSeconds(), p2.getStart().getInSeconds()));
		int longestPeriod = Integer.MIN_VALUE;
		Period periodForSleep = null;
		for (int i = 1; i < periods.size(); i++) {
			int period = periods.get(i).getStart().getInSeconds() - periods.get(i - 1).getEnd().getInSeconds();
			if (period > longestPeriod) {
				longestPeriod = period;
				periodForSleep = new Period(periods.get(i - 1).getEnd(), periods.get(i).getStart());
			}
		}
		scanner.close();
		return periodForSleep;
	}

}