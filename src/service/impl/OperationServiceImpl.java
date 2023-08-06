package service.impl;

import data.GlobalData;
import enums.ExceptionEnums;
import exception.ApplicationException;
import service.OperationService;

import static helperService.helperService.*;
import static util.InputUtil.inputInt;

public class OperationServiceImpl implements OperationService {
    public static int[][] atmCash = new int[][]{
            {1, 1},
            {5, 1},
            {10, 1},
            {20, 1},
            {50, 1},
            {100, 1},
            {200, 1},
            {500, 1}
    };

    @Override
    public void showBalance(long id) {
        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i].getId() == id) {
                System.out.println("your balance is: " + GlobalData.customers[i].getCard().getCurrentBalance());
            }
        }
    }
    @Override
    public void cashingOut(long id) {
        int cash = inputInt("enter the cashing out: ");
        isGetCashingOutAtm(cash);
        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i].getId() == id) {
                if (GlobalData.customers[i].getCard().getCurrentBalance() < cash) {
                    throw new ApplicationException(ExceptionEnums.LACK_OF_FUNDS);
                } else {
                    getCashingOut(cash);
                    GlobalData.customers[i].getCard().setCurrentBalance(GlobalData.customers[i].getCard().getCurrentBalance() - cash);
                    cashingOutReceipt(cash, i);
                }
            }
        }
    }
}


