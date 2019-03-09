package com.batuhan.untils.Activities.Login.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.batuhan.untils.Activities.MainPages.View.GirisActivity;
import com.batuhan.untils.Helpers.Helper;
import com.batuhan.untils.Activities.Login.Presenter.LoginPresenter;
import com.batuhan.untils.R;

public class LoginActivity extends Fragment implements LoginPresenter.LoginView {

    private EditText editTextLoginPassword,editTextLoginEmail;
    private Button buttonLoginSignIn , buttonLoginQuestionMark;
    private TextView textViewLoginForgotPassword;
    private Helper helper;
    private LoginPresenter presenter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        //Fragment yapısında view atamamız gereklidir.
        final View view = inflater.inflate(R.layout.activity_login,container,false);

        presenter = new LoginPresenter(this);

        editTextLoginPassword = view.findViewById(R.id.editTextLoginPassword);
        editTextLoginEmail = view.findViewById(R.id.editTextLoginEmail);
        buttonLoginSignIn = view.findViewById(R.id.buttonLoginSignIn);
        buttonLoginQuestionMark = view.findViewById(R.id.buttonLoginQuestionMark);
        textViewLoginForgotPassword = view.findViewById(R.id.textViewLoginForgotPassword);


        editTextLoginEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.checkUsernamePassword(editTextLoginEmail,editTextLoginPassword);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.checkUsernamePassword(editTextLoginEmail,editTextLoginPassword);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Dışa tıklandığında klavyeyi kapatma
        editTextLoginEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    helper.hideKeyboardFrom(getActivity(),view);
                }
            }
        });

        //Dışa tıklandığında klavyeyi kapatma
        editTextLoginPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    helper.hideKeyboardFrom(getActivity(),view);
                }
            }
        });

        buttonLoginSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presenter.checkUsernamePassword(editTextLoginEmail,editTextLoginPassword)){
                    helper.makeShortToast("Giriş Başarılı",getActivity());
                    Intent i = new Intent(getActivity(),GirisActivity.class);
                    startActivity(i);
                }else{
                    loginFailedToast("Wrong Email or Password",getActivity());
                }
            }
        });

        buttonLoginQuestionMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.makeShortToast("You dont need help!",getActivity());
            }
        });

        textViewLoginForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.makeShortToast("Şifremi Unuttum!",getActivity());
            }
        });


        return view;

    }


    @Override
    public void loginFailedToast(String text, Context context) {
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();

    }
}
