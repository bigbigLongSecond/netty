package com.designpattern.decoration;

import com.designpattern.decoration.enhance.IBeauty;
import com.designpattern.decoration.enhance.Me;
import com.designpattern.decoration.enhance.RingeDecoration;
import com.designpattern.decoration.increase.House;
import com.designpattern.decoration.increase.IHouse;
import com.designpattern.decoration.increase.IStickyHookHouse;
import com.designpattern.decoration.increase.StickyHookHouseDecoration;

import java.io.*;

/**
 * @author dzl
 * 2020/10/22 11:23
 * @Description  装饰模式
 * 用途： 增强一个类原有的功能
 *       为一个类添加一个新的功能
 *
 */
public class Client {
    public static void main(String[] args) {
//        IBeauty me   = new Me();
//        System.out.println("本来的----->" + me.getBeautyValue());
//        IBeauty ringeDecoration = new RingeDecoration(me);
//        System.out.println("增强后" + ringeDecoration.getBeautyValue());
//        IHouse iHouse = new House();
//        IStickyHookHouse iStickyHookHouse = new StickyHookHouseDecoration(iHouse);
//        iStickyHookHouse.hangThing();
//        iStickyHookHouse.live();
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream("file1.txt"))){
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1);
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
