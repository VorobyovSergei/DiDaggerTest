package com.example.mydidagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mydidagger.myClassesForDagger.DatabaseHelper
import com.example.mydidagger.myClassesForDagger.NetworkUtils
import com.example.mydidagger.myDaggerComponent.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    //Например какие-то классы нам нужны здесь

    //1 способ
//    lateinit var databaseHelper: DatabaseHelper
//    lateinit var networkUtils: NetworkUtils
    //классы созданы и нам надо теперь создать модули и компоненты для Даггера

    //2 способ
    @Inject lateinit var databaseHelper: DatabaseHelper
    @Inject lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1 способ
        //После этого MainActivity сможет получать от компонента все необходимые объекты.
//        val appComponent = (application as App).appComponent

        //все, теперь это создается за нас
//        databaseHelper = appComponent.getDatabaseHelper()
//        networkUtils = appComponent.getNetworkUtils()

        (application as App).appComponent.injectMainActivity(this)

        databaseHelper.logme()
        networkUtils.logme()
    }
}