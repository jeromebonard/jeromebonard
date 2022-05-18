package com.app.jay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ShowDetailContact extends AppCompatActivity {

        Button btnValidate;
        EditText txtName,txtSurname,dateBirth,numberTel,txtMail;
        EditText txtPostalC,txtCity;
        RadioGroup rgGender;
        String rgGenderChoice;
        Contact contact;

        @Override
        public void onBackPressed() {

            Intent intentB = new Intent();
            intentB.putExtra("contact", contact);
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
            });

            contact = (Contact) getIntent().getSerializableExtra("contact");
            setInfosContact();

        }

        public void verifycontent(){
            if(txtName.getText().toString().equals("") ||
                    (txtSurname.getText().toString().equals("")) ||
                    (numberTel.getText().toString().equals(""))){
                Toast toast = Toast.makeText(getApplicationContext(), "Champ(s) requis non renseigné(s)",Toast.LENGTH_LONG);
                toast.show();
            }
            else {
                showContent();
            }
        }
        public void showContent(){

            if(rgGender.getCheckedRadioButtonId() == rgGender.getChildAt(0).getId()){
                this.rgGenderChoice = "Female";
            }else if(rgGender.getCheckedRadioButtonId() == rgGender.getChildAt(1).getId()){
                this.rgGenderChoice = "Male";
            }
            /*
            String saisie = rgGenderChoice + "\n"
            + txtName.getText().toString() +" " + txtSurname.getText().toString() + "\n"
            + dateBirth.getText().toString() + "\n"
            + numberTel.getText().toString() +"\n"
            + txtMail.getText().toString() + "\n"
            + txtPostalC.getText().toString() + " " + txtCity.getText().toString();
            */

            contact.setTxtName(txtName.getText().toString());
            contact.setSurname(txtSurname.getText().toString());
            contact.setGender(rgGenderChoice);

            AlertDialog.Builder alert = new AlertDialog.Builder(ShowDetailContact.this);
            alert.setTitle("Informations saisies");;
            alert.setMessage(contact.toString());
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intentB = new Intent();
                    intentB.putExtra("contact", contact);
                    setResult(RESULT_OK, intentB);
                    onBackPressed();
                }
            });
            alert.show();
        }
        public void setInfosContact(){
            this.txtName.setText(this.contact.getTxtName());
        }
}
