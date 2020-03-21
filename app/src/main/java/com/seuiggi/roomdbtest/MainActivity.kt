package com.seuiggi.roomdbtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.seuiggi.roomdbtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = ViewModelProvider.AndroidViewModelFactory(application).create(UserViewModel::class.java)
        userViewModel.getAll().observe(this, Observer {
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        })

        binding.vm = userViewModel
        binding.activity = this@MainActivity
        binding.lifecycleOwner = this
    }

    fun insertClick(view: View) {
        val id = binding.idEdit.text.toString()
        val password = binding.passwordEdit.text.toString()
        val hash = System.currentTimeMillis()
        userViewModel.insert(User(hash, id, password))
    }

    fun deleteClick(view: View) {
        val id = binding.idEdit.text.toString()
        val password = binding.passwordEdit.text.toString()
        val hash = System.currentTimeMillis()
        userViewModel.delete(User(hash, id, password))
    }
}