package com.designpattern.proxy.dynamic;

/**
 * @author dzl
 * 2020/10/26 10:09
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        HttpUtil iHttp = new HttpUtil();
        IHttp iHttp1 = new HttpProxy().getInstance(iHttp);
        iHttp1.request("hello");
        iHttp1.onSuccess("end");
    }
}
