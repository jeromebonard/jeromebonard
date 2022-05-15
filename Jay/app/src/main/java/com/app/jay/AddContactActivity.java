package com.app.jay;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {

    Button btnValidate;
    EditText txtName,txtSurname,dateBirth,numberTel,txtMail;
    EditText txtPostalC,txtCity;
    RadioGroup rgGender;
    Contact contact;

    @Override
    public void onBackPressed() {
        Intent intentB = new Intent();
        intentB.putExtra("AddToMain", contact.toString());
        setResult(RESULT_OK, intentB);
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        btnValidate = findViewById(R.id.btnValidate);
        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        dateBirth = findViewById(R.id.dateBirth);
        numberTel = findViewById(R.id.numberTel);
        txtMail = findViewById(R.id.txtMail);
        txtPostalC = findViewById(R.id.txtPostalC);
        txtCity = findViewById(R.id.txtCity);
        rgGender = findViewById(R.id.rgGender);
        String str = getIntent().getStringExtra("MainToAdd");

        btnValidate.setOnClickListener(view -> {
        verifycontent();

        this.contact = new Contact(txtName.getText().toString(), txtSurname.getText().toString(), numberTel.getText().toString());


        });
    }

        public void verifycontent(){
            if(txtName.getText().toString().equals("") ||
                    (txtSurname.getText().toString().equals("")) ||
                    (numberTel.getText().toString().equals(""))){
                Toast toast = Toast.makeText(getApplicationContext(), "Champ requis non renseigné",Toast.LENGTH_LONG);
                toast.show();
            }
            else showContent();
        }
        public void showContent(){
            String rgGenderChoice = "";
            if(rgGender.getCheckedRadioButtonId() == rgGender.getChildAt(0).getId()){
                rgGenderChoice = "Female";
            }else if(rgGender.getCheckedRadioButtonId() == rgGender.getChildAt(1).getId()){
                rgGenderChoice = "Male";
            }
            String saisie = rgGenderChoice + "\n"
            + txtName.getText().toString() +" " + txtSurname.getText().toString() + "\n"
            + dateBirth.getText().toString() + "\n"
            + numberTel.getText().toString() +"\n"
            + txtMail.getText().toString() + "\n"
            + txtPostalC.getText().toString() + " " + txtCity.getText().toString();

            AlertDialog.Builder builder = new AlertDialog.Builder(AddContactActivity.this);
            builder.setMessage(saisie).setTitle("Informations saisies");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
}