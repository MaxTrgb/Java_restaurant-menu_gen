package com.restoraunt;

import java.util.ArrayList;

public interface IMyList<T> {

    T get(T item);
    void addElement(T item);

}
