package com.example.noahdoperalskigreenflag;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity
{

    Button nextButton;
    TextInputEditText email;
    TextInputEditText password;
    TextInputEditText repeatPassword;

    Boolean emailValid = false;
    Boolean passwordValid = false;
    Boolean repeatValid = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().hide();
        nextButton = findViewById(R.id.btnNext);
        email = findViewById(R.id.tietEmailAddress);
        password = findViewById(R.id.tietPassword);
        repeatPassword = findViewById(R.id.tietRepeatPassword);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                //Pattern p = Pattern.compile("^[a-zA-Z0-9]+@.[a-zA-Z]$");
                //Pattern p = Pattern.compile("^[A-Za-z0-9+_.-](@)[a-zA-Z]$");
                Pattern p = Pattern.compile("^([A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,})$", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher((email.getText()).toString());

                emailValid = m.matches();
                if (emailValid)
                {
                    Drawable drawable = getApplicationContext().getResources().getDrawable(R.drawable.tick2x);
                    email.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                }
                else
                {
                    Drawable drawable = getApplicationContext().getResources().getDrawable(R.drawable.cross2x);
                    email.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);

                }

                Log.d("DEBUG", emailValid.toString());

                checkValidation();
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                Pattern p = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
                Matcher m = p.matcher(Objects.requireNonNull(password.getText()).toString());
                passwordValid = m.matches();
                if (passwordValid)
                {
                    Drawable drawable = getApplicationContext().getResources().getDrawable(R.drawable.tick2x);
                    password.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                }
                else
                {
                    Drawable drawable = getApplicationContext().getResources().getDrawable(R.drawable.cross2x);
                    password.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);

                }
                Log.d("DEBUG", passwordValid.toString());
                checkValidation();
            }
        });

        repeatPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                repeatValid = Objects.requireNonNull(repeatPassword.getText()).toString().equals(Objects.requireNonNull(password.getText()).toString());

                if (repeatValid)
                {
                    Drawable drawable = getApplicationContext().getResources().getDrawable(R.drawable.tick2x);
                    repeatPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                }
                else
                {
                    Drawable drawable = getApplicationContext().getResources().getDrawable(R.drawable.cross2x);
                    repeatPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);

                }
                Log.d("DEBUG", repeatValid.toString());
                checkValidation();
            }
        });



        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                Pattern p = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
                Matcher m = p.matcher(Objects.requireNonNull(password.getText()).toString());
                passwordValid = m.matches();
                if (passwordValid)
                {
                    Drawable drawable = getApplicationContext().getResources().getDrawable(R.drawable.tick2x);
                    password.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                }
                else
                {
                    Drawable drawable = getApplicationContext().getResources().getDrawable(R.drawable.cross2x);
                    password.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);

                }
                Log.d("DEBUG", passwordValid.toString());
                checkValidation();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Log.d("DEBUG", "Toasting");
                Toast.makeText(SecondActivity.this,"Email", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    public void checkValidation()
    {
        nextButton.setEnabled(emailValid && passwordValid && repeatValid);
    }


}
