package com.gabbo.studiodentistico;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Actions {
    JSONObject patient = new JSONObject();
    ArrayList patients = new ArrayList();
    public boolean savePatient(String name, String surname, String age, String phonenumber, String pathology) {
        try {
            patient.put("name", name);
            patient.put("surname", surname);
            patient.put("age", age);
            patient.put("phonenumber", phonenumber);
            patient.put("pathology", pathology);

            patients.add(patient);
            System.out.println(patients);

            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void printPatients() {
        System.out.println(patients);
    }
}
