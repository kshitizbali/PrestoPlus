package com.kshitizbali.presto.viewmodels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kshitizbali.presto.models.SignupUserModel;

public class SignupViewModel extends ViewModel {

    public MutableLiveData<String> firstName = new MutableLiveData<>();
    public MutableLiveData<String> lastName = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> phone = new MutableLiveData<>();

    private MutableLiveData<SignupUserModel> signupUserModelMutableLiveData;

    public MutableLiveData<SignupUserModel> getUser() {
        if (signupUserModelMutableLiveData == null) {
            signupUserModelMutableLiveData = new MutableLiveData<SignupUserModel>();
        }
        return signupUserModelMutableLiveData;
    }

    public void onClick(View view) {
        SignupUserModel signupUserModel = new SignupUserModel(firstName.getValue(), lastName.getValue(), email.getValue(), phone.getValue());
        signupUserModelMutableLiveData.setValue(signupUserModel);
    }
}
