package com.example.abo_nayel.nearbyplaces;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Login extends AppCompatActivity {

    Button signUp,login;
    EditText name , pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUp= (Button)findViewById(R.id.signup);
        login = (Button)findViewById(R.id.signin);
        name= (EditText)findViewById(R.id.mail);
        pass= (EditText)findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mySP = getSharedPreferences("User_Data",0);
                if(mySP.getString(name.getText().toString(),null)==(null)){
                    Toast.makeText(Login.this,"user name is incorrect ..",Toast.LENGTH_SHORT).show();
                }else {
//                    Toast.makeText(Login.this, mySP.getString(name.getText().toString(), null), Toast.LENGTH_SHORT).show();
                    Gson gson = new Gson();

                    User user = gson.fromJson(mySP.getString(name.getText().toString(),null),User.class);
                    Toast.makeText(Login.this,"user name : "+user.name, Toast.LENGTH_SHORT).show();
                    if(name.getText().toString().equals(user.getName())&&pass.getText().toString().equals(user.getPassword())){
                        Intent i = new Intent(Login.this,Search.class);
                        startActivity(i);
                    }
//                    String thisUser = gson.toJson(mySP.getString(name.getText().toString(), null));
//
//                    JsonObject jsonObject = new JsonObject();
//                    JsonArray jsonArray = jsonObject.getAsJsonArray(name.getText().toString());
//                    //user = new Gson(jsonArray.toString(), User[].class);
//                    //Toast.makeText(Login.this, user[0].getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Place_Details.class);
                startActivity(i);
            }
        });
    }
}
