package com.eir.report.web.service;
/*
import com.experian.ewacs.contract.query.v1.GetUserAndProductsInfo;
import com.experian.ewacs.contract.query.v1.GetUserAndProductsInfoResponse;
import com.experian.ewacs.contract.query.v1.QueryServiceImplService;
import com.experian.ewacs.contract.query.v1.QueryServicePortType;
import com.experian.ewacs.contract.query.v1.QueryUserProductInfoFault;
import com.experian.ewacs.schema.query.v1.*;*/
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to get bureau member details from EWACS system.
 */
public class EwacsHelper {/*
    private final String ewacsServicePath;
    private final String ewacsProductName;

    private final URL wsdlURL;
    private final QueryServiceImplService query;
    private final QueryServicePortType port;

    private static final String SUBCODE = "Subcode";
    private static final Log LOGGER = LogFactory.getLog(EwacsHelper.class);

    *//**
     * Construct with service path and product name
     * @param ewacsServicePath
     * @param ewacsProductName
     * @throws MalformedURLException
     *//*
    public EwacsHelper(String ewacsServicePath, String ewacsProductName) throws MalformedURLException {
        this.ewacsServicePath = ewacsServicePath;
        LOGGER.info("this.ewacsServicePath : " + this.ewacsServicePath);
        this.ewacsProductName = ewacsProductName;
        wsdlURL = new URL(ewacsServicePath);
        query = new QueryServiceImplService(wsdlURL);
        port = query.getQueryServicePortTypePort();
    }

    *//**
     * Returns list of bureau member ids assigned to given userid
     * @param userId
     * @return EwacsData
     * @throws QueryUserProductInfoFault
     *//*
    public EwacsData getDetailsForUser(final String userId) throws QueryUserProductInfoFault {
        GetUserAndProductsInfoResponse response = getEwacsResponse(userId);
        LOGGER.debug("Got ewacs response for user Id : ");
        List<Long> bmIds = extractBmIds(response);
        String fullName = getFullNameFromResponse(response);
        return new EwacsData(fullName,bmIds);

    }

    *//**
     * EWACS webservice call returns response object. this method helps to look at the
     * object graph and return list of 'Long' BM id.
     * @param response
     * @return
     *//*
    private List<Long> extractBmIds(final GetUserAndProductsInfoResponse response) {
        List<Long> bureauMemberIdList = new ArrayList<Long>();
        ProductInfoResponseType products = response.getQueryUserProductInfoResponse().getProductInfoResponse();
        if (products == null) {
            LOGGER.warn("No product info from EWACS.Returning empty BM ID list");
            return bureauMemberIdList;
        }
        for (ProductType productType : products.getProduct()) {
            if (productType != null && productType.getProductOptions() != null) {
                for (ProductOptionInfoType infoType : productType.getProductOptions().getProductOption()) {
                    if (SUBCODE.equalsIgnoreCase(infoType.getName())) {
                        LOGGER.debug("BM id : " + infoType.getValue());
                        bureauMemberIdList.add(Long.valueOf(infoType.getValue()));
                    }
                }
            }
        }

        return bureauMemberIdList;
    }

    private String getFullNameFromResponse( GetUserAndProductsInfoResponse response )
    {
        String ret = "";
        UserInfoResponseType userInfo = response.getQueryUserProductInfoResponse().getUserInfoResponse();
        if ( null != userInfo &&
                null != userInfo.getName() )
        {
            ret = userInfo.getName().getFirst() + " " + userInfo.getName().getLast();
        }
        return ret;
    }

    private GetUserAndProductsInfoResponse getEwacsResponse(String userId) throws QueryUserProductInfoFault {
        GetUserAndProductsInfo getUserAndProductsInfo = new GetUserAndProductsInfo();
        QueryUserProductInfoRequestType queryUserProductInfoRequestType = new QueryUserProductInfoRequestType();
        UserInfoRequestType userInfoRequestType = new UserInfoRequestType();
        userInfoRequestType.setUserID(userId);
        queryUserProductInfoRequestType.setUserInfoRequest(userInfoRequestType);
        ProductInfoRequestType productInfoRequestType = new ProductInfoRequestType();
        productInfoRequestType.getProductName().add(ewacsProductName);
        queryUserProductInfoRequestType.setProductInfoRequest(productInfoRequestType);
        getUserAndProductsInfo.setQueryUserProductInfoRequest(queryUserProductInfoRequestType);
        long startTime = System.currentTimeMillis();
        GetUserAndProductsInfoResponse response = port.getUserAndProductsInfo(getUserAndProductsInfo);
        long tId = Thread.currentThread().getId();
        long endTime = System.currentTimeMillis();
        LOGGER.debug("Time Taken for EWACS call [T:" + tId + "] :" + ( endTime - startTime ));
        return response;
    }
*/}
