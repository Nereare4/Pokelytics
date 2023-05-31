package study.project.pokelytics.activities

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import study.project.pokelytics.R
import study.project.pokelytics.adapters.NavAdapter
import study.project.pokelytics.databinding.ActivityMainBinding
import study.project.pokelytics.databinding.NavigationDrawerLayoutBinding
import study.project.pokelytics.models.NavItem
import study.project.pokelytics.models.User
import study.project.pokelytics.viewmodels.NavigationViewModel


class MainActivity : ActivityBase<ActivityMainBinding>() {

    override fun getResourceLayout(): Int = R.layout.activity_main
    private val viewModel: NavigationViewModel by viewModel()
    private lateinit var navLayoutManager: LinearLayoutManager
    private lateinit var settingsLayoutManager: LinearLayoutManager
    private lateinit var navAdapter: NavAdapter
    private lateinit var user: User

    override fun initializeView() {
        loadData()
        navLayoutManager = LinearLayoutManager(this)
        settingsLayoutManager = LinearLayoutManager(this)
        navAdapter = NavAdapter()
        viewModel.getNavItems()
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

            navRecycler.adapter = navAdapter

            settingsRecycler.adapter = NavAdapter().apply {
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
        viewModel.navItems.observe(this) {
            it.forEach { it.mapId() }
            navAdapter.items.addAll(it)
            navAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        private const val USER = "user"
        fun getIntent(context: Context, user: User) = Intent(context, MainActivity::class.java)
            .apply {
                putExtra(USER, user)
            }
    }
    private fun loadData() {
        user = intent.getSerializableExtra(USER) as User
    }


}