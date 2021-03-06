/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for BackupRestoreOperationType.
 */
public enum BackupRestoreOperationType {
    /** Enum value Default. */
    DEFAULT("Default"),

    /** Enum value Clone. */
    CLONE("Clone"),

    /** Enum value Relocation. */
    RELOCATION("Relocation");

    /** The actual serialized value for a BackupRestoreOperationType instance. */
    private String value;

    BackupRestoreOperationType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a BackupRestoreOperationType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed BackupRestoreOperationType object, or null if unable to parse.
     */
    @JsonCreator
    public static BackupRestoreOperationType fromString(String value) {
        BackupRestoreOperationType[] items = BackupRestoreOperationType.values();
        for (BackupRestoreOperationType item : items) {
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
