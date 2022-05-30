package com.example.hci

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hci.databinding.RssBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class RssRecActivity(): AppCompatActivity() {
    lateinit var binding: RssBinding
    lateinit var adapter: MyTipsAdapter
    var rssurl = "https://www.bonappetit.com/feed/recipes-rss-feed/rss"

    val scope = CoroutineScope(Dispatchers.IO)

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        binding = RssBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun getrssnews(){
        scope.launch {
            adapter.items.clear()
            val doc = Jsoup.connect(rssurl).parser(Parser.xmlParser()).get()
            val headlines = doc.select("item")
            for(news in headlines){
                adapter.items.add(MyTipsData(news.select("title").text(),
                    news.select("link").text()))
            }
            withContext(Dispatchers.Main){
                adapter.notifyDataSetChanged()
                binding.swipe.isRefreshing = false
            }
        }
    }



    private fun init(){

        binding.swipe.setOnRefreshListener {
            binding.swipe.isRefreshing = true
            getrssnews()
        }
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL)
        )
        adapter = MyTipsAdapter(ArrayList<MyTipsData>())
        adapter.itemClickListener = object:MyTipsAdapter.OnItemClickListener{
            override fun OnItemClick(position: Int) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(adapter.items[position].url))
                startActivity(intent)
            }
        }
        binding.recyclerView.adapter = adapter
        getrssnews()
    }

    }