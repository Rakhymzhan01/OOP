package university.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import university.utils.StaticMethods;
import university.database.Database;
import university.enums.Language;
import university.academics.News;
import university.research.ResearchPaper;
import university.research.ResearchJournal;
import university.research.Researcher;

/**
 * The User class is an abstract class representing a generic user in the system.
 * It provides common functionality for all roles in the system, such as:
 * - Viewing top researchers, notifications, and news.
 * - Subscribing to journals.
 * - Adding comments to news.
 */
public abstract class User implements Serializable {

    private static final long serialVersionUID = -2636065254513175824L;

    private static int nextId = 1;

    private final int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private List<String> notifications;
    private List<ResearchJournal> journals;
    private Language language; // Use Language enum

    /**
     * Constructs a new User with the specified username, password, first name, and last name.
     * Automatically assigns a unique ID to the user.
     *
     * @param username  The username of the user.
     * @param password  The password of the user.
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     */
    public User(String username, String password, String firstName, String lastName) {
        this.id = nextId++;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.notifications = new ArrayList<>();
        this.journals = new ArrayList<>();
        this.language = Language.RUSSIAN; // Default language is Russian
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
        System.out.println("Language changed to: " + language.getDisplayName());
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public List<ResearchJournal> getJournals() {
        return journals;
    }

    // Core Functionality
    public void addNotification(String message) {
        notifications.add(message);
    }

    public void viewNotifications() {
        System.out.println(language.getNewNotificationsMessage());
        if (notifications.isEmpty()) {
            System.out.println(language.getNoNotificationsMessage());
        } else {
            StaticMethods.printList(notifications);
            notifications.clear();
        }
    }

    public void viewTopResearcher() {
        System.out.println("----Top Cited Researcher----");
        Researcher researcher = Database.getInstance().getTopCitedResearcher();
        if (researcher == null) {
            System.out.println("No top researchers available.");
            return;
        }

        int totalCitations = researcher.getPapers().stream()
                .mapToInt(ResearchPaper::getCitations)
                .sum();

        System.out.println(researcher.getUser().getFirstName() + " " +
                researcher.getUser().getLastName() + " | Citations: " + totalCitations);
    }

    public void viewNews() {
        List<News> newsList = Database.getInstance().getNews();
        if (newsList.isEmpty()) {
            System.out.println(language.getNoNewsMessage());
            return;
        }

        System.out.println(language.getNewsHeader());
        for (int i = 0; i < newsList.size(); i++) {
            System.out.println((i + 1) + ". " + newsList.get(i).getTitle());
        }
    }

    public void viewOneNews() {
        List<News> newsList = Database.getInstance().getNews();
        if (newsList.isEmpty()) {
            System.out.println(language.getNoNewsMessage());
            return;
        }

        viewNews();
        System.out.println(language.getEnterNewsNumberMessage());
        int choice = StaticMethods.validate(newsList.size());
        if (choice <= 0) return;

        News selectedNews = newsList.get(choice - 1);
        System.out.println(selectedNews);
        viewComments(selectedNews);

        System.out.println(language.getAddCommentPromptMessage());
        Scanner scanner = new Scanner(System.in);
        if ("+".equals(scanner.nextLine())) {
            addComment(selectedNews);
        }
    }

    public void viewComments(News news) {
        List<String> comments = news.getComments();
        if (comments.isEmpty()) {
            System.out.println(language.getNoCommentsMessage());
        } else {
            System.out.println(language.getCommentsHeader());
            comments.forEach(comment -> System.out.println(" - " + comment));
        }
    }

    public void addComment(News news) {
        System.out.println(language.getEnterYourCommentMessage());
        Scanner scanner = new Scanner(System.in);
        String comment = scanner.nextLine();
        news.getComments().add(comment);
        System.out.println(language.getCommentAddedMessage());
    }

    public void changeLanguage() {
        System.out.println("1 - English\n2 - Русский\n3 - Қазақша");

        int choice = StaticMethods.validate(1, 3);
        switch (choice) {
            case 1 -> setLanguage(Language.ENGLISH);
            case 2 -> setLanguage(Language.RUSSIAN);
            case 3 -> setLanguage(Language.KAZAKH);
            default -> System.out.println("Invalid choice.");
        }
    }

    public void viewJournals() {
        StaticMethods.printList(journals);
    }

    // Abstract Methods
    public abstract void viewMenu();

    public abstract void changeInfo();

    // Overrides
    @Override
    public String toString() {
        return String.format("[ID: %d, Username: %s, Name: %s %s]", id, username, firstName, lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User other = (User) obj;
        return id == other.id &&
                Objects.equals(username, other.username) &&
                Objects.equals(password, other.password);
    }
}
