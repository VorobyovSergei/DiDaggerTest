package com.example.mydidagger.myDaggerComponent

import android.app.Application

//После того как даггер создал нам класс компонента,
// нам необходимо создать экземпляр этого класса.
// Это можно сделать, например, в Application классе
// (не забудьте добавить его в манифест):
class App:Application() {

    //На этом месте ваша среда разработки, возможно, будет ругаться
    // на класс DaggerAppComponent. Так может происходить, потому что
    // класса DaggerAppComponent пока не существует.
    // Мы описали интерфейс компонента AppComponent,
    // но нам надо скомпилировать проект, чтобы даггер создал этот класс-компонент.
    //
    //Скомпилируйте проект.
    //В Android Studio это можно сделать через меню Build -> Make Project (CTRL+F9).
    // После того как процесс завершится, класс DaggerAppComponent будет создан
    // в недрах папки build\generated\. Студия теперь знает этот класс
    // и должна предлагать добавить его в import,
    //чтобы в коде не было никаких ошибок.
    val appComponent = DaggerAppComponent.create()
}