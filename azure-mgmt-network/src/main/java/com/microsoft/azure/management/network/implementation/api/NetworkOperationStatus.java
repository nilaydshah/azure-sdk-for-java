/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.network.implementation.api;

/**
 * Defines values for NetworkOperationStatus.
 */
public final class NetworkOperationStatus {
    /** Static value InProgress for NetworkOperationStatus. */
    public static final String IN_PROGRESS = "InProgress";

    /** Static value Succeeded for NetworkOperationStatus. */
    public static final String SUCCEEDED = "Succeeded";

    /** Static value Failed for NetworkOperationStatus. */
    public static final String FAILED = "Failed";

    private NetworkOperationStatus() {
    }
}
