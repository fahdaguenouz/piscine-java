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
    if (stringDate == null) {
        return null; // Handle null input gracefully
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.ENGLISH);
    return LocalDate.parse(stringDate.toLowerCase(), formatter);
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