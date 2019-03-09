package com.batuhan.untils.Activities.Register.Presenter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.batuhan.untils.Models.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPresenter {

    public User user;
    public RegisterView registerView;



    public void getNewUserData(EditText email,EditText username , EditText password , String image){


        User newUser = new User(1,username.getText().toString(),password.getText().toString(),password.getText().toString(),image,null);

    }

    //Password Password must contain at least one letter, at least one number, and be longer than six charaters.
    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{6,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();

    }

    public boolean confirmEditTextChange(Context context, View view , EditText registerPassword , EditText registerEmail , EditText registerUsername , Button registerBtnSignUp){
        String passwordText = registerPassword.getText().toString();
        if(isValidPassword(registerPassword.getText().toString().trim()) && isValidEmail(registerEmail.getText()) && registerUsername != null){

            registerBtnSignUp.setTextColor(Color.argb(255,37, 105, 181));
            registerBtnSignUp.setEnabled(true);
            return true;
        }else{
            registerBtnSignUp.setTextColor(Color.argb(255,182, 182, 182));
            registerBtnSignUp.setEnabled(false);
            return false;
        }
    }

    public interface RegisterView{

        void passwordInfo();
        void succsesfulRegisterInfo();
        void checkRegister();

    }
}
