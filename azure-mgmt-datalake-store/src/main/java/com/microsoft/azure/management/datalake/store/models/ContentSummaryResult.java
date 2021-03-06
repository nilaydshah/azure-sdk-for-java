/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Lake Store filesystem content summary information response.
 */
public class ContentSummaryResult {
    /**
     * the content summary for the specified path.
     */
    @JsonProperty(value = "ContentSummary", access = JsonProperty.Access.WRITE_ONLY)
    private ContentSummary contentSummary;

    /**
     * Get the contentSummary value.
     *
     * @return the contentSummary value
     */
    public ContentSummary contentSummary() {
        return this.contentSummary;
    }

}
