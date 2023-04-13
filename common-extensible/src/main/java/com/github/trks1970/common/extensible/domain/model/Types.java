package com.github.trks1970.common.extensible.domain.model;

public enum Types {
  STRING("String"),
  BOOLEAN("Boolean");

  private final String value;

  Types(String value) {
    this.value = value;
  }

  String getValue() {
    return value;
  }
}
