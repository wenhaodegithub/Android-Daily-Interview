package com.example.myandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // 初始化ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // 初始化ViewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        
        // 设置UI
        setupUI()
        
        // 观察数据
        observeData()
    }
    
    private fun setupUI() {
        binding.buttonClick.setOnClickListener {
            viewModel.onButtonClicked()
        }
        
        binding.buttonReset.setOnClickListener {
            viewModel.resetCounter()
        }
    }
    
    private fun observeData() {
        viewModel.counterText.observe(this) { text ->
            binding.textCounter.text = text
        }
        
        viewModel.welcomeMessage.observe(this) { message ->
            binding.textWelcome.text = message
        }
    }
}