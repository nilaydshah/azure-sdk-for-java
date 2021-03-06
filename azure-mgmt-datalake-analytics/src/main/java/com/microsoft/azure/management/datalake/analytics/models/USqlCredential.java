/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.analytics.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Data Lake Analytics catalog U-SQL credential item.
 */
public class USqlCredential extends CatalogItem {
    /**
     * the name of the database the credential is in.
     */
    private String databaseName;

    /**
     * the name of the secret associated with the credential.
     */
    private String identity;

    /**
     * the name of the credential.
     */
    @JsonProperty(value = "credentialName")
    private String name;

    /**
     * the user name associated with the credential.
     */
    private String userName;

    /**
     * Get the databaseName value.
     *
     * @return the databaseName value
     */
    public String databaseName() {
        return this.databaseName;
    }

    /**
     * Set the databaseName value.
     *
     * @param databaseName the databaseName value to set
     * @return the USqlCredential object itself.
     */
    public USqlCredential withDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    /**
     * Get the identity value.
     *
     * @return the identity value
     */
    public String identity() {
        return this.identity;
    }

    /**
     * Set the identity value.
     *
     * @param identity the identity value to set
     * @return the USqlCredential object itself.
     */
    public USqlCredential withIdentity(String identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the USqlCredential object itself.
     */
    public USqlCredential withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the userName value.
     *
     * @return the userName value
     */
    public String userName() {
        return this.userName;
    }

    /**
     * Set the userName value.
     *
     * @param userName the userName value to set
     * @return the USqlCredential object itself.
     */
    public USqlCredential withUserName(String userName) {
        this.userName = userName;
        return this;
    }

}
