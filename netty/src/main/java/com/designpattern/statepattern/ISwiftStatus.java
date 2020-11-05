package com.designpattern.statepattern;

/**
 * @author dzl
 * 2020/10/26 15:36
 * @Description 用户可以切换状态  ---> 买会员   会员到期，成为一名普通会员
 */
public interface ISwiftStatus {
    void buy();
    void expire();
}
