package com.tcs.kobiton.dafiti.utils;

public class Format {

  public static int value(String value) {
    return Integer.parseInt(value.replace("$ ", "").replace(".", ""));
  }
}
