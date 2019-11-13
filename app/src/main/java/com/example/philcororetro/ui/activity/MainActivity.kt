package com.example.philcororetro.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.philcororetro.R
import com.example.philcororetro.adapters.ActionAdaptor
import com.example.philcororetro.ui.viewmodel.ActionViewModel
import com.example.philcororetro.extensions.getViewModel


import com.example.philcororetro.di.base.ViewModelFactory
import com.example.philcororetro.extensions.observeNotNull
import com.example.philcororetro.model.Action
import com.example.philcororetro.model.ViewState
import com.example.philcororetro.ui.base.BaseActivity

import kotlinx.android.synthetic.main.activity_main.*
import java.sql.DriverManager.println
import android.widget.Toast
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import org.jetbrains.anko.toast


class MainActivity : BaseActivity() {

    private val actionViewModel by lazy { getViewModel<ActionViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.philcororetro.R.layout.activity_main)


     

       actionViewModel.getActions().observeNotNull(this){state ->
           when(state){
               is ViewState.Loading -> println("PM_DEBUG Loading....")
           // is ViewState.Success -> println("PM_DEBUG Got data! => ${state.data}")
               is ViewState.Success -> toastMessage("PM_DEBUG Got data! => ${state.data}")
           }

            //TODO

        }


    }

    private fun logThread(methodName: String){
        println("debug: ${methodName}: ${Thread.currentThread().name}")
    }

    private fun initRecyclerView(list: List<Action>) {

            println("The list is: ${list}")

        recyclerview.layoutManager = LinearLayoutManager(this)
       recyclerview.adapter = ActionAdaptor(list, this)
    }

    private fun toastMessage(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}
