package com.ddzx.base_module.util;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
/**
 * This example uses an OkHttp interceptor to change the target hostname dynamically at runtime.
 * Typically this would be used to implement client-side load balancing or to use the webserver
 * that's nearest geographically.
 */
public final class DynamicBaseUrl {

  static final class HostSelectionInterceptor implements Interceptor {
    private volatile String host;

    public void setHost(String host) {
      this.host = host;
    }

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
      Request request = chain.request();
      String host = this.host;
      if (host != null) {
        HttpUrl newUrl = request.url().newBuilder().host(host).build();
        request = request.newBuilder().url(newUrl).build();
      }
      return chain.proceed(request);
    }
  }
}