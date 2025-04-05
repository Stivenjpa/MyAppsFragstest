package com.example.myappsfragstest
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.myappsfragstest.test.TestFragment
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        enableEdgeToEdge()
        supportActionBar?.hide()

        if(savedInstanceState == null){

            val fragment = TestFragment.newInstance(
                param1 = "Hello",
                param2 = 5,
                param3 = 5,
                param4 = R.drawable.rick,
                param5 = true
            )

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container, fragment) //
            }
            val bundle = bundleOf()

        }

    }
}

