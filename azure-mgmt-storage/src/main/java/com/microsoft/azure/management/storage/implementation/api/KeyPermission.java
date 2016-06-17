/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.storage.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for KeyPermission.
 */
public enum KeyPermission {
    /** Enum value READ. */
    READ("READ"),

    /** Enum value FULL. */
    FULL("FULL");

    /** The actual serialized value for a KeyPermission instance. */
    private String value;

    KeyPermission(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a KeyPermission instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed KeyPermission object, or null if unable to parse.
     */
    @JsonCreator
    public static KeyPermission fromString(String value) {
        KeyPermission[] items = KeyPermission.values();
        for (KeyPermission item : items) {
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
