package com.stefanpetcu.rotatelinkedlist.utils;

import java.util.LinkedList;

class ListUtils {
    static <T> void rotateLikedListBy(LinkedList<T> list, Integer places) {
        if (list.size() == 0) {
            return;
        }

        while (places > 0) {
            var lastElement = list.removeLast();
            list.addFirst(lastElement);

            places--;
        }
    }
}
