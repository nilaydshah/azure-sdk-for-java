/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.implementation.api;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.Validator;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.Response;

/**
 * An instance of this class provides access to all the operations defined
 * in Providers.
 */
public final class ProvidersInner {
    /** The Retrofit service to perform REST calls. */
    private ProvidersService service;
    /** The service client containing this operation class. */
    private WebSiteManagementClientImpl client;

    /**
     * Initializes an instance of ProvidersInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ProvidersInner(Retrofit retrofit, WebSiteManagementClientImpl client) {
        this.service = retrofit.create(ProvidersService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Providers to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ProvidersService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("providers/Microsoft.Web/sourcecontrols")
        Call<ResponseBody> getSourceControls(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("providers/Microsoft.Web/sourcecontrols/{sourceControlType}")
        Call<ResponseBody> getSourceControl(@Path("sourceControlType") String sourceControlType, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("providers/Microsoft.Web/sourcecontrols/{sourceControlType}")
        Call<ResponseBody> updateSourceControl(@Path("sourceControlType") String sourceControlType, @Body SourceControlInner requestMessage, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("providers/Microsoft.Web/publishingUsers/web")
        Call<ResponseBody> getPublishingUser(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("providers/Microsoft.Web/publishingUsers/web")
        Call<ResponseBody> updatePublishingUser(@Body UserInner requestMessage, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the SourceControlCollectionInner object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<SourceControlCollectionInner> getSourceControls() throws CloudException, IOException, IllegalArgumentException {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getSourceControls(this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getSourceControlsDelegate(call.execute());
    }

    /**
     * Gets the source controls available for Azure websites.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getSourceControlsAsync(final ServiceCallback<SourceControlCollectionInner> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getSourceControls(this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<SourceControlCollectionInner>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getSourceControlsDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<SourceControlCollectionInner> getSourceControlsDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<SourceControlCollectionInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<SourceControlCollectionInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets source control token.
     *
     * @param sourceControlType Type of source control
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the SourceControlInner object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<SourceControlInner> getSourceControl(String sourceControlType) throws CloudException, IOException, IllegalArgumentException {
        if (sourceControlType == null) {
            throw new IllegalArgumentException("Parameter sourceControlType is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getSourceControl(sourceControlType, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getSourceControlDelegate(call.execute());
    }

    /**
     * Gets source control token.
     *
     * @param sourceControlType Type of source control
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getSourceControlAsync(String sourceControlType, final ServiceCallback<SourceControlInner> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (sourceControlType == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter sourceControlType is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getSourceControl(sourceControlType, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<SourceControlInner>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getSourceControlDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<SourceControlInner> getSourceControlDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<SourceControlInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<SourceControlInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Updates source control token.
     *
     * @param sourceControlType Type of source control
     * @param requestMessage Source control token information
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the SourceControlInner object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<SourceControlInner> updateSourceControl(String sourceControlType, SourceControlInner requestMessage) throws CloudException, IOException, IllegalArgumentException {
        if (sourceControlType == null) {
            throw new IllegalArgumentException("Parameter sourceControlType is required and cannot be null.");
        }
        if (requestMessage == null) {
            throw new IllegalArgumentException("Parameter requestMessage is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(requestMessage);
        Call<ResponseBody> call = service.updateSourceControl(sourceControlType, requestMessage, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return updateSourceControlDelegate(call.execute());
    }

    /**
     * Updates source control token.
     *
     * @param sourceControlType Type of source control
     * @param requestMessage Source control token information
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall updateSourceControlAsync(String sourceControlType, SourceControlInner requestMessage, final ServiceCallback<SourceControlInner> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (sourceControlType == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter sourceControlType is required and cannot be null."));
            return null;
        }
        if (requestMessage == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter requestMessage is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(requestMessage, serviceCallback);
        Call<ResponseBody> call = service.updateSourceControl(sourceControlType, requestMessage, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<SourceControlInner>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(updateSourceControlDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<SourceControlInner> updateSourceControlDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<SourceControlInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<SourceControlInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets publishing user.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the UserInner object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<UserInner> getPublishingUser() throws CloudException, IOException, IllegalArgumentException {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getPublishingUser(this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return getPublishingUserDelegate(call.execute());
    }

    /**
     * Gets publishing user.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getPublishingUserAsync(final ServiceCallback<UserInner> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getPublishingUser(this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<UserInner>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getPublishingUserDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<UserInner> getPublishingUserDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<UserInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<UserInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Updates publishing user.
     *
     * @param requestMessage Details of publishing user
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the UserInner object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<UserInner> updatePublishingUser(UserInner requestMessage) throws CloudException, IOException, IllegalArgumentException {
        if (requestMessage == null) {
            throw new IllegalArgumentException("Parameter requestMessage is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(requestMessage);
        Call<ResponseBody> call = service.updatePublishingUser(requestMessage, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        return updatePublishingUserDelegate(call.execute());
    }

    /**
     * Updates publishing user.
     *
     * @param requestMessage Details of publishing user
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall updatePublishingUserAsync(UserInner requestMessage, final ServiceCallback<UserInner> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (requestMessage == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter requestMessage is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(requestMessage, serviceCallback);
        Call<ResponseBody> call = service.updatePublishingUser(requestMessage, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<UserInner>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(updatePublishingUserDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<UserInner> updatePublishingUserDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<UserInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<UserInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
