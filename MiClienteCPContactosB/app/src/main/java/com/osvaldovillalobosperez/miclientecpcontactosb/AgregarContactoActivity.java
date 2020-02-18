package com.osvaldovillalobosperez.miclientecpcontactosb;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class AgregarContactoActivity extends AppCompatActivity {
    EditText etUsuarioA, etMailA, etTelefonoA, etFechaNacA;
    Button btnAgregarA, btnCancelarA;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        etUsuarioA = findViewById(R.id.txtUsuarioCrear);
        etMailA = findViewById(R.id.txtEmailCrear);
        etTelefonoA = findViewById(R.id.txtTelefonoCrear);
        etFechaNacA = findViewById(R.id.txtFechaNacimientoCrear);
        btnAgregarA = findViewById(R.id.btnAgregarCrear);
        btnCancelarA = findViewById(R.id.btnCancelarCrear);
        btnAgregarA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuarioA.getText().toString(),
                        email = etMailA.getText().toString(),
                        telefono = etTelefonoA.getText().toString(),
                        fechaNac = etFechaNacA.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put(ContractCPContactos.FIELD_USUARIO, usuario);
                contentValues.put(ContractCPContactos.FIELD_EMAIL, email);
                contentValues.put(ContractCPContactos.FIELD_TEL, telefono);
                contentValues.put(ContractCPContactos.FIELD_FECHANACIMIENTO, fechaNac);
                getContentResolver().insert(ContractCPContactos.CONTENT_URI, contentValues);
                finish();
            }
        });
        btnCancelarA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
