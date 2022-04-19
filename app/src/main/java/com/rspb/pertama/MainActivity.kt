package com.rspb.pertama

import android.app.Person
import android.net.Uri
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import android.content.Intent as Intent1

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView
    private val resultLauncher =
registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode ==
                MoveForResultActivity.RESULT_CODE && result.data !=null){
            val selectedValue = result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnpindah: Button = findViewById(R.id.btn_pindah)
        btnpindah.setOnClickListener(this)

        val btnpindahdata: Button = findViewById(R.id.btn_pindah_data)
        btnpindahdata.setOnClickListener(this)

        val btnMoveWithObject:Button =
            findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btndialphone: Button = findViewById(R.id.btn_dial_number)
        btndialphone.setOnClickListener(this)

        val btnMoveForResult : Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

        val btnbiodata: Button = findViewById(R.id.btn_biodata)
        btnbiodata.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_pindah -> {
                val intentpindah = Intent1(this@MainActivity,MoveActivity::class.java)
                startActivity(intentpindah)
            }
            R.id.btn_pindah_data -> {
                val moveWithDataIntent = Intent1(this@MainActivity,MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"Dani Kasmanto Himawan")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,20)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val pertama = Pertama (
                    "DANI KASMANTO",
                    20,
                    "dani.kasmanto112@gmail.com",
                    "Pekanbaru"
                        )

                val moveWithObjectIntent = Intent1(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, pertama)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "082258551420"
                val dialPhoneIntent = Intent1(Intent1.ACTION_DIAL,Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent1(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
            R.id.btn_biodata -> {
                val intentbiodata = Intent1(this@MainActivity,biodata::class.java)
                startActivity(intentbiodata)
            }
        }
    }
}