package alessandro.mystudio.ticketfirebase.RecyclerView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import alessandro.mystudio.ticketfirebase.AggiugiParcelable;
import alessandro.mystudio.ticketfirebase.FirebaseDatabaseHelper;
import alessandro.mystudio.ticketfirebase.R;
import alessandro.mystudio.ticketfirebase.RecyclerView_Config;

public class Visualizza extends AppCompatActivity {

   private MaterialSearchView mMaterialSearch;

    private ArrayList <Ticket> mExampleList ;

    RecyclerView mRecyclearView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    Toolbar mToolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        /*//todo modalita FullScreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mMaterialSearch = findViewById(R.id.searchview);

        createExampleList();
        BuildRecyclearView();
        createNewTicket();

    }
    //TODO nuova scheda Ticket
    public void createNewTicket() {
        /*Bundle incomingMessages = getIntent().getExtras();
        if(incomingMessages != null){
            int  ticket = Integer.parseInt(incomingMessages.getString("ticket"));
            //String ticket = incomingMessages.getString("ticket");
            String redattore = incomingMessages.getString("redattore");
            String targa = incomingMessages.getString("targa");
            int dataA = Integer.parseInt(incomingMessages.getString("dataA"));
            String materiale = incomingMessages.getString("materiale");
            int dataC = Integer.parseInt(incomingMessages.getString("dataC"));

            //TODO creazione nuova scheda Ticket
            Ticket Ticket = new Ticket(ticket,redattore,targa,dataA,materiale,dataC);
            //mExampleList.add(Ticket);
            //mAdapter.notifyDataSetChanged();

        }*/
        //collect our intent
        Intent intent = getIntent();
        AggiugiParcelable parcelable = intent.getParcelableExtra("Visualizza");

        Integer ticket = parcelable.getParcTicket();
        String  redattore = parcelable.getParcRedattore();
        String  targa = parcelable.getParcTarga();
        Integer dataA = parcelable.getParcDataApertura();
        String  materiale = parcelable.getParcMaterialeG();
        Integer dataC = parcelable.getParcDataChiusura();

        //TODO creazione nuova scheda Ticket
        Ticket Ticket = new Ticket(ticket,redattore,targa,dataA,materiale,dataC);

    }

    //TODO Costruzione della RecyclerView
    public void BuildRecyclearView() {
        //todo dichiarazione adapter e chiamiamo il suo costruttore passandogli i parametri necessari
        mRecyclearView  = findViewById(R.id.miorecyclerView);
        mRecyclearView.setHasFixedSize(true);
        //todo assegnazione LinearLayoutManager alla RecyclearView
        mLayoutManager = new LinearLayoutManager(this);
        //todo set LinearLayoutManager
        mAdapter = new ExampleAdapter(mExampleList);
        mRecyclearView.setLayoutManager(mLayoutManager);
        //TODO COLLEGAMENTO ADAPTER ALLA TABLELYOUT
        mRecyclearView.setAdapter(mAdapter);


    }

    //TODO Esempio di ArrayList
    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new Ticket(123356,"ALESSANDRO","EP562WS",12052018,"Lampeggiante Guasto",23102018));
        mExampleList.add(new Ticket(34567,"FRANCESCO", "EP762NS",19052019,"Motore Guasto",21052019));
        mExampleList.add(new Ticket(34353,"ALESSANDRO","EP760WR",25052017,"Freni Guasti",10122018));
    }

    //TODO Procedura ToolBar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        mMaterialSearch.setMenuItem(menuItem);

        /*getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        mMaterialSearch.setMenuItem(menuItem);*/

        /*SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length()>0){
                   mAdapter.getFilter().filter(newText);
                }else{
                    loadData();
                }
                return false;
            }
        });
        return true;*/

        return true;
    };

    //TODO Procedura di selezione pulsante Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_salva){

            Toast.makeText(Visualizza.this,"Hai premuto il tasto Salva",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    /*//TODO PROCEDURA DI SALVATAGGIO RICEVENDO I PARAMETRI DAL Aggiungi.CLASS
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mExampleList);
        editor.putString("arrayticket",json);
        editor.apply();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("arrayticket",null);
        Type type = new TypeToken<ArrayList<Ticket>>(){}.getType();
        mExampleList = gson.fromJson(json,type);

        if(mExampleList == null){
            mExampleList = new ArrayList<>();
        }
    }*/


}
