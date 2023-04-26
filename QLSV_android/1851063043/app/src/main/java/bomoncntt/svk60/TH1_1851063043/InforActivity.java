package bomoncntt.svk60.TH1_1851063043;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import bomoncntt.svk60.TH1_1851063043.Helper.Common;
import bomoncntt.svk60.TH1_1851063043.Helper.DatabaseHelper;

import static android.Manifest.permission.CAMERA;

public class InforActivity extends AppCompatActivity {
    Spinner spinnerlop;
    ArrayList<String> arraylistLop;
    String lop="";
    Button btnluu,btnlamlai;
    EditText txtmasv,txttensv;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    DatabaseHelper db;
    Bitmap myBitmap;
    Uri picUri;
    CircleImageView croppedImageView;
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();
    private final static int ALL_PERMISSIONS_RESULT = 107;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        croppedImageView=(CircleImageView)findViewById(R.id.img_profile1);
        db=new DatabaseHelper(this);
        btnluu=findViewById(R.id.btnluu);
        btnlamlai=findViewById(R.id.btnlamlai);
        txtmasv=findViewById(R.id.txtmasv);
        txttensv=findViewById(R.id.txttensv);
        spinnerlop=findViewById(R.id.spinnerlop);
        radioSexGroup=(RadioGroup)findViewById(R.id.radiogroupsex);

