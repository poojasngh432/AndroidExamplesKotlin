package com.example.lvandrvproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //getting recyclerview from xml
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<User>()

        //adding some dummy data to the list
        users.add(User("Night King", "Raises the dead"))
        users.add(User("Arya Stark","Trained as one of the faceless assassins"))
        users.add(User("The Mountain", "Cersie's Personal Guard"))
        users.add(User("Brienne of Tarth", "Kingsguard to Renly Baratheon"))
        users.add(User("The Hound", "One of The Strongest Fighters in Westeros"))
        users.add(User("Tormund Giantsbane","Strongest of the freefolk North of the Wall"))
        users.add(User("Jon Snow","Rhaegar Targeryen"))
        users.add(User("Jeor Mormont","Lord Commander of The Night's Watch"))
        users.add(User("Grey Worm","Best of the Unsullied"))
        users.add(User("Darrio Naharis","Lieutenant of the Second Sons Sellsword company"))
        users.add(User("Jaime Lannister","The Kingslayer"))
        users.add(User("Oberyn Martell","The Viper"))
        users.add(User("Ned Stark","The Hand of the King"))
        users.add(User("Barristan Selmy","Former Lord Commander of Kingsguard"))
        users.add(User("Jorah Mormont","Daenerys's Best Soldier"))
        users.add(User("Bronn","Sellsword"))

        //creating our adapter
        val adapter = CustomAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }
}
