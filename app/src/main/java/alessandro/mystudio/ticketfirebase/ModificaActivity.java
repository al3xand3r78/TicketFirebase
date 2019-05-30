package alessandro.mystudio.ticketfirebase;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class ModificaActivity extends AppCompatActivity {

    private MaterialSearchView mMaterialSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_search_resault);

        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        //toolbar2.setTitleTextColor("#");

        mMaterialSearch = findViewById(R.id.searchview);

        /*SearchView simpleSearchView = (SearchView)findViewById(R.id.search);
        boolean isIconfied = simpleSearchView.isIconfiedByDefault();*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        mMaterialSearch.setMenuItem(menuItem);
        return super.onCreateOptionsMenu(menu);
    }
}
