import external.trueaccord.model.Debt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.AdminService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class MainTestCases {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private AdminService adminService;
    private String expectedDebtsOutput = "{ id : 0, amount : 123.46, is_in_payment_plan : true, remaining_amount : 20.959999999999994, next_payment_due_date : 2020-11-05 }\n" +
            "{ id : 1, amount : 100.0, is_in_payment_plan : true, remaining_amount : 50.0, next_payment_due_date : 2020-08-15 }\n" +
            "{ id : 2, amount : 4920.34, is_in_payment_plan : true, remaining_amount : 607.6700000000001, next_payment_due_date : 2020-08-22 }\n" +
            "{ id : 3, amount : 12938.0, is_in_payment_plan : true, remaining_amount : 9247.744999999999, next_payment_due_date : 2020-08-01 }\n" +
            "{ id : 4, amount : 9238.02, is_in_payment_plan : false, remaining_amount : 9238.02, next_payment_due_date : null }\n";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        adminService = new AdminService();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void printDebts() {
        adminService.printDebts();
        assertEquals(expectedDebtsOutput, outContent.toString());
    }

    @Test
    public void debtInPaymentPlan() {
        Debt debt = new Debt();
        debt.setId(1);
        assertEquals(true, adminService.isInPaymentPlan(debt));
    }

    @Test
    public void debtNotInPaymentPlan() {
        Debt debt = new Debt();
        debt.setId(55);
        assertEquals(false, adminService.isInPaymentPlan(debt));
    }

    @Test
    public void debtPaidOff() {
        Debt debt = new Debt();
        debt.setId(0);
        debt.setAmount(102.5);
        assertEquals(0.0, adminService.calculateRemainingAmount(debt));
    }

    @Test
    public void debtRemainingFullPaymentPlan() {
        Debt debt = new Debt();
        debt.setId(1);
        debt.setAmount(100);
        assertEquals(50.0, adminService.calculateRemainingAmount(debt));
    }

    @Test
    public void debtRemainingPartialPaymentPlan() {
        Debt debt = new Debt();
        debt.setId(1);
        debt.setAmount(150);
        assertEquals(100.0, adminService.calculateRemainingAmount(debt));
    }

    @Test
    public void nextPaymentAfterDelayed() {
        Debt debt = new Debt();
        debt.setId(0);
        assertEquals("2020-11-05", adminService.getNextPaymentDate(debt));
    }

    @Test
    public void nextPaymentNormal() {
        Debt debt = new Debt();
        debt.setId(1);
        assertEquals("2020-08-15", adminService.getNextPaymentDate(debt));
    }

    @Test
    public void nextPaymentFirstPayment() {
        Debt debt = new Debt();
        debt.setId(3);
        assertEquals("2020-08-01", adminService.getNextPaymentDate(debt));
    }
}
