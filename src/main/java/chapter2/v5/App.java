package chapter2.v5;

import chapter2.Apple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import static chapter2.v4.App.filter;

/**
 * 行为参数化是一个很有用的模式，它能够轻松地适应不断变化的需求。
 * 这种模式可以把一个行为（一段代码）封装起来，并通过传递和使用创建的行为将方法的行为参数化。这种做法类似于策略设计模式。
 * Java API 中的很多方法都可以用不同的行为来参数化。这些方法往往与匿名类一起使用。
 * <p>
 * <p>
 * Created by liuchenwei on 2019-04-15.
 */
public class App {

    /**
     * JDK 已有的方法，用一个 Comparator 排序，用 Runnable 执行一个代码块，以及 GUI 事件处理。
     */
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        Thread t = new Thread(() -> System.out.println("Hello world"));
    }
}
