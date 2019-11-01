package com.example.recyclerviewhomework.model

import android.util.Log

class ListExample() {

    val myList = listOf(1, 2, 3, 4, 5, 6, 7, 8)

    var myMutableList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8)

    fun getList(): List<Int> {
        Log.d(TAG, "getList(): $myList \n${myList.size}")
        return myList
    }

    fun getMutableList(): MutableList<Int> {
        Log.d(TAG, "getMutableList(): $myMutableList \n${myMutableList.size}")
        return myMutableList
    }

    fun addItem(element: Int): Boolean {
        val check = myMutableList.add(element)
        Log.d(TAG, "addItem($element): $myMutableList")
        return check
    }

    fun addItemInPos(index: Int, element: Int) {
        myMutableList.add(index, element)
        Log.d(TAG, "addItemInPos($index, $element): $myMutableList")
    }

    fun addAllItemsInPos(index: Int, elements: Collection<Int>): Boolean {
        val check = myMutableList.addAll(index, elements)
        Log.d(TAG, "addAllItemsInPos($index, $elements): $myMutableList")
        return check
    }

    fun addAllItems(elements: Collection<Int>): Boolean {
        val check = myMutableList.addAll(elements)
        Log.d(TAG, "addAllItems($elements): $myMutableList")
        return check
    }

    fun clearList() {
        myMutableList.clear()
        Log.d(TAG, "clear(): $myMutableList")
    }

    fun removeItem(element: Int): Boolean {
        val check = myMutableList.remove(element)
        Log.d(TAG, "removeItem($element): $myMutableList")
        return check
    }

    fun removeAllItems(elements: Collection<Int>): Boolean {
        val check = myMutableList.removeAll(elements)
        Log.d(TAG, "removeAllItems($elements): $myMutableList")
        return check
    }

    fun removeItemAt(index: Int): Int {
        val item = myMutableList.removeAt(index)
        Log.d(TAG, "removeItemAt($index): $item")
        return item
    }

    fun retainAllItems(elements: Collection<Int>): Boolean {
        val check = myMutableList.retainAll(elements)
        Log.d(TAG, "retainAllItems($elements): $myMutableList")
        return check
    }

    fun set(index: Int, element: Int): Int {
        val previousItem = myMutableList.set(index, element)
        Log.d(TAG, "set($index, $element): $previousItem -> $myMutableList")
        return previousItem
    }

    val sizeMyList: Int
        get() {
            val size = myList.size
            Log.d(TAG, "sizeMyList: $size")
            return size
        }

    fun containsInMyList(element: Int): Boolean {
        val check = myList.contains(element)
        Log.d(TAG, "containsInMyList($element): $myList = $check")
        return check
    }

    fun containsAllInMyList(elements: Collection<Int>): Boolean {
        val check = myList.containsAll(elements)
        Log.d(TAG, "containsAllInMyList($elements): $myList = $check")
        return check
    }

    fun getItem(index: Int): Int {
        val item = myList.get(index)
        Log.d(TAG, "getItem($index): $item")
        return item
    }

    fun indexOfItem(element: Int): Int {
        val index = myList.indexOf(element)
        Log.d(TAG, "indexOfItem($element): $index")
        return index
    }

    fun isEmptyMyMutableList(): Boolean {
        val check = myMutableList.isEmpty()
        Log.d(TAG, "isEmptyMyList(): $myMutableList = $check")
        return check
    }

    fun iteratorMyList(): Iterator<Int> {
        val iter = myList.iterator()
        Log.d(TAG, "iterator(): $myList = $iter")
        return iter
    }

    fun lastIndexOfItem(element: Int): Int {
        val index = myList.lastIndexOf(element)
        Log.d(TAG, "lastIndexOfItem($element): $index")
        return index
    }

    fun listIteratorMyList(): ListIterator<Int> {
        val listIterator = myList.listIterator()
        Log.d(TAG, "listIteratorMyList(): $listIterator")
        return listIterator
    }

    fun listIteratorMyList(index: Int): ListIterator<Int> {
        val listIterator = myList.listIterator(index)
        Log.d(TAG, "listIteratorMyList($index): $listIterator")
        return listIterator
    }

    fun subListMyList(fromIndex: Int, toIndex: Int): List<Int> {
        val subList = myList.subList(fromIndex, toIndex)
        Log.d(TAG, "subListMyList($fromIndex, $toIndex): $subList")
        return subList
    }

    companion object {
        const val TAG = "ListExample"
    }
}