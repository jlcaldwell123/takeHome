package external.trueaccord.model;

import java.util.ArrayList;
import java.util.List;

public class DebtList {
    private List<Debt> debts;

    public DebtList() {
        debts = new ArrayList<>();
    }

    public List<Debt> getDebts() {
        return debts;
    }

    public void setDebts(List<Debt> debts) {
        this.debts = debts;
    }

    // standard constructor and getter/setter
}