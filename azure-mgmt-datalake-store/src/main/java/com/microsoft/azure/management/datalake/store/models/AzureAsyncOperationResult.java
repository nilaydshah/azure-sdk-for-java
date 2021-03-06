/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The response body contains the status of the specified asynchronous
 * operation, indicating whether it has succeeded, is in progress, or has
 * failed. Note that this status is distinct from the HTTP status code
 * returned for the Get Operation Status operation itself. If the
 * asynchronous operation succeeded, the response body includes the HTTP
 * status code for the successful request. If the asynchronous operation
 * failed, the response body includes the HTTP status code for the failed
 * request and error information regarding the failure.
 */
public class AzureAsyncOperationResult {
    /**
     * the status of the AzureAsuncOperation. Possible values include:
     * 'InProgress', 'Succeeded', 'Failed'.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private OperationStatus status;

    /**
     * The error property.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Error error;

    /**
     * Get the status value.
     *
     * @return the status value
     */
    public OperationStatus status() {
        return this.status;
    }

    /**
     * Get the error value.
     *
     * @return the error value
     */
    public Error error() {
        return this.error;
    }

}
