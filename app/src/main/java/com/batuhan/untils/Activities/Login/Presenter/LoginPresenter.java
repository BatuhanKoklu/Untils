package com.batuhan.untils.Activities.Login.Presenter;

import android.content.Context;
import android.widget.EditText;

import com.batuhan.untils.Models.User;

public class LoginPresenter {

    private User user;
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        this.user = new User();
    }

    public boolean checkUsernamePassword(EditText etxtEmail , EditText etxtPassword){
        if(user.getUserEmail() == etxtEmail.getText().toString() && user.getUserPassword() == etxtPassword.getText().toString()){
            return true;
        }
        else{
            return false;
        }
    }

    public interface LoginView{

        void loginFailedToast(String text, Context context);
    }
}
