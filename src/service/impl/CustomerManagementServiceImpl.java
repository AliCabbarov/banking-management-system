package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import service.CustomerManagementService;
import service.CustomerService;

import static util.MenuUtil.entryMenu;

public class CustomerManagementServiceImpl implements CustomerManagementService {
    @Override
    public void customerManage() {
        while (true) {
            try {
                CustomerService customerService = new CustomerServiceImpl();
                try {
                    int option = entryMenu();
                    switch (option) {
                        case 0:
                            System.exit(-1);
                        case 1:
                            customerService.register();
                            break;
                        case 2:
                            customerService.login();
                            break;
                        case 3:
                            customerService.increaseTheBalance();
                            break;
                        default:
                            throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                    }
                } catch (ApplicationException exception) {
                    System.out.println(exception.getMessage());
                }
            }catch (RuntimeException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
