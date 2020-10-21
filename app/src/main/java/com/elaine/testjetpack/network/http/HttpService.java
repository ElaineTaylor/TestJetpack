package com.elaine.testjetpack.network.http;

import androidx.lifecycle.LiveData;

import com.elaine.testjetpack.network.bean.ArticleBean;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HttpService {
    @GET("article/list/{index}/json")
    LiveData<NetBaseBean<ArticleBean>> getArticle(@Path("index") int page);
}
