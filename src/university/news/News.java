package university.news;

import java.time.LocalDate;

public class News {
    private int id; // Unique ID for each news item
    private String title;
    private String description;
    private LocalDate date;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
        this.date = LocalDate.now(); // Automatically set the current date
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id; // Allows ID reassignment
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Date: " + date + "\n";
    }
}