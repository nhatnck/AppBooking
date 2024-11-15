package com.example.appfood.Activity;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.appfood.R;
import com.example.appfood.databinding.ActivitySignInBinding;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignInNewActivity extends BaseActivity {
    ActivitySignInBinding binding;
    private static final int RC_SIGN_IN = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_sign_in_new);
        int status = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if (status != ConnectionResult.SUCCESS) {
            // Google Play Services không có sẵn, xử lý tình huống này
            GoogleApiAvailability.getInstance().getErrorDialog(this, status, 0).show();
        }

        setVariable();
        changeSreenSignUp();
    }
    private void setVariable() {
        Toast.makeText(this, "DAY DAY 1111", Toast.LENGTH_SHORT).show();

        binding.btnSignIn.setOnClickListener(v -> {
            Toast.makeText(this, "DAY DAY 22222", Toast.LENGTH_SHORT).show();

//            String email = binding.emailEdt.getText().toString();
//            String password= binding.passwordEdt.getText().toString();
//            Log.d("THISSS", "ddddd " + email + password);
//
//            if(!email.isEmpty() && !password.isEmpty()) {
//                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(SignInNewActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            startActivity(new Intent(SignInNewActivity.this, MainActivity.class));
//                        }else {
//                            Toast.makeText(SignInNewActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }else {
//                Toast.makeText(SignInNewActivity.this, "Please fill email and password", Toast.LENGTH_SHORT).show();
//            }
        });

    }

    private void changeSreenSignUp() {
        binding.txtSignUp.setOnClickListener(v -> {
            Log.d("TESSST ", "LOGIN");
            startActivity(new Intent(SignInNewActivity.this, SignUpActivity.class));
            Toast.makeText(SignInNewActivity.this, "OK", Toast.LENGTH_LONG).show();
        });
    }
}