package masterung.th.in.androidthai.mariealert;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainServiceActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private MyConstant myConstant = new MyConstant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutMainServiceFragment, new ListEventFragment()).commit();
        }

//        Create Toolbar
        toolbar = findViewById(R.id.toolbarMainService);
        setSupportActionBar(toolbar);

    }   // Main Method



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_service, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemLogout) {
            myLogout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void myLogout() {
        SharedPreferences sharedPreferences = MainServiceActivity.this.getSharedPreferences(myConstant.getRememberFile(), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
