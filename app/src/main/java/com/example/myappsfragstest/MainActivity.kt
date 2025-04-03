package com.example.myappsfragstest
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.myappsfragstest.test.TestFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        enableEdgeToEdge()
        supportActionBar?.hide()

        if(savedInstanceState == null){
            val bundle = bundleOf()
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<TestFragment>(R.layout.fragment_test,args = bundle)
            }
        }

    }
}

