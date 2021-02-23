package com.techdsf.lms.ui.sampleregister;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.techdsf.lms.R;
import com.techdsf.lms.activity.MainActivity;


public class SignInFragment extends Fragment {
    private static final String TAG = "SignInFragment";

    //All Variable
    private TextView doNotHaveAnAccount;
    private FrameLayout parentFrameLayout;
    private EditText email,password;
    private Button signInButton;
    private TextView crossButton;
    private TextView forgotTextView;

    private String emailPattern="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    //firebase variable
    private FirebaseAuth firebaseAuth;


    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started.");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        doNotHaveAnAccount = view.findViewById(R.id.notUserSignUpId);
        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);
        email = view.findViewById(R.id.logInUserEmailId);
        password = view.findViewById(R.id.logInUserPasswordId);
        signInButton = view.findViewById(R.id.logInBtnId);
        crossButton = view.findViewById(R.id.crossBtnSignInId);
        forgotTextView = view.findViewById(R.id.forgotPasswordId);


        //firebase
        firebaseAuth = FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        doNotHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: dont have an account");
                setFragment(new SignUpFragment());
            }
        });

//        forgotTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                resetPasswordFragment=true;
//                setFragment(new ResetPasswordFragment());
//            }
//        });

        crossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO email and password verification to firebase and login
                checkEmailAndPassword();
            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.salid_to_right,R.anim.salidout_to_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(email.getText().toString())){
            if (!TextUtils.isEmpty(password.getText().toString())){
                signInButton.setEnabled(true);
                signInButton.setTextColor(Color.rgb(255,255,255));
            }else {
                signInButton.setEnabled(false);
                signInButton.setTextColor(Color.argb(50,255,255,255));
            }
        }else {
            signInButton.setEnabled(false);
            signInButton.setTextColor(Color.argb(50,255,255,255));
        }
    }
    private void checkEmailAndPassword(){
        if (email.getText().toString().matches(emailPattern)){
            if (password.length()>=8){

                signInButton.setEnabled(false);
                signInButton.setTextColor(Color.argb(50,255,255,255));

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    mainIntent();
                                }else {
                                    signInButton.setEnabled(true);
                                    signInButton.setTextColor(Color.rgb(255,255,255));
                                    String error=task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }else {
                Toast.makeText(getActivity(),"Invalid email and password!",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getActivity(),"Invalid email and password!",Toast.LENGTH_SHORT).show();
        }
    }

    private void mainIntent(){
        Intent mainIntent=new Intent(getActivity(), MainActivity.class);
        startActivity(mainIntent);
        getActivity().finish();
    }
}