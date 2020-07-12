package com.example.r2f_sample.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.r2f_sample.R;
import com.example.r2f_sample.viewmodel.LoginValid;
import com.example.r2f_sample.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;

    @Override
    public void onResume() {
        super.onResume();

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final TextView errorMsg = findViewById(R.id.error_msg);

        //clear form
        errorMsg.setText("");
        password.setError(null);
        username.getText().clear();
        password.getText().clear();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final Button login = findViewById(R.id.login);
        final TextView errorMsg = findViewById(R.id.error_msg);

        loginViewModel.getLoginValid().observe(this, new Observer<LoginValid>() {
            @Override
            public void onChanged(LoginValid loginValid) {
                //clear error message
                password.setError(null);
                errorMsg.setText("");

                if (loginValid != null) {
                    if (loginValid.isValid()) {
                        //go to next activity
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                    else {
                        String errString = getString(loginValid.getLoginError());
                        password.setError(errString);
                        errorMsg.setText(errString);
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login(username.getText().toString(), password.getText().toString());
            }
        });
    }
}