package ru.alexpt.android.testview

import android.content.Context
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteStatement







class ActivityNew3 : AppCompatActivity() {

    // Имя базы данных
    private val DATABASE_NAME = "mydatabase.db"
    private val TABLE_NAME = "table1"
    private val DATABASE_VERSION = 1

    private var context: Context? = null
    private var db: SQLiteDatabase? = null

    private val INSERT = ("insert into $TABLE_NAME(name) values (?)")
    private var insertStmt: SQLiteStatement? = null

    // Структура нашей таблицы будет следующей: CREATE TABLE table1 (id INTEGER PRIMARY KEY, name TEXT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new3)

        // Таблица создается в методе onCreate():
    }

    fun DataHelper(context: Context) {
        this.context = context
        val openHelper = OpenHelper(this.context)
        this.db = openHelper.getWritableDatabase()
        this.insertStmt = this.db!!.compileStatement(INSERT)
    }

    // Действие при вставке записи
    fun insert(name: String): Long {
        this.insertStmt.bindString(1, name)
        return this.insertStmt.executeInsert()
    }

    fun deleteAll() {
        // Удаляем все записи в таблице
        this.db.delete(TABLE_NAME, null, null)
    }

    fun selectAll() {

        var list: ArrayList<String> = ArrayList<String>()

        var query = this.db!!.query(TABLE_NAME, (String.get()) { "name" }, null, null, null, null, "name desc")

    }
}