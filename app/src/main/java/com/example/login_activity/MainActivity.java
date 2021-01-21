package com.example.login_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.login_activity.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //DataBinding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myEmail = "collinceokeyo98@gmail.com";
                String myPassword = "0708289107";

                if (binding.email.getText().toString().isEmpty()){
                    binding.email.setError("Enter Valid Email");
                }
                else if (binding.password.getText().toString().isEmpty()){
                    binding.password.setError("Enter Valid Password");
                }
                else if ((binding.email.getText().toString().isEmpty() && (binding.password.getText().toString().isEmpty()))){
                    Toast.makeText(MainActivity.this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show();
                }
                else if (binding.email.getText().toString().equals(myEmail) && binding.password.getText().toString().equals(myPassword)){
                    String url = "https://github.com/Collince-Okeyo";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);

                }
            }
        });

        binding.loginFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fbUrl = "https://www.facebook.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(fbUrl));
                startActivity(intent);
            }
        });
    }
}