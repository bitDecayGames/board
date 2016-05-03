package com.bitdecay.board.utils;

public interface Serializable<T> {
    String serialize();
    T deserialize(String data);
}
