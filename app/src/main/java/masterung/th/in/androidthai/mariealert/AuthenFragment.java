package masterung.th.in.androidthai.mariealert;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;


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

//        Login Controller
        loginController();

    }   // Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                String user = userEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                MasterAlert masterAlert = new MasterAlert(getActivity());

                if (user.isEmpty() || password.isEmpty()) {
//                    Have Space
                    masterAlert.normalDialog(myConstant.getTitleHaveSpace(), myConstant.getMessageHaveSpace());
                } else {

                    try {

                        GetUserWhereOneColumnThread getUserWhereOneColumnThread = new GetUserWhereOneColumnThread(getActivity());
                        getUserWhereOneColumnThread.execute("User", user, myConstant.getUrlGetUserWhereUser());
                        String result = getUserWhereOneColumnThread.get();
                        Log.d("5AprilV1", "result ==>>> " + result);

                        if (result.equals("null")) {
                            masterAlert.normalDialog(myConstant.getTitleUserFalse(), myConstant.getMessageUserFalse());
                        } else {
                            JSONArray jsonArray = new JSONArray(result);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            if (password.equals(jsonObject.getString("Password"))) {

                            } else {
                                masterAlert.normalDialog(myConstant.getTitlePasswordFalse(), myConstant.getMessagePasswordFalse());
                            }
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }   // onClick
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        checkRemember();
    }

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
