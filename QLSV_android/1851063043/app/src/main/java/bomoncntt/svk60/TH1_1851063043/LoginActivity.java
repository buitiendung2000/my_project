package bomoncntt.svk60.TH1_1851063043;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername,edtPassword;
    Button btnSignin;
    CheckBox cbRemember;
    public static final String MyPREFERENCES="MYPREFS";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Đăng nhập hệ thống");



        edtUsername = (EditText) findViewById(R.id.edtusername);
        edtPassword = (EditText) findViewById(R.id.edtpassword);
        cbRemember = (CheckBox) findViewById(R.id.checkBoxRemember);
        btnSignin = (Button) findViewById(R.id.btnlogin);
        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");
        if(checkbox.equals("true")){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else if(checkbox.equals("false")){
            Toast.makeText(LoginActivity.this,"Hãy đăng nhập!",Toast.LENGTH_SHORT).show();
        }

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edtUsername.getText().toString();
                String password=edtPassword.getText().toString();

                validate(edtUsername.getText().toString(),edtPassword.getText().toString());
            }
        });
        cbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                    Toast.makeText(LoginActivity.this,"Đã ghi nhớ!",Toast.LENGTH_SHORT).show();
                }else if(!compoundButton.isChecked()){
                    SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                    Toast.makeText(LoginActivity.this,"Bỏ ghi nhớ!",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
private void validate (String username, String password){
        if(username.equals("1851063043")&&password.equals("123")) {
            finish();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this,"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(LoginActivity.this, "Kiểm tra lại tên đăng nhập hoặc mật khẩu !", Toast.LENGTH_SHORT).show();
            edtUsername.setError("Sai");
            edtPassword.setError("Sai");
        }
}




}