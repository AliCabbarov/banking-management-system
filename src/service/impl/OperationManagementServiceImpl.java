package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import service.CustomerManagementService;
import service.OperationManagementService;
import service.OperationService;

import static util.MenuUtil.operationMenu;

public class OperationManagementServiceImpl implements OperationManagementService {

    @Override
    public void operationManage(long id) {
        while (true) {
            try {
                OperationService operationService = new OperationServiceImpl();
                CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
                int option = operationMenu();
                switch (option) {
                    case 1:
                        operationService.showBalance(id);
                        break;
                    case 2:
                        operationService.cashingOut(id);
                        break;
                    case 3:
                        customerManagementService.customerManage();
                    default:
                        throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
