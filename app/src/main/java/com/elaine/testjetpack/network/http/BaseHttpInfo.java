package com.elaine.testjetpack.network.http;

/**
 * 网络基础信息配置
 *
 * @author elaine
 */
public interface BaseHttpInfo {
    /**
     * 网络请求地址
     */
    String BASE_URL = "https://www.wanandroid.com/";

    /**
     * 请求超时配置
     */
    int DEFAULT_CONNECT_TIMEOUT = 60;
    int DEFAULT_WRITE_TIMEOUT = 60;
    int DEFAULT_READ_TIMEOUT = 60;

}
