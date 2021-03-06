/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ManagedHostingEnvironmentStatus.
 */
public enum ManagedHostingEnvironmentStatus {
    /** Enum value Preparing. */
    PREPARING("Preparing"),

    /** Enum value Ready. */
    READY("Ready"),

    /** Enum value Deleting. */
    DELETING("Deleting");

    /** The actual serialized value for a ManagedHostingEnvironmentStatus instance. */
    private String value;

    ManagedHostingEnvironmentStatus(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a ManagedHostingEnvironmentStatus instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed ManagedHostingEnvironmentStatus object, or null if unable to parse.
     */
    @JsonCreator
    public static ManagedHostingEnvironmentStatus fromString(String value) {
        ManagedHostingEnvironmentStatus[] items = ManagedHostingEnvironmentStatus.values();
        for (ManagedHostingEnvironmentStatus item : items) {
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
