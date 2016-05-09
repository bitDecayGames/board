package com.bitdecay.board.utils;

/**
 * Should be able to serialize all of the data in this class to a string that can be deserialized back into the original data
 * @param <T> This is just to provide the correct return type for deserialize
 */
public interface Serializable<T> {
    String serialize();
    T deserialize(String data);
}
