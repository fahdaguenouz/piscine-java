import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
       return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.ENGLISH);
        return LocalDate.parse(stringDate.toLowerCase(), formatter);
    }

      public static LocalTime parseTimeFormat(String stringDate) {
        // Example: "09 hours in the evening, 07 minutes and 23 seconds"
        // We’ll manually extract hours, minutes, and seconds.
        String lower = stringDate.toLowerCase();

        // Extract numbers using regex-friendly splits
        int hours = Integer.parseInt(lower.split(" hours")[0].trim());

        // Determine AM/PM
        if (lower.contains("evening") || lower.contains("afternoon") || lower.contains("night")) {
            if (hours != 12) hours += 12; // Convert to PM
        } else if (lower.contains("morning") && hours == 12) {
            hours = 0; // 12 AM case
        }

        // Extract minutes and seconds
        String minutesPart = lower.split("hours")[1].split("minutes")[0];
        int minutes = Integer.parseInt(minutesPart.replaceAll("[^0-9]", "").trim());

        String secondsPart = lower.split("minutes")[1];
        int seconds = Integer.parseInt(secondsPart.replaceAll("[^0-9]", "").trim());

        return LocalTime.of(hours, minutes, seconds);
    }

}