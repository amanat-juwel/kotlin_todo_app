package com.example.buttoncounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainAcitivity"
private const val TEXT_CONTENTS = "TExtContent"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var numTimesClicked = 0
        var userInput: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textView?.text = "" //set initial text empty
        textView?.movementMethod = ScrollingMovementMethod() //to scroll through the text view list

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                numTimesClicked += 1

                /*
                //start counter
                textView?.append("The button got tapped ${numTimesClicked} time")
                if (numTimesClicked != 1) {
                    textView?.append("s") //clicked more than one time
                }
                textView?.append("\n") //new line
                */
                textView?.append(numTimesClicked.toString())
                textView?.append(". ")
                textView?.append(userInput?.text)
                textView?.append("\n")

                //userInput.text.clear()
                userInput.setText("")
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart: called")
        super.onStart()
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        Log.d(TAG, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState, outPersistentState)

        //saving text data while screen rotates
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    // This callback is called only when there is a saved instance that is previously saved by using
    // onSaveInstanceState(). We restore some state in onCreate(), while we can optionally restore
    // other state here, possibly usable after onStart() has completed.
    // The savedInstanceState Bundle is same as the one used in onCreate().
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.d(TAG, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
        //retrieving text data while screen rotates
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }

    override fun onResume() {
        Log.d(TAG, "onResume: called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: called")
        super.onDestroy()
    }
}
