package com.example.myappsfragstest
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.myappsfragstest.test.TestFragment


lateinit var botonsalir:Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        enableEdgeToEdge()
        supportActionBar?.hide()
        if(savedInstanceState == null){

            val fragment = TestFragment.newInstance(
                param1 = "Bye",
                param2 = 8,
                param3 = 40,
                param4 = R.drawable.morty,
                param5 = true
            )

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container2, fragment) //
            }

            botonsalir = findViewById(R.id.BtnSalir)
            botonsalir.setOnClickListener {
                finish()
            }

        }

    }
}