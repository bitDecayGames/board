package com.bitdecay.board;

import com.bitdecay.board.utils.CollectionUtils;
import com.bitdecay.board.utils.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Actions<T extends GameBoardState> implements Serializable<Actions>, Collection<T> {
    private final List<T> queue = new ArrayList<>();

    public void append(T element){
        this.queue.add(element);
    }

    public T peek(){
        if (this.queue.size() > 0) return this.queue.get(0);
        else return null;
    }

    public T remove(){
        if (this.queue.size() > 0) return this.queue.remove(0);
        else return null;
    }

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public Actions deserialize(String data) {
        return null;
    }

    @Override
    public String toString(){
        return CollectionUtils.mkString(this.queue, "[\n    ", ", \n    ", "\n]");
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.queue.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.queue.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.queue.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return this.queue.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return this.queue.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.queue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return this.queue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.queue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.queue.retainAll(c);
    }

    @Override
    public void clear() {
        this.queue.clear();
    }
}
