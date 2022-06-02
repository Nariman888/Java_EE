package practice1.db;

import practice1.application.ZAKAZ;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<ZAKAZ> allOrders = new ArrayList<>();
    private static long id=0L;

    public static void addOrders(ZAKAZ zakaz) {
        zakaz.setId(id);
        allOrders.add(zakaz);
        id++;

    }
    public static ArrayList<ZAKAZ> getAllOrders(){
        return allOrders;
    }
}
