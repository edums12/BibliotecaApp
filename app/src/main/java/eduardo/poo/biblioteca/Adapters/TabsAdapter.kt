package eduardo.poo.biblioteca.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import eduardo.poo.biblioteca.Fragments.HistoricoFragment
import eduardo.poo.biblioteca.Fragments.InicialFragment
import eduardo.poo.biblioteca.Fragments.ReservaFragment

class TabsAdapter (fragment :FragmentManager) :FragmentPagerAdapter(fragment) {

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> InicialFragment.getInstance()
        1 -> HistoricoFragment.getInstance()
        2 -> ReservaFragment.getInstance()
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "Inicial"
        1 -> "Histórico"
        2 -> "Reserva"
        else -> ""
    }

    override fun getCount(): Int = 3


}