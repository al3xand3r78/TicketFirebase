package alessandro.mystudio.ticketfirebase;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import alessandro.mystudio.ticketfirebase.RecyclerView.Visualizza;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo60x);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(" ");


    }

    public void AGGIUNGI(View view) {
        Intent intent = new Intent(MainActivity.this, Aggiungi.class);
        startActivity(intent);
        //finish();
    }

    public void Visualizza(View view) {
        Intent intent2 = new Intent(MainActivity.this, Visualizza.class);
        startActivity(intent2);
        //finish();
    }

    public void Modifica(View view) {

        Intent intent3 = new Intent(MainActivity.this, ModificaActivity.class);
        startActivity(intent3);
    }
}
