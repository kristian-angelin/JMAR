import java.time.LocalDateTime;

public record DataCollectionEntry(int id, String title, String text, LocalDateTime date) {}
