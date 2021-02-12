/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Week 7 Toast Anyone?
*/

package edu.rockvalleycollege.week7toast

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtMessage = findViewById<EditText>(R.id.txtMessage)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        var txtTheMessage = findViewById<TextView>(R.id.txtTheMessage)

        txtMessage.requestFocus()

        btnSubmit.setOnClickListener {
            if(txtMessage.text.length == 0){
                txtTheMessage.setText("You need to enter something")
            }else {
                hideKeyboard()

                Toast.makeText(this, "The message is: ${txtMessage.text.toString()}", Toast.LENGTH_LONG).show()
                txtTheMessage.setText("The message in Toast should read: ${txtMessage.text.toString()}")

                txtMessage.setText("")
                txtMessage.requestFocus()
            }
        }//End if onclick listener

        // This code goes at the end of OnCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }// End of hidekeyboard

    }// End of OnCreate

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }// End of Hide keyboard

}// End of Main Activity