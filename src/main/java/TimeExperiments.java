import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class TimeExperiments {
    public static void main(String[] args) {
        printer("Step 1: Write code to output the current date and time.");
        Instant timeNow=Instant.now();
        System.out.println(transformToSystemTime(timeNow));

        printer("Step 2: Add a timespan of 2 weeks to the current date and output the new date.");
        Instant twoWeeksLater = Instant.now().plus(14, ChronoUnit.DAYS);
        System.out.println(transformToSystemTime(twoWeeksLater));

        printer("Step 3: Compare the current date with a specified future date and output whether the current date is before or after the specified date.");
        long until = timeNow.until(Instant.now().plus(20, ChronoUnit.DAYS), ChronoUnit.DAYS);
        if (until > 0) {
            System.out.println("The current date is " + until + " days before the specified date!");
        } else if (until < 0) {
            System.out.println("The current date is " + until + " after the specified date!");
        } else {
            System.out.println("The current date is the same as the specified date!");
        }

        printer("Step 4: Calculate the difference in days between two arbitrary dates and output the result");
        LocalDate startTime=getRandomDate();
        LocalDate endTime=getRandomDate();
        long daysBetween=ChronoUnit.DAYS.between(startTime,endTime);
        System.out.println("Start time: " + startTime);
        System.out.println("End Time: " +  endTime);
        System.out.println("Difference: " + daysBetween);
    }

    public static ZonedDateTime transformToSystemTime(Instant instant) {
        return instant.atZone(ZoneId.systemDefault());
    }

    public static LocalDate getRandomDate() {
        long minDay = LocalDate.of(1, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2020, 1, 1).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public static void printer(String message) {
        System.out.println();
        System.out.println(message);
    }
}
