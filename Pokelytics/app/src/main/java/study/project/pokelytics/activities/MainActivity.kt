package study.project.pokelytics.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.adapters.NavAdapter
import study.project.pokelytics.databinding.ActivityMainBinding
import study.project.pokelytics.databinding.NavigationDrawerLayoutBinding
import study.project.pokelytics.models.NavItem
import study.project.pokelytics.viewmodels.NavigationViewModel
import java.util.Locale


class MainActivity : ActivityBase<ActivityMainBinding>() {

    override fun getResourceLayout(): Int = R.layout.activity_main
    private val viewModel: NavigationViewModel by viewModel()
    private lateinit var navLayoutManager: LinearLayoutManager
    private lateinit var settingsLayoutManager: LinearLayoutManager
    private lateinit var navAdapter: NavAdapter
    private lateinit var navHost: NavHostFragment
    private lateinit var navController : NavController
    override fun initializeView() {
        navLayoutManager = LinearLayoutManager(this)
        settingsLayoutManager = LinearLayoutManager(this)
        initializeNavGraph()
        navAdapter = NavAdapter(
            onClick = { id ->
                when (id.lowercase(Locale.ROOT)) {
                    "pokedex" -> {
                        navController.navigate(R.id.pokemonList)
                    }
                    "moves" -> {
                        navController.navigate(R.id.moveList)
                    }
                    "items" -> {
                        navController.navigate(R.id.berryList)
                    }
                    "Settings" -> {
                        //viewModel.navigateToSettings()
                    }
                    "Logout" -> {
                        //viewModel.logout()
                    }
                }
            }
        )
        viewModel.getNavItems()
        initializeDrawer()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.topBar.moreIcon.setOnClickListener {
            binding.drawerLayout.open()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initializeDrawer() {
        val navDrawerBinding = NavigationDrawerLayoutBinding.inflate(LayoutInflater.from(this), binding.root as ViewGroup, false).apply {
            navRecycler.layoutManager = navLayoutManager
            settingsRecycler.layoutManager = settingsLayoutManager

            navRecycler.adapter = navAdapter

            settingsRecycler.adapter = NavAdapter(
                onClick = { id ->
                    when (id) {
                        "About" -> {
                            //viewModel.navigateToAbout()
                        }
                        "Settings" -> {
                            //viewModel.navigateToSettings()
                        }
                        "Logout" -> {
                            //viewModel.logout()
                        }
                    }
                }
            ).apply {
                items = mutableListOf(
                    NavItem("About", "About"),
                    NavItem("Settings", "Settings"),
                    NavItem("Logout", "Logout")
                )
                notifyDataSetChanged()
            }
        }
        binding.navigationDrawer.removeAllViews()
        binding.navigationDrawer.addView(navDrawerBinding.root)
    }

    private fun initializeNavGraph() {
        navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val graph = navHost.navController.navInflater.inflate(R.navigation.nav_graph_main)
        navHost.navController.graph = graph
        navController = navHost.navController
    }

    override fun bindViewModel() {
        binding.apply {
            lifecycleOwner = this@MainActivity
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun subscribe() {
        viewModel.navItems.observe(this) {
            it.forEach { navItem -> navItem.mapId() }
            navAdapter.items.addAll(it)
            navAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }


}