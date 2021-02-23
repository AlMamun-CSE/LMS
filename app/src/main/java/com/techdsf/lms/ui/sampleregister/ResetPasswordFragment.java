package com.techdsf.lms.ui.sampleregister;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.techdsf.lms.R;

public class ResetPasswordFragment extends Fragment {
    private static final String TAG = "ResetPasswordFragment";

    //all variable
    private EditText registeredEmail;
    private Button resetButton;
    private TextView goBack;
    private FrameLayout parentFrameLayout;
    private ProgressBar resetpasswrodProgreesBar;
    private TextView sendemailverification;
    private ImageView emailIcon;
    private ViewGroup emailcontainer;

    //firebase
    private FirebaseAuth firebaseAuth;


    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reset_password, container, false);

        parentFrameLayout=getActivity().findViewById(R.id.register_framelayout);
        registeredEmail=view.findViewById(R.id.emailverificationId);
        resetButton=view.findViewById(R.id.resetPasswordButton);
        goBack=view.findViewById(R.id.gobackid);
        resetpasswrodProgreesBar=view.findViewById(R.id.progressBarEmail);
        emailcontainer=view.findViewById(R.id.forgotPasswordContainer);
        sendemailverification=view.findViewById(R.id.forgotText);
        emailIcon=view.findViewById(R.id.forgotEmailIcon);

        //firebase
        firebaseAuth=FirebaseAuth.getInstance();

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registeredEmail.addTextChangedListener(new TextWatcher() {
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
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });


        firebaseAuth=FirebaseAuth.getInstance();

        resetButton.setOnClickListener(v -> {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(emailcontainer);
            }
            resetpasswrodProgreesBar.setVisibility(View.GONE);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(emailcontainer);
            }

            emailIcon.setVisibility(View.VISIBLE);
            resetpasswrodProgreesBar.setVisibility(View.VISIBLE);

            resetButton.setEnabled(false);
            resetButton.setTextColor(Color.argb(50,255,255,255));

            firebaseAuth.sendPasswordResetEmail(registeredEmail.getText().toString())
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()){
                            Toast.makeText(getActivity(), "Success Full", Toast.LENGTH_SHORT).show();
                            ScaleAnimation scaleAnimation = new ScaleAnimation(1,0,1,0,emailIcon.getWidth()/2,emailIcon.getHeight()/2);
                            scaleAnimation.setDuration(100);
                            scaleAnimation.setInterpolator(new AccelerateInterpolator());
                            scaleAnimation.setRepeatMode(Animation.REVERSE);
                            scaleAnimation.setRepeatCount(1);

                            scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    sendemailverification.setText("Recovery email sent successfully ! check your inbox");
                                    sendemailverification.setTextColor(getResources().getColor(R.color.successGreen));

                                    TransitionManager.beginDelayedTransition(emailcontainer);
                                    sendemailverification.setVisibility(View.VISIBLE);

                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {
                                    emailIcon.setImageResource(R.drawable.ic_green_email_24);
                                }
                            });
                            sendemailverification.startAnimation(scaleAnimation);
                        }else {
                            String error=task.getException().getMessage();

                            resetButton.setEnabled(true);
                            resetButton.setTextColor(Color.rgb(255,255,255));

                            sendemailverification.setText(error);
                            sendemailverification.setTextColor(getResources().getColor(R.color.light_green_A700));
                            TransitionManager.beginDelayedTransition(emailcontainer);
                            sendemailverification.setVisibility(View.VISIBLE);
                        }
                        resetpasswrodProgreesBar.setVisibility(View.GONE);

                    });
        });

    }


    private void checkInputs() {
        if (!TextUtils.isEmpty(registeredEmail.getText())){
            resetButton.setEnabled(true);
            resetButton.setTextColor(Color.rgb(255,255,255));
        }else {
            resetButton.setEnabled(false);
            resetButton.setTextColor(Color.argb(50,255,255,255));
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.salid_to_left,R.anim.salidout_to_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
