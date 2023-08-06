package service.impl;

import data.GlobalData;
import enums.Status;
import model.Customer;
import service.CardService;
import service.CustomerManagementService;

import java.time.LocalDateTime;

import static util.InputUtil.inputString;

public class CardServiceImpl implements CardService {
    @Override
    public void showDetails(long id) {
        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i].getId() == id) {
                System.out.println(GlobalData.customers[i].getInfo());
            }
        }
    }

    @Override
    public void updateMyDetails(long id) {
        System.out.println("if you dont update press enter!!!");
        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i].getId() == id) {
                String updateName = inputString("enter the update name: ");
                if (updateName.isEmpty()) {
                } else {
                    GlobalData.customers[i].setName(updateName);
                    GlobalData.customers[i].setUpdateDate(LocalDateTime.now());
                }
                String updateSurname = inputString("enter the update surname: ");
                if (updateName.isEmpty()) {
                } else {
                    GlobalData.customers[i].setSurname(updateSurname);
                    GlobalData.customers[i].setUpdateDate(LocalDateTime.now());
                }
                String updateEmail = inputString("enter the update email: ");
                if (updateName.isEmpty()) {
                } else {
                    GlobalData.customers[i].setEmail(updateEmail);
                    GlobalData.customers[i].setUpdateDate(LocalDateTime.now());
                }
                String updatePassword = inputString("enter the new password: ");
                String oldPassword = inputString("enter the old password: ");
                if (GlobalData.customers[i].getPassword().equals(oldPassword)) {
                    if (updatePassword.isEmpty()) {
                    } else {
                        GlobalData.customers[i].setPassword(updatePassword);
                        GlobalData.customers[i].setUpdateDate(LocalDateTime.now());
                    }
                }
                System.out.println(Status.UPDATE_SUCCESSFULLY);
                customerManagementService.customerManage();
            }

        }

    }


}
