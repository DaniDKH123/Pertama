package com.rspb.pertama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveForResultActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var btnChoose: Button
    private lateinit var btnNumber: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        btnChoose.setOnClickListener(this)
        btnNumber = findViewById(R.id.rg_number)
    }

    override fun onClick(p0: View?) {
       if (p0?.id == R.id.btn_choose) {
           if (btnNumber.checkedRadioButtonId > 0) {
               var value = 0
               when (btnNumber.checkedRadioButtonId){
                   R.id.rg_50 -> value = 50
                   R.id.rg_100 -> value = 100
                   R.id.rg_150 -> value = 150
                   R.id.rg_200 -> value = 200
               }
               val resultIntent = Intent()
               resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
               setResult(RESULT_CODE, resultIntent)
               finish()
           }
       }
    }
}