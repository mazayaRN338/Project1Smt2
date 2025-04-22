package com.example.project1smt2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate - static initialization");

        Button btnClick = findViewById(R.id.btnClick);
        btnClick.setOnClickListener(v -> {
            Log.d(TAG, "User klik tombol - sedang berinteraksi di onResume()");
            Toast.makeText(this, "Tombol diklik!", Toast.LENGTH_SHORT).show();
        });

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
            Log.d(TAG, "Navigasi ke SecondActivity");
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart - ketika Activity (screen) menjadi visible");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart - dipanggil jika Activity stop (dipanggil di onStart())");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume - mulai interaksi dengan user");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause - resume/kembali ke Activity sebelumnya");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop - tidak lagi visible, tapi masih exist dan semua state info bertahan");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy - final call sebelum Android system menghapus Activity");
    }
}

