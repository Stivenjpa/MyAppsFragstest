package com.example.myappsfragstest
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.myappsfragstest.test.TestFragment
import android.content.Intent

lateinit var boton: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        enableEdgeToEdge()
        supportActionBar?.hide()

        if(savedInstanceState == null){ //Control de rotacion para guardar la estancia

            val fragment = TestFragment.newInstance( //paso de datos
                param1 = "Hello",
                param2 = 5,
                param3 = 5,
                param4 = R.drawable.rick,
                param5 = true
            )

            supportFragmentManager.commit { //inicializar el fragmento
                setReorderingAllowed(true)
                add(R.id.fragment_container, fragment) //
            }

            boton = findViewById(R.id.BtnSA)
            boton.setOnClickListener {
                var intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }

        }

    }
}

