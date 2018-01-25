package ru.alexpt.android.datepickerproject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ACERa on 25.01.2018.
 */

public class DateMetod {

    String date1, date2, resYars;
    Date dateOne, dateTwo;
    long difference;
    int days, yars, months;

    public String dateMetod(){

        date1 = "21.01.2009";
        date2 = "07.08.2015";

        // ---------------------------- Количество дней между датами --------------------------------------

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        dateOne = null;
        dateTwo = null;

        try {
            dateOne = format.parse(date1);
            dateTwo = format.parse(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //---------------------- Количество дней между датами в миллисекундах ---------------------------------

        difference = dateTwo.getTime() - dateOne.getTime();

        //-------------- Перевод количества дней между датами из миллисекунд в дни ----------------------------

        days =  (int)(difference / (24 * 60 * 60 * 1000)); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)

        yars = days / 365;

        months = (days - yars * 365) / 30;

        resYars = "Страховой стаж: " + yars + " лет " + months + " мес.";
        System.out.println(resYars);
        return resYars;
    }
}
