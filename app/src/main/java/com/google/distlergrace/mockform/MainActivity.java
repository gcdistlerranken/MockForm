package com.google.distlergrace.mockform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //Constants
    final String NIP = "NO INPUT PROVIDED";

    //Widgets
    EditText    editTextName;
    EditText    editTextAddress;
    EditText    editTextCity;
    Spinner     spinnerStates;
    EditText    editTextZipCode;
    RadioGroup  radioButtonGroup;
    RadioButton radioButton;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
    RadioButton radioButtonNoAnswer;
    CheckBox    checkBoxMorningShift;
    CheckBox    checkBoxAfternoonShift;
    CheckBox    checkBoxEveningShift;
    Switch      switchSettings;
    ImageButton imageButtonCheckout;
    Toast       t;

    //Non-Widget Variables
    String  name        = "";
    String  address     = "";
    String  city        = "";
    String  state       = "";
    String  zipCode     = "";
    String  gender      = "";
    String  shift       = "";
    String  settings    = "";
    String results      = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName            = findViewById(R.id.editTextName);
        editTextAddress         = findViewById(R.id.editTextAddress);
        editTextCity            = findViewById(R.id.editTextCity);

        editTextZipCode         = findViewById(R.id.editTextZipCode);
        radioButtonGroup        = findViewById(R.id.radioButtonGroup);
        radioButtonMale         = findViewById(R.id.radioButtonMale);
        radioButtonFemale       = findViewById(R.id.radioButtonFemale);
        radioButtonNoAnswer     = findViewById(R.id.radioButtonNoAnswer);
        checkBoxMorningShift    = findViewById(R.id.checkBoxMorningShift);
        checkBoxAfternoonShift  = findViewById(R.id.checkBoxAfternoonShift);
        checkBoxEveningShift    = findViewById(R.id.checkBoxEveningShift);
        switchSettings          = findViewById(R.id.switchSettings);
        imageButtonCheckout     = findViewById(R.id.imageButtonCheckout);

        spinnerStates           = findViewById(R.id.spinnerStates);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.states_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStates.setAdapter(adapter);

        imageButtonCheckout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Get Name Value
                if (editTextName != null)
                {
                    name = editTextName.getText().toString();
                }
                else
                {
                    name = NIP;
                }

                //Get Address Value
                if (editTextAddress != null)
                {
                    address = editTextAddress.getText().toString();
                }
                else
                {
                    address = NIP;
                }

                //Get City Value
                if (editTextCity != null)
                {
                    city = editTextCity.getText().toString();
                }
                else
                {
                    city = NIP;
                }

                //Get State Value
                state = spinnerStates.getSelectedItem().toString();

                //Get Zip Code Value
                if (editTextZipCode != null)
                {
                    zipCode = editTextZipCode.getText().toString();
                }
                else
                {
                    zipCode = NIP;
                }

                //Get Radio Button Selection
                if (radioButtonGroup != null)
                {
                    int selectedId = radioButtonGroup.getCheckedRadioButtonId();
                    radioButton = findViewById(selectedId);
                    gender = radioButton.getText().toString();
                }
                else
                {
                    gender = NIP;
                }


                //Get Check Box Selections
                if (checkBoxMorningShift.isChecked())
                {
                    shift += "Morning, ";
                }
                if (checkBoxAfternoonShift.isChecked())
                {
                    shift += "Afternoon, ";
                }
                if (checkBoxEveningShift.isChecked())
                {
                    shift += "Evening ";
                }

                //Get Switch Selection
                if (switchSettings.isChecked())
                {
                    settings = "On";
                }
                else
                {
                    settings = "Off";
                }

                results  = "NAME: "       + name;
                results += "\nADDR: "     + address;
                results += "\nCITY: "     + city;
                results += "\nSTATE: "    + state;
                results += "\nZIP: "      + zipCode;
                results += "\nGENDER: "   + gender;
                results += "\nSHIFT: "    + shift;
                results += "\nSETTINGS: " + settings;

                t = Toast.makeText(getApplicationContext(), results, Toast.LENGTH_LONG);
                t.show();
            }

        });
    }
}
