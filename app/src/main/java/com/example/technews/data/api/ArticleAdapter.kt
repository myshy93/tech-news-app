package com.example.technews.data.api

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.technews.R
import com.example.technews.data.api.models.Article
import com.example.technews.databinding.FragmentArticleBinding


class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.DataBoundViewHolder>() {

    private lateinit var articles: List<Article>

    fun setArticles(articles: List<Article>) {
        this.articles = articles
    }

    companion object ExtraKeys {
        const val articleIdKey: String = "ARTICLE_ID"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder {
        val context = parent.context
//        val inflater = LayoutInflater.from(context)
//        val inflatedView = inflater.inflate(R.layout.fragment_article, parent, false)
        val binding: FragmentArticleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_article,
            parent,
            false
        )
        return DataBoundViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return articles.size
    }


    override fun onBindViewHolder(holder: DataBoundViewHolder, position: Int) {
//        val item = Uri.parse(("http://github.com"))
        val view: View = holder.binding.root
        holder.binding.article = articles[position]
        holder.binding.executePendingBindings()
//        val view = holder.getView()
        view.setOnClickListener {
            val context = it.context
//            TODO: open a web view
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(articles[position].url))
            context.startActivity(intent)
        }

    }

    class DataBoundViewHolder constructor(val binding: FragmentArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

}

