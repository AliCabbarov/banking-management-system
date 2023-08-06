package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import model.Customer;
import service.CardManagementService;
import service.CardService;
import service.CustomerManagementService;
import service.OperationManagementService;

import static util.MenuUtil.loginMenu;

public class CardManagementServiceImpl implements CardManagementService {
    @Override
    public void cardManage(long id) {
        while (true) {
            try {
                CardService cardService = new CardServiceImpl();
                CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
                OperationManagementService operationManagementService = new OperationManagementServiceImpl();
                int option = loginMenu();
                switch (option) {
                    case 1:
                        cardService.showDetails(id);
                        break;
                    case 2:
                        cardService.updateMyDetails(id);
                        break;
                    case 3:
                        operationManagementService.operationManage(id);
                        break;
                    case 4:
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
