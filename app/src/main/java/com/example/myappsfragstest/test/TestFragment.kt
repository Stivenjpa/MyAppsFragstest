package com.example.myappsfragstest.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myappsfragstest.R


class TestFragment : Fragment() {

    private var name: String? = null
    private var num1: Int = 0
    private var num2: Int = 0
    private var image: Int = R.drawable.rick
    private var visible: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NOMBRE_BUNDLE)
            num1 = it.getInt(NUM1_BUNDLE)
            num2 = it.getInt(NUM2_BUNDLE)
            image = it.getInt(IMAGE_BUNDLE, R.drawable.ic_launcher_background)
            visible = it.getBoolean(VISIBLE_BUNDLE, true)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Si visible es falso, ocultamos
        if (!visible) {
            view.visibility = View.GONE
            return
        }

        val textView = view.findViewById<TextView>(R.id.textView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val resultText = view.findViewById<TextView>(R.id.resultText)

        // Texto
        textView.text = name

        // Imagen
        imageView.setImageResource(image)

        // Resultado
        val resultado = num1 * num2
        resultText.text = "Resultado: $resultado"
    }

    companion object {
        private const val NOMBRE_BUNDLE = "param1"
        private const val NUM1_BUNDLE = "param2"
        private const val NUM2_BUNDLE = "param3"
        private const val IMAGE_BUNDLE = "param4"
        private const val VISIBLE_BUNDLE = "param5"

        @JvmStatic
        fun newInstance(param1: String, param2: Int, param3: Int, param4: Int, param5: Boolean) =
            TestFragment().apply {
                arguments = Bundle().apply {
                    putString(NOMBRE_BUNDLE, param1)
                    putInt(NUM1_BUNDLE, param2)
                    putInt(NUM2_BUNDLE, param3)
                    putInt(IMAGE_BUNDLE, param4)
                    putBoolean(VISIBLE_BUNDLE, param5)

                }
            }
    }
}