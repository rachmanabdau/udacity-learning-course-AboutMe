package com.volvox.aboutme

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.databinding.DataBindingUtil
import android.os.Build.VERSION_CODES.M
import kotlinx.android.synthetic.main.activity_main.*
import com.volvox.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName : MyName = MyName("Rachman")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View){

        binding.apply{
            myName?.nickname = nicknameEdit.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
            binding.nicknameText.visibility = View.VISIBLE
            binding.nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
        }

        //Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
