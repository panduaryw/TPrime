package com.panduaryw.t_prime;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register extends AppCompatActivity {

    //inisiasi
    EditText textUsername,textNama,textPassword,textAlamat,textTelepon,textIdentitas;
    String username,namaLengkap,password,alamat,noHp,noIdentitas;
    private String USERNAME_KEY = "USERNAME";
    private String NAMA_KEY = "NAMA";
    private String PASSWORD_KEY = "PASSWORD";
    private String ALAMAT_KEY = "ALAMAT";
    private String HP_KEY = "NO_HP";
    private String ID_KEY = "NO_IDENTITAS";
    FirebaseAuth mAuth;
    DatabaseReference mDatabaseRef;
    Button btnRegister;
    FirebaseFirestore db;
    public static  final  String COLLECTION_NAME_KEY = "users";
//    private static final String REGISTER_URL="http://rezaeffendy.com/tprime/userRegister.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("user");
        textUsername=(EditText)findViewById(R.id.text_username);
        textNama=(EditText)findViewById(R.id.text_fullname);
        textPassword=(EditText)findViewById(R.id.password);
        textAlamat=(EditText)findViewById(R.id.alamat);
        textTelepon=(EditText)findViewById(R.id.telepon);
        textIdentitas=(EditText)findViewById(R.id.identitas);
        btnRegister=(Button)findViewById(R.id.btn_register);
        db = FirebaseFirestore.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doRegister();
            }
        });
    }

    // mengambil data dari yang kita input
    private void doRegister(){
            namaLengkap = textNama.getText().toString();
            username = textUsername.getText().toString();
            password = textPassword.getText().toString();
            alamat = textAlamat.getText().toString();
            noHp = textTelepon.getText().toString();
            noIdentitas = textIdentitas.getText().toString();
            mAuth.createUserWithEmailAndPassword(username, password)
                    .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Users users = new Users(namaLengkap, username, password, alamat, noHp, noIdentitas);
                                String uploadId = mDatabaseRef.push().getKey();
                                mDatabaseRef.child(uploadId).setValue(users);
                                Toast.makeText(Register.this, "Register success", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Register.this, Dashboard.class);
                                startActivity(i);
                                finish();
                            }
                        }
                    });
        }
    }
