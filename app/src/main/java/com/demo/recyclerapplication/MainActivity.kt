package com.demo.recyclerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var mainrecycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainrecycler= findViewById(R.id.recycler)
        mainrecycler.adapter = AlphaNumericAdapter(generateData())
        mainrecycler.layoutManager = LinearLayoutManager(this)
        mainrecycler.itemAnimator = DefaultItemAnimator()
    }

    private fun generateData(): ArrayList<AlphaNumericData> {
        val list: ArrayList<AlphaNumericData> = ArrayList()
        list.add(AlphaNumericData("Characters"))
        for (i in 'A'..'Z'){
            list.add(AlphaNumericData("$i"))
        }
        list.add(AlphaNumericData("Numbers"))
        for (i in 0..9){
            list.add(AlphaNumericData("$i"))
        }
        return list
    }
}