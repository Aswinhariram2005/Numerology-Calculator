package com.aswinhariram2005.numerologycalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.aswinhariram2005.numerologycalculator.databinding.ActivityResultBinding

private lateinit var binding: ActivityResultBinding

class Result : AppCompatActivity() {
    private var Lifepath = 0
    private var Birthday = 0
    private var Compound = 0
    private var Destiny = 0
    private var Heart = 0
    private var Personality = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra("NAME_KEY")
        var dob = intent.getStringExtra("DOB_KEY")
        if (name != null && dob !=null) {
            calculate(name, dob)
            compare(name,dob)
        }


    }

    private fun compare(name: String, dob: String) {
        binding.res.setText(life_and_dest(name, dob))
    }

    private fun life_and_dest(name: String, dob: String): String {
        var life = simplify(lifePath(name, dob))
        var des = simplify(destiny(name, dob))
        var res = 0.0;
     if (life>des){
         res = ((des/life)*100).toDouble()
     }
        else{
         res = ((life/des)*100).toDouble()
        }
        if (res>50){
            return "Name matches with DOB"
        }
        else{
            return " SORRY, Name is NOT Matching with DOB"
        }
    }

    private fun calculate(name: String, dob: String) {

        hideKeyBoard()

        Lifepath = lifePath(name, dob)
        Birthday = birth(name, dob)
        Compound = compound(name, dob)
        Destiny = destiny(name, dob)
        Heart = heartDesire(name, dob)
        Personality = personality(name, dob)

        binding.tableHeading.setText("$name's Core Numerology Numbers")
        binding.lifepathTxt.setText(Lifepath.toString())
        binding.birthNumberTxt.setText(Birthday.toString())
        binding.compNumTxt.setText(Compound.toString())
        binding.destTxt.setText(Destiny.toString())
        binding.heartDesireTxt.setText(Heart.toString())
        binding.personTxt.setText(Personality.toString())
    }
    private fun lifePath(name: String, dob: String): Int {
        var dob_split = dob.split("/")
        var sum = 0
        for (i in dob_split) {
            for (x in i) {
                sum += x.toString().toInt()
            }
        }



        do {
           sum =  simplify(simplify(sum))
        }
            while (sum>9)
       return sum
    }

    private fun birth(name: String, dob: String): Int {
        var dob_split = dob.split("/")
        var date = dob_split[0]
        var sum = 0;
        for (i in date) {
            sum += i.toString().toInt()
        }
        return simplify(sum)
    }

    private fun compound(name: String, dob: String): Int {
        var sum = 0
        for (i in name) {
            sum += chaladeanTable(i)
        }


        return sum

    }

    private fun destiny(name: String, dob: String): Int {

        return simplify(compound(name, dob))
    }

    private fun heartDesire(name: String, dob: String): Int {
        var sum = 0
        for (i in name) {
            if (i in "AEIOUaeiou") {
                sum += chaladeanTable(i)
            }
        }
        return sum
    }

    private fun personality(name: String, dob: String): Int {
        var sum = 0
        for (i in name) {
            if (i !in "AEIOUaeiou") {
                Log.d("TAG_CHECK", "personality: $i = ${chaladeanTable(i)}")
                sum += chaladeanTable(i)
            }
        }
        return simplify(sum)
    }
    private fun hideKeyBoard() {

        val view: View? = this.currentFocus
        if (view != null) {
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)

        }
    }
    private fun simplify(sum: Int): Int {
        var res = 0
        for (i in sum.toString()) {
            res += i.toString().toInt()
        }
        return res
    }

    private fun chaladeanTable(letter: Char): Int {
        if (letter in "AIJQYaijqy") {
            return 1
        } else if (letter in "BKRbkr") {
            return 2
        } else if (letter in "CGLScgls") {
            return 3
        } else if (letter in "DMTdmt") {
            return 4
        } else if (letter in "EHNXehnx") {
            return 5
        } else if (letter in "UVWuvw") {
            return 6
        } else if (letter in "OZoz") {
            return 7
        } else if (letter in "FPfp") {
            return 8
        } else {
            return 0
        }
    }
}