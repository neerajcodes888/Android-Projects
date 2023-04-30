package com.example.tool_bar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Droid CAFE");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
          if(itemId==R.id.order)
              Toast.makeText(this, "You ordered an item ", Toast.LENGTH_SHORT).show();
        if(itemId==R.id.contact)
            Toast.makeText(this, " You Selected  Contact", Toast.LENGTH_SHORT).show();
        if(itemId==R.id.Status)
            Toast.makeText(this, "You Selected  Satus ", Toast.LENGTH_SHORT).show();
        if(itemId==R.id.Favorites)
            Toast.makeText(this, "You Selected Favorites", Toast.LENGTH_SHORT).show();

          return super.onOptionsItemSelected(item);

    }
}
