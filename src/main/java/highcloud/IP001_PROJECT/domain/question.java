package highcloud.IP001_PROJECT.domain;

public class question {
    private int id;
    private String head;
    private String body;

    public question(int id, String head, String body, String date, String who) {
        this.id = id;
        this.head = head;
        this.body = body;
        this.date = date;
        this.who = who;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    private String date;
    private String who;
}
