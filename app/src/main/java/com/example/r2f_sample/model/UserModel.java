package com.example.r2f_sample.model;

import android.content.Context;
import android.util.Log;

import com.example.r2f_sample.R2FApplication;
import com.example.r2f_sample.pojo.User;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserModel {
    private static final String USER_FILE = "userJSON2";

    public boolean saveUser(User user) {
        //create a json string
        String jsonString = createUserJSON(user);

        Log.d("MenuActivity", jsonString);

        //set the saved flag to false
        boolean saved = false;

        //no error creating JSON
        if (jsonString != null) {
            try {
                //write the string to file
                saved = writeFileOnInternalStorage(R2FApplication.GetAppContext(), USER_FILE, jsonString);

            } catch (IOException e) {
                Log.e("MenuActivity", "Exception saving user data", e);
            }
        }

        return saved;
    }

    private String createUserJSON(User u) {

        JSONObject user = new JSONObject();
        try {
            user.put("fullName", u.getFullName());
            user.put("address1", u.getAddress1());
            user.put("address2", u.getAddress2());
            user.put("city", u.getCity());
            user.put("state", u.getState());
            user.put("zip", u.getZip());
        }
        catch(Exception e) {
            Log.e("MenuActivity", "Exception storing user data", e);
            return null;
        }

        return user.toString();
    }

    public User loadUser() {
        //read the json string from file
        String jsonString = null;
        try {
            jsonString = readFileOnInternalStorage(R2FApplication.GetAppContext(), USER_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //if jsonString is null
        if (jsonString == null) {
            //return null
            return null;
        }
        //otherwise
        else {
            //prase the json
            JSONParser parser = new JSONParser();
            JSONObject u = null;

            try {
                u = (JSONObject) parser.parse(jsonString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //create a user object from that
            User userObj = new User(u);

            //return the user object
            return userObj;
        }
    }

    private String readFileOnInternalStorage(Context context, String fileName) throws IOException {

        FileInputStream fis = context.openFileInput(fileName);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();

    }
    private boolean writeFileOnInternalStorage(Context context, String fileName, String body) throws IOException {
        FileOutputStream outputStream;
        Log.d("MenuActivity", body);
        outputStream = R2FApplication.GetAppContext().openFileOutput(fileName, Context.MODE_PRIVATE);
        outputStream.write(body.getBytes());
        outputStream.close();

        return true;
    }
}
