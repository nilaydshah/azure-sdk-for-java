/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.storage.implementation;

import com.microsoft.azure.CloudException;
import com.microsoft.azure.management.resources.fluentcore.arm.models.implementation.GroupableResourceImpl;
import com.microsoft.azure.management.resources.implementation.ResourceManager;
import com.microsoft.azure.management.storage.KeyType;
import com.microsoft.azure.management.storage.StorageAccount;
import com.microsoft.azure.management.storage.implementation.api.AccessTier;
import com.microsoft.azure.management.storage.implementation.api.CustomDomain;
import com.microsoft.azure.management.storage.implementation.api.Encryption;
import com.microsoft.azure.management.storage.implementation.api.Kind;
import com.microsoft.azure.management.storage.implementation.api.ProvisioningState;
import com.microsoft.azure.management.storage.implementation.api.Sku;
import com.microsoft.azure.management.storage.implementation.api.SkuName;
import com.microsoft.azure.management.storage.implementation.api.StorageAccountCreateParametersInner;
import com.microsoft.azure.management.storage.implementation.api.StorageAccountInner;
import com.microsoft.azure.management.storage.implementation.api.StorageAccountKey;
import com.microsoft.azure.management.storage.implementation.api.StorageAccountListKeysResultInner;
import com.microsoft.azure.management.storage.implementation.api.StorageAccountUpdateParametersInner;
import com.microsoft.azure.management.storage.implementation.api.StorageAccountsInner;
import com.microsoft.rest.ServiceResponse;
import org.joda.time.DateTime;

import java.io.IOException;
import java.util.List;

/**
 * Implementation for StorageAccount and its parent interfaces.
 */
