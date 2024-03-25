package com.example.musicplayer;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DatabaseActivity extends AppCompatActivity {

    FirebaseAuth authUser;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        authUser = FirebaseAuth.getInstance();
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.all_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idSelected = item.getItemId();

        if (idSelected == R.id.menuupdate) {
            Intent intent = new Intent(DatabaseActivity.this, UpdateActivity.class);
            startActivity(intent);
        } else if (idSelected == R.id.yourprofile) {
            Intent intent = new Intent(DatabaseActivity.this, YourProfile.class);
            startActivity(intent);
        } else if (idSelected == R.id.deleteprofile) {
            Intent intent = new Intent(DatabaseActivity.this, DeleteProfileActivity.class);
            startActivity(intent);
        }

        else if (idSelected == R.id.logout) {
            authUser.signOut();
            Toast.makeText(DatabaseActivity.this, "Logged Out", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(DatabaseActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}