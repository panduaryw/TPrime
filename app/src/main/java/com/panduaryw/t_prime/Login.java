package com.panduaryw.t_prime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.util.Log;
import android.support.annotation.NonNull;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText etUsername, etPassword;
    String username, password;
    Button login,register;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseRef;
    private String TAG = "com.panduaryw.tprime";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("user");
        mAuth = FirebaseAuth.getInstance();
        progressDialog =  new ProgressDialog(Login.this);
        etUsername = (EditText) findViewById(R.id.text_username);
        etPassword = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.btn_login);
        register = (Button) findViewById(R.id.btn_register);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataUser();
                doLogin();
            }
        });
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }

    private void getDataUser() {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
    }

    private void doLogin() {
        final String lEmail = etUsername.getText().toString();
        final String lPass = etPassword.getText().toString();
        progressDialog.setMessage("Please Wait");

        // Showing progressDialog.
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(lEmail, lPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent x = new Intent(Login.this, Dashboard.class);
                            startActivity(x);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            progressDialog.dismiss();
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }

}