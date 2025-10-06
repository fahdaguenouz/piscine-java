import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class ParseDate {

  public static LocalDateTime parseIsoFormat(String stringDate) {
    if (stringDate == null) {
        return null; 
    }
    return LocalDateTime.parse(stringDate);
}

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) {
            return null; 
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive() // Make parsing case-insensitive
                .appendPattern("EEEE d MMMM yyyy")
                .toFormatter(Locale.ENGLISH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null; // Handle null input gracefully
        }

        String lower = stringDate.toLowerCase();

        // Extract hours
        int hours = Integer.parseInt(lower.split(" hours")[0].trim());

        // Determine AM/PM
        if (lower.contains("evening") || lower.contains("afternoon") || lower.contains("night")) {
            if (hours != 12)
                hours += 12; // Convert to PM
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