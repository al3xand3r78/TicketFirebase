package alessandro.mystudio.ticketfirebase;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import alessandro.mystudio.ticketfirebase.RecyclerView.Visualizza;

public class Aggiungi extends AppCompatActivity {



     EditText ed_ticket,ed_redattore,ed_targa,ed_dataA,ed_materiale,ed_dataC;
     Button salva;
     AggiugiParcelable parcelable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Aggiungi");


        ed_ticket = findViewById(R.id.editex_ticket);
        ed_redattore = findViewById(R.id.editex_redattore);
        ed_targa = findViewById(R.id.editex_targa);
        ed_dataA = findViewById(R.id.editex_dataA);
        ed_materiale = findViewById(R.id.editex_materiale);
        ed_dataC = findViewById(R.id.editex_dataC);
        salva = findViewById(R.id.btn_save);

        ed_ticket.addTextChangedListener(aggiungTextWatcher);
        ed_redattore.addTextChangedListener(aggiungTextWatcher);
        ed_targa.addTextChangedListener(aggiungTextWatcher);
        ed_dataA.addTextChangedListener(aggiungTextWatcher);
        ed_materiale.addTextChangedListener(aggiungTextWatcher);
        ed_dataC.addTextChangedListener(aggiungTextWatcher);


        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Parsing String To Integer

                int tk = Integer.parseInt(ed_ticket.getText().toString());
                int datA = Integer.parseInt(ed_dataA.getText().toString());
                int datC = Integer.parseInt(ed_dataC.getText().toString());

                //Created object of type Student and passed Age,Name and Roll Number
                parcelable = new AggiugiParcelable(tk,ed_redattore.getText().toString(),ed_targa.getText().toString(),datA,ed_materiale.getText().toString(),datC);

                Intent intent = new Intent(Aggiungi.this, Visualizza.class);
                intent.putExtra("Visualizza", parcelable);
                startActivity(intent);
            }
        });


    }
    private TextWatcher aggiungTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String newTicket = ed_ticket.getText().toString().trim();
            String newRedattore = ed_redattore.getText().toString().trim();
            String newTarga = ed_targa.getText().toString().trim();
            String newDataA = ed_dataA.getText().toString().trim();
            String newMateriale = ed_materiale.getText().toString().trim();
            String newDataC = ed_dataC.getText().toString().trim();
            salva.setEnabled(!newTicket.isEmpty() && !newRedattore.isEmpty() && !newTarga.isEmpty() && !newDataA.isEmpty() && !newMateriale.isEmpty() && !newDataC.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    /*public void SAVE(View view) {
        //get string from ed_ view objects


        Intent intentV = new Intent(Aggiungi.this, Visualizza.class);



        //TODO CONVERSIONE TICKET DA INTERO A STRINGA
        Intent intent = new Intent(Aggiungi.this, Visualizza.class);
        intent.putExtra("ticket",newTicket);
        intent.putExtra("redattore",newRedattore);
        intent.putExtra("targa",newTarga);
        intent.putExtra("dataA",newDataA);
        intent.putExtra("materiale",newMateriale);
        intent.putExtra("dataC",newDataC);
        startActivity(intent);
        finish();
    }*/
    /*private boolean ticketValido(String ticket){
        if(!ticket.isEmpty())
            return true;
        else
            Toast.makeText(getApplicationContext(),"Inserisci il numero ticket",Toast.LENGTH_LONG).show();
            return false;
    }*/

}
