public class Service {

    private final long id;
    private final String text;

    public Service(long id, String text)
    {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }
}
