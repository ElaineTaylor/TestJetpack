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

    /**
     * 请求重试次数
     */
    int REPEAT_TIMES = 0;

    /**
     * 网络请求成功返回值
     */
    int REQUEST_SUCCESS = 200;

    /**
     * 网络请求--登录失效返回值
     */
    int REQUEST_FAILED = 8003;

    //网络请求Exception和Code
    /**
     * HTTP错误
     */
    String HTTP_EXCEPTION = "HTTP错误";
    int HTTP_EXCEPTION_CODE = -101;
    /**
     * 网络连接错误
     */
    String HTTP_CONNECT_EXCEPTION = "网络连接错误";
    int HTTP_CONNECT_EXCEPTION_CODE = -102;
    /**
     * 网络连接超时
     */
    String HTTP_TIME_OUT_EXCEPTION = "网络连接超时";
    int HTTP_TIME_OUT_EXCEPTION_CODE = -103;
    /**
     * 网络I/O错误
     */
    String HTTP_I_O_EXCEPTION = "网络I/O错误";
    int HTTP_I_O_EXCEPTION_CODE = -104;
    /**
     * 数据解析错误
     */
    String HTTP_PARSE_EXCEPTION = "数据解析错误";
    int HTTP_PARSE_EXCEPTION_CODE = -105;
    /**
     * 其他错误
     */
    int HTTP_OTHER_CODE = -106;
    //网络请求Exception和Code
}
