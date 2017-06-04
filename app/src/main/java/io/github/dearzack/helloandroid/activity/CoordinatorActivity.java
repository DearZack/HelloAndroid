package io.github.dearzack.helloandroid.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import io.github.dearzack.helloandroid.R;
import io.github.dearzack.helloandroid.adapter.PersonAdapter;
import io.github.dearzack.helloandroid.bean.Person;
import io.github.dearzack.helloandroid.util.EasyTransition;
import io.github.dearzack.helloandroid.util.EasyTransitionOptions;

public class CoordinatorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView portrait;

    private List<Person> persons;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        init();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.person_list);
        portrait = (ImageView) findViewById(R.id.portrait);
        initData();
        adapter = new PersonAdapter(this, persons, new PersonAdapter.Callback() {
            @Override
            public void onClick(View view, int position) {
                // ready for intent
                Intent intent = new Intent(CoordinatorActivity.this, TransitionActivity.class);
                intent.putExtra("name", persons.get(position).getName());

                // ready for transition options
                EasyTransitionOptions options =
                        EasyTransitionOptions.makeTransitionOptions(
                                CoordinatorActivity.this,
                                view.findViewById(R.id.head),
                                view.findViewById(R.id.name));

                // start transition
                EasyTransition.startActivity(intent, options);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                if (parent.getChildAdapterPosition(view) != 0) {
                    outRect.top = 1;
                }
            }
        });
    }

    private void initData() {
        if (persons == null) {
            persons = new ArrayList<>();
        }
        for (int i = 0; i < 30; i++) {
            Person person = new Person();
            person.setHead(R.mipmap.logo);
            person.setName("Name  " + i);
            persons.add(person);
        }
    }


}
