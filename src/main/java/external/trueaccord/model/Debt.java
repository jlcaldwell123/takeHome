package external.trueaccord.model;

public class Debt {

    private int id;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Debt{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
