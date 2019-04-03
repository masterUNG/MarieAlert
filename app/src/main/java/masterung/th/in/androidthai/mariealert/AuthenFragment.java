package masterung.th.in.androidthai.mariealert;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 */
public class AuthenFragment extends Fragment {

    private CheckBox checkBox;
    private boolean statusLoginABoolean = false;
    private MyConstant myConstant = new MyConstant();


    public AuthenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//       Initial View
        checkBox = getView().findViewById(R.id.chbRemember);


//        Check Remember
        checkRemember();

    }   // Main Method

    private void checkRemember() {

        try {

            SharedPreferences sharedPreferences = getActivity()
                    .getSharedPreferences(myConstant.getRememberFile(), Context.MODE_PRIVATE);
            statusLoginABoolean = sharedPreferences.getBoolean("StatusLogin", false);

            if (statusLoginABoolean) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authen, container, false);
    }

}
