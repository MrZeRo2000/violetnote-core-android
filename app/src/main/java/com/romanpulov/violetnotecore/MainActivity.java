package com.romanpulov.violetnotecore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.romanpulov.violetnotecore.AESCrypt.AESCryptException;
import com.romanpulov.violetnotecore.Service.StringCryptService;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText encryptStringEdit = findViewById(R.id.encryptStringEdit);
        final EditText encryptPasswordEdit = findViewById(R.id.encryptPasswordEdit);

        final TextView encryptedStringText = findViewById(R.id.encryptedStringText);
        final TextView decryptedStringText = findViewById(R.id.decryptedStringText);

        final TextView errorText = findViewById(R.id.errorText);

        final Button encryptAES128Button = findViewById(R.id.encryptAES128Button);
        encryptAES128Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    encryptedStringText.setText(
                        StringCryptService.encryptStringAES128(encryptStringEdit.getText().toString(), encryptPasswordEdit.getText().toString())
                    );
                    errorText.setText(null);
                } catch (AESCryptException | IOException e) {
                    e.printStackTrace();
                    errorText.setText(e.getMessage());
                }
            }
        });

        final Button decryptAES128Button = findViewById(R.id.decryptAES128Button);
        decryptAES128Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    decryptedStringText.setText(
                            StringCryptService.decryptStringAES128(encryptedStringText.getText().toString(), encryptPasswordEdit.getText().toString())
                    );
                    errorText.setText(null);
                } catch (AESCryptException | IOException e) {
                    e.printStackTrace();
                    errorText.setText(e.getMessage());
                }
            }
        });

        final Button encryptAES256Button = findViewById(R.id.encryptAES256Button);
        encryptAES256Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    encryptedStringText.setText(
                            StringCryptService.encryptStringAES256(encryptStringEdit.getText().toString(), encryptPasswordEdit.getText().toString())
                    );
                    errorText.setText(null);
                } catch (AESCryptException | IOException e) {
                    e.printStackTrace();
                    errorText.setText(e.getMessage());
                }
            }
        });

        final Button decryptAES256Button = findViewById(R.id.decryptAES256Button);
        decryptAES256Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    decryptedStringText.setText(
                            StringCryptService.decryptStringAES256(encryptedStringText.getText().toString(), encryptPasswordEdit.getText().toString())
                    );
                    errorText.setText(null);
                } catch (AESCryptException | IOException e) {
                    e.printStackTrace();
                    errorText.setText(e.getMessage());
                }
            }
        });
        

    }
}