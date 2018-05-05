package ru.alexpt.android.datepickerproject;

/**
 * Created by ACERa on 25.01.2018.
 */

public class MainTest {
    public static void main(String[] args) {

//        String date1 = "21.09.2009";    // контрольные рассчетные значения для тестирования метода
//        String date2 = "29.09.2017";

        //--------------- Тестируем метод рассчета страхового стажа -----------------
        DateMetod dateMetod = new DateMetod();
        dateMetod.dateMetod();
    }
}
