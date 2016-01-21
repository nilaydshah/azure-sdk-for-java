/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 0.14.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.compute.models;

import java.util.List;

/**
 * Instance view statuses summary for virtual machines of a virtual machine
 * scale set.
 */
public class VirtualMachineScaleSetInstanceViewStatusesSummary {
    /**
     * Gets the extensions information.
     */
    private List<VirtualMachineStatusCodeCount> statusesSummary;

    /**
     * Get the statusesSummary value.
     *
     * @return the statusesSummary value
     */
    public List<VirtualMachineStatusCodeCount> getStatusesSummary() {
        return this.statusesSummary;
    }

}