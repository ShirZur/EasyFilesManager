package com.example.easyfilesmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.filehandling.FileManager;


public class MainActivity extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatEditText fileNameEditText;
    private androidx.appcompat.widget.AppCompatEditText fileContentEditText;
    private Button createFileButton;
    private Button createFolderButton;
    private Button writeFileButton;
    private Button readFileButton;
    private Button deleteFileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        findViews();
        setOnClick();

           }

    private void setOnClick() {
        createFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = fileNameEditText.getText().toString();
                if (!fileName.isEmpty()) {
                    FileManager.createFile(MainActivity.this, fileName);
                    Toast.makeText(MainActivity.this, "File " + fileName + " created successfully!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a file name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        createFolderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String folderName = fileNameEditText.getText().toString();
                if (!folderName.isEmpty()) {
                    FileManager.createFolder(MainActivity.this, folderName);
                    Toast.makeText(MainActivity.this, "Folder " + folderName + " created successfully!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a folder name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        writeFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = fileNameEditText.getText().toString();
                String content = fileContentEditText.getText().toString();
                if (!fileName.isEmpty() && !content.isEmpty()) {
                    FileManager.writeFile(MainActivity.this, fileName, content);
                    Toast.makeText(MainActivity.this, "Content written to " + fileName + " successfully!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a file name and content", Toast.LENGTH_SHORT).show();
                }
            }
        });

        readFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = fileNameEditText.getText().toString();
                if (!fileName.isEmpty()) {
                    String content = FileManager.readFile(MainActivity.this, fileName);
                    if (!content.isEmpty()) {
                        fileContentEditText.setText(content);
                        Toast.makeText(MainActivity.this, "Content read from " + fileName + " successfully!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "File is empty or does not exist", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a file name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = fileNameEditText.getText().toString();
                if (!fileName.isEmpty()) {
                    boolean isDeleted = FileManager.deleteFile(MainActivity.this, fileName);
                    Toast.makeText(MainActivity.this, "File " + fileName + " deleted: " + isDeleted, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a file name", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void findViews() {
        fileNameEditText = findViewById(R.id.fileNameEditText);
        fileContentEditText = findViewById(R.id.fileContentEditText);
        createFileButton = findViewById(R.id.createFileButton);
        createFolderButton = findViewById(R.id.createFolderButton);
        writeFileButton = findViewById(R.id.writeFileButton);
        readFileButton = findViewById(R.id.readFileButton);
        deleteFileButton = findViewById(R.id.deleteFileButton);
    }


}