package com.example.lvandrvproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_fruit.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv.setOnClickListener{
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }
        lvCustom.setOnClickListener{
            val intent = Intent(this, CustomAdapterActivity::class.java)
            startActivity(intent)
        }
        rv.setOnClickListener{
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

    }
}
