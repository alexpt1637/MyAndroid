package ru.alexpt.android.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ACERa on 15.01.2018.
 */

// Необходимо указать что класс унаследован от класса SQLiteOpenHelper
public class DBHelper extends SQLiteOpenHelper {

    // создаем константы для версии БД, имени БД и имени таблицы
    public static final int DATABASE_VERSION = 1; // указываем версию БД = 1, номер версии проверяется в методе onUpgrade
    public static final String DATABASE_NAME = "contactDb";
    public static final String TABLE_CONTACTS = "contactDb";

    // создаем константы для столбцов таблицы
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_MAIL = "mail"; // далее эти константы переносим в конструктор ниже

    // реализуем конструктор с 4 параметрами: context, имя базы, объект класса CursorFactory, версию базы банных
    public DBHelper(Context context) {
        // занулим CursorFactory, т.к. сейчас он не используется (служит для расширения класа Cursor)
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // заменяем name, version константами
        // выше в классе DBHelper создаем константы для версии БД, имени БД и имени таблицы
    }

    @Override   // метод создает базу данных, если она не существует
    public void onCreate(SQLiteDatabase db) {
        // реализуем логику создания таблиц и заполнения их начальными данными с помощью команд SQL
        db.execSQL("create table " + TABLE_CONTACTS + " (" + KEY_ID
                + " integer primary key," + KEY_NAME + " text" + ") ");
    }

    @Override   // метод срабатывает при изменении номера версии
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // формируем запрос на уничтожение таблицы
        db.execSQL("drop table if exists " + TABLE_CONTACTS);

        // вновь вызываем метод onCreate для создания новой таблицы с обновленной структурой
        onCreate(db);
        // продолжим работу с базой данных в классе SQLiteActivity
    }
}
