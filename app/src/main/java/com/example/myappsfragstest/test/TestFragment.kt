package com.example.myappsfragstest.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myappsfragstest.R




class TestFragment : Fragment() {

    private var name: String? = null
    private var num1:Float = 0.0f
    private var num2:Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NOMBRE_BUNDLE)
            num1 = it.getFloat(NUM1_BUNDLE)
            num2 = it.getFloat(NUM2_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    companion object {
        private const val NOMBRE_BUNDLE = "param1"
        private const val NUM1_BUNDLE = "param2"
        private const val NUM2_BUNDLE = "param3"

        @JvmStatic
        fun newInstance(param1: String, param2: Float,param3:Float) =
            TestFragment().apply {
                arguments = Bundle().apply {
                    putString(NOMBRE_BUNDLE, param1)
                    putFloat(NUM1_BUNDLE, param2)
                    putFloat(NUM2_BUNDLE, param3)

                }
            }
    }
}