package com.aswinhariram2005.numerologycalculator

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.aswinhariram2005.numerologycalculator.Result
import com.aswinhariram2005.numerologycalculator.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup_datePicker()

        binding.calculateBtn.setOnClickListener {


            var name = binding.nameEdt.text.toString()
            var dob = binding.dobEdt.text.toString()
            if (!name.isEmpty() and !dob.isEmpty()) {
                startActivity(Intent(applicationContext,Result::class.java).also {
                    it.putExtra("NAME_KEY",name)
                    it.putExtra("DOB_KEY",dob)
                })

            }
        }
    }



    private fun hideKeyBoard() {

        val view: View? = this.currentFocus
        if (view != null) {
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)

        }
    }



    private fun setup_datePicker() {


        var cal = Calendar.getInstance()

        binding.dobEdt.setOnClickListener {
            hideKeyBoard()
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { datePicker, y, m, dom ->
                    binding.dobEdt.setText("$dom/${m + 1}/$y")
                    binding.calculateBtn.setFocusableInTouchMode(true);
                    binding.calculateBtn.requestFocus();
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }


}