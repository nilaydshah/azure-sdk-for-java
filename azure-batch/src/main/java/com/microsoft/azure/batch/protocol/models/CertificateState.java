/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for CertificateState.
 */
public enum CertificateState {
    /** Enum value active. */
    ACTIVE("active"),

    /** Enum value deleting. */
    DELETING("deleting"),

    /** Enum value deletefailed. */
    DELETEFAILED("deletefailed");

    /** The actual serialized value for a CertificateState instance. */
    private String value;

    CertificateState(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a CertificateState instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed CertificateState object, or null if unable to parse.
     */
    @JsonCreator
    public static CertificateState fromString(String value) {
        CertificateState[] items = CertificateState.values();
        for (CertificateState item : items) {
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
