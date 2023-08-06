import service.CustomerManagementService;
import service.impl.CustomerManagementServiceImpl;

public class Main {
    public static void main(String[] args) {
         CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
         customerManagementService.customerManage();



    }
}