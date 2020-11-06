package com.example.whatdidilearn.view

import android.app.AlertDialog
import android.app.AlertDialog.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.whatdidilearn.R
import com.example.whatdidilearn.data.DatabaseItems
import com.example.whatdidilearn.data.ItemLearnedDao
import com.example.whatdidilearn.databinding.ActivityMainBinding
import com.example.whatdidilearn.databinding.ActivityNewLearnedItemBinding
import com.example.whatdidilearn.entities.Level
import com.example.whatdidilearn.repository.LearnedItemRepository
import com.example.whatdidilearn.viewmodel.LearnedItemViewModel
import com.example.whatdidilearn.viewmodel.LearnedItemViewModelFactory
import com.example.whatdidilearn.viewmodel.NewLearnedItemViewModel
import com.example.whatdidilearn.viewmodel.NewLearnedItemViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class NewLearnedItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewLearnedItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title ="New Learned Item"

        val dao = DatabaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO)).ItemLearnedDao()
        val repository = LearnedItemRepository(dao)
        val viewModelFactory = NewLearnedItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)
                .get(NewLearnedItemViewModel::class.java)

        binding.buttonSalvar.setOnClickListener {
            val title = binding.editItemTitle.text.toString()
            val description = binding.editItemDescription.text.toString()

            viewModel.insertNewLearnedItem(title, description)

            backToMainActivity()
        }


    }

    private fun backToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun errorDialog(){
        val builder = Builder(this)
        builder.setMessage("Please fill out all fields.")
        builder.setPositiveButton("OK", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}


