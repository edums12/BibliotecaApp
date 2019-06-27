package eduardo.poo.biblioteca.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import eduardo.poo.biblioteca.Adapters.TabsAdapter
import eduardo.poo.biblioteca.MainActivity
import eduardo.poo.biblioteca.Models.Pessoa

import eduardo.poo.biblioteca.R
import kotlinx.android.synthetic.main.fragment_init.*

class InitFragment : Fragment() {

    companion object{
        fun newInstance() :InitFragment = InitFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_init, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Bem vindo! " + Pessoa.getInstance().nome().split(' ')[0]

        val adapter = TabsAdapter(activity!!.supportFragmentManager)

        viewpager.adapter = adapter

        tabs.setupWithViewPager(viewpager)

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}
