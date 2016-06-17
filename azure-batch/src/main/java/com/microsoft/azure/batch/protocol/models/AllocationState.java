/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for AllocationState.
 */
public enum AllocationState {
    /** Enum value steady. */
    STEADY("steady"),

    /** Enum value resizing. */
    RESIZING("resizing"),

    /** Enum value stopping. */
    STOPPING("stopping");

    /** The actual serialized value for a AllocationState instance. */
    private String value;

    AllocationState(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a AllocationState instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed AllocationState object, or null if unable to parse.
     */
    @JsonCreator
    public static AllocationState fromString(String value) {
        AllocationState[] items = AllocationState.values();
        for (AllocationState item : items) {
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
