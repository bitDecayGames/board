package com.bitdecay.board.utils;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {
    private CollectionUtils(){}

    public static <T> String mkString(Collection<T> collection, String middle){
        return mkString(collection, "", middle, "");
    }

    public static <T> String mkString(Collection<T> collection, String begining, String middle, String end){
        return mkString(collection, begining, middle, end, Object::toString);
    }

    public static <T> String mkString(Collection<T> collection, String middle, MkString<T> mkString){
        return mkString(collection, "", middle, "", mkString);
    }

    public static <T> String mkString(Collection<T> collection, String begining, String middle, String end, MkString<T> mkString){
        StringBuilder sb = new StringBuilder(begining);
        Iterator<T> iterator = collection.iterator();
        while(iterator.hasNext()){
            sb.append(mkString.mkString(iterator.next()));
            if (iterator.hasNext()) sb.append(middle);
        }
        sb.append(end);
        return sb.toString();
    }

    public interface MkString<T>{
        String mkString(T element);
    }
}
