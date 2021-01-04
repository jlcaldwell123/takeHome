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
        return "{ id : " + id
                + ", amount : " + amount + " }";
    }

    public String toString(boolean paymentPlan) {
        return "{ id : " + id
                + ", amount : " + amount
                + ", is_in_payment_plan : " + paymentPlan + " }";
    }
}
