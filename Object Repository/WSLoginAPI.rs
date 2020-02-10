<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>WSLoginAPI</name>
   <tag></tag>
   <elementGuidId>8cb921ce-ce65-4573-aa44-7c49af26c5c6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;contentType&quot;: &quot;application/x-www-form-urlencoded&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;,
  &quot;parameters&quot;: [
    {
      &quot;name&quot;: &quot;uEmail&quot;,
      &quot;value&quot;: &quot;qa.roopa@yopmail.com&quot;
    },
    {
      &quot;name&quot;: &quot;uPassword&quot;,
      &quot;value&quot;: &quot;Password1&quot;
    },
    {
      &quot;name&quot;: &quot;appCode&quot;,
      &quot;value&quot;: &quot;MY&quot;
    },
    {
      &quot;name&quot;: &quot;version&quot;,
      &quot;value&quot;: &quot;1&quot;
    }
  ]
}</httpBodyContent>
   <httpBodyType>x-www-form-urlencoded</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/x-www-form-urlencoded</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://test-services.interact.technology/rest/user/login</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.token</defaultValue>
      <description></description>
      <id>334dde66-a45a-46d1-94db-af0c277967b8</id>
      <masked>false</masked>
      <name>token</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()



WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)

GlobalVariable.token = response.getHeaderFields().get('x-nextinteract-authtoken').toString()




</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
