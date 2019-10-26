package nandaadi.saputra.fragment.activity

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import nandaadi.saputra.fragment.R
import nandaadi.saputra.fragment.fragment.HistoryFragment
import nandaadi.saputra.fragment.fragment.HomeFragment
import nandaadi.saputra.fragment.fragment.InfoFragment
import nandaadi.saputra.fragment.fragment.ProfileFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var content: FrameLayout? = null

    val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val fragment = HomeFragment.newInstance()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.info -> {
                    val fragment = InfoFragment.newInstance()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.history -> {
                    val fragment = HistoryFragment.newInstance()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.about -> {
                    val fragment = ProfileFragment.newInstance()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.contentSewa, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initView()


        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun initView() {

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = HomeFragment.newInstance()
        addFragment(fragment)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_add -> {
                val intent = Intent(this@MainActivity, StudentActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_map -> {
                val intent = Intent(this@MainActivity, MapsActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_movie -> {
                val intent = Intent(this@MainActivity, MovieActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_transaksi -> {

            }
            R.id.nav_pengaturan -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}