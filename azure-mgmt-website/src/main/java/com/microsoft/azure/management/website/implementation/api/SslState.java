/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for SslState.
 */
public enum SslState {
    /** Enum value Disabled. */
    DISABLED("Disabled"),

    /** Enum value SniEnabled. */
    SNI_ENABLED("SniEnabled"),

    /** Enum value IpBasedEnabled. */
    IP_BASED_ENABLED("IpBasedEnabled");

    /** The actual serialized value for a SslState instance. */
    private String value;

    SslState(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a SslState instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed SslState object, or null if unable to parse.
     */
    @JsonCreator
    public static SslState fromString(String value) {
        SslState[] items = SslState.values();
        for (SslState item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
