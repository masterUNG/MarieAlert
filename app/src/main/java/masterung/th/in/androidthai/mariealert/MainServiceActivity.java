package masterung.th.in.androidthai.mariealert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutMainServiceFragment, new ListEventFragment()).commit();
        }


    }
}
