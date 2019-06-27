package eduardo.poo.biblioteca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eduardo.poo.biblioteca.Fragments.EntradaFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.elevation = 0f

        supportFragmentManager.beginTransaction().add(R.id.root_layout, EntradaFragment.newInstance(), "Entrada").commit();
    }
}
