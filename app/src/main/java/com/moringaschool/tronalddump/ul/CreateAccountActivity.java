package com.moringaschool.tronalddump.ul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.tronalddump.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = CreateAccountActivity.class.getSimpleName();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;// AuthListener to Listen to Authenticate User Account
    @BindView(R.id.createUserButton) Button mCreateUserButton;
    @BindView(R.id.nameEditText) EditText mEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText)EditText mPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @BindView(R.id.loginTextView) TextView mLoginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        mAuth=FirebaseAuth.getInstance();

        mLoginTextView.setOnClickListener(this);// redirect to login
        mCreateUserButton.setOnClickListener(this);//submit new user
         createAuthListener();//Calling Create AuthListener method

    }
    public void createNewUser(){
        final String name = mEditText.getText().toString().trim();
        final String email = mEmailEditText.getText().toString().trim();
        final String password = mPasswordEditText.getText().toString().trim();
        final String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "Authentification Successful");
                        }
                        else {
                            Toast.makeText(CreateAccountActivity.this, "Authentification Failed",
                            Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    public void createAuthListener(){

    }

    @Override
    public void onClick(View view) {
        if (view==mLoginTextView){
            Intent intent= new Intent(CreateAccountActivity.this, loginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (view==mCreateUserButton){
            createNewUser();
        }
    }
}