package Model;

public class Rectangle {
    private int base;
    private int hight;

    public Rectangle() {
    }

    public Rectangle(int base, int hight) {
        this.base  = base;
        this.hight = hight;
    }

    public int getBase() {
        return this.base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHight() {
        return this.hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }    
    
}
