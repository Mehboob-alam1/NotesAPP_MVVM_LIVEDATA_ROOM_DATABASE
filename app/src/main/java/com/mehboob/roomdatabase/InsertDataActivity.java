package com.mehboob.roomdatabase;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.mehboob.roomdatabase.databinding.ActivityInsertDataBinding;

public class InsertDataActivity extends AppCompatActivity {


    private ActivityInsertDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInsertDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnAdd.setOnClickListener(v -> {
            Intent i = new Intent();

            i.putExtra("title",binding.etTitle.getText().toString());
            i.putExtra("desc",binding.etDesc.getText().toString());
            setResult(RESULT_OK,i);
            finish();
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(InsertDataActivity.this, MainActivity.class));
    }
}