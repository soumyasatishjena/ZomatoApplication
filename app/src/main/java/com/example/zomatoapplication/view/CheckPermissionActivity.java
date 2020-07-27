package com.example.zomatoapplication.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.zomatoapplication.R;
import com.example.zomatoapplication.databinding.ActivityCheckPermissionBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import static android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS;

public class CheckPermissionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Permission");
        super.onCreate(savedInstanceState);
        ActivityCheckPermissionBinding binding = DataBindingUtil.
                setContentView(this, R.layout.activity_check_permission);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            callActivity();
            return;
        }
        binding.btnGrantPermission.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnGrantPermission){
            Dexter.withActivity(this)
                    .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    .withListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted(PermissionGrantedResponse response) {
                           callActivity();
                        }

                        @Override
                        public void onPermissionDenied(PermissionDeniedResponse response) {
                            if(response.isPermanentlyDenied()){
                                AlertDialog.Builder builder = new
                                        AlertDialog.Builder(CheckPermissionActivity.this);
                                builder.setTitle(R.string.permission_denied)
                                        .setMessage(R.string.message)
                                        .setNegativeButton(R.string.cancel, null)
                                        .setPositiveButton(R.string.ok,
                                                (dialog, which) -> {
                                                    Intent intent = new Intent();
                                                    intent.setAction
                                                            (ACTION_APPLICATION_DETAILS_SETTINGS);
                                                    intent.setData(Uri.fromParts("package",
                                                            getPackageName(), null));
                                                })
                                        .show();
                            } else {
                                Toast.makeText(CheckPermissionActivity.this, R.string.denied,
                                        Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(PermissionRequest permission,
                                                                       PermissionToken token) {
                            token.continuePermissionRequest();
                        }
                    }).check();
        }
    }

    private void callActivity(){
        startActivity(new Intent(CheckPermissionActivity.this,
                PromotionActivity.class));
        finish();
    }
}