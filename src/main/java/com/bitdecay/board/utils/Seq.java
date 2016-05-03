package com.bitdecay.board.utils;

import java.util.ArrayList;
import java.util.Iterator;

public class Seq<T> extends ArrayList<T> {

    public String mkString(String middle){
        return mkString("", middle, "");
    }

    public String mkString(String begining, String middle, String end){
        return mkString(begining, middle, end, T::toString);
    }

    public String mkString(String middle, MkString<T> mkString){
        return mkString("", middle, "", mkString);
    }

    public String mkString(String begining, String middle, String end, MkString<T> mkString){
        StringBuilder sb = new StringBuilder(begining);
        Iterator<T> iterator = iterator();
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
