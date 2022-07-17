package com.example.mydidagger.myDaggerModuls

import com.example.mydidagger.myClassesForDagger.DatabaseHelper
import dagger.Module
import dagger.Provides

//этот модуль который и будет создавать экземпляр класса
@Module//мы сообщаем даггеру, что этот класс является модулем
class StorageModule {
    @Provides //указывает, что метод является поставщиком объекта.
    fun provideDatabaseHelper(): DatabaseHelper {
        return DatabaseHelper()
    }
}