package com.restoraunt;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MenuList extends AbstractList<Menu> implements IMyList<Menu>, Iterable<Menu> {
    int size = 7;
    int length = 0;
    private Menu[] list = new Menu[size];


    @Override
    public Menu get(Menu item) {
        for (Menu temp : list) {

            if (temp.equals(item)) {
                return temp;
            }

        }
        throw new NoSuchElementException("Error: not found");
    }

    @Override
    public void addElement(Menu item) {
        if (length < size) {
            list[length] = item;
            length++;
            return;
        }
        Menu[] newList = new Menu[size * 2];
        for (int i = 0; i < newList.length; i++) {
            newList[i] = list[i];
        }
        size *= 2;
    }

    @Override
    public Iterator<Menu> iterator() {
        return new MenuListIterator();
    }

    private class MenuListIterator implements Iterator<Menu> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < length;
        }

        @Override
        public Menu next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Menu menu = list[current];
            current++;
            return menu;

        }
    }

    @Override
    public boolean add(Menu menu) {
        addElement(menu);
        return true;
    }

    @Override
    public Menu get(int index) {
        return list[index];
    }

    @Override
    public int size() {
        return size;
    }
}
