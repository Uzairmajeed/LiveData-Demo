package com.facebook.livedata_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.facebook.livedata_demo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        val viewModel=ViewModelProvider(this).get(MainActivtyViewModel::class.java)
        viewModel.startTimer()

        viewModel.seconds().observe(this,Observer{
            binding.textview.text=it.toString()
        })

        viewModel.finsihed.observe(this,Observer{

            if(it){
                Toast.makeText(applicationContext, "Timer Finished!", Toast.LENGTH_SHORT).show() }
        })

    }
}