/**
 * Copyright 2016 2015-2016 ZTE, Inc. and others. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openo.msb.wrapper.util;

import org.junit.Assert;
import org.junit.Test;
import org.openo.msb.api.RouteServer;


public class JacksonJsonUtilTest {
    @Test
    public void testBeanToJson(){
        try{
            RouteServer server=new RouteServer("127.0.0.1","80");
            String json=JacksonJsonUtil.beanToJson(server);
            Assert.assertEquals("{\"ip\":\"127.0.0.1\",\"port\":\"80\",\"weight\":0}",json);
        }
        catch(Exception e){
            Assert.fail("Exception" + e.getMessage());
        }
    }
    
    @Test
    public void testJsonToBean(){
        try{
            String json="{\"ip\":\"127.0.0.1\",\"port\":\"80\",\"weight\":0}";
            RouteServer server=(RouteServer) JacksonJsonUtil.jsonToBean(json, RouteServer.class);
            Assert.assertEquals("127.0.0.1",server.getIp());
            Assert.assertEquals("80",server.getPort());
        }
        catch(Exception e){
            Assert.fail("Exception" + e.getMessage());
        }
    }
}