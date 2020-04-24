package blogpost;

public class BlogPost {
    String authorName;
    String title;
    String text;
    String publicationDate;

    public BlogPost ( String authorName, String title, String text, String publicationDate) {
        this.authorName = authorName;
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
}
