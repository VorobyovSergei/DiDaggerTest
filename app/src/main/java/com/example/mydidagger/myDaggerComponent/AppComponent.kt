package com.example.mydidagger.myDaggerComponent

import com.example.mydidagger.MainActivity
import com.example.mydidagger.myClassesForDagger.DatabaseHelper
import com.example.mydidagger.myClassesForDagger.NetworkUtils
import com.example.mydidagger.myDaggerModuls.NetworkModule
import com.example.mydidagger.myDaggerModuls.StorageModule
import dagger.Component

//При компиляции проекта, даггер найдет этот интерфейс по аннотации @Component
// и сгенерирует класс DaggerAppComponent (Dagger + имя интерфейса),
// который станет реализацией этого интерфейса.
@Component
    (modules = [StorageModule::class, NetworkModule::class]) //модули где искать компоненты
interface AppComponent {
//    Нам остается рассказать компоненту, какие именно объекты мы хотим от него получать.
//    Для этого мы будем наполнять его интерфейс методами. И вот тут у нас есть два вида методов.

    //1 способ
//    Создаем два метода. Они могут быть с любым именем,
//    главное - это их возвращаемые типы (NetworkUtils и DatabaseHelper)
    fun getDatabaseHelper(): DatabaseHelper
    fun getNetworkUtils(): NetworkUtils

    //2 способ
//    Вместо пары get-методов мы описываем один inject-метод. Имя может быть любым,
    //    главное - это тип его единственного параметра. Мы указываем здесь MainActivity.
    //    Тем самым, мы говорим компоненту, что когда мы будем вызывать этот метод
    //    и передавать туда экземпляр MainActivity, мы ожидаем,
    //    что компонент наполнит этот экземпляр требуемыми объектами.
    fun injectMainActivity(mainActivity: MainActivity)
}