package com.example.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    val colors= arrayOf("Red","Blue","Green","Yellow","Black")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btConfirm)
        button.setOnClickListener{
            Toast.makeText(this,"You Have Confirmed",Toast.LENGTH_SHORT).show()
        }
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colors)
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(
                    this@MainActivity,
                    "You Selected " + colors[p2],
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val ratingTV : TextView = findViewById(R.id.TVRating)
        ratingTV.setOnClickListener{
            var dialog_var=CustomDialogClass()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.my_first_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> Toast.makeText(this, "Refreshing..", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "Added To Favorite", Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(this, "Thank You For Your Report", Toast.LENGTH_SHORT).show()
            R.id.item4 -> Toast.makeText(this, "Downloading..", Toast.LENGTH_SHORT).show()
            R.id.item5 -> Toast.makeText(this, "UNAVAILABLE", Toast.LENGTH_SHORT).show()
            R.id.subitem1 -> Toast.makeText(this, "Connecting...", Toast.LENGTH_SHORT).show()
            R.id.subitem2 -> Toast.makeText(this, "Saving...", Toast.LENGTH_SHORT).show()
        }
        return true;
    }


    fun receiveFeedback(feedback : String){
        val ratingTV: TextView=findViewById(R.id.TVRating)
        ratingTV.text=feedback
    }
}