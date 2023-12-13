import java.util.*;
public class Story {
    private int id;
    private String category;
    private String title;
    private String text;
    private List<String> tags;
    private String date;

    public Story(int id, String category, String title, String text, List<String> tags, String date) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.text = text;
        this.tags = tags;
        this.date = date;
    }
    public int getId() {return id;}
    public String getCategory() {return category;}
    public String getTitle() {return title;}
    public String getText() {return text;}
    public List<String> getTags() {return tags;}
    public String getDate() {return date;}

    public void setText(String text) {
        this.text = text;
    }
}
