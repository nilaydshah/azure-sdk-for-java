/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for JobReleaseTaskState.
 */
public enum JobReleaseTaskState {
    /** Enum value running. */
    RUNNING("running"),

    /** Enum value completed. */
    COMPLETED("completed");

    /** The actual serialized value for a JobReleaseTaskState instance. */
    private String value;

    JobReleaseTaskState(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a JobReleaseTaskState instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed JobReleaseTaskState object, or null if unable to parse.
     */
    @JsonCreator
    public static JobReleaseTaskState fromString(String value) {
        JobReleaseTaskState[] items = JobReleaseTaskState.values();
        for (JobReleaseTaskState item : items) {
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
