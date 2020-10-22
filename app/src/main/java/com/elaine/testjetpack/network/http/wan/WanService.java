package com.elaine.testjetpack.network.http.wan;

import androidx.lifecycle.LiveData;

import com.elaine.testjetpack.network.bean.ArticleBean;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WanService {
    @GET("article/list/{index}/json")
    LiveData<WanResponse<ArticleBean>> getArticle(@Path("index") int page);
}
