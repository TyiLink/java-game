package pkm.items;

public class Pokeball {
    private int qnt;

    public Pokeball(int qnt) {
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
