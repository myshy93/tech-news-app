package com.example.technews

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technews.databinding.FragmentArticleBinding


class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    private var articles: List<ArticleViewModel> = listOf()

    fun setArticles(newArticles: List<ArticleViewModel>) {
        this.articles = newArticles
    }

    companion object ExtraKeys {
        const val articleIdKey: String = "ARTICLE_ID"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentArticleBinding.inflate(layoutInflater)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    class ArticleViewHolder(val binding: FragmentArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticleViewModel) {
            binding.articleViewModel = article
            binding.root.setOnClickListener {
                val intent = Intent(it.context, WebActivity::class.java)
                intent.putExtra("ARTICLE_URL", article.url)
                it.context.startActivity(intent)
            }
        }
    }
}

