package com.elaine.testjetpack.network.http;


import android.util.Log;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit工具类
 *
 * @author elaine
 * @date 2020/9/1
 */
public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil;
    Retrofit retrofit;

    public static RetrofitUtil getInstance() {
        synchronized (RetrofitUtil.class) {
            if (retrofitUtil == null) {
                retrofitUtil = new RetrofitUtil();
            }
        }
        return retrofitUtil;
    }

    private RetrofitUtil() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .connectTimeout(BaseHttpInfo.DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(BaseHttpInfo.DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(BaseHttpInfo.DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
                .proxy(Proxy.NO_PROXY)
                .retryOnConnectionFailure(true);

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Log.e("httpLog=======", message));
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(httpLoggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(BaseHttpInfo.BASE_URL)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 创建service
     *
     * @param serviceClass 各model的Api文件
     * @param <T>          <T>
     * @return 返回service
     */
    public <T> T createService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
