package com.example;

public interface NamesOnly {
    String getName();
    AddressSummary getAddress();
    interface AddressSummary {
        String getCity();
    }
    default String getFullName() {
        return getName().concat(" ").concat(getAddress().getCity());
    }
}
