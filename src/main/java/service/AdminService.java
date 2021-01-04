package service;

import external.trueaccord.model.Debt;
import external.trueaccord.model.Payment;
import external.trueaccord.model.PaymentPlan;
import external.trueaccord.service.TrueAccordService;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

    private TrueAccordService trueAccordService;
    private List<Debt> debts;
    private List<Payment> payments;
    private List<PaymentPlan> paymentPlans;

    public AdminService() {
        trueAccordService = new TrueAccordService();
        debts = this.trueAccordService.getDebts();
        paymentPlans = this.trueAccordService.getPaymentPlans();
        payments = this.trueAccordService.getPayments();
    }

    public void printDebts() {
        if (debts != null && !debts.isEmpty()) {
            for (Debt debt: debts) {
                System.out.println(debt.toString(isInPaymentPlan(debt)));
            }
        }
    }

    public boolean isInPaymentPlan(Debt debt) {
        if (debt != null && paymentPlans != null
                && !paymentPlans.isEmpty()) {
            for (PaymentPlan paymentPlan: paymentPlans) {
                if (paymentPlan.getDebt_id() == debt.getId()) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
