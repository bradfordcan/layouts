package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // created by compiler
    // name is derived from layout activity_main + binding
    private lateinit var binding: ActivityMainBinding

    // Create instance of the data class
    private val name: Name = Name("Bradford Canonigo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        // Create binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /*findViewById<Button>(R.id.button_done).setOnClickListener {
            addNickname(it)
        }*/

        binding.name = name

        binding.buttonDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        /*val editText = findViewById<EditText>(R.id.edit_text_name)
        val nicknameText = findViewById<TextView>(R.id.text_nickname)

        nicknameText.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE*/

        binding.apply {
            // textNickname.text = binding.editTextName.text
            name?.nickname = editTextName.text.toString()
            invalidateAll()
            editTextName.visibility = View.GONE
            buttonDone.visibility = View.GONE
            textNickname.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
