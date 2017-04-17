package com.mksengun.loginregistertransition;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.UserProfileChangeRequest;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CompleteProfileFragment extends Fragment {


    ProgressBar progressBar;
    Button buttonContinue;
    EditText editTextName;
    private View rootView;

    public CompleteProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_complete_profile, container, false);

        progressBar = (ProgressBar) rootView.findViewById(R.id.PB_complete_profile_fragment);
        buttonContinue = (Button) rootView.findViewById(R.id.BT_continue_complete_profile_fragment);
        editTextName = (EditText) rootView.findViewById(R.id.ET_name_complete_profile_fragment);

        progressBar.setVisibility(View.GONE);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);


                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(editTextName.getText().toString())
                        .build();

                MainActivity.sCurrentUser.updateProfile(profileUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(getActivity(), "Merhaba " + MainActivity.sCurrentUser.getDisplayName(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    progressBar.setVisibility(View.GONE);
                                    Log.wtf("mksengun", "User profile not updated.");
                                }
                            }
                        });

            }
        });


        return rootView;
    }

}
