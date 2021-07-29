package com.example.applock2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.applock2.adapter.MyAdapter;
import com.example.applock2.model.Myitem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initToolbar();


    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this,getApplications());
        recyclerView.setAdapter(adapter);
    }

    private List<Myitem> getApplications() {
        List<Myitem> items = new ArrayList<>();
        PackageManager manager = getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN,null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> infos = manager.queryIntentActivities(intent,0);
        for(ResolveInfo resolveInfo:infos) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            items.add(new Myitem(activityInfo.loadIcon(manager),activityInfo.loadLabel(manager).toString(),activityInfo.packageName));
        }
        return items;

    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        toolbar.setTitle("Application");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == android.R.id.home)
            finish();

        return true;
    }

}