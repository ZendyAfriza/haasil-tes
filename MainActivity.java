package com.example.catatantugasharian;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DbHelper dbHelper;
    ArrayAdapter<string> mAdapter;
    listView lstTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new DbHelper(this);
        lstTask=(listView) findViewById(R.id.lstTask);

        loadTaskList();

    }
    private void loadTaskList(){
        ArrayList<string> taskList = dbHelper.getTaskList();
        if (mAdapter==null){
            mAdapter=new ArrayAdapter<string>(this, R,layout.layout_row, R.id.task_tittle, taskList);
            lstTask.setAdapter(mAdapter);
        }else{
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.Menu,menu, menu);

        Drawable.Icon=Menu.getItem(0).getIcon();
        icon.mutate();

        icon.setColorFilter(getResources().getColor(android.R.color.holo_blue_bright), porterDuff.mode.SRC_IN);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_add_task:
                final EditText TeksEditTeks = new EditText(this);
                AlertDialog dialog= new AlertDialog.Builder(this);
                        .setTitle("TAMBAH TUGAS")
                        .setMassage("Apa Yang Kamu Lakukan Hari Ini ?")
                        .setView(TeksEditTeks)
                        .setPositiveButton("Tambah",new DialogInterface dialog,int which){
                            @Override
                                    public void onClick(DialogInterface dialog,int which){
                                string task= string.valueOf(taskEditText.getText());
                                dbHelper.insertNewTask(task);
                                loadTaskList();
                }

        }
        .setNegativeButton(teks"batal",null)
        .create();
    dialog.show();
    return true;
    }
    return super.onOptionsItemSelected

}