package com.example.sathya.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sathya.myapplication.db.RealmController;
import com.example.sathya.myapplication.db.model.Book;

import java.util.ArrayList;

import io.realm.Realm;

public class HomeActivity extends Activity implements View.OnClickListener {
    private Realm realm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.submit).setOnClickListener(this);

        Realm.getDefaultInstance();
        this.realm = RealmController.with(this).getRealm();
        setRealmData();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            RealmController.getInstance().refresh();
            Log.i("DataBase Size", RealmController.getInstance().getBooks().size() + "<<");
        }
    }

    private void setRealmData() {
        ArrayList<Book> arrayList = new ArrayList<>();
        Book book = new Book();
        book.setId(1 + System.currentTimeMillis());
        book.setAuthor("Reto Meier");
        book.setTitle("Android 4 Application Development");
        book.setImageUrl("http://api.androidhive.info/images/realm/1.png");
        arrayList.add(book);

        book = new Book();
        book.setId(2 + System.currentTimeMillis());
        book.setAuthor("Itzik Ben-Gan");
        book.setTitle("Microsoft SQL Server 2012 T-SQL Fundamentals");
        book.setImageUrl("http://api.androidhive.info/images/realm/2.png");
        arrayList.add(book);

        book = new Book();
        book.setId(3 + System.currentTimeMillis());
        book.setAuthor("Magnus Lie Hetland");
        book.setTitle("Beginning Python: From Novice To Professional Paperback");
        book.setImageUrl("http://api.androidhive.info/images/realm/3.png");
        arrayList.add(book);

        book = new Book();
        book.setId(4 + System.currentTimeMillis());
        book.setAuthor("Chad Fowler");
        book.setTitle("The Passionate Programmer: Creating a Remarkable Career in Software Development");
        book.setImageUrl("http://api.androidhive.info/images/realm/4.png");
        arrayList.add(book);

        book = new Book();
        book.setId(5 + System.currentTimeMillis());
        book.setAuthor("Yashavant Kanetkar");
        book.setTitle("Written Test Questions In C Programming");
        book.setImageUrl("http://api.androidhive.info/images/realm/5.png");
        arrayList.add(book);

        for (Book b : arrayList) {
            realm.beginTransaction();
            realm.copyToRealm(b);
            realm.commitTransaction();
        }


    }
}
