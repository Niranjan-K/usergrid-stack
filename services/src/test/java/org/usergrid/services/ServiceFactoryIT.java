/*******************************************************************************
 * Copyright 2012 Apigee Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.usergrid.services;

import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usergrid.cassandra.Concurrent;

import baas.io.simple.SimpleService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@Concurrent()
public class ServiceFactoryIT extends AbstractServiceIT {

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceFactoryIT.class);

	@Ignore
	@Test
	public void testServiceFactory() throws Exception {
		logger.info("test service factory");
	}
	
	@Test
	public void testPackagePrefixes() throws Exception {
		logger.info("test package prefixes");

		UUID applicationId = setup.getEmf().createApplication("org", "app");
		ServiceManager sm = setup.getSmf().getServiceManager(applicationId);
		Service service = sm.getService("simple");
		assertEquals("/simple", service.getServiceType());
		assertNotNull(service);
		assertEquals(SimpleService.class, service.getClass());
	}
}
