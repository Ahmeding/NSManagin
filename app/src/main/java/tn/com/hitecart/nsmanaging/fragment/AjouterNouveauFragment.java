package tn.com.hitecart.nsmanaging.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tn.com.hitecart.nsmanaging.R;
import tn.com.hitecart.nsmanaging.database.AdherentRepository;
import tn.com.hitecart.nsmanaging.database.DBManager;
import tn.com.hitecart.nsmanaging.model.Adherent;


public class AjouterNouveauFragment extends Fragment {

    private EditText name;
    private EditText lastname;
    private EditText age;
    private EditText profession;
    private EditText grade;
    private EditText dateinscrit;
    private EditText email;
    private EditText phone;
    private EditText address;
    private TextInputLayout nameLayout;
    //
    private TextInputLayout lastnameLayout;
    private TextInputLayout ageLayout;
    private TextInputLayout professionLayout;
    private TextInputLayout gradeLayout;
    private TextInputLayout dateinscritLayout;
    private TextInputLayout emailLayout;
    private TextInputLayout phoneLayout;
    private TextInputLayout addressLayout;
    //
    private Button btnSave;
    //
    private AdherentRepository repos;
    //
    private Adherent adherent;
    //
    private View view;
    //
    private List<Adherent> adherents = new ArrayList<>();

    public AjouterNouveauFragment() {
        // Required empty public constructor
    }

    public static AjouterNouveauFragment newInstance() {
        return new AjouterNouveauFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ajouter_nouveau, container, false);
        //init the comments repository
        repos = new AdherentRepository(getContext());

        nameLayout = (TextInputLayout) view.findViewById(R.id.input_layout_name);
        lastnameLayout = (TextInputLayout) view.findViewById(R.id.input_layout_lastname);
        ageLayout = (TextInputLayout) view.findViewById(R.id.input_layout_age);
        professionLayout = (TextInputLayout) view.findViewById(R.id.input_layout_profession);
        gradeLayout = (TextInputLayout) view.findViewById(R.id.input_layout_grade);
        dateinscritLayout = (TextInputLayout) view.findViewById(R.id.input_layout_inscritDate);
        emailLayout = (TextInputLayout) view.findViewById(R.id.input_layout_email);
        phoneLayout = (TextInputLayout) view.findViewById(R.id.input_layout_phoneNum);
        addressLayout = (TextInputLayout) view.findViewById(R.id.input_layout_address);
        //
        name = (EditText) view.findViewById(R.id.input_name);
        lastname = (EditText) view.findViewById(R.id.input_lastname);
        age = (EditText) view.findViewById(R.id.input_age);
        profession = (EditText) view.findViewById(R.id.input_profession);
        grade = (EditText) view.findViewById(R.id.input_grade);
        dateinscrit = (EditText) view.findViewById(R.id.input_inscritDate);
        email = (EditText) view.findViewById(R.id.input_email);
        phone = (EditText) view.findViewById(R.id.input_phoneNum);
        address = (EditText) view.findViewById(R.id.input_address);
        //
        btnSave = (Button) view.findViewById(R.id.btn_save);

        name.addTextChangedListener(new MyTextWatcher(name));
        lastname.addTextChangedListener(new MyTextWatcher(lastname));
        age.addTextChangedListener(new MyTextWatcher(age));
        profession.addTextChangedListener(new MyTextWatcher(profession));
        grade.addTextChangedListener(new MyTextWatcher(grade));
        dateinscrit.addTextChangedListener(new MyTextWatcher(dateinscrit));
        email.addTextChangedListener(new MyTextWatcher(email));
        phone.addTextChangedListener(new MyTextWatcher(phone));
        address.addTextChangedListener(new MyTextWatcher(address));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        return view;
    }

    private void submitForm() {

        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validateLastname()) {
            return;
        }
        if (!validateAge()) {
            return;
        }
        if (!validateGrade()) {
            return;
        }
        if (!validateProfession()) {
            return;
        }
        if (!validatePhone()) {
            return;
        }
        if (!validateAddress()) {
            return;
        }

        if (!validateDateInscrit()) {
            return;
        }


        Toast.makeText(getContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        addNew(adherent);
        //startActivity(new Intent(this,MainActivity.class));
    }

    private void addNew(Adherent adherent) {


        adherent = new Adherent();
        adherent.setNameAdherent(name.getText().toString());
        adherent.setLastnameAdherent(lastname.getText().toString());
        adherent.setAge(Integer.valueOf(age.getText().toString()));
        adherent.setAddress(address.getText().toString());
        adherent.setEmail(email.getText().toString());
        adherent.setGrade(grade.getText().toString());
        adherent.setInscritDate(dateinscrit.getText().toString());
        adherent.setPhoneNum(phone.getText().toString());
        adherent.setProfession(profession.getText().toString());
        repos.create(adherent);
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_lastname:
                    validateLastname();
                    break;
                case R.id.input_age:
                    validateAge();
                    break;
                case R.id.input_profession:
                    validateProfession();
                    break;
                case R.id.input_inscritDate:
                    validateDateInscrit();
                    break;
                case R.id.input_grade:
                    validateGrade();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;
                case R.id.input_phoneNum:
                    validatePhone();
                    break;
                case R.id.input_address:
                    validateAddress();
                    break;

            }
        }
    }

    private boolean validateProfession() {

        if (profession.getText().toString().trim().isEmpty()) {
            professionLayout.setError(getString(R.string.err_msg_profession));
            requestFocus(profession);
            return false;
        } else {
            professionLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateDateInscrit() {

        if (dateinscrit.getText().toString().trim().isEmpty()) {
            dateinscritLayout.setError(getString(R.string.err_msg_dateincrit));
            requestFocus(dateinscrit);
            return false;
        } else {
            dateinscritLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateGrade() {

        if (grade.getText().toString().trim().isEmpty()) {
            gradeLayout.setError(getString(R.string.err_msg_grade));
            requestFocus(grade);
            return false;
        } else {
            gradeLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String emailaddress = email.getText().toString().trim();

        if (emailaddress.isEmpty() || !isValidEmail(emailaddress)) {
            emailLayout.setError(getString(R.string.err_msg_email));
            requestFocus(email);
            return false;
        } else {
            emailLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePhone() {
        if (phone.getText().toString().trim().isEmpty()) {
            phoneLayout.setError(getString(R.string.err_msg_phone));
            requestFocus(phone);
            return false;
        } else {
            phoneLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAddress() {

        if (address.getText().toString().trim().isEmpty()) {
            addressLayout.setError(getString(R.string.err_msg_address));
            requestFocus(address);
            return false;
        } else {
            addressLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAge() {
        if (age.getText().toString().trim().isEmpty()) {
            ageLayout.setError(getString(R.string.err_msg_age));
            requestFocus(age);
            return false;
        } else {
            ageLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateLastname() {
        if (lastname.getText().toString().trim().isEmpty()) {
            lastnameLayout.setError(getString(R.string.err_msg_lastname));
            requestFocus(lastname);
            return false;
        } else {
            lastnameLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateName() {

        if (name.getText().toString().trim().isEmpty()) {
            nameLayout.setError(getString(R.string.err_msg_name));
            requestFocus(lastname);
            return false;
        } else {
            nameLayout.setErrorEnabled(false);
        }

        return true;
    }

}
