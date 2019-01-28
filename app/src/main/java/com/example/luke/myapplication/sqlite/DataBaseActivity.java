package com.example.luke.myapplication.sqlite;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luke.myapplication.R;

public class DataBaseActivity extends AppCompatActivity {

    private DataBaseHelper dbHelper;
    private EditText editName;
    private EditText editSurName;
    private EditText editMarks;
    private EditText editId;
    private Button addDataButton;
    private Button deleteButton;
    private Button readButton;
    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        dbHelper = new DataBaseHelper(this);

        editName = findViewById(R.id.name_edit_text);
        editSurName = findViewById(R.id.surname_edit_text);
        editMarks = findViewById(R.id.marks_edit_text);
        editId = findViewById(R.id.id_edit_text);

        addDataButton = findViewById(R.id.add_data_button);
        deleteButton = findViewById(R.id.delete_data_button);
        readButton = findViewById(R.id.view_data_button);
        updateButton = findViewById(R.id.update_data_button);

        setEvent();
    }

    private void setEvent() {
        final String name = editName.getText().toString();
        final String surName = editSurName.getText().toString();
        final String marks = editMarks.getText().toString();
        String id = editId.getText().toString();

        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean result = dbHelper.insertData(name, surName, marks);

                if(result){
                    Toast.makeText(DataBaseActivity.this,"Add Data Success!", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(DataBaseActivity.this,"Add Data Failure!", Toast.LENGTH_LONG).show();
                }
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = dbHelper.getAllData();
                if(res.getCount() == 0){
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id :" + res.getString(0) + "\n");
                    buffer.append("Name :" + res.getString(1) + "\n");
                    buffer.append("SurName :" + res.getString(2) + "\n");
                    buffer.append("Marks :" + res.getString(3) + "\n");
                }

                showMessage("Data", buffer.toString());
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = dbHelper.updateData(editId.getText().toString(), editName.getText().toString(),
                        editSurName.getText().toString(), editMarks.getText().toString());

                if(isUpdate){
                    Toast.makeText(DataBaseActivity.this,"Update Data Success!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(DataBaseActivity.this,"Update Data Failure!", Toast.LENGTH_LONG).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deleteRow = dbHelper.deleteData(editId.getText().toString());
                if(deleteRow > 0){
                    Toast.makeText(DataBaseActivity.this,"Delete Data Success!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(DataBaseActivity.this,"Delete Data Failure!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
