package com.example.abo_nayel.nearbyplaces;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class SignUp extends AppCompatActivity {

    Button signIn,signUp;
    EditText name, mail, pass , birthday;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        name = (EditText)findViewById(R.id.nameedt);
        mail = (EditText)findViewById(R.id.mailedt);
        pass = (EditText)findViewById(R.id.passtxt);
        birthday = (EditText)findViewById(R.id.birthedt);
        signIn = (Button)findViewById(R.id.signinbtn);
        signUp = (Button)findViewById(R.id.signupbtn);
        image = (ImageView)findViewById(R.id.profile_image);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this,Login.class);
                startActivity(i);
//                SharedPreferences prefs =SignUp.this.getSharedPreferences("User_Data",MODE_PRIVATE);
//
//                Toast.makeText(SignUp.this,prefs.getString("user0",null),Toast.LENGTH_SHORT).show();

//                if(users.size()>0){
//                Toast.makeText(SignUp.this,users.get(0).toString(),Toast.LENGTH_SHORT).show();
//                editor.remove("user0");
//                users.remove(0);}
//                Intent i = new Intent(SignUp.this,Login.class);
//                startActivity(i);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               User user= new User(name.getText().toString(), mail.getText().toString(), pass.getText().toString());
             User user= new User(name.getText().toString(), mail.getText().toString(), pass.getText().toString(),image.getDrawingCache(),(Date)birthday.getText());

                SharedPreferences sharedPreferences=getSharedPreferences("User_Data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.clear();
                Gson gson = new Gson();

                String theUser = gson.toJson(user);
                Toast.makeText(SignUp.this,theUser,Toast.LENGTH_SHORT).show();

                editor.putString(user.getName(),theUser);
                editor.apply();

            }
        });


    }
}
