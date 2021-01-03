package external.trueaccord.model;

public class Payment {

    private int payment_plan_id;
    private double amount;
    private String date;

    public int getPayment_plan_id() {
        return payment_plan_id;
    }

    public void setPayment_plan_id(int payment_plan_id) {
        this.payment_plan_id = payment_plan_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_plan_id=" + payment_plan_id +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
