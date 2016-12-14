package com.bbva.lab.models;

/**
 * Created by jorge on 14/12/2016.
 */
public class HashModel {

    private String hash;

    public HashModel() {
    }

    @Override
    public String toString() {
        return "HashModel{" +
                "hash='" + hash + '\'' +
                '}';
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
