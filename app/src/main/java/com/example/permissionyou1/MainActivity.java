package com.example.permissionyou1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private static int REQUEST_CODE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[]permissions={Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permissions,REQUEST_CODE);


            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            showTost("Camera permissions granted");

        }else if (grantResults[0]==PackageManager.PERMISSION_DENIED){
            String[]permissions1={Manifest.permission.CAMERA};
            ActivityCompat.requestPermissions(MainActivity.this,permissions1,REQUEST_CODE);
if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                showTost("permission granted");
            }
if(grantResults[0]==PackageManager.PERMISSION_DENIED){
                showTost("permission denied");
            }

        }
    }

    private void showTost(String mesege){
        Toast.makeText(this,mesege,Toast.LENGTH_SHORT).show();
    }
}