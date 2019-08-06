package com.kshitizbali.presto.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.kshitizbali.presto.R;
import com.kshitizbali.presto.databinding.ActivityMainBinding;
import com.kshitizbali.presto.models.SignupUserModel;
import com.kshitizbali.presto.viewmodels.SignupViewModel;

public class MainActivity extends AppCompatActivity {

    private SignupViewModel signupViewModel;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        signupViewModel = ViewModelProviders.of(MainActivity.this).get(SignupViewModel.class);

        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        binding.setLifecycleOwner(MainActivity.this);
        binding.setSignupViewModel(signupViewModel);

        signupViewModel.getUser().removeObservers(MainActivity.this);
        signupViewModel.getUser().observe(MainActivity.this, new Observer<SignupUserModel>() {
            @Override
            public void onChanged(final SignupUserModel signupUserModel) {
                if (TextUtils.isEmpty(signupUserModel.getStrFirstName())) {
                    binding.atvFirstName.setError("Enter First Name");
                    binding.atvFirstName.requestFocus();
                } else if (TextUtils.isEmpty(signupUserModel.getStrLastName())) {
                    binding.atvLastName.setError("Enter Last Name");
                    binding.atvLastName.requestFocus();
                } else if (TextUtils.isEmpty(signupUserModel.getStrEmail())) {
                    binding.atvEmailId.setError("Enter a Valid Email Address");
                    binding.atvEmailId.requestFocus();
                } else if (!signupUserModel.isValidEmail()) {
                    binding.atvEmailId.setError("Enter a Valid Email Address");
                    binding.atvEmailId.requestFocus();
                } else if (TextUtils.isEmpty(signupUserModel.getStrPhone())) {
                    binding.atvPhone.setError("Enter a Valid Email Address");
                    binding.atvPhone.requestFocus();
                } else if (!signupUserModel.isValidPhone()) {
                    binding.atvPhone.setError("Enter a Valid Phone Number");
                    binding.atvPhone.requestFocus();
                } else {

                    final Handler handler = new Handler();
                    binding.progressBar.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 100ms

                            showCustomDialog(signupUserModel.getStrFirstName());
                            binding.progressBar.setVisibility(View.GONE);
                        }
                    }, 400);

                }
            }
        });

        final Animation animFade = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.fade_in);
        final Animation animFadeOut = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.fade_out);


        binding.btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.groupSignUp.getVisibility() == View.GONE) {
                    binding.groupWelcome.setVisibility(View.GONE);
                    binding.groupSignUp.setVisibility(View.VISIBLE);
                }
            }
        });


        binding.ivCancelSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.groupWelcome.getVisibility() == View.GONE) {
                    binding.groupSignUp.setVisibility(View.GONE);
                    binding.groupWelcome.setVisibility(View.VISIBLE);
                }
            }
        });

       /* Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);*/
        binding.tvLoyInfoTitle.startAnimation(animFade);
        binding.btSignUp.startAnimation(animFade);
        binding.ivRestImage.startAnimation(animFade);
    }


    private void showCustomDialog(String fName) {
        ViewGroup viewGroup = findViewById(android.R.id.content);


        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_confirm, viewGroup, false);

        TextView tvStatusSubtext = (TextView) dialogView.findViewById(R.id.tvStatusSubtext);
        Button buttonOk = (Button) dialogView.findViewById(R.id.buttonOk);

        tvStatusSubtext.setText(String.format("%s %s", getString(R.string.welcome_to_the_family), fName));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(dialogView);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                binding.atvFirstName.setText("");
                binding.atvLastName.setText("");
                binding.atvEmailId.setText("");
                binding.atvPhone.setText("");

            }
        });

    }
}
