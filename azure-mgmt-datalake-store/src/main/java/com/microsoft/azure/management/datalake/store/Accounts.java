/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store;

import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.datalake.store.models.DataLakeStoreAccount;
import com.microsoft.azure.management.datalake.store.models.FirewallRule;
import com.microsoft.azure.management.datalake.store.models.PageImpl;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in Accounts.
 */
public interface Accounts {
    /**
     * Deletes the specified firewall rule from the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account from which to delete the firewall rule.
     * @param firewallRuleName The name of the firewall rule to delete.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> deleteFirewallRule(String resourceGroupName, String accountName, String firewallRuleName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Deletes the specified firewall rule from the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account from which to delete the firewall rule.
     * @param firewallRuleName The name of the firewall rule to delete.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteFirewallRuleAsync(String resourceGroupName, String accountName, String firewallRuleName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Gets the specified Data Lake Store firewall rule.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account from which to get the firewall rule.
     * @param firewallRuleName The name of the firewall rule to retrieve.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FirewallRule object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FirewallRule> getFirewallRule(String resourceGroupName, String accountName, String firewallRuleName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Gets the specified Data Lake Store firewall rule.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account from which to get the firewall rule.
     * @param firewallRuleName The name of the firewall rule to retrieve.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getFirewallRuleAsync(String resourceGroupName, String accountName, String firewallRuleName, final ServiceCallback<FirewallRule> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the Data Lake Store firewall rules within the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account from which to get the firewall rules.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;FirewallRule&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PagedList<FirewallRule>> listFirewallRules(final String resourceGroupName, final String accountName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Lists the Data Lake Store firewall rules within the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account from which to get the firewall rules.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listFirewallRulesAsync(final String resourceGroupName, final String accountName, final ListOperationCallback<FirewallRule> serviceCallback) throws IllegalArgumentException;

    /**
     * Creates or updates the specified firewall rule.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account to which to add the firewall rule.
     * @param name The name of the firewall rule to create or update.
     * @param parameters Parameters supplied to create the create firewall rule.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FirewallRule object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FirewallRule> createOrUpdateFirewallRule(String resourceGroupName, String accountName, String name, FirewallRule parameters) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Creates or updates the specified firewall rule.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account to which to add the firewall rule.
     * @param name The name of the firewall rule to create or update.
     * @param parameters Parameters supplied to create the create firewall rule.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall createOrUpdateFirewallRuleAsync(String resourceGroupName, String accountName, String name, FirewallRule parameters, final ServiceCallback<FirewallRule> serviceCallback) throws IllegalArgumentException;

    /**
     * Creates the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param name The name of the Data Lake Store account to create.
     * @param parameters Parameters supplied to create the Data Lake Store account.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the DataLakeStoreAccount object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<DataLakeStoreAccount> create(String resourceGroupName, String name, DataLakeStoreAccount parameters) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * Creates the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param name The name of the Data Lake Store account to create.
     * @param parameters Parameters supplied to create the Data Lake Store account.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall createAsync(String resourceGroupName, String name, DataLakeStoreAccount parameters, final ServiceCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;

    /**
     * Creates the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param name The name of the Data Lake Store account to create.
     * @param parameters Parameters supplied to create the Data Lake Store account.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the DataLakeStoreAccount object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<DataLakeStoreAccount> beginCreate(String resourceGroupName, String name, DataLakeStoreAccount parameters) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Creates the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param name The name of the Data Lake Store account to create.
     * @param parameters Parameters supplied to create the Data Lake Store account.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginCreateAsync(String resourceGroupName, String name, DataLakeStoreAccount parameters, final ServiceCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;

    /**
     * Updates the specified Data Lake Store account information.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param name The name of the Data Lake Store account to update.
     * @param parameters Parameters supplied to update the Data Lake Store account.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the DataLakeStoreAccount object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<DataLakeStoreAccount> update(String resourceGroupName, String name, DataLakeStoreAccount parameters) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * Updates the specified Data Lake Store account information.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param name The name of the Data Lake Store account to update.
     * @param parameters Parameters supplied to update the Data Lake Store account.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall updateAsync(String resourceGroupName, String name, DataLakeStoreAccount parameters, final ServiceCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;

    /**
     * Updates the specified Data Lake Store account information.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param name The name of the Data Lake Store account to update.
     * @param parameters Parameters supplied to update the Data Lake Store account.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the DataLakeStoreAccount object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<DataLakeStoreAccount> beginUpdate(String resourceGroupName, String name, DataLakeStoreAccount parameters) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Updates the specified Data Lake Store account information.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param name The name of the Data Lake Store account to update.
     * @param parameters Parameters supplied to update the Data Lake Store account.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginUpdateAsync(String resourceGroupName, String name, DataLakeStoreAccount parameters, final ServiceCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;

    /**
     * Deletes the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account to delete.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> delete(String resourceGroupName, String accountName) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * Deletes the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account to delete.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteAsync(String resourceGroupName, String accountName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Deletes the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account to delete.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> beginDelete(String resourceGroupName, String accountName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Deletes the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account to delete.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginDeleteAsync(String resourceGroupName, String accountName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Gets the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account to retrieve.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the DataLakeStoreAccount object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<DataLakeStoreAccount> get(String resourceGroupName, String accountName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Gets the specified Data Lake Store account.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account.
     * @param accountName The name of the Data Lake Store account to retrieve.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getAsync(String resourceGroupName, String accountName, final ServiceCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within a specific resource group. The response includes a link to the next page of results, if any.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account(s).
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;DataLakeStoreAccount&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PagedList<DataLakeStoreAccount>> listByResourceGroup(final String resourceGroupName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within a specific resource group. The response includes a link to the next page of results, if any.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account(s).
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listByResourceGroupAsync(final String resourceGroupName, final ListOperationCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;
    /**
     * Lists the Data Lake Store accounts within a specific resource group. The response includes a link to the next page of results, if any.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account(s).
     * @param filter OData filter. Optional.
     * @param top The number of items to return. Optional.
     * @param skip The number of items to skip over before returning elements. Optional.
     * @param expand OData expansion. Expand related resources in line with the retrieved resources, e.g. Categories/$expand=Products would expand Product data in line with each Category entry. Optional.
     * @param select OData Select statement. Limits the properties on each entry to just those requested, e.g. Categories?$select=CategoryName,Description. Optional.
     * @param orderby OrderBy clause. One or more comma-separated expressions with an optional "asc" (the default) or "desc" depending on the order you'd like the values sorted, e.g. Categories?$orderby=CategoryName desc. Optional.
     * @param count A Boolean value of true or false to request a count of the matching resources included with the resources in the response, e.g. Categories?$count=true. Optional.
     * @param search A free form search. A free-text search expression to match for whether a particular entry should be included in the feed, e.g. Categories?$search=blue OR green. Optional.
     * @param format The desired return format. Return the response in particular formatxii without access to request headers for standard content-type negotiation (e.g Orders?$format=json). Optional.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;DataLakeStoreAccount&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PagedList<DataLakeStoreAccount>> listByResourceGroup(final String resourceGroupName, final String filter, final Integer top, final Integer skip, final String expand, final String select, final String orderby, final Boolean count, final String search, final String format) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within a specific resource group. The response includes a link to the next page of results, if any.
     *
     * @param resourceGroupName The name of the Azure resource group that contains the Data Lake Store account(s).
     * @param filter OData filter. Optional.
     * @param top The number of items to return. Optional.
     * @param skip The number of items to skip over before returning elements. Optional.
     * @param expand OData expansion. Expand related resources in line with the retrieved resources, e.g. Categories/$expand=Products would expand Product data in line with each Category entry. Optional.
     * @param select OData Select statement. Limits the properties on each entry to just those requested, e.g. Categories?$select=CategoryName,Description. Optional.
     * @param orderby OrderBy clause. One or more comma-separated expressions with an optional "asc" (the default) or "desc" depending on the order you'd like the values sorted, e.g. Categories?$orderby=CategoryName desc. Optional.
     * @param count A Boolean value of true or false to request a count of the matching resources included with the resources in the response, e.g. Categories?$count=true. Optional.
     * @param search A free form search. A free-text search expression to match for whether a particular entry should be included in the feed, e.g. Categories?$search=blue OR green. Optional.
     * @param format The desired return format. Return the response in particular formatxii without access to request headers for standard content-type negotiation (e.g Orders?$format=json). Optional.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listByResourceGroupAsync(final String resourceGroupName, final String filter, final Integer top, final Integer skip, final String expand, final String select, final String orderby, final Boolean count, final String search, final String format, final ListOperationCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within the subscription. The response includes a link to the next page of results, if any.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;DataLakeStoreAccount&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PagedList<DataLakeStoreAccount>> list() throws CloudException, IOException, IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within the subscription. The response includes a link to the next page of results, if any.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listAsync(final ListOperationCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;
    /**
     * Lists the Data Lake Store accounts within the subscription. The response includes a link to the next page of results, if any.
     *
     * @param filter OData filter. Optional.
     * @param top The number of items to return. Optional.
     * @param skip The number of items to skip over before returning elements. Optional.
     * @param expand OData expansion. Expand related resources in line with the retrieved resources, e.g. Categories/$expand=Products would expand Product data in line with each Category entry. Optional.
     * @param select OData Select statement. Limits the properties on each entry to just those requested, e.g. Categories?$select=CategoryName,Description. Optional.
     * @param orderby OrderBy clause. One or more comma-separated expressions with an optional "asc" (the default) or "desc" depending on the order you'd like the values sorted, e.g. Categories?$orderby=CategoryName desc. Optional.
     * @param count The Boolean value of true or false to request a count of the matching resources included with the resources in the response, e.g. Categories?$count=true. Optional.
     * @param search A free form search. A free-text search expression to match for whether a particular entry should be included in the feed, e.g. Categories?$search=blue OR green. Optional.
     * @param format The desired return format. Return the response in particular formatxii without access to request headers for standard content-type negotiation (e.g Orders?$format=json). Optional.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;DataLakeStoreAccount&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PagedList<DataLakeStoreAccount>> list(final String filter, final Integer top, final Integer skip, final String expand, final String select, final String orderby, final Boolean count, final String search, final String format) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within the subscription. The response includes a link to the next page of results, if any.
     *
     * @param filter OData filter. Optional.
     * @param top The number of items to return. Optional.
     * @param skip The number of items to skip over before returning elements. Optional.
     * @param expand OData expansion. Expand related resources in line with the retrieved resources, e.g. Categories/$expand=Products would expand Product data in line with each Category entry. Optional.
     * @param select OData Select statement. Limits the properties on each entry to just those requested, e.g. Categories?$select=CategoryName,Description. Optional.
     * @param orderby OrderBy clause. One or more comma-separated expressions with an optional "asc" (the default) or "desc" depending on the order you'd like the values sorted, e.g. Categories?$orderby=CategoryName desc. Optional.
     * @param count The Boolean value of true or false to request a count of the matching resources included with the resources in the response, e.g. Categories?$count=true. Optional.
     * @param search A free form search. A free-text search expression to match for whether a particular entry should be included in the feed, e.g. Categories?$search=blue OR green. Optional.
     * @param format The desired return format. Return the response in particular formatxii without access to request headers for standard content-type negotiation (e.g Orders?$format=json). Optional.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listAsync(final String filter, final Integer top, final Integer skip, final String expand, final String select, final String orderby, final Boolean count, final String search, final String format, final ListOperationCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the Data Lake Store firewall rules within the specified Data Lake Store account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;FirewallRule&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PageImpl<FirewallRule>> listFirewallRulesNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Lists the Data Lake Store firewall rules within the specified Data Lake Store account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listFirewallRulesNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<FirewallRule> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within a specific resource group. The response includes a link to the next page of results, if any.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;DataLakeStoreAccount&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PageImpl<DataLakeStoreAccount>> listByResourceGroupNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within a specific resource group. The response includes a link to the next page of results, if any.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listByResourceGroupNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within the subscription. The response includes a link to the next page of results, if any.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;DataLakeStoreAccount&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PageImpl<DataLakeStoreAccount>> listNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Lists the Data Lake Store accounts within the subscription. The response includes a link to the next page of results, if any.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<DataLakeStoreAccount> serviceCallback) throws IllegalArgumentException;

}
