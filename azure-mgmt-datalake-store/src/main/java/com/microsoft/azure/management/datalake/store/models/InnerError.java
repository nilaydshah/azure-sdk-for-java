/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Lake Store inner error information.
 */
public class InnerError {
    /**
     * the stack trace for the error.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String trace;

    /**
     * the context for the error message.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String context;

    /**
     * Get the trace value.
     *
     * @return the trace value
     */
    public String trace() {
        return this.trace;
    }

    /**
     * Get the context value.
     *
     * @return the context value
     */
    public String context() {
        return this.context;
    }

}
