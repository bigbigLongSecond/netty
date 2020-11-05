package com.designpattern.proxy.dynamic;

/**
 * @author dzl
 * 2020/10/26 9:58
 * @Description
 */
public interface IHttp {
    void request(String sendData);

    void onSuccess(String receivedData);
}
