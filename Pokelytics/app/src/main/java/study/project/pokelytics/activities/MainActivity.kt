package study.project.pokelytics.activities

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import study.project.pokelytics.R
import study.project.pokelytics.adapters.NavAdapter
import study.project.pokelytics.databinding.ActivityMainBinding
import study.project.pokelytics.databinding.NavigationDrawerLayoutBinding
import study.project.pokelytics.models.NavItem


class MainActivity : ActivityBase<ActivityMainBinding>() {

    override fun getResourceLayout(): Int = R.layout.activity_main
    private lateinit var navLayoutManager: LinearLayoutManager
    private lateinit var settingsLayoutManager: LinearLayoutManager
    override fun initializeView() {
        navLayoutManager = LinearLayoutManager(this)
        settingsLayoutManager = LinearLayoutManager(this)
        initializeNavGraph()
        initializeDrawer()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.topBar.moreIcon.setOnClickListener {
            binding.drawerLayout.open()
        }
    }

    private fun initializeDrawer() {
        val navDrawerBinding = NavigationDrawerLayoutBinding.inflate(LayoutInflater.from(this), binding.root as ViewGroup, false).apply {
            navRecycler.layoutManager = navLayoutManager
            settingsRecycler.layoutManager = settingsLayoutManager
            navRecycler.adapter = NavAdapter().apply {
                items = mutableListOf(
                    NavItem("Home", R.drawable.ic_pokeball),
                    NavItem("Pokedex", R.drawable.ic_pokeball),
                    NavItem("Moves", R.drawable.ic_pokeball),
                    NavItem("Items", R.drawable.ic_pokeball),
                    NavItem("Abilities", R.drawable.ic_pokeball),
                    NavItem("Locations", R.drawable.ic_pokeball),
                    NavItem("Type Charts", R.drawable.ic_pokeball),
                    NavItem("Egg Groups", R.drawable.ic_pokeball),
                    NavItem("Berries", R.drawable.ic_pokeball),
                    NavItem("Natures", R.drawable.ic_pokeball),
                )
                notifyDataSetChanged()
            }

            settingsRecycler.adapter = NavAdapter().apply {
                items = mutableListOf(
                    NavItem("About", R.drawable.ic_pokeball),
                    NavItem("Settings", R.drawable.ic_pokeball),
                    NavItem("Logout", R.drawable.ic_pokeball)
                )
                notifyDataSetChanged()
            }
        }
        binding.navigationDrawer.removeAllViews()
        binding.navigationDrawer.addView(navDrawerBinding.root)
    }

    private fun initializeNavGraph() {
        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val graph = navHost.navController.navInflater.inflate(R.navigation.nav_graph_main)
        navHost.navController.graph = graph
    }

    override fun bindViewModel() {
        binding.apply {
            lifecycleOwner = this@MainActivity
        }
    }
    override fun subscribe() {

    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }


}