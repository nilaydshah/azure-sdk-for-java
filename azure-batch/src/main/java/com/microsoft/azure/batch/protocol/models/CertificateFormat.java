/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for CertificateFormat.
 */
public enum CertificateFormat {
    /** Enum value pfx. */
    PFX("pfx"),

    /** Enum value cer. */
    CER("cer"),

    /** Enum value unmapped. */
    UNMAPPED("unmapped");

    /** The actual serialized value for a CertificateFormat instance. */
    private String value;

    CertificateFormat(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a CertificateFormat instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed CertificateFormat object, or null if unable to parse.
     */
    @JsonCreator
    public static CertificateFormat fromString(String value) {
        CertificateFormat[] items = CertificateFormat.values();
        for (CertificateFormat item : items) {
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
