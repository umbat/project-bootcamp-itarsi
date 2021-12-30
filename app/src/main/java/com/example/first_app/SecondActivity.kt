package com.example.first_app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    private lateinit var tvGreeting: TextView
    private lateinit var rvProdi: RecyclerView
    private var title = "Mode List"
    private var list: ArrayList<Prodi> = arrayListOf()

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setActionBarTitle(title)
        supportActionBar?.title = "STMKG"

        val name = intent.getStringExtra(EXTRA_NAME)

        tvGreeting.text = "Selamat Datang $name"
        tvGreeting = findViewById(R.id.tv_greeting)
        rvProdi = findViewById(R.id.rv_prodi)
        rvProdi.setHasFixedSize(true)

        list.addAll(ProdiData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvProdi.layoutManager = LinearLayoutManager(this)
        val listProdiAdapter = ListAdapter(list)
        rvProdi.adapter = listProdiAdapter

        listProdiAdapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Prodi) {
                showSelectedProdi(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvProdi.layoutManager = GridLayoutManager(this, 2)
        val gridProdiAdapter = GridAdapter(list)
        rvProdi.adapter = gridProdiAdapter

        gridProdiAdapter.setOnItemClickCallback(object : GridAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Prodi) {
                showSelectedProdi(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }
        }
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun showSelectedProdi(players: Prodi) {
        val intent= Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_PRODI, players)
        startActivity(intent)
    }
}
