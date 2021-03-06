/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.implementation.api;


/**
 * The DebugSetting model.
 */
public class DebugSetting {
    /**
     * Gets or sets the debug detail level.
     */
    private String detailLevel;

    /**
     * Get the detailLevel value.
     *
     * @return the detailLevel value
     */
    public String detailLevel() {
        return this.detailLevel;
    }

    /**
     * Set the detailLevel value.
     *
     * @param detailLevel the detailLevel value to set
     * @return the DebugSetting object itself.
     */
    public DebugSetting withDetailLevel(String detailLevel) {
        this.detailLevel = detailLevel;
        return this;
    }

}
