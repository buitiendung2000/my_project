package bomoncntt.svk60.TH1_1851063043;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bomoncntt.svk60.TH1_1851063043.Helper.DatabaseHelper;
import bomoncntt.svk60.TH1_1851063043.Helper.MyListAdapter;
import bomoncntt.svk60.TH1_1851063043.Model.SinhVien;



public class MainActivity extends AppCompatActivity {

    ArrayList<SinhVien> arrayListSV=null;
    ArrayAdapter<SinhVien> adapter=null;
    ListView lvsv;
    DatabaseHelper mydb=null;
    ArrayList<SinhVien> StudentCheckItemList=null;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readText();

        StudentCheckItemList=new ArrayList<>();
        setTitle("Thông Tin Sinh Viên");
        lvsv=findViewById(R.id.listsinhvien);
        mydb=new DatabaseHelper(this);


        arrayListSV=new ArrayList<>();
        Cursor cursor=mydb.showData();
        while(cursor.moveToNext()){
            SinhVien sv=new SinhVien(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            arrayListSV.add(sv);
        }


         adapter = new MyListAdapter(this, arrayListSV);

        lvsv.setAdapter(adapter);

        lvsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox itemCheckBox=(CheckBox)view.findViewById(R.id.sinhvien_list_item_checkbox);
                boolean checkboxChecked=false;
                if(itemCheckBox.isChecked()){
                    itemCheckBox.setChecked(false);
                    checkboxChecked=false;
                }else{
                    itemCheckBox.setChecked(true);
                    checkboxChecked=true;
                }
                SinhVien sv=new SinhVien();
                sv.setMasv(arrayListSV.get(position).getMasv());
                sv.setTensv(arrayListSV.get(position).getTensv());
                sv.setLop(arrayListSV.get(position).getLop());
                sv.setGt(arrayListSV.get(position).getGt());
                sv.setAnhsv(arrayListSV.get(position).getAnhsv());

                Log.d("checkbox",""+checkboxChecked);
                addCheckListItem(sv,checkboxChecked);
                Log.d("testing",getStudentCheck());

            }
        });
    }

    private String getStudentCheck()
    {
        StringBuilder retBuf=new StringBuilder();
        if(StudentCheckItemList!=null){
            int size=StudentCheckItemList.size();
            for(int i=0;i<size;i++){
                SinhVien st=StudentCheckItemList.get(i);
                retBuf.append(st);
                retBuf.append(" ");
            }
        }
        return retBuf.toString().trim();
    }
    private void addCheckListItem(SinhVien student,boolean add){
        if(StudentCheckItemList!=null){
            boolean accountExist=false;
            int existPosition=-1;
            int size=StudentCheckItemList.size();


            for(int i=0;i<size;i++){
                SinhVien sv=StudentCheckItemList.get(i);
                if(sv.getMasv().equals(student.getMasv())){
                    accountExist=true;
                    existPosition=i;
                    break;

                }
            }
            if(add){
                if(!accountExist){
                    StudentCheckItemList.add(student);
                }
            }else {
                if(accountExist){
                    if(existPosition!=-1){
                        StudentCheckItemList.remove(existPosition);
                    }
                }
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.item_menu_action,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int itemId=item.getItemId();
        if(itemId==R.id.menu_add){
            Log.v("add","ok");
            Intent in=new Intent(getApplicationContext(),InforActivity.class);
            in.putExtra("Flag","add");
            in.putExtra("MASV","");
            in.putExtra("TENSV","");
            in.putExtra("GT","");
            in.putExtra("LOP","");
            in.putExtra("ANHSV","");
            startActivity(in);

        }else if(itemId==R.id.menu_delete){
            Log.v("delete","ok");
            if(StudentCheckItemList!=null){
                int size=StudentCheckItemList.size();
                if(size==0){
                    Toast.makeText(getApplicationContext(), "Chọn ít nhất 1 phần tử để xóa", Toast.LENGTH_SHORT).show();

                }else {
                    for(int i=0;i<size;i++){
                        SinhVien sv=StudentCheckItemList.get(i);
                        Integer delete=mydb.delete(sv.getMasv());
                        if(delete>0){
                            StudentCheckItemList.remove(i);
                            size=StudentCheckItemList.size();
                            Toast.makeText(getApplicationContext(), "Xóa thành công!", Toast.LENGTH_SHORT).show();

                        }else
                        {
                            Toast.makeText(getApplicationContext(), "Xóa bị lỗi", Toast.LENGTH_SHORT).show();

                        }
                        i--;
                    }

                    arrayListSV.clear();

                    Cursor cursor =mydb.showData();
                    while(cursor.moveToNext()){
                        SinhVien sv=new SinhVien(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                        arrayListSV.add(sv);

                    }
                    adapter=new MyListAdapter(this,arrayListSV);
                    lvsv.setAdapter(adapter);
                    //outsource

                }
            }
        }else if(itemId==R.id.menu_edit){
            Log.v("edit","ok");
            if(StudentCheckItemList!=null) {
                int size=StudentCheckItemList.size();
             if(size!=1){
                 Toast.makeText(getApplicationContext(), "Chỉ chọn 1 phần tử để sửa", Toast.LENGTH_SHORT).show();
                 Log.d("okkkkk",""+size);
             }else {  //size=1
                 SinhVien sv=StudentCheckItemList.get(0);
                 Intent in = new Intent(getApplicationContext(), InforActivity.class);
                 in.putExtra("Flag", "edit");
                 in.putExtra("MASV", StudentCheckItemList.get(0).getMasv());
                 in.putExtra("TENSV", StudentCheckItemList.get(0).getTensv());
                 in.putExtra("GT", StudentCheckItemList.get(0).getGt());
                 in.putExtra("LOP", StudentCheckItemList.get(0).getLop());
                 in.putExtra("ANHSV", StudentCheckItemList.get(0).getAnhsv());
                 startActivity(in);
                 adapter.notifyDataSetChanged();
             }
            }
        }else{
            SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("remember","false");
            editor.apply();
            Toast.makeText(MainActivity.this,"Đăng xuất thành công!",Toast.LENGTH_SHORT).show();
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
    public void readText() {
        try {
            FileInputStream fileIn = openFileInput("datalogin.txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;

            while ((charRead = InputRead.read(inputBuffer)) > 0) {

                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                s += readstring;
            }
            InputRead.close();

            Log.v("contentsssssssss", s);
        } catch (Exception e) {

        }
    }
}