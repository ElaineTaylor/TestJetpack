package com.elaine.testjetpack.network.http;

import com.elaine.testjetpack.network.bean.ArticleBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HttpService {
    @GET("article/list/{index}/json")
    Call<List<ArticleBean>> getArticleList(@Path("index") int page);
}
