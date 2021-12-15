package tads.eaj.ufrn.exemploroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    val db:AppDatabase by lazy {
        Room.databaseBuilder(
                this,
                AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db.carroDao().inserir(Carro("nome", "tipo", "desc", 2018))
        db.carroDao().listAll().forEach { Log.i("APPROOM", it.toString()) }

        val c1 = Carro("nome", "tipo", "desc", 1998)
        val c2 = Carro("nome2", "tipo2", "2", 1999)

        db.carroDao().insereDois(c1, c2)

        //db.carroDao().deletaTodos()
    }
}