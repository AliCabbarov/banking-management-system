package util;

import static util.InputUtil.*;

public class MenuUtil {
    public static byte entryMenu(){
        System.out.println("-----------/Banking Management System/-----------\n" +
                "[0]. exit System\n" +
                "[1]. Register\n" +
                "[2]. Login\n" +
                "[3]. Increase the balance");
        return inputByte("choose option: ");
    }

    public static byte operationMenu(){
        System.out.println("[1]. Show balance\n" +
                "[2]. cashing out\n" +
                "[3]. log out");
        return inputByte("choose option: ");
    }
    public static byte loginMenu(){
        System.out.println(
                "[1]. Show my details\n" +
                "[2]. update my details\n" +
                "[3]. Operations\n" +
                        "[4]. Log out");
        return inputByte("choose option: ");
    }
}