class StorageAccountImpl
        extends GroupableResourceImpl<StorageAccount, StorageAccountInner, StorageAccountImpl>
        implements
        StorageAccount,
        StorageAccount.Definitions,
        StorageAccount.Update {

    private PublicEndpoints publicEndpoints;
    private AccountStatuses accountStatuses;
    private String name;
    private List<StorageAccountKey> cachedAccountKeys;
    private StorageAccountCreateParametersInner createParameters;
    private StorageAccountUpdateParametersInner updateParameters;

    private final StorageAccountsInner client;

    StorageAccountImpl(String name,
                              StorageAccountInner innerModel,
                              final StorageAccountsInner client,
                              final ResourceManager resourceManager) {
        super(name, innerModel, resourceManager);
        this.name = name;
        this.createParameters = new StorageAccountCreateParametersInner();
        this.client = client;
    }

    @Override
    public AccountStatuses accountStatuses() {
        if (accountStatuses == null) {
            accountStatuses = new AccountStatuses(this.inner().statusOfPrimary(), this.inner().statusOfSecondary());
        }
        return accountStatuses;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Sku sku() {
        return this.inner().sku();
    }

    @Override
    public Kind kind() {
        return inner().kind();
    }

    @Override
    public DateTime creationTime() {
        return this.inner().creationTime();
    }

    @Override
    public CustomDomain customDomain() {
        return this.inner().customDomain();
    }

    @Override
    public DateTime lastGeoFailoverTime() {
        return this.inner().lastGeoFailoverTime();
    }

    @Override
    public ProvisioningState provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public PublicEndpoints endPoints() {
        if (publicEndpoints == null) {
            publicEndpoints = new PublicEndpoints(this.inner().primaryEndpoints(), this.inner().secondaryEndpoints());
        }
        return publicEndpoints;
    }

    @Override
    public Encryption encryption() {
        return inner().encryption();
    }

    @Override
    public AccessTier accessTier() {
        return inner().accessTier();
    }

    @Override
    public List<StorageAccountKey> keys() throws CloudException, IOException {
        if (cachedAccountKeys == null) {
            cachedAccountKeys = refreshKeys();
        }
        return cachedAccountKeys;
    }

    @Override
    public List<StorageAccountKey> refreshKeys() throws CloudException, IOException {
        ServiceResponse<StorageAccountListKeysResultInner> response =
                this.client.listKeys(this.resourceGroupName(), this.key);
        StorageAccountListKeysResultInner resultInner = response.getBody();
        cachedAccountKeys = resultInner.keys();
        return cachedAccountKeys;
    }

    @Override
    public List<StorageAccountKey> regenerateKey(KeyType keyType) throws CloudException, IOException {
        ServiceResponse<StorageAccountListKeysResultInner> response =
                this.client.regenerateKey(this.resourceGroupName(), this.key, keyType.toString());
        StorageAccountListKeysResultInner resultInner = response.getBody();
        cachedAccountKeys = resultInner.keys();
        return cachedAccountKeys;
    }

    @Override
    public StorageAccountImpl refresh() throws Exception {
        ServiceResponse<StorageAccountInner> response =
            this.client.getProperties(this.resourceGroupName(), this.key);
        StorageAccountInner storageAccountInner = response.getBody();
        this.setInner(storageAccountInner);
        clearWrapperProperties();
        return this;
    }

    @Override
    public StorageAccountImpl withSku(SkuName skuName) {
        if (isInCreateMode()) {
            createParameters.withSku(new Sku().withName(skuName));
        } else {
            updateParameters.withSku(new Sku().withName(skuName));
        }
        return this;
    }

    @Override
    public StorageAccountImpl withBlobStorageAccountKind() {
        createParameters.withKind(Kind.BLOB_STORAGE);
        return this;
    }

    @Override
    public StorageAccountImpl withGeneralPurposeAccountKind() {
        createParameters.withKind(Kind.STORAGE);
        return this;
    }

    @Override
    public StorageAccountImpl withEncryption(Encryption encryption) {
        if (isInCreateMode()) {
            createParameters.withEncryption(encryption);
        } else {
            updateParameters.withEncryption(encryption);
        }
        return this;
    }

    private void clearWrapperProperties() {
        accountStatuses = null;
        publicEndpoints = null;
    }

    @Override
    protected void createResource() throws Exception {
        createParameters.withLocation(this.region());
        createParameters.withTags(this.inner().getTags());
        this.client.create(this.resourceGroupName(), this.name(), createParameters);
        // create response does not seems including the endpoints so fetching it again.
        StorageAccountInner storageAccountInner = this.client
                .getProperties(this.resourceGroupName(), this.name())
                .getBody();
        this.setInner(storageAccountInner);
        clearWrapperProperties();
    }

    @Override
    public StorageAccountImpl update() {
        updateParameters = new StorageAccountUpdateParametersInner();
        return super.update();
    }

    @Override
    public StorageAccountImpl apply() throws Exception {
        this.setInner(client.update(resourceGroupName(), name(), updateParameters).getBody());
        return this;
    }

    @Override
    public StorageAccountImpl withCustomDomain(CustomDomain customDomain) {
        if (isInCreateMode()) {
            createParameters.withCustomDomain(customDomain);
        } else {
            updateParameters.withCustomDomain(customDomain);
        }
        return this;
    }

    @Override
    public StorageAccountImpl withCustomDomain(String name) {
        return withCustomDomain(new CustomDomain().withName(name));
    }

    @Override
    public StorageAccountImpl withCustomDomain(String name, boolean useSubDomain) {
        return withCustomDomain(new CustomDomain().withName(name).withUseSubDomain(useSubDomain));
    }

    @Override
    public StorageAccountImpl withoutCustomDomain() {
        return withCustomDomain(new CustomDomain().withName(""));
    }

    @Override
    public StorageAccountImpl withAccessTier(AccessTier accessTier) {
        if (isInCreateMode()) {
            createParameters.withAccessTier(accessTier);
        } else {
            if (this.inner().kind() != Kind.BLOB_STORAGE) {
                throw new UnsupportedOperationException("Access tier can not be changed for general purpose storage accounts.");
            }
            updateParameters.withAccessTier(accessTier);
        }
        return this;
    }
}
