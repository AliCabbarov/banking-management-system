package service.impl;

import data.GlobalData;
import enums.ExceptionEnums;
import enums.Status;
import exception.ApplicationException;
import model.Customer;
import service.CardManagementService;
import service.CustomerService;

import java.time.LocalDateTime;

import static helperService.helperService.*;
import static util.InputUtil.inputInt;
import static util.InputUtil.inputString;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void register() {
        int count = inputInt("How many register: ");
        if (GlobalData.customers == null) {
            GlobalData.customers = new Customer[count];
            for (int i = 0; i < GlobalData.customers.length; i++) {
                boolean isTrue = appropriationCustomer();
                if (isTrue) {
                    System.out.println(Status.REGISTER_SUCCESSFULLY);
                }
            }
        } else {
            Customer[] tempCustomer = GlobalData.customers;
            GlobalData.customers = new Customer[GlobalData.customers.length + count];
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (i < tempCustomer.length) {
                    GlobalData.customers[i] = tempCustomer[i];
                } else {
                    boolean isTrue = appropriationCustomer();
                    if (isTrue) {
                        System.out.println(Status.REGISTER_SUCCESSFULLY);
                    }
                }

            }
        }
        deleteNullCustomer();


    }

    @Override
    public void login() {
        CardManagementService cardManagementService = new CardManagementServiceImpl();
        String email = inputString("enter the email: ");
        String password = inputString("password: ");
        if (GlobalData.customers == null) {
            throw new ApplicationException(ExceptionEnums.NOT_FOUND_EXCEPTION);
        }
        boolean customerDoesntExist = true;
        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i].getEmail().equals(email)) {
                customerDoesntExist = false;
                if (GlobalData.customers[i].getPassword().equals(password)) {
                    if (GlobalData.customers[i].isBlockStatus()) {
                        throw new ApplicationException(ExceptionEnums.BLOCKED_CUSTOMER_EXCEPTION);
                    }
                    System.out.println("Welcome Dear_____" + GlobalData.customers[i].getName());
                    GlobalData.customers[i].setBlocAttempts((byte) 0);
                    cardManagementService.cardManage(GlobalData.customers[i].getId());
                } else {
                    GlobalData.customers[i].setBlocAttempts((byte) (GlobalData.customers[i].getBlocAttempts() + 1));
                }
                if (GlobalData.customers[i].getBlocAttempts() == 3) {
                    System.out.println(Status.BLOCKED.name());
                    GlobalData.customers[i].setBlockStatus(true);
                }
            }
        }
        if (customerDoesntExist) {
            throw new ApplicationException(ExceptionEnums.NOT_FOUND_EXCEPTION);
        }
    }

    @Override
    public boolean increaseTheBalance() {

        String cardNumber = inputString("enter the curd number: ");
        if (GlobalData.customers == null) {
            throw new ApplicationException(ExceptionEnums.NOT_FOUND_EXCEPTION);
        }
        boolean blockedCustomer = true;
        boolean customerDoesNotExist = true;
        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i].getCard().getCardNumber().equals(cardNumber)) {
                customerDoesNotExist = false;
                if (!GlobalData.customers[i].isBlockStatus()) {
                    blockedCustomer = false;
                    int money = inputInt("enter the money: (input the Integer type)");
                    if (money >= 1) {
                        GlobalData.customers[i].getCard().setCurrentBalance(GlobalData.customers[i].getCard().getCurrentBalance() + money);
                        System.out.println(Status.SUCCESS);
                        increaseTheBalanceReceipt(money,i);
                    } else throw new ApplicationException(ExceptionEnums.WRONG_MONEY_EXCEPTION);
                }

            }
        }
        if (customerDoesNotExist) {
            throw new ApplicationException(ExceptionEnums.NOT_FOUND_EXCEPTION);
        }
        if (blockedCustomer) {
            throw new ApplicationException(ExceptionEnums.BLOCKED_CUSTOMER_EXCEPTION);
        }
        return true;
    }
}
