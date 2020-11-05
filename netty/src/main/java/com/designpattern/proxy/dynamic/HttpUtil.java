package com.designpattern.proxy.dynamic;

/**
 * @author dzl
 * 2020/10/26 9:59
 * @Description
 */
public class HttpUtil implements IHttp {
    @Override
    public void request(String sendData) {
        System.out.println("网络请求中");
    }

    @Override
    public void onSuccess(String receivedData) {
        System.out.println("网络请求完毕");
    }
}
