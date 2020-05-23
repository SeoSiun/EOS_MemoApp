package com.example.memoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.memoapp.adapter.MemoAdapter;
import com.example.memoapp.data.Memo;
import com.example.memoapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Memo> memoList= new ArrayList<>();
    private MemoAdapter memoAdapter = new MemoAdapter(memoList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();

        addMemo(1,"첫번째 메모", "안녕", "2020.05.18");
        addMemo(2,"두번째 메모", "ㅎㅇ", "2020.05.18");
        addMemo(3,"세번째 메모", "ㅇㅇ", "2020.05.18");
    }

    //activity가 처음 켜졌을 때, 설정하는 initializing하는 함수
    private void setUI(){

        //tool bar
        //xml에 있는 요소를 자바 코드에 불러와 주는 함수 findViewById
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        //recycler view
        RecyclerView recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //recycler view adapter
        recyclerView.setAdapter(memoAdapter);

    }

    private void addMemo(int id, String title, String text, String date){

        //add memo
        Memo newMemo = new Memo(id,title,text,date);
        memoList.add(newMemo);

        //update recycler view
        memoAdapter.notifyDataSetChanged();
    }
}
