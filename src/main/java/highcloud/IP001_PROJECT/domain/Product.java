package highcloud.IP001_PROJECT.domain;

public class Product {
    private int ID;
    private String TITLE;
    private double PRICE;
    private String TRACK;
    private String INFO;

    public String getINFO() {
        return INFO;
    }

    public void setINFO(String INFO) {
        this.INFO = INFO;
    }

    private String IMG;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    public String getTRACK() {
        return TRACK;
    }

    public void setTRACK(String TRACK) {
        this.TRACK = TRACK;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
}
