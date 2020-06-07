package com.example.lvandrvproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_fruit.view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        lvFruits.adapter = ArrayAdapter<String>(
            this,
            R.layout.list_item_fruit,
            R.id.tvFruitName,
            arrayOf(
                "Apples",
                "Mangos",
                "Guavas",
                "Oranges",
                "Strawberries",
                "Plums",
                "Kiwis",
                "Grapes",
                "Watermelons",
                "Bananas",
                "Pineapples",
                "Cherries",
                "Peaches",
                "Apricots",
                "Lychees",
                "Grapefruits"
            )
        )

        lvFruits.setOnItemClickListener(){ parent, view, position, id ->
            Toast.makeText(this,
                "Mike ate $position ${view.tvFruitName.text}",
                Toast.LENGTH_SHORT).show()

        }
    }
}
