package com.techdsf.lms.ui.sampleregister;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.techdsf.lms.R;
import com.techdsf.lms.activity.MainActivity;

import java.util.HashMap;
import java.util.Map;

public class SignUpFragment extends Fragment {
    private static final String TAG = "SignUpFragment";


    //All Variable
    private TextView alreadyHaveAnAccount;
    private FrameLayout parentFrameLayout;
    private EditText email,fullName,password,confirmPassword,phoneNumber;
    private TextView crossBtn;
    private Button signUpButton;
    private String emailPattern="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";


    //firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started.");
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);

        alreadyHaveAnAccount=view.findViewById(R.id.alreadyHaveAnAccountLogInId);
        parentFrameLayout=getActivity().findViewById(R.id.register_framelayout);
        email=view.findViewById(R.id.signUpUserEmailId);
        fullName=view.findViewById(R.id.signUpUserNameId);
        password=view.findViewById(R.id.signUpUserPasswordId);
        confirmPassword=view.findViewById(R.id.signUpUserConfirmPasswordId);
        phoneNumber = view.findViewById(R.id.signUpUserPhoneNumberid);
        crossBtn=view.findViewById(R.id.crossBtnId);
        signUpButton=view.findViewById(R.id.signUpBtnId);

        //firebaseAuth
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: sign in ");
                setFragment(new SignInFragment());
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
        fullName.addTextChangedListener(new TextWatcher() {
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
        confirmPassword.addTextChangedListener(new TextWatcher() {
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

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: send data the firebase
                checkEmailAndPassword();

            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.salid_to_left,R.anim.salidout_to_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    private void checkInputs(){
        if (!TextUtils.isEmpty(fullName.getText())){
            if (!TextUtils.isEmpty(email.getText())){
                if (!TextUtils.isEmpty(password.getText()) && password.length()>=8){
                    if (!TextUtils.isEmpty(confirmPassword.getText())){
                        signUpButton.setEnabled(true);
                        signUpButton.setTextColor(Color.rgb(255,255,255));
                    }else {
                        signUpButton.setEnabled(false);
                        signUpButton.setTextColor(Color.argb(50,255,255,255));
                    }
                }else {
                    signUpButton.setEnabled(false);
                    signUpButton.setTextColor(Color.argb(50,255,255,255));
                }
            }else {
                signUpButton.setEnabled(false);
                signUpButton.setTextColor(Color.argb(50,255,255,255));
            }
        }else{
            signUpButton.setEnabled(false);
            signUpButton.setTextColor(Color.argb(50,255,255,255));
        }
    }

    private void checkEmailAndPassword(){
        Drawable customDrable=getResources().getDrawable(R.drawable.ic_error_icon_black);
        customDrable.setBounds(0,0,customDrable.getIntrinsicWidth(),customDrable.getIntrinsicHeight());

        if (email.getText().toString().matches(emailPattern)){
            if (password.getText().toString().equals(confirmPassword.getText().toString())){

                signUpButton.setEnabled(false);
                signUpButton.setTextColor(Color.rgb(255,255,255));

                //create account firebase
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){

                                    Map<Object,String> userdata=new HashMap<>();
                                    userdata.put("fullName",fullName.getText().toString());
                                    userdata.put("email",email.getText().toString());
                                    userdata.put("phoneNumber",phoneNumber.getText().toString());
                                    userdata.put("Password",password.getText().toString());

                                    firebaseFirestore.collection("USERS")
                                            .add(userdata)
                                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                                    if (task.isSuccessful()){
                                                        Intent mainIntent=new Intent(getActivity(), MainActivity.class);
                                                        startActivity(mainIntent);
                                                        getActivity().finish();
                                                    }else {
                                                        signUpButton.setEnabled(true);
                                                        signUpButton.setTextColor(Color.argb(50,255,255,255));
                                                        String error=task.getException().getMessage();
                                                        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            });

                                }else {
                                    signUpButton.setEnabled(true);
                                    signUpButton.setTextColor(Color.argb(50,255,255,255));
                                    String error=task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }else {
                confirmPassword.setError("Password doesn't matched.",customDrable);
            }
        }else {
            email.setError("Invalid email!",customDrable);
        }
    }

}