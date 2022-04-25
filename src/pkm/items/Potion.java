package pkm.items;

public class Potion {
    private int qnt;

    public Potion(int qnt) {
        this.qnt = qnt;
    }

    public int getQnt() {
        return qnt;
    }

    public void reward() {
        qnt++;
    }

    public void use() {
        qnt--;
    }
}
