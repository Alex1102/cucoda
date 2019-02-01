package com.mycompany.cucoda.model;


import java.util.Optional;

public enum Market {

    MY_COMPANY("mycompany"),
    ANY_COMPANY("anycompany");

    String id;
    Market(final String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public static boolean hasMarket(final String id) {

        for (Market m : Market.values()) {
            if (m.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public Optional<Market> getMarketByMarketId(final String id) {

        for (Market m : Market.values()) {
            if (m.getId().equals(id)) {
                return Optional.ofNullable(m);
            }
        }

        return Optional.empty();
    }
}
