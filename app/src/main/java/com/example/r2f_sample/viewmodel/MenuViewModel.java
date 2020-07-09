package com.example.r2f_sample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.r2f_sample.model.UserModel;
import com.example.r2f_sample.pojo.User;

public class MenuViewModel extends ViewModel {

    private MutableLiveData<MenuState> menuState;
    private MutableLiveData<User> user;
    private UserModel userModel;

    public MenuViewModel() {
        super();

        menuState = new MutableLiveData<>();
        user = new MutableLiveData<>();
        userModel = new UserModel();
    }

    public LiveData<User> getUser() {
        return user;
    }

    public LiveData<MenuState> getMenuState() {
        return menuState;
    }

    public void saveUser(User user) {
        //save the user into the model
        boolean saved = userModel.saveUser(user);

        //update the status
        menuState.setValue(new MenuState(saved));
    }

    public void loadUser() {
        //load the user from the model
        User u = userModel.loadUser();

        //update the value
        if (u != null) {
            user.setValue(u);
        }
    }
}
