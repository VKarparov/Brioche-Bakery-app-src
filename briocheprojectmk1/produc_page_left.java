package com.example.briocheprojectmk1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;


public class produc_page_left extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ImageButton button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produc_page_left);

        button = (ImageButton) findViewById(R.id.home_page2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMiddle();
            }
        });

        button2 = (Button) findViewById(R.id.contacts_page);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRight();
            }
        });

    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.dots_menu);
        popup.show();
    }

    public void  openActivityMiddle() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        CustomIntent.customType(this, "fadein-to-fadeout");
        finish();
    }

    public void openActivityRight() {
        Intent intent = new Intent(this, contacts_page_right.class);
        startActivity(intent);
        CustomIntent.customType(this, "fadein-to-fadeout");
        finish();
    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                CustomIntent.customType(this, "fadein-to-fadeout");
                finish();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Up to date", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Goodbye", Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);
                return true;
            default:
                return false;
        }
    }
}