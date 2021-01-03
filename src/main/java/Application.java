import service.AdminService;

public class Application {

    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        adminService.printDebts();
    }
}
