package helperService;

import data.GlobalData;
import enums.ExceptionEnums;
import exception.ApplicationException;
import model.Card;
import model.Customer;

import java.time.LocalDateTime;
import java.util.Random;

import static service.impl.OperationServiceImpl.atmCash;
import static util.InputUtil.inputString;

public class helperService {
    private static long id = 1;
    private static long cardId = 1;
    private static int countIndex = 0;

    public static boolean appropriationCustomer() {
        Customer customer = fillCustomer();
        if (customer != null) {
            GlobalData.customers[countIndex] = customer;
            countIndex++;
            return true;
        }
        return false;
    }

    private static Customer fillCustomer() {
        try {

            String name = inputString("enter the name: ");
            String surname = inputString("enter the surname the: ");
            String email = inputString("enter the email: ");

            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (GlobalData.customers[i] != null) {
                    if (GlobalData.customers[i].getEmail().equals(email)) {
                        throw new ApplicationException(ExceptionEnums.SAME_EMAIL_EXCEPTION);
                    }
                }
            }
            String password = inputString("enter the password: ");
            Random random = new Random();
            String cardNumber = "41695844" + random.nextInt(10000000, 99999999);
            Card card = new Card(++cardId, cardNumber, 0, null);
            return new Customer(id++, name, surname, email, password, true, false, LocalDateTime.now(), null, card, (byte) 0);
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
            return null;
        }
    }

    public static void deleteNullCustomer() {
        int nullCount = 0;
        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i] == null) {
                nullCount++;
            }

        }
        Customer[] tempLibrary = GlobalData.customers;
        GlobalData.customers = new Customer[GlobalData.customers.length - nullCount];
        for (int i = 0; i < GlobalData.customers.length; i++) {
            GlobalData.customers[i] = tempLibrary[i];
        }
        zeroCountIndex();
    }

    public static void zeroCountIndex() {
        if (GlobalData.customers.length == 0) {
            GlobalData.customers = null;
            countIndex = 0;
        }
    }

    public static void cashingOutReceipt(double tempCash, int i) {
        System.out.println("-----Cash receipt-------\n" +
                "Date and Time: " + LocalDateTime.now() +
                "\n Card number: " + GlobalData.customers[i].getCard().getCardNumber().substring(0, 4) + " **** **** " + GlobalData.customers[i].getCard().getCardNumber().substring(12, 16) +
                "\nCash: -" + tempCash + " azn\n" +
                "Total remain balance: " + GlobalData.customers[i].getCard().getCurrentBalance() + " azn\n" +
                "-------------------------");
    }

    public static void increaseTheBalanceReceipt(double money, int i) {
        System.out.println("-----Cash receipt-------\n" +
                "Date and Time: " + LocalDateTime.now() +
                "\n Card number: " + GlobalData.customers[i].getCard().getCardNumber().substring(0, 4) + " **** **** " + GlobalData.customers[i].getCard().getCardNumber().substring(12, 16) +
                "\namount: +" + money + " azn\n" +
                "Total remain balance: " + GlobalData.customers[i].getCard().getCurrentBalance() + " azn\n" +
                "-------------------------");
    }

    public static void getCashingOut(int cash) {
        int tempCash = cash;
        int numberMany;
        for (int j = atmCash.length - 1; j >= 0; j--) {
            numberMany = tempCash / atmCash[j][0];
            if (atmCash[j][1] > 0 && numberMany > 0) {
                if (atmCash[j][1] > numberMany) {
                    System.out.println(tempCash / atmCash[j][0] + "-s-" + atmCash[j][0]);
                    atmCash[j][1] = atmCash[j][1] - numberMany;
                    tempCash = tempCash % atmCash[j][0];
                } else {
                    System.out.println(atmCash[j][1] + "-s-" + atmCash[j][0]);
                    tempCash = tempCash - atmCash[j][0] * atmCash[j][1];
                    atmCash[j][1] = 0;
                }
            }
        }
    }

    public static void isGetCashingOutAtm(int cash) {
        int sum = 0;
        for (int i = 0; i < atmCash.length; i++) {
            if (cash >= atmCash[i][0]) {
                sum += atmCash[i][0] * atmCash[i][1];
            }
        }
        if (sum < cash) {
            throw new ApplicationException(ExceptionEnums.LOW_BALANCE_IN_ATM_EXCEPTION);
        }
    }
}
