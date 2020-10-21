package com.elaine.testjetpack.network.http;

import androidx.lifecycle.LiveData;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<T> implements CallAdapter<T, LiveData<T>> {
    private Type mResponseType;

    public LiveDataCallAdapter(Type mResponseType) {
        this.mResponseType = mResponseType;
    }

    @Override
    public Type responseType() {
        return mResponseType;
    }

    @Override
    public LiveData<T> adapt(Call<T> call) {
        return new MyLiveData<>(call);
    }

    private static class MyLiveData<T> extends LiveData<T> {
        private AtomicBoolean started = new AtomicBoolean(false);
        private final Call<T> call;

        public MyLiveData(Call<T> call) {
            this.call = call;
        }

        @Override
        protected void onActive() {
            super.onActive();
            if (started.compareAndSet(false, true)) {
                call.enqueue(new Callback<T>() {
                    @Override
                    public void onResponse(Call<T> call, Response<T> response) {
                        T body = response.body();
                        postValue(body);
                    }

                    @Override
                    public void onFailure(Call<T> call, Throwable t) {
                        postValue((T) new NetBaseBean<>(NetBaseBean.CODE_ERROR, t.getMessage()));
                    }
                });
            }
        }
    }
}
