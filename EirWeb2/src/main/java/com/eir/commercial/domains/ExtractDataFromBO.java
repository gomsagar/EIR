package com.eir.commercial.domains;

public class ExtractDataFromBO {/*
	
	public List<BilOutputData> getInquiryDetailsList(ReportBO reporData) {
		List<BusinessInquiryOutputData> businessInquiryOutputDatasList = getEnquiries(reporData);
		List<BilOutputData> bilOutputDataList = new ArrayList<BilOutputData>();
		try {
			if(isNotEmpty(businessInquiryOutputDatasList)){
				for(BusinessInquiryOutputData businessInquiryOutputData : businessInquiryOutputDatasList){
					if (businessInquiryOutputData != null && !businessInquiryOutputData .get("outputFilteredInquiries") .getClass().equals(String.class)) {
					    if (isNotEmpty((List<BilOutputData>) businessInquiryOutputData.get("outputFilteredInquiries"))) {
					    	bilOutputDataList.addAll((List<BilOutputData>) businessInquiryOutputData.get("outputFilteredInquiries"));
					    }

					}

				}
			}
		}catch (Exception e) {
			return bilOutputDataList;
		}
		return bilOutputDataList;
	}
	
	
//	public HashMap<String, String> extractReportSummaryField(List<BilOutputData> bilOutputDataList,List<BCADataBO> bcaDataBOs, CreditFacCurrencySummaryDataBO creditFacCurrencySummaryDataBO, ReportSummaryDataBO reportSummaryDataBO){
//		HashMap<String, String> hashMap = new HashMap<String, String>();
//		 String hdfc;
//		 String pvt;
//		 String psu;
//		 String nbfc;
//		 String others;
//		String status = ""; 
//		for(BCADataBO bcaDataBO : bcaDataBOs){
////			getcode
//		}
//		return hashMap;
//	}
	
//	public static 
	
	
	@SuppressWarnings("unchecked")
    public List<BusinessBestIdentityDataBO> getCompanyBestIdentityProfileData(
            ReportBO reporData) {
        List<BusinessBestIdentityBO> businessBestIdentityBOList = null;
        List<BusinessBestIdentityDataBO> businessBestIdentityDataBOList = new ArrayList<BusinessBestIdentityDataBO>();
        try {
            if (!(ElFunctions.get(reporData, "BusinessIdentity") instanceof String)) {
                businessBestIdentityBOList = (List<BusinessBestIdentityBO>) ElFunctions
                        .get(reporData, "BusinessIdentity");
                if (isNotEmpty(businessBestIdentityBOList)) {
                    for (BusinessBestIdentityBO businessBestIdentityBO : businessBestIdentityBOList) {
                        if (businessBestIdentityBO != null
                                && !(ElFunctions.get(businessBestIdentityBO,
                                "businessIdentity") instanceof String)
                                && isNotEmpty((List<BusinessBestIdentityDataBO>) ElFunctions
                                .get(businessBestIdentityBO,
                                        "businessIdentity"))) {
                            businessBestIdentityDataBOList
                                    .addAll((List<BusinessBestIdentityDataBO>) ElFunctions
                                            .get(businessBestIdentityBO,
                                                    "businessIdentity"));
                        }
                    }
                }
            }
        } catch (NextGenBusinessObjectException exception) {
            return businessBestIdentityDataBOList;
        }
        return businessBestIdentityDataBOList;
    }
	
	@SuppressWarnings("unchecked")
	public List<BusinessBackgroundDataBO> getBusinessBackgroundData(ReportBO reporData) {
		List<BusinessBackgroundBO> businessBackgroundBOList = null;
        List<BusinessBackgroundDataAttrsBO> businessBackgroundDataAttrsBOList = null;
        List<BusinessBackgroundDataBO> businessBackgroundDataBO = new ArrayList<BusinessBackgroundDataBO>();
        try {
			if (!(ElFunctions.get(reporData, "BusinessBackground") instanceof String)) {
				businessBackgroundBOList = (List<BusinessBackgroundBO>) ElFunctions.get(reporData, "BusinessBackground");
				
                if (isNotEmpty(businessBackgroundBOList)) {
                    for (BusinessBackgroundBO businessBackgroundBO : businessBackgroundBOList) {
                        if (businessBackgroundBO != null && !(ElFunctions.get(businessBackgroundBO,"businessBackground") instanceof String) && isNotEmpty((List<BusinessBackgroundDataAttrsBO>) ElFunctions.get(businessBackgroundBO,"businessBackground"))){
                        	businessBackgroundDataAttrsBOList = (List<BusinessBackgroundDataAttrsBO>) ElFunctions.get(businessBackgroundBO,"businessBackground");
                        }
                    }
			}
        }
		} catch (NextGenBusinessObjectException ngObjEx) {
			System.out.println(ngObjEx.getMessage());
		}
		return businessBackgroundDataBO;
    }
	
	@SuppressWarnings("unchecked")
	public List<ReportSummaryDataBO> getReportSummaryData(ReportBO reporData) {
        List<ReportSummaryBO> reportSummaryBOList = null;
        List<ReportSummaryDataBO> reportSummaryDataBOList = new ArrayList<ReportSummaryDataBO>(); 
        try {
			if (!(ElFunctions.get(reporData, "reportSummary") instanceof String)) {
			    reportSummaryBOList = (List<ReportSummaryBO>) ElFunctions.get(reporData, "reportSummary");
			    if (isNotEmpty(reportSummaryBOList)) {
			    	for (ReportSummaryBO reportSummaryBO : reportSummaryBOList) {
			    		if (reportSummaryBO != null && !(ElFunctions.get(reportSummaryBO, "reportSummaryInfo") instanceof String)) {
                            if (isNotEmpty((List<ReportSummaryDataBO>) ElFunctions.get(reportSummaryBO, "reportSummaryInfo"))) {
                                reportSummaryDataBOList.addAll((List<ReportSummaryDataBO>) ElFunctions.get(reportSummaryBO,"reportSummaryInfo"));
                            }

                        }

			    	}
			    }
			    }
		} catch (NextGenBusinessObjectException nge) {
			System.err.println(nge.getMessage());
		}
		return reportSummaryDataBOList;
        }
	
     public List<BusinessHistory> getBusinessHistroy(Report report) {
        List<BusinessHistory> businessHistoryList = null;
        if (report != null) {
            businessHistoryList = report.getBusHistoryList();
        }
        return businessHistoryList;
    }
     
     public List<CurrencyBasedAccSummDataBO> getAccountSummaryData(ReportBO reporData) {
         List<CurrencyBasedAccSummBO> currencyBasedAccSummBOList = null;
         CurrencyBasedAccSummDataAttrsBO currencyBasedAccSummDataAttrsBO = null;
         List<CurrencyBasedAccSummDataBO> currencyBasedAccSummDataBOList = new ArrayList<CurrencyBasedAccSummDataBO>();
         if (reporData != null) {
             try {
                 if (!(ElFunctions.get(reporData, "currencyBasedAccSumm") instanceof String)) {
                     currencyBasedAccSummBOList = (List<CurrencyBasedAccSummBO>) ElFunctions.get(reporData, "currencyBasedAccSumm");
                     if (isNotEmpty(currencyBasedAccSummBOList)) {
                         currencyBasedAccSummDataBOList = getCurrencyBasedAccSummList(
                                 currencyBasedAccSummBOList,
                                 currencyBasedAccSummDataAttrsBO,
                                 currencyBasedAccSummDataBOList);
                     }
                 }
             } catch (NextGenBusinessObjectException exception) {
            	 System.err.println(exception.getMessage());
                 return currencyBasedAccSummDataBOList;
             }
         }
         return currencyBasedAccSummDataBOList;
     }
     
     private static List<CurrencyBasedAccSummDataBO> getCurrencyBasedAccSummList(
             List<CurrencyBasedAccSummBO> currencyBasedAccSummBOList,
             CurrencyBasedAccSummDataAttrsBO currencyBasedAccSummDataAttrs,
             List<CurrencyBasedAccSummDataBO> currencyBasedAccSummDataBOList) {
         CurrencyBasedAccSummDataAttrsBO currencyBasedAccSummDataAttrsBO = currencyBasedAccSummDataAttrs;
         for (CurrencyBasedAccSummBO currencyBasedAccSummBO : currencyBasedAccSummBOList) {
             try {
                 if (currencyBasedAccSummBO != null
                         && !(ElFunctions.get(currencyBasedAccSummBO,
                         "currencyBasedAccSummDataAttrs") instanceof String)) {
                     currencyBasedAccSummDataAttrsBO = (CurrencyBasedAccSummDataAttrsBO) ElFunctions
                             .get(currencyBasedAccSummBO,
                                     "currencyBasedAccSummDataAttrs");
                     if ((currencyBasedAccSummDataAttrsBO != null)
                             && (!(ElFunctions.get(
                             currencyBasedAccSummDataAttrsBO, "accSumm") instanceof String))
                             && (isNotEmpty((List<CurrencyBasedAccSummDataBO>) ElFunctions
                             .get(currencyBasedAccSummDataAttrsBO,
                                     "accSumm")))
                             && (currencyBasedAccSummDataAttrsBO != null)) {

                         currencyBasedAccSummDataBOList
                                 .addAll((List<CurrencyBasedAccSummDataBO>) ElFunctions
                                         .get(currencyBasedAccSummDataAttrsBO,
                                                 "accSumm"));

                     }
                 }
             } catch (NextGenBusinessObjectException e) {
            	 System.err.println(e.getMessage());
             }

         }

         return currencyBasedAccSummDataBOList;
     }
     
     
     
     
     public List<BusinessInquiryOutputData> getEnquiries(ReportBO reporData) {
         List<BusinessInquiryOutputBO> businessInquiryOutputBOList = null;
         List<BusinessInquiryOutputData> businessInquiryOutputDataList = new ArrayList<BusinessInquiryOutputData>();
         try {
             if (!(ElFunctions.get(reporData, "BusinessInquiryDataBand") instanceof String)) {
                 businessInquiryOutputBOList = (List<BusinessInquiryOutputBO>) ElFunctions
                         .get(reporData, "BusinessInquiryDataBand");
                 if (isNotEmpty(businessInquiryOutputBOList)) {
                     for (BusinessInquiryOutputBO businessInquiryOutputBO : businessInquiryOutputBOList) {
                         if (businessInquiryOutputBO != null
                                 && !(ElFunctions.get(businessInquiryOutputBO,
                                 "businessInquiryOutputData") instanceof String)
                                 && isNotEmpty((List<BusinessInquiryOutputData>) ElFunctions
                                 .get(businessInquiryOutputBO,
                                         "businessInquiryOutputData"))) {
                             businessInquiryOutputDataList
                                     .addAll((List<BusinessInquiryOutputData>) ElFunctions
                                             .get(businessInquiryOutputBO,
                                                     "businessInquiryOutputData"));
                         }
                     }

                 }
             }
         } catch (NextGenBusinessObjectException exception) {
             return businessInquiryOutputDataList;
         }
         return businessInquiryOutputDataList;
     }
     
     public List<ConsumerSummaryDataBO> getConsumerReportSummaryList(ReportBO report) {

         List<ConsumerSummaryBO> consumerSummaryBOList;
         List<ConsumerSummaryDataBO> consumerSummaryDataBOList = new ArrayList<ConsumerSummaryDataBO>();
         try {
             if (!(ElFunctions.get(report, "consumerSummary") instanceof String)) {
                 consumerSummaryBOList = (List<ConsumerSummaryBO>) ElFunctions.get(report, "consumerSummary");

                 if (isNotEmpty(consumerSummaryBOList)) {
                     for (ConsumerSummaryBO consumerSummaryBO : consumerSummaryBOList) {
                         if (!(ElFunctions.get(consumerSummaryBO,
                                 "ConSummaryData") instanceof String)) {
                             consumerSummaryDataBOList.addAll((List<ConsumerSummaryDataBO>) ElFunctions.get(consumerSummaryBO,"ConSummaryData"));

                         }
                     }
                 }

             }
         } catch (NextGenBusinessObjectException exception) {
             return consumerSummaryDataBOList;
         }
         return consumerSummaryDataBOList;
     }
     
     
     public List<BCADataBO> getCreditAccount(ReportBO reporData) {
         List<BCABO> bCABOList = null;
         List<BCADataBO> bCADataBO = new ArrayList<BCADataBO>();
         try {
             if (!(ElFunctions.get(reporData, "BCAInformation") instanceof String)) {
                 bCABOList = (List<BCABO>) ElFunctions.get(reporData,"BCAInformation");
                 if (isNotEmpty(bCABOList)) {
                     for (BCABO bCABO : bCABOList) {
                         if (bCABO != null
                                 && !(ElFunctions.get(bCABO, "BCAData") instanceof String)) {

                             bCADataBO.addAll((List<BCADataBO>) ElFunctions.get( bCABO, "BCAData"));

                         }
                     }

                 }
             }
         } catch (NextGenBusinessObjectException exception) {
        	 System.err.println(exception.getMessage());
         }
         return bCADataBO;
     }
     
     
     
     public List<BilOutputData> getServiceEnquiries(ReportBO reporData) {
         List<BusinessServiceInquiryOutputBO> businessServiceInquiryOutputBOList = null;
         List<BilOutputData> bilOutputDataList = new ArrayList<BilOutputData>();
         try {
             if (!(ElFunctions.get(reporData, "BusinessServiceInquiryDataBand") instanceof String)) {
                 businessServiceInquiryOutputBOList = (List<BusinessServiceInquiryOutputBO>) ElFunctions
                         .get(reporData, "BusinessServiceInquiryDataBand");
                 if (isNotEmpty(businessServiceInquiryOutputBOList)) {
                     for (BusinessServiceInquiryOutputBO businessServiceInquiryOutputBO : businessServiceInquiryOutputBOList) {
                         if (businessServiceInquiryOutputBO != null
                                 && !(ElFunctions.get(
                                 businessServiceInquiryOutputBO,
                                 "businessServiceInquiryOutputList") instanceof String)
                                 && isNotEmpty((List<BusinessInquiryOutputData>) ElFunctions
                                 .get(businessServiceInquiryOutputBO,
                                         "businessServiceInquiryOutputList"))) {
                             bilOutputDataList
                                     .addAll((List<BilOutputData>) ElFunctions
                                             .get(businessServiceInquiryOutputBO,
                                                     "businessServiceInquiryOutputList"));
                         }
                     }

                 }
             }
         } catch (NextGenBusinessObjectException exception) {
             return bilOutputDataList;
         }
         return bilOutputDataList;
     }

     
     public List<RelationshipInformationDataBO> getRelationShipInfoData(
             ReportBO reporData) {
         List<RelationshipInformationBO> relationshipInformationBOList = null;
         List<RelationshipInformationDataBO> relationshipInformationDataBOList = new ArrayList<RelationshipInformationDataBO>();
         if (reporData != null) {
             try {
                 if (!(ElFunctions.get(reporData, "relationshipInformation") instanceof String)) {
                     relationshipInformationBOList = (List<RelationshipInformationBO>) ElFunctions
                             .get(reporData, "relationshipInformation");
                     if (isNotEmpty(relationshipInformationBOList)) {
                         for (RelationshipInformationBO relationshipInformationBO : relationshipInformationBOList) {
                             if (relationshipInformationBO != null
                                     && !(ElFunctions.get(
                                     relationshipInformationBO,
                                     "relationshipInformationData") instanceof String)
                                     && isNotEmpty((List<RelationshipInformationDataBO>) ElFunctions
                                     .get(relationshipInformationBO,
                                             "relationshipInformationData"))) {
                                 relationshipInformationDataBOList
                                         .addAll((List<RelationshipInformationDataBO>) ElFunctions
                                                 .get(relationshipInformationBO,
                                                         "relationshipInformationData"));
                             }
                         }
                     }
                 }
             } catch (NextGenBusinessObjectException exception) {
                 return relationshipInformationDataBOList;
             }
         }
         return relationshipInformationDataBOList;
     }

     
          
     
	private static boolean isNotEmpty(List<?> list) {
        return (list != null && list.size() > 0);
    }
*/}
