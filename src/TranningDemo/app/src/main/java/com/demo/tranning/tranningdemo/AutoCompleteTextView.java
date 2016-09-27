package com.demo.tranning.tranningdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteTextView extends AppCompatActivity {
android.widget.AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    // 定义字符串数组，作为提示的文本
    String[] books = new String[]{
            ".NET 揭秘",
            ".NET via CLR",
            "Java 编程思想",
            "活着",
            "四世同堂",
            "平凡的世界",
            "三体",
            "Javascript 语言精粹",
            "C# 高级编程",
            "C# via Depth"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, books);

        autoCompleteTextView = (android.widget.AutoCompleteTextView)findViewById(R.id.auto);
        autoCompleteTextView.setAdapter(adapter);

        multiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.mauto);
        multiAutoCompleteTextView.setAdapter(adapter);
        // 为MultiAutoCompleteTextView设置分隔符
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
