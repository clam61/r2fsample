package com.example.r2f_sample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.r2f_sample.model.AuthenticationModel;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginValid> loginValid;

    //The model to represent authentication in whatever form it may be
    private AuthenticationModel authenticationModel;

    public LoginViewModel() {
        loginValid = new MutableLiveData<>();
        authenticationModel = new AuthenticationModel();
    }

    public LiveData<LoginValid> getLoginValid() {
        return loginValid;
    }

    public void login(String u, String p) {
        //in reality since we are talkign to the remote database this will an asyncrhonous job
        boolean valid = authenticationModel.login(u, p);

        //set the value to update any observers
        loginValid.setValue(new LoginValid(valid));
    }
}
