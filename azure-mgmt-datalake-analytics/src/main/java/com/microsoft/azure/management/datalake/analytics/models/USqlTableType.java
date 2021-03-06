/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.analytics.models;


/**
 * A Data Lake Analytics catalog U-SQL table type item.
 */
public class USqlTableType extends USqlType {
    /**
     * the type field information associated with this table type.
     */
    private TypeFieldInfo columns;

    /**
     * Get the columns value.
     *
     * @return the columns value
     */
    public TypeFieldInfo columns() {
        return this.columns;
    }

    /**
     * Set the columns value.
     *
     * @param columns the columns value to set
     * @return the USqlTableType object itself.
     */
    public USqlTableType withColumns(TypeFieldInfo columns) {
        this.columns = columns;
        return this;
    }

}
