package com.rspb.pertama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_pertama"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvobject : TextView = findViewById(R.id.tv_object_received)

        val person = intent.getParcelableExtra<Pertama>(EXTRA_PERSON) as Pertama

        val text = "Name : ${person.name.toString()}, \nEmail : ${person.email}, \nAge : ${person.age}, \nLocation : ${person.city}"
            tvobject.text = text
    }
}