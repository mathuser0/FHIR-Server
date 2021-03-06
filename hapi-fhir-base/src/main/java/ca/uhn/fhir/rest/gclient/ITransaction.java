package ca.uhn.fhir.rest.gclient;

/*
 * #%L
 * HAPI FHIR - Core Library
 * %%
 * Copyright (C) 2014 - 2015 University Health Network
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.List;

import org.hl7.fhir.instance.model.api.IBaseBundle;

import ca.uhn.fhir.model.api.Bundle;
import ca.uhn.fhir.model.api.IResource;

public interface ITransaction {

	/**
	 * Use a list of resources as the transaction input
	 */
	ITransactionTyped<List<IResource>> withResources(List<IResource> theResources);
	
	/**
	 * Use a DSTU1 Bundle (Atom) as the transaction input
	 */
	ITransactionTyped<Bundle> withBundle(Bundle theBundle);

	/**
	 * Use a DSTU2+ Bundle resource as the transaction input
	 */
	<T extends IBaseBundle> ITransactionTyped<T> withBundle(T theBundleResource);

	/**
	 * Use the given raw text (should be a Bundle resource) as the transaction input
	 */
	ITransactionTyped<String> withBundle(String theBundle);

}