        arraylistLop=new ArrayList<String>();
        arraylistLop.add("Khóa 59");
        arraylistLop.add("Khóa 60");
        arraylistLop.add("Khóa 61");
        arraylistLop.add("Khóa 62");
        ArrayAdapter<String> adapterlop=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arraylistLop);
        adapterlop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerlop.setAdapter(adapterlop);
        //b?t s? ki?n spinner
        spinnerlop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lop=arraylistLop.get(position).toString();
                Log.v("lop",lop);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lop="";
                Log.v("lop",lop);
            }
        });

        Intent in=getIntent();
        String flag=in.getStringExtra("Flag");
        if(flag.equals("add")) {
            setTitle("Thêm dữ liệu");
            String masv = in.getStringExtra("MASV");
            String tensv = in.getStringExtra("TENSV");
            String gt = in.getStringExtra("GT");
            String lop = in.getStringExtra("LOP");
            String anh_sv = in.getStringExtra("ANH_SV");
            Log.v("statusthaotac","cong");
        } else if(flag.equals("edit")){
            String masv = in.getStringExtra("MASV");
            String tensv = in.getStringExtra("TENSV");
            String gt = in.getStringExtra("GT");
            String lop = in.getStringExtra("LOP");
            String anh_sv = in.getStringExtra("ANH_SV");
            setTitle("Sửa dữ liệu");
            txtmasv.setText(masv);
            txttensv.setText(tensv);
            txtmasv.setEnabled(false);

            if(gt.equalsIgnoreCase("Nam")){
                radioSexButton=(RadioButton)findViewById(R.id.radioButtonNam);
                radioSexGroup.check(radioSexButton.getId());
            }else{
                radioSexButton=(RadioButton)findViewById(R.id.radioButtonNu);
                radioSexGroup.check(radioSexButton.getId());
            }
            Common.selecValue(spinnerlop,lop);
            Log.v("statusthaotac","sửa");
            croppedImageView.setImageBitmap(Common.StringToBitMap(anh_sv));
        }

        btnlamlai.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                txtmasv.setEnabled(false);
                txttensv.requestFocus();
                txttensv.setText("");
                radioSexButton=(RadioButton)findViewById(R.id.radioButtonNam);
                radioSexGroup.check(radioSexButton.getId());
                spinnerlop.setSelection(0);

            }
        });

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag.equals("add")) {
                    String masv = txtmasv.getText().toString();
                    String tensv = txttensv.getText().toString();
                    try{
                        if (masv.length()> 0&&tensv.length()> 0){
                            int selectedId = radioSexGroup.getCheckedRadioButtonId();
                            radioSexButton = (RadioButton) findViewById(selectedId);
                            String gt = radioSexButton.getText().toString();
                            String anh_sv="";
                            if(myBitmap!=null) {
                                anh_sv = Common.BitMapToString(myBitmap);
                            }
                            boolean inserted = db.insertData(masv, tensv, gt, lop,anh_sv);
                            if (inserted) {
                                Toast.makeText(getApplicationContext(), "Insert thành công", Toast.LENGTH_SHORT).show();
                                finish();
                                Intent st = new Intent(getApplicationContext(), MainActivity.class);
                                st.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(st);
                            } }
                        else{

                            if (txtmasv.length()==0) {
                                txtmasv.setError("Nhập mã sinh viên!");
                                Toast.makeText(getApplicationContext(),"Mã sinh viên khác rỗng!",Toast.LENGTH_SHORT).show();

                            }else if (txttensv.length()==0){
                                txttensv.setError("Nhập tên sinh viên!");
                                Toast.makeText(getApplicationContext(),"Tên sinh viên khác rỗng!",Toast.LENGTH_SHORT).show();

                            }
                        }

                    }catch (Exception e){

                    }
                }
                else if(flag.equals("edit"))

                {
                    String masv = txtmasv.getText().toString();
                    String tensv = txttensv.getText().toString();
                    int selectedId = radioSexGroup.getCheckedRadioButtonId();
                    radioSexButton = (RadioButton) findViewById(selectedId);
                    String gt = radioSexButton.getText().toString();
                    String anh_sv="";

                    if(myBitmap!=null) {
                        anh_sv = Common.BitMapToString(myBitmap);

                    }


                    boolean updated=db.update(masv,tensv,gt,lop, anh_sv);
                    if (updated) {
                        Toast.makeText(getApplicationContext(), "Update thành công!", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent st = new Intent(getApplicationContext(), MainActivity.class);
                        st.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(st);
                    } else {
                        Toast.makeText(getApplicationContext(), "Update không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public Intent getPickImageChooserIntent() {

        Uri outputFileUri = getCaptureImageOutputUri();
        List<Intent> allIntents = new ArrayList<>();
        PackageManager packageManager = getPackageManager();

        Intent captureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for (ResolveInfo res : listCam) {
            Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            if (outputFileUri != null) {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            }
        }
        allIntents.add(0 ,getPickImageChooserIntentFile());
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        List<ResolveInfo> listGallery = packageManager.queryIntentActivities(galleryIntent, 0);
        Intent chooserIntent = Intent.createChooser(captureIntent, "Chọn ứng dụng");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, captureIntent);
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, allIntents.toArray(new Parcelable[allIntents.size()]));
        Log.v("allIntents",""+allIntents.size());

        return chooserIntent;
    }

    public Intent getPickImageChooserIntentFile() {
        List<Intent> allIntents = new ArrayList<>();
        PackageManager packageManager = getPackageManager();
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        List<ResolveInfo> listGallery = packageManager.queryIntentActivities(galleryIntent, 0);
        for (ResolveInfo res : listGallery) {
            Intent intent = new Intent(galleryIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
        }
        Intent chooserIntent = Intent.createChooser(galleryIntent, "Select source");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, allIntents.toArray(new Parcelable[allIntents.size()]));
        Log.v("allIntents",""+allIntents.size());
        return chooserIntent;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap;
        if (resultCode == Activity.RESULT_OK) {
            Log.v("picUri",""+data);
            if (getPickImageResultUri(data) != null) {
                picUri = getPickImageResultUri(data);
                try {
                    myBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), picUri);
                    Log.v("myBitmap",""+myBitmap);
                    myBitmap = getResizedBitmap(myBitmap,100 );
                    croppedImageView.setImageBitmap(myBitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                Log.v("picUri","null");
                bitmap = (Bitmap) data.getExtras().get("data");

                myBitmap = bitmap;

                if (croppedImageView != null) {
                    croppedImageView.setImageBitmap(myBitmap);
                }

            }
        }
    }
    public Uri getPickImageResultUri(Intent data) {
        boolean isCamera = true;
        if (data != null) {
            String action = data.getAction();
            isCamera = action != null && action.equals(MediaStore.ACTION_IMAGE_CAPTURE);
        }
        return isCamera ? getCaptureImageOutputUri() : data.getData();
    }
    private Uri getCaptureImageOutputUri() {
        Uri outputFileUri = null;
        File getImage = getExternalCacheDir();
        if (getImage != null) {
            outputFileUri = Uri.fromFile(new File(getImage.getPath(), "profile.png"));
        }
        return outputFileUri;
    }
    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList<String> result = new ArrayList<String>();
        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }
        return result;
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    private boolean hasPermission(String permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }
    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_actionbar_insert,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_camere) {
            Log.d("camera1","ok");
            //m? camera
            permissions.add(CAMERA);
            permissionsToRequest = findUnAskedPermissions(permissions);
            Intent in=getPickImageChooserIntent();
            startActivityForResult(in, 200);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (permissionsToRequest.size() > 0)
                    requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}