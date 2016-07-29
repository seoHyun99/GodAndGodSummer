package com.juntcompany.godandgodsummer.WriteBoard;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.juntcompany.godandgodsummer.Dialog.DeleteDialogFragment;
import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.Manager.PropertyManager;
import com.juntcompany.godandgodsummer.R;

import java.io.File;

public class WriteBoardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_board);

//        툴바 세팅
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Get the ActionBar here to configure the way it behaves.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.button_back);

        View viewToolbar =getLayoutInflater().inflate(R.layout.toolbar_write_board, null);

        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
////////////////////        툴바셋팅


        final ImageView imageView = (ImageView)findViewById(R.id.imageView);

        EditText editContent = (EditText)findViewById(R.id.edit_content);
        editContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.GONE); // 글쓰는 곳 edittext 클릭하면 옆에 펜모양 없어지기
            }
        });

        ImageView imagePhoto = (ImageView)findViewById(R.id.image_photo);
        imagePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION_GET_CONTENT 드라이버에서 가져오기
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*"); //이미지 가져오기 위해 새로운 창 띄우는 기능
// Always show the chooser (if there are multiple options available)
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });
        ScrollView scrollView = (ScrollView)findViewById(R.id.scrollView);
        scrollView.setEnabled(false); //이미지가 리사이즈 되어도 안줄어들려면 scrollview 사용 해야함
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            Log.i("uri", uri.toString());
            Cursor c = getContentResolver().query(uri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
            if (c.moveToNext()) {
                String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
//                PropertyManager.getInstance().setProfileImage(path); //이미지를 저장
                File file = new File(path);
                Uri fileUri = Uri.fromFile(file);
                ImageView imagePick = (ImageView)findViewById(R.id.image_pick);
                Glide.with(getApplicationContext()).load(fileUri).into(imagePick);
            }
        }
    }

    private int PICK_IMAGE_REQUEST = 1;
    private static final String DELETE_DIALOG = "dialog";
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                DeleteDialogFragment df = new DeleteDialogFragment();
                df.show(getSupportFragmentManager(), DELETE_DIALOG);
//                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
