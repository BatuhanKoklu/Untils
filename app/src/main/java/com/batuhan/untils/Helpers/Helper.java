package com.batuhan.untils.Helpers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.batuhan.untils.Models.User;
import com.batuhan.untils.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;


public class Helper {

    public Helper() {

    }

    public static class BlurBuilder {

        private static final float BITMAP_SCALE = 0.6f;
        private static final float BLUR_RADIUS = 15f;

        public static Bitmap blur(Context context, Bitmap image) {
            int width = Math.round(image.getWidth() * BITMAP_SCALE);
            int height = Math.round(image.getHeight() * BITMAP_SCALE);

            Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
            Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);

            RenderScript rs = RenderScript.create(context);

            ScriptIntrinsicBlur intrinsicBlur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
            Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
            Allocation tmpOut = Allocation.createFromBitmap(rs, outputBitmap);

            intrinsicBlur.setRadius(BLUR_RADIUS);
            intrinsicBlur.setInput(tmpIn);
            intrinsicBlur.forEach(tmpOut);
            tmpOut.copyTo(outputBitmap);

            return outputBitmap;
        }
    }

    //Short Toast Olusturma
    public void makeShortToast(String text , Context context){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    //Klavye Kapatma
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    //Email doğrulama
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();

    }


    //Email password kontrol ile birlikte button rengi değiştirme
    public boolean confirmUsernamePasswordChangeColor(Context context, View view , EditText editTextPassword , Button button){
        String passwordText = editTextPassword.getText().toString();
        if(passwordText.length() > 5 && isValidEmail(editTextPassword.getText())){

            button.setTextColor(Color.argb(255,37, 105, 181));
            return true;
        }else{

            button.setTextColor(Color.argb(255,182, 182, 182));
            return false;
        }
    }


    public void urlToImage(String url , final ImageView imageView , final Context context){

        Picasso.get()
                .load(url)
                .placeholder(R.drawable.icon_person)
                .error(R.drawable.icon_error)
                .into(imageView);

    }

}
