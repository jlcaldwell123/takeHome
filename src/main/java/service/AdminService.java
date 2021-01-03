package service;

import external.trueaccord.service.TrueAccordService;

public class AdminService {

    private TrueAccordService trueAccordService;

    public AdminService() {
        this.trueAccordService = new TrueAccordService();
    }

    public boolean outDebts() {
        System.out.println(this.trueAccordService.getDebts());
        System.out.println(this.trueAccordService.getPaymentPlans());
        System.out.println(this.trueAccordService.getPayments());
        return true;
    }
}
