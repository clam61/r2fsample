package com.example.r2f_sample.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.r2f_sample.R;
import com.example.r2f_sample.pojo.User;
import com.example.r2f_sample.viewmodel.MenuState;
import com.example.r2f_sample.viewmodel.MenuViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    MenuViewModel menuViewModel;

    @Override
    protected void onStart() {
        super.onStart();

        //load the user
        menuViewModel.loadUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        menuViewModel = new ViewModelProvider(this).get(MenuViewModel.class);
        menuViewModel.getMenuState().observe(this, new Observer<MenuState>() {
            @Override
            public void onChanged(MenuState menuState) {
                if (menuState != null) {
                    if (menuState.getSuccess()) {
                        finish();
                    }
                    else {
                        ///TODO
                    }
                }
            }
        });

        menuViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User u) {
                if (u != null) {
                    final TextView fullName = findViewById(R.id.menu_full_name);
                    final TextView address1 = findViewById(R.id.menu_address_1);
                    final TextView address2 = findViewById(R.id.menu_address_2);
                    final TextView city = findViewById(R.id.menu_city);
                    final Spinner state = findViewById(R.id.menu_state);
                    final TextView zip = findViewById(R.id.menu_zip);

                    fullName.setText(u.getFullName());
                    address1.setText(u.getAddress1());
                    address2.setText(u.getAddress2());
                    city.setText(u.getCity());
                    state.setSelection(getSpinnerIndex(u.getState(), state));
                    zip.setText(u.getZip());
                }
            }
        });

        final Button doneButton = findViewById(R.id.done);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView fullName = findViewById(R.id.menu_full_name);
                final TextView address1 = findViewById(R.id.menu_address_1);
                final TextView address2 = findViewById(R.id.menu_address_2);
                final TextView city = findViewById(R.id.menu_city);
                final Spinner state = findViewById(R.id.menu_state);
                final TextView zip = findViewById(R.id.menu_zip);

                User user = new User(fullName.getText().toString(), address1.getText().toString(),
                        address2.getText().toString(), city.getText().toString(), state.getSelectedItem().toString(),
                        zip.getText().toString());
                menuViewModel.saveUser(user);
            }
        });
    }

    private int getSpinnerIndex(String myString, Spinner spinner) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)) {
                return i;
            }
        }

        return 0;
    }
}