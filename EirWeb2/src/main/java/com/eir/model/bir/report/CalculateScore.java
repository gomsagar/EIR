package com.eir.model.bir.report;

import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.eir.model.bir.CompanyReportType;
import com.eir.model.bir.FinancialRatios;
import com.eir.model.bir.KeyManagerialPersonType;
import com.eir.model.bir.ProductOrServiceType;
import com.eir.model.bir.SnapshotType;

public class CalculateScore {

	public static Map<Float, String> getCalculatedScore(StringReader str) {
		
		//File folder = new File("D:/EIR Docs/MANJEET COTTON PRIVATE LIMITED(22-03-2017).xml");
		
		
    	StringBuilder builder = new StringBuilder();
    	
    	try
    	{
            JAXBContext context = JAXBContext.newInstance(CompanyReportType.class);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            CompanyReportType com= (CompanyReportType) jaxbUnmarshaller.unmarshal(str);  
            
            Properties prop1 = new Properties();
            Properties prop2 = new Properties();
            Properties prop3 = new Properties();
            Properties prop4 = new Properties();
            Properties prop5 = new Properties();
            Properties prop6 = new Properties();
            Properties prop7 = new Properties();
            Properties prop8 = new Properties();
            Properties prop9 = new Properties();
            Properties prop10 = new Properties();
            Properties prop11 = new Properties();
            Properties prop12 = new Properties();
            Properties prop13 = new Properties();
            Properties prop14 = new Properties();
            Properties prop15 = new Properties();
            Properties prop16 = new Properties();
            Properties prop17 = new Properties();
            Properties prop18 = new Properties();
            Properties prop19 = new Properties();
            Properties prop20 = new Properties();
            Properties prop21 = new Properties();
            Properties prop22 = new Properties();
            Properties prop23 = new Properties();
            Properties prop24 = new Properties();
//            Properties prop25 = new Properties();//litigation
            
            InputStream debt_ratio_in = CalculateScore.class.getClassLoader().getResourceAsStream("Debt Ratio.properties");
            InputStream asset_turnover_in = CalculateScore.class.getClassLoader().getResourceAsStream("Asset Turnover.properties");
            InputStream banking_Relationship = CalculateScore.class.getClassLoader().getResourceAsStream("Banking Relationship.properties");
            InputStream current_Ratio = CalculateScore.class.getClassLoader().getResourceAsStream("Current Ratio.properties");
            InputStream debt_Equity_Ratio = CalculateScore.class.getClassLoader().getResourceAsStream("Debt Equity Ratio.properties");
            InputStream export_Import_History = CalculateScore.class.getClassLoader().getResourceAsStream("Export_Import_History.properties");
            InputStream Family_Shares_EncumberedOrPledged = CalculateScore.class.getClassLoader().getResourceAsStream("Family Shares EncumberedOrPledged.properties");
            InputStream Industry_Risk_Rating = CalculateScore.class.getClassLoader().getResourceAsStream("Industry_Risk_Rating.properties");
            InputStream Industry_Type = CalculateScore.class.getClassLoader().getResourceAsStream("Industry_Type.properties");
            InputStream Interest_Coverage_ratio = CalculateScore.class.getClassLoader().getResourceAsStream("Interest Coverage ratio.properties");
            InputStream Inventory_Turnover = CalculateScore.class.getClassLoader().getResourceAsStream("Inventory Turnover.properties");
            InputStream Net_Fixed_Net_Worth = CalculateScore.class.getClassLoader().getResourceAsStream("Net Fixed_Net Worth.properties");
            InputStream No_Of_Employess = CalculateScore.class.getClassLoader().getResourceAsStream("No_Of_Employess.properties");
            InputStream Ownership_of_Directors = CalculateScore.class.getClassLoader().getResourceAsStream("Ownership of Directors.properties");
            InputStream Ownership_of_Family = CalculateScore.class.getClassLoader().getResourceAsStream("Ownership of Family.properties");
            InputStream Real_Estate_Value_Total_Assets = CalculateScore.class.getClassLoader().getResourceAsStream("Real Estate Value_Total Assets.properties");
            InputStream Return_on_Investments = CalculateScore.class.getClassLoader().getResourceAsStream("Return on Investments.properties");
            InputStream Return_on_Total_Assets = CalculateScore.class.getClassLoader().getResourceAsStream("Return on Total Assets.properties");
            InputStream Total_Long_Term_Borrowings_Net_Income = CalculateScore.class.getClassLoader().getResourceAsStream("Total Long Term Borrowings_Net Income.properties");
            InputStream Total_Short_Term_Borrowings_Net_Income = CalculateScore.class.getClassLoader().getResourceAsStream("Total Short Term Borrowings_Net Income.properties");
            InputStream Type_of_Company = CalculateScore.class.getClassLoader().getResourceAsStream("Type of Company.properties");
            InputStream Years_of_Business = CalculateScore.class.getClassLoader().getResourceAsStream("Years of Business.properties");
            InputStream Years_of_Directors = CalculateScore.class.getClassLoader().getResourceAsStream("Years of Directors.properties");
            InputStream log = CalculateScore.class.getClassLoader().getResourceAsStream("Log.properties");
//            InputStream litigation = CalculateScore.class.getClassLoader().getResourceAsStream("Litigation.properties");//Litigation
            
//            prop.load(new FileReader(new File("Debt Ratio.properties")));
            prop1.load(debt_ratio_in);

            TreeSet debt_ratio_keys  = new TreeSet(prop1.keySet());
            Iterator debtRatioIt = debt_ratio_keys.iterator();
            ArrayList<Float> debtRatioList = new ArrayList<Float>();
            while(debtRatioIt.hasNext()){
            	debtRatioList.add(Float.parseFloat(String.valueOf(debtRatioIt.next())));
            }
            debt_ratio_in.close();

            prop2.load(asset_turnover_in);

            TreeSet asset_turnover_keys  = new TreeSet(prop2.keySet());
            Iterator assetTurnoverIt = asset_turnover_keys.iterator();
            ArrayList<Float> assetTurnOverList = new ArrayList<Float>();
            while(assetTurnoverIt.hasNext()){
            	assetTurnOverList.add(Float.parseFloat(String.valueOf(assetTurnoverIt.next())));
            }
            asset_turnover_in.close();

//            prop3.load(banking_Relationship);

//          TreeSet banking_relationship  = new TreeSet(prop3.keySet());
//          Iterator banking_relation = banking_relationship.iterator();
//          ArrayList<Float> bankingList = new ArrayList<Float>();
//          while(banking_relation.hasNext()){
//          	bankingList.add(Float.parseFloat(String.valueOf(banking_relation.next())));
//          }
//            banking_Relationship.close();

            prop4.load(current_Ratio);

            TreeSet current_ratio_keys  = new TreeSet(prop4.keySet());
            Iterator current_ratio_it = current_ratio_keys.iterator();
            ArrayList<Float> currentRatioList = new ArrayList<Float>();
            while(current_ratio_it.hasNext()){
            	currentRatioList.add(Float.parseFloat(String.valueOf(current_ratio_it.next())));
            }
            current_Ratio.close();

            
            prop5.load(debt_Equity_Ratio);
            
            TreeSet debt_equity_ratio_keys  = new TreeSet(prop5.keySet());
            Iterator debt_equity_ratio_it = debt_equity_ratio_keys.iterator();
            ArrayList<Float> debtEquityList = new ArrayList<Float>();
            while(debt_equity_ratio_it.hasNext()){
            	debtEquityList.add(Float.parseFloat(String.valueOf(debt_equity_ratio_it.next())));
            }
            debt_Equity_Ratio.close();

            
//            prop6.load(export_Import_History);

//          TreeSet export_import  = new TreeSet(prop6.keySet());
//          Iterator export_import_it = export_import.iterator();
//          ArrayList<Float> exportimportList = new ArrayList<Float>();
//          while(export_import_it.hasNext()){
//          	exportimportList.add(Float.parseFloat(String.valueOf(export_import_it.next())));
//          }
//            export_Import_History.close();

            prop7.load(Family_Shares_EncumberedOrPledged);

            TreeSet family  = new TreeSet(prop7.keySet());
            Iterator family_it = family.iterator();
            ArrayList<Float> familyList = new ArrayList<Float>();
            while(family_it.hasNext()){
            	familyList.add(Float.parseFloat(String.valueOf(family_it.next())));
            }
            Family_Shares_EncumberedOrPledged.close();

            prop8.load(Industry_Risk_Rating);

            TreeSet industry_risk  = new TreeSet(prop8.keySet());
            Iterator industry_risk_it = industry_risk.iterator();
            ArrayList<Float> industry_riskList = new ArrayList<Float>();
            while(industry_risk_it.hasNext()){
            	industry_riskList.add(Float.parseFloat(String.valueOf(industry_risk_it.next())));
            }
            Industry_Risk_Rating.close();

            
            prop9.load(Industry_Type);

            TreeSet industry_type_keys  = new TreeSet(prop9.keySet());
            Iterator industry_type_keys_it = industry_type_keys.iterator();
            ArrayList<String> industry_type_keysList = new ArrayList<String>();
            while(industry_type_keys_it.hasNext()){
            	industry_type_keysList.add((String) industry_type_keys_it.next());
            }
            Industry_Type.close();

            prop10.load(Interest_Coverage_ratio);

            TreeSet coverage_keys  = new TreeSet(prop10.keySet());
            Iterator coverage_keys_it = coverage_keys.iterator();
            ArrayList<Float> coverage_keysList = new ArrayList<Float>();
            while(coverage_keys_it.hasNext()){
            	coverage_keysList.add(Float.parseFloat((String)(coverage_keys_it.next())));
            }
            Interest_Coverage_ratio.close();
            Collections.sort(coverage_keysList);

            
            prop11.load(Inventory_Turnover);

            TreeSet invetory_keys  = new TreeSet(prop11.keySet());
            Iterator invetory_it = invetory_keys.iterator();
            ArrayList<Float> invetoryList = new ArrayList<Float>();
            while(invetory_it.hasNext()){
            	invetoryList.add(Float.parseFloat(String.valueOf(invetory_it.next())));
            }
            Collections.sort(invetoryList);
            Inventory_Turnover.close();

            prop12.load(Net_Fixed_Net_Worth);

            TreeSet net_fixed_keys  = new TreeSet(prop12.keySet());
            Iterator net_fixed_it = net_fixed_keys.iterator();
            ArrayList<Float> net_fixedList = new ArrayList<Float>();
            while(net_fixed_it.hasNext()){
            	net_fixedList.add(Float.parseFloat(String.valueOf(net_fixed_it.next())));
            }
            Net_Fixed_Net_Worth.close();

            prop13.load(No_Of_Employess);

            TreeSet employees_keys  = new TreeSet(prop13.keySet());
            Iterator employees_it = employees_keys.iterator();
            ArrayList<Integer> employeesList = new ArrayList<Integer>();
            while(employees_it.hasNext()){
            	employeesList.add(Integer.parseInt(String.valueOf(employees_it.next())));
            }
            No_Of_Employess.close();
            Collections.sort(employeesList);

            prop14.load(Ownership_of_Directors);

            TreeSet owner_director_keys  = new TreeSet(prop14.keySet());
            Iterator owner_director_it = owner_director_keys.iterator();
            ArrayList<Float> owner_directorList = new ArrayList<Float>();
            while(owner_director_it.hasNext()){
            	owner_directorList.add(Float.parseFloat(String.valueOf(owner_director_it.next())));
            }
            Ownership_of_Directors.close();

            prop15.load(Ownership_of_Family);

            TreeSet owner_family_keys  = new TreeSet(prop15.keySet());
            Iterator owner_family_it = owner_family_keys.iterator();
            ArrayList<Float> owner_familyList = new ArrayList<Float>();
            while(owner_family_it.hasNext()){
            	owner_familyList.add(Float.parseFloat(String.valueOf(owner_family_it.next())));
            }
            Ownership_of_Family.close();

            prop16.load(Real_Estate_Value_Total_Assets);

            TreeSet real_estate_keys  = new TreeSet(prop16.keySet());
            Iterator real_estate_it = real_estate_keys.iterator();
            ArrayList<Float> real_estateList = new ArrayList<Float>();
            while(real_estate_it.hasNext()){
            	real_estateList.add(Float.parseFloat(String.valueOf(real_estate_it.next())));
            }
            Real_Estate_Value_Total_Assets.close();
            
            prop17.load(Return_on_Investments);

            TreeSet return_invest_keys  = new TreeSet(prop17.keySet());
            Iterator return_invest_it = return_invest_keys.iterator();
            ArrayList<Float> return_investList = new ArrayList<Float>();
            while(return_invest_it.hasNext()){
            	return_investList.add(Float.parseFloat(String.valueOf(return_invest_it.next())));
            }
            Return_on_Investments.close();
            Collections.sort(return_investList);

            prop18.load(Return_on_Total_Assets);

            TreeSet return_asset_keys  = new TreeSet(prop18.keySet());
            Iterator return_asset_it = return_asset_keys.iterator();
            ArrayList<Float> return_assetList = new ArrayList<Float>();
            while(return_asset_it.hasNext()){
            	return_assetList.add(Float.parseFloat(String.valueOf(return_asset_it.next())));
            }
            Return_on_Total_Assets.close();

            
            prop19.load(Total_Long_Term_Borrowings_Net_Income);

            TreeSet long_term_borrow_keys  = new TreeSet(prop19.keySet());
            Iterator long_term_borrow_it = long_term_borrow_keys.iterator();
            ArrayList<Float> long_term_borrowList = new ArrayList<Float>();
            while(long_term_borrow_it.hasNext()){
            	long_term_borrowList.add(Float.parseFloat(String.valueOf(long_term_borrow_it.next())));
            }
            Total_Long_Term_Borrowings_Net_Income.close();
            Collections.sort(long_term_borrowList);

            
            prop20.load(Total_Short_Term_Borrowings_Net_Income);

            TreeSet short_term_borrow_keys  = new TreeSet(prop20.keySet());
            Iterator short_term_borrow_it = short_term_borrow_keys.iterator();
            ArrayList<Float> short_term_borrowList = new ArrayList<Float>();
            while(short_term_borrow_it.hasNext()){
            	short_term_borrowList.add(Float.parseFloat(String.valueOf(short_term_borrow_it.next())));
            }
            Total_Short_Term_Borrowings_Net_Income.close();
            Collections.sort(short_term_borrowList);

            
            prop21.load(Type_of_Company);

            TreeSet type_company_keys  = new TreeSet(prop21.keySet());
            Iterator type_company_it = type_company_keys.iterator();
            ArrayList<String> type_companyList = new ArrayList<String>();
            while(type_company_it.hasNext()){
            	type_companyList.add((String.valueOf(type_company_it.next())));
            }
            Type_of_Company.close();


            prop22.load(Years_of_Business);

            TreeSet years_business_keys  = new TreeSet(prop22.keySet());
            Iterator years_business_it = years_business_keys.iterator();
            ArrayList<Integer> years_businessList = new ArrayList<Integer>();
            while(years_business_it.hasNext()){
            	years_businessList.add(Integer.parseInt(String.valueOf(years_business_it.next())));
            }
            Years_of_Business.close();

            
            prop23.load(Years_of_Directors);
            
            TreeSet years_directors_keys  = new TreeSet(prop23.keySet());
            Iterator years_directors_it = years_directors_keys.iterator();
            ArrayList<Integer> years_directorsList = new ArrayList<Integer>();
            while(years_directors_it.hasNext()){
            	years_directorsList.add(Integer.parseInt(String.valueOf(years_directors_it.next())));
            }
            Years_of_Directors.close();
            Collections.sort(years_directorsList);

            prop24.load(log);
            
            TreeSet log_keys  = new TreeSet(prop24.keySet());
            Iterator log_it = log_keys.iterator();
            ArrayList<Integer> logList = new ArrayList<Integer>();
            while(log_it.hasNext()){
            	logList.add(Integer.parseInt(String.valueOf(log_it.next())));
            }
            log.close();
            Collections.sort(logList);
            
//            prop25.load(litigation);//litigation
            
            
            //----------------------------//
                            
            
            builder.append(""+"|"+""+"|"+"Name Of Company"+"|");//+source.getName());
            builder.append(System.getProperty("line.separator"));
            
    		System.out.println(""+"|"+""+"|"+"Name Of Company"+"|");//+source.getName());
    		
            List<SnapshotType> list_Profit_Loss  = com.getProfitAndLoss().getSnapshot();
            Iterator<SnapshotType> it_Profit_Loss = list_Profit_Loss.iterator();
            String annual_turnover = "";
            Double profit_before_tax = 0.0;
            Double current_tax = 0.0;
            Double deffered_tax = 0.0;
            Double net_income = 0.0;
            while(it_Profit_Loss.hasNext()){
            	SnapshotType s = it_Profit_Loss.next();
            	
            	if(null != s.getRevenueFromOperations() && !(s.getRevenueFromOperations().equals(""))){
            		annual_turnover = s.getRevenueFromOperations();
            	}else{
            		if(null != s.getRevenue() && !(s.getRevenue().equals(""))){
            			annual_turnover = s.getRevenue();
            		}
            	}
            	//net income required parameters
            	if(null != s.getProfitBeforeTax() && !(s.getProfitBeforeTax().equals(""))){
            		profit_before_tax = Double.parseDouble(s.getProfitBeforeTax());
            	}
            	if(null != s.getCurrentTax() && !(s.getCurrentTax().equals(""))){
            		current_tax = Double.parseDouble(s.getCurrentTax());
            	}
            	if(null != s.getDeferredTax() && !(s.getDeferredTax().equals(""))){
            		deffered_tax = Double.parseDouble(s.getDeferredTax());
            	}
            }
            net_income = profit_before_tax + current_tax + deffered_tax;
            
            if(annual_turnover==""){
            	builder.append(""+"|"+""+"|"+"Annual Turnover"+"|"+"0");
            	builder.append(System.getProperty("line.separator"));
            }else{
                builder.append(""+"|"+""+"|"+"Annual Turnover"+"|"+Math.round(Double.parseDouble(annual_turnover))/1000);
                builder.append(System.getProperty("line.separator"));                	
            }

            
//    		System.out.println(""+"|"+""+"|"+"Annual Turnover"+"|"+Math.round(Double.parseDouble(annual_turnover))/1000);//revenue tag field from P & L.
    		
    		builder.append("Nature of Factors"+"|"+"Category"+"|"+"Factors"+"|"+"");
    		builder.append(System.getProperty("line.separator"));
    		
    		System.out.println("Nature of Factors"+"|"+"Category"+"|"+"Factors"+"|"+"");
    		
	        List<FinancialRatios> ratios = com.getFinacialRatios();
	        Iterator<FinancialRatios> it_financial_leverage_ratios  = ratios.iterator();
	        String debt_ratio = "";
	        String debt_equity_ratio = "";
	        String coverage_ratio = "";
	        String fixed_assets1 = "";
	        float fixed_assets1_score = 0;
	        String fixed_assets2 = "";//Real Estate value. Empty as it does not count in calculation part
	        float fixed_assets2_score = 50;
	        float debt_ratio_score = 0;
	        float debt_equity_ratio_score = 0;
	        float coverage_ratio_score = 0;
	        while(it_financial_leverage_ratios.hasNext()){
	        	FinancialRatios fr = it_financial_leverage_ratios.next();
	        	
	        	if(null != fr.getLeverageRatios().getDebtRatio()){
	        		debt_ratio = fr.getLeverageRatios().getDebtRatio();
	        	}
	        	if(null != fr.getLeverageRatios().getDebtEquityRatio()){
	        		debt_equity_ratio = fr.getLeverageRatios().getDebtEquityRatio();
	        	}
	        	if(null != fr.getLeverageRatios().getFixedAssetsToNetWorth()){
	        		fixed_assets1 = fr.getLeverageRatios().getFixedAssetsToNetWorth();
	        	}
	        	if(null != fr.getLeverageRatios().getInterestCoverageRatio() && !(fr.getLeverageRatios().getInterestCoverageRatio().startsWith("-"))){
	        		coverage_ratio = fr.getLeverageRatios().getInterestCoverageRatio();
	        	}else{
	        		coverage_ratio = "-9999";
	        	}
	        }

            for(int i = 0; i<debtRatioList.size(); i++){
                for(int j = i+1; j<debtRatioList.size(); j++){                    	
                	if(debtRatioList.get(i) <= Float.parseFloat(debt_ratio) && Float.parseFloat(debt_ratio) <= debtRatioList.get(j)){

                		debt_ratio_score = Float.parseFloat(String.valueOf( prop1.get(String.valueOf(debtRatioList.get(j))) ));
                		break;
                	}
                }
            }

           if(Float.parseFloat(debt_equity_ratio)>=debtEquityList.get(10)){
        	   debt_equity_ratio_score = Float.parseFloat(String.valueOf( prop5.get(String.valueOf(debtEquityList.get(10))) ));
        	   
           }else{
               for(int i = 0; i<debtEquityList.size(); i++){
                   for(int j = i+1; j<debtEquityList.size(); j++){                    	
                   	if(debtEquityList.get(i) <= Float.parseFloat(debt_equity_ratio) && Float.parseFloat(debt_equity_ratio) <= debtEquityList.get(j)){

                   		debt_equity_ratio_score = Float.parseFloat(String.valueOf( prop5.get(String.valueOf(debtEquityList.get(j))) ));
                   		break;
                   	}
                   }
               }            	   
           }
            
            if(Float.parseFloat(coverage_ratio) >= coverage_keysList.get(10)){
          		coverage_ratio_score = Float.parseFloat(String.valueOf( prop10.get(String.valueOf(coverage_keysList.get(10))) ));
            }else{
            	if(coverage_ratio.equals("-9999")){
            		coverage_ratio_score = 10;
            	}else{
                    for(int i = 0; i<coverage_keysList.size(); i++){
                        for(int j = i+1; j<coverage_keysList.size(); j++){                    	
                        	if(coverage_keysList.get(i) <= Float.parseFloat(coverage_ratio) && Float.parseFloat(coverage_ratio) <= coverage_keysList.get(j)){

                        		coverage_ratio_score = Float.parseFloat(String.valueOf( prop10.get(String.valueOf(coverage_keysList.get(j))) ));
                        		break;
                        	}
                        }// end of j for
                    } //end of i for               	

            	}
            }
            

            builder.append("Quantitative"+"|"+"Leverage Ratio"+"|"+"Debt Ratio"+"|"+debt_ratio);
            builder.append(System.getProperty("line.separator"));
            
            builder.append(""+"|"+""+"|"+"Debt equity ratio"+"|"+debt_equity_ratio);
            builder.append(System.getProperty("line.separator"));
            
    		System.out.println("Quantitative"+"|"+"Leverage Ratio"+"|"+"Debt Ratio"+"|"+debt_ratio);//value of debt ratio                
    		System.out.println(""+"|"+""+"|"+"Debt equity ratio"+"|"+debt_equity_ratio);//value of debt equity ratio

	        Iterator<FinancialRatios> it_financial_Solvency_ratios  = ratios.iterator();
	        String current_ratio = "";
	        float current_ratio_score = 0;
	        while(it_financial_Solvency_ratios.hasNext()){
	        	FinancialRatios fr = it_financial_Solvency_ratios.next();
	        	
	        	if(null != fr.getSolvencyRatios().getCurrentRatio()){
	        		current_ratio = fr.getSolvencyRatios().getCurrentRatio();
	        	}
	        }

            for(int i = 0; i<currentRatioList.size(); i++){
                for(int j = i+1; j<currentRatioList.size(); j++){                    	
                	if(currentRatioList.get(i) <= Float.parseFloat(current_ratio) && Float.parseFloat(current_ratio) <= currentRatioList.get(j)){

                		current_ratio_score = Float.parseFloat(String.valueOf( prop4.get(String.valueOf(currentRatioList.get(j))) ));
                		break;
                	}
                }
            }

	        builder.append(""+"|"+"Solvency Ratio"+"|"+"Current Ratio"+"|"+current_ratio);
	        builder.append(System.getProperty("line.separator"));
	        
	        builder.append(""+"|"+"Coverage"+"|"+"Interest Coverage Ratio"+"|"+coverage_ratio);
	        builder.append(System.getProperty("line.separator"));
	        
			System.out.println(""+"|"+"Solvency Ratio"+"|"+"Current Ratio"+"|"+current_ratio);//value of current ratio

			System.out.println(""+"|"+"Coverage"+"|"+"Interest Coverage Ratio"+"|"+coverage_ratio);//value of interest coverage ratio
			
	        Iterator<FinancialRatios> it_financial_Efficiency_ratios  = ratios.iterator();
	        String inventory_turnover = "";
	        String asset_turnover = "";
	        float inventory_turover_score = 0 ;
	        float asset_turnover_score = 0;
	        while(it_financial_Efficiency_ratios.hasNext()){
	        	FinancialRatios fr = it_financial_Efficiency_ratios.next();
	        	
	        	if(null != fr.getEffeciencyRatios().getInventoryTurnoverRatio()){
	        		inventory_turnover = fr.getEffeciencyRatios().getInventoryTurnoverRatio();
	        	}
	        	if(null != fr.getEffeciencyRatios().getAssetTurnoverRatio()){
	        		asset_turnover = fr.getEffeciencyRatios().getAssetTurnoverRatio();
	        	}
	        }

	        if(asset_turnover.startsWith("-")){
	        	asset_turnover_score = 10;
	        }else{
                for(int i = 0; i<assetTurnOverList.size(); i++){
                    for(int j = i+1; j<assetTurnOverList.size(); j++){                    	
                    	if(assetTurnOverList.get(i) <= Float.parseFloat(asset_turnover) && Float.parseFloat(asset_turnover) <= assetTurnOverList.get(j)){

                    		asset_turnover_score = Float.parseFloat(String.valueOf( prop2.get(String.valueOf(assetTurnOverList.get(j))) ));
                    		break;
                    	}
                    }
                }    	        	
	        }
	        
	        if(inventory_turnover.startsWith("-")){
	        	inventory_turover_score = 0;
	        }else{
                for(int i = 0; i<invetoryList.size(); i++){
                    for(int j = i+1; j<invetoryList.size(); j++){                    	
                    	if(invetoryList.get(i) <= Float.parseFloat(inventory_turnover) && Float.parseFloat(inventory_turnover) <= invetoryList.get(j)){
 
//                    		String key = String.valueOf(invetoryList.get(j));
//                    		String value  = (String)prop11.get(key);                    		
                    		inventory_turover_score = Float.parseFloat((String)( prop11.get(String.valueOf(invetoryList.get(j)))) );
                    		break;
                    	}
                    }
                }    	        	
	        }
            
            builder.append(""+"|"+"Efficiency"+"|"+"Inventory Turnover"+"|"+inventory_turnover);
            builder.append(System.getProperty("line.separator"));
            
            builder.append(""+"|"+""+"|"+"Asset Turnover"+"|"+asset_turnover);
            builder.append(System.getProperty("line.separator"));
            
			System.out.println(""+"|"+"Efficiency"+"|"+"Inventory Turnover"+"|"+inventory_turnover);//value of inventory turnover
			System.out.println(""+"|"+""+"|"+"Asset Turnover"+"|"+asset_turnover);//value of asset turnover

	        Iterator<FinancialRatios> it_financial_Profitability_ratios  = ratios.iterator();
	        String return_on_assets = "";
	        String return_on_investments = "";
	        float return_on_assets_score = 0;
	        float return_on_investments_score = 0;
	        while(it_financial_Profitability_ratios.hasNext()){
	        	FinancialRatios fr  = it_financial_Profitability_ratios.next();
	        	
	        	if(null != fr.getProfitabilityRatios().getReturnOnAssets()){
	        		return_on_assets = fr.getProfitabilityRatios().getReturnOnAssets();
	        	}
	        	if(null != fr.getProfitabilityRatios().getReturnOnInvestments()){
	        		return_on_investments = fr.getProfitabilityRatios().getReturnOnInvestments();
	        	}
	        }

            for(int i = 0; i<return_investList.size(); i++){
                for(int j = i+1; j<return_investList.size(); j++){                    	
                	if(return_investList.get(i) <= Float.parseFloat(return_on_investments) && Float.parseFloat(return_on_investments) <= return_investList.get(j)){

                		return_on_investments_score = Float.parseFloat(String.valueOf( prop17.get(String.valueOf(return_investList.get(j))) ));
                		break;
                	}
                }
            }

	        
            for(int i = 0; i<return_assetList.size(); i++){
                for(int j = i+1; j<return_assetList.size(); j++){                    	
                	if(return_assetList.get(i) <= Float.parseFloat(return_on_assets) && Float.parseFloat(return_on_assets) <= return_assetList.get(j)){

                		return_on_assets_score = Float.parseFloat(String.valueOf( prop18.get(String.valueOf(return_assetList.get(j))) ));
                		break;
                	}
                }
            }
            
            builder.append(""+"|"+"Profitability"+"|"+"Return on Total Assets"+"|"+return_on_assets);
            builder.append(System.getProperty("line.separator"));
            
            builder.append(""+"|"+""+"|"+"Return on Investments"+"|"+return_on_investments);
            builder.append(System.getProperty("line.separator"));
            
			System.out.println(""+"|"+"Profitability"+"|"+"Return on Total Assets"+"|"+return_on_assets);//value
			System.out.println(""+"|"+""+"|"+"Return on Investments"+"|"+return_on_investments);//value

            List<SnapshotType> list_Balance_Sheet  = com.getBalanceSheet().getSnapshotType();
            Iterator<SnapshotType> it_Balance_Sheet = list_Balance_Sheet.iterator();
            Double short_term_borrowings = 0.0;
            Double long_term_borrowings = 0.0;
            Double shortterm_netincome = 0.0;
            Double longterm_netincome = 0.0;
            float shortterm_netincome_score =0 ;
            float longterm_netincome_score =0 ;
            //parameters required for total assets against Scale of Operations in quantitative
            Double fixed_assets = 0.0;
            Double inventories = 0.0;
            Double long_term_loans_and_advances = 0.0;
            Double trade_receivables =0.0 ;
            Double cash_and_bank_bal = 0.0;
            Double short_term_loans_and_advances = 0.0;
            while(it_Balance_Sheet.hasNext()){
            	SnapshotType s = it_Balance_Sheet.next();
            	
            	if(null != s.getShortTermBorrowings() && !(s.getShortTermBorrowings().equals(""))){
            		short_term_borrowings = Double.parseDouble(s.getShortTermBorrowings());
            	}
            	if(null != s.getLongTermBorrowings() && !(s.getLongTermBorrowings().equals(""))){
            		long_term_borrowings = Double.parseDouble(s.getLongTermBorrowings());
            	}
            	//parameters required for total assets against Scale of Operations in quantitative
            	if(null != s.getFixedAssets() && !(s.getFixedAssets().equals(""))){
            		fixed_assets = Double.parseDouble(s.getFixedAssets());
            	}
            	if(null != s.getInventories() && !(s.getInventories().equals(""))){
            		inventories = Double.parseDouble(s.getInventories());
            	}
            	if(null != s.getLongTermLoansAndAdvances() && !(s.getLongTermLoansAndAdvances().equals(""))){
            		long_term_loans_and_advances = Double.parseDouble(s.getLongTermLoansAndAdvances());
            	}
            	if(null != s.getTradeReceivables() && !(s.getTradeReceivables().equals(""))){
            		trade_receivables = Double.parseDouble(s.getTradeReceivables());
            	}
            	if(null != s.getCashAndBankBalances() && !(s.getCashAndBankBalances().equals(""))){
            		cash_and_bank_bal = Double.parseDouble(s.getCashAndBankBalances());
            	}
            	if(null != s.getShortTermLoansAndAdvances() && !(s.getShortTermLoansAndAdvances().equals(""))){
            		short_term_loans_and_advances = Double.parseDouble(s.getShortTermLoansAndAdvances());
            	}
            }

            if(short_term_borrowings!=0)
            {
            	if(!(net_income <= 0))
            	{
            		shortterm_netincome = (short_term_borrowings/net_income)*100;
            		builder.append(""+"|"+"Known Liabilities"+"|"+"(Total short term borrowing/net income)*100"+"|"+shortterm_netincome);
            	    builder.append(System.getProperty("line.separator"));
            	    
            		System.out.println(""+"|"+"Known Liabilities"+"|"+"(Total short term borrowing/net income)*100"+"|"+shortterm_netincome);	
            	}else{
            		builder.append(""+"|"+"Known Liabilities"+"|"+"(Total short term borrowing/net income)*100"+"|"+"-9999");
            		builder.append(System.getProperty("line.separator"));
            		
            		System.out.println(""+"|"+"Known Liabilities"+"|"+"(Total short term borrowing/net income)*100"+"|"+"-9999");
            	}
            }else{
            	builder.append(""+"|"+"Known Liabilities"+"|"+"(Total short term borrowing/net income)*100"+"|"+"0");
            	builder.append(System.getProperty("line.separator"));
            	
        		System.out.println(""+"|"+"Known Liabilities"+"|"+"(Total short term borrowing/net income)*100"+"|"+"0");
            }
            
           if(shortterm_netincome==0){
        	   shortterm_netincome_score = 100;
           }else{
               if(Float.parseFloat(String.valueOf(Math.round(shortterm_netincome))) >= short_term_borrowList.get(10)){
               	shortterm_netincome_score = 10;
               }else{
                   for(int i = 0; i<short_term_borrowList.size(); i++){
                       for(int j = i+1; j<short_term_borrowList.size(); j++){                    	
                       	if(short_term_borrowList.get(i) <= Float.parseFloat(String.valueOf(Math.round(shortterm_netincome))) && Float.parseFloat(String.valueOf(Math.round(shortterm_netincome))) <= short_term_borrowList.get(j)){

                       	//	System.out.println(Float.parseFloat(String.valueOf(Math.round(shortterm_netincome))));
//                       		String key = String.valueOf(short_term_borrowList.get(j));
//                       		String value = (String) prop20.get(key);
//                       		
//                       		System.out.println("Key - "+key+" value -"+value);
                       		
                       		shortterm_netincome_score = Float.parseFloat(String.valueOf( prop20.get(String.valueOf(short_term_borrowList.get(j))) ));
                       		break;
                       	}
                       }
                   }                	
               }            	   
           }
            
            if(long_term_borrowings!=0)
            {
            	if(!(net_income <= 0))
            	{
            		longterm_netincome = (long_term_borrowings/net_income)*100;
            		builder.append(""+"|"+""+"|"+"(Total long term borrowing/net income)*100"+"|"+longterm_netincome);
            		builder.append(System.getProperty("line.separator"));
            		
            		System.out.println(""+"|"+""+"|"+"(Total long term borrowing/net income)*100"+"|"+longterm_netincome);
            	}else{
            		builder.append(""+"|"+""+"|"+"(Total long term borrowing/net income)*100"+"|"+"-9999");
            		builder.append(System.getProperty("line.separator"));
            		
            		System.out.println(""+"|"+""+"|"+"(Total long term borrowing/net income)*100"+"|"+"-9999");
            	}
            	
            }else{
            	builder.append(""+"|"+""+"|"+"(Total long term borrowing/net income)*100"+"|"+"0");
            	builder.append(System.getProperty("line.separator"));
            	
            	System.out.println(""+"|"+""+"|"+"(Total long term borrowing/net income)*100"+"|"+"0");	
            }
            
            
            if(longterm_netincome==0){//longterm_netincome==0 means user input is nothing.
            	longterm_netincome_score = 100;
            }else{
            	if(Float.parseFloat(String.valueOf(Math.round(longterm_netincome))) >= long_term_borrowList.get(10)){
            		longterm_netincome_score = 10;
            	}else{
                    for(int i = 0; i<long_term_borrowList.size(); i++){
                        for(int j = i+1; j<long_term_borrowList.size(); j++){                    	
                        	if(long_term_borrowList.get(i) <= Float.parseFloat(String.valueOf(Math.round(longterm_netincome))) && Float.parseFloat(String.valueOf(Math.round(longterm_netincome))) <= long_term_borrowList.get(j)){
    	
//                        		String key = String.valueOf(long_term_borrowList.get(j));
//                        		String value = (String) prop19.get(key);
//                        		
//                        		System.out.println("Key - "+key+" value -"+value);

                        		longterm_netincome_score = Float.parseFloat(String.valueOf( prop19.get(String.valueOf(long_term_borrowList.get(j))) ));
                        		break;
                        	}
                        }
                    }                	
            		
            	}
            }
                            
            if(Float.parseFloat(String.valueOf(fixed_assets1)) >= net_fixedList.get(10)){
        		fixed_assets1_score = Float.parseFloat(String.valueOf( prop12.get(String.valueOf(net_fixedList.get(10))) ));
            }else{
                for(int i = 0; i<net_fixedList.size(); i++){
                    for(int j = i+1; j<net_fixedList.size(); j++){                    	
                    	if(net_fixedList.get(i) <= Float.parseFloat(String.valueOf(fixed_assets1)) && Float.parseFloat(String.valueOf(fixed_assets1)) <= net_fixedList.get(j)){

                    		fixed_assets1_score = Float.parseFloat(String.valueOf( prop12.get(String.valueOf(net_fixedList.get(j))) ));
                    		break;
                    	}
                    }
                }                	
            }

//            System.out.println(real_estateList.toString());
//            if(Float.parseFloat(String.valueOf(fixed_assets2)) >= real_estateList.get(10)){
//        		fixed_assets2_score = Float.parseFloat(String.valueOf( prop16.get(String.valueOf(real_estateList.get(10))) ));
//            }else{
//                for(int i = 0; i<real_estateList.size(); i++){
//                    for(int j = i+1; j<real_estateList.size(); j++){                    	
//                    	if(real_estateList.get(i) <= Float.parseFloat(String.valueOf(fixed_assets2)) && Float.parseFloat(String.valueOf(fixed_assets2)) <= real_estateList.get(j)){
//
//                    		fixed_assets2_score = Float.parseFloat(String.valueOf( prop16.get(String.valueOf(real_estateList.get(j))) ));
//                    		break;
//                    	}
//                    }
//                }                	
//            }      ------------- As Land values Does not come in Zauba Reports We don not calculate Real Estate Value paramtere here------------

            builder.append(""+"|"+"Fixed Assets"+"|"+"(Net Fixed Asset/Net worth)"+"|"+fixed_assets1);
            builder.append(System.getProperty("line.separator"));
            
            builder.append(""+"|"+""+"|"+"(Real Estate value/Total Assets)"+"|"+fixed_assets2);
            builder.append(System.getProperty("line.separator"));
            
    		System.out.println(""+"|"+"Fixed Assets"+"|"+"(Net Fixed Asset/Net worth)"+"|"+fixed_assets1);
    		System.out.println(""+"|"+""+"|"+"(Real Estate value/Total Assets)"+"|"+fixed_assets2);//assigned NA above already
    		
    		builder.append("Qualitative"+"|"+"Scale of Operations"+"|"+"Total Sales"+"|"+Math.round(Double.parseDouble(annual_turnover))/1000);
    		builder.append(System.getProperty("line.separator"));
    		
    		System.out.println("Qualitative"+"|"+"Scale of Operations"+"|"+"Total Sales"+"|"+Math.round(Double.parseDouble(annual_turnover))/1000);
    		Double total_assets =  fixed_assets + inventories + long_term_loans_and_advances + trade_receivables + cash_and_bank_bal + short_term_loans_and_advances;
    		if(total_assets!=0){
    			builder.append(""+"|"+""+"|"+"Total Assets"+"|"+Math.round(total_assets)/1000);
    			builder.append(System.getProperty("line.separator"));
    			
    			System.out.println(""+"|"+""+"|"+"Total Assets"+"|"+Math.round(total_assets)/1000);	
    		}else{
    			builder.append(""+"|"+""+"|"+"Total Assets"+"|"+"0");
    			builder.append(System.getProperty("line.separator"));
    			
    			System.out.println(""+"|"+""+"|"+"Total Assets"+"|"+"0");
    		}
    		
    		int employee_no = 0;
    		float employee_score = 0;
    		if(null != com.getCompanyProfile().getEmploymentDetails().getNoOfEmployees() && !(com.getCompanyProfile().getEmploymentDetails().getNoOfEmployees().equals(""))){
    			employee_no = Integer.parseInt(com.getCompanyProfile().getEmploymentDetails().getNoOfEmployees());	
    		}
            if(employee_no!=0)
            {
            	builder.append(""+"|"+""+"|"+"No of Employees"+"|"+employee_no);
            	builder.append(System.getProperty("line.separator"));
            	
            	System.out.println(""+"|"+""+"|"+"No of Employees"+"|"+employee_no);
            	
                for(int i=0; i<employeesList.size(); i++){
                    for(int j=i+1; j<employeesList.size(); j++){
                    	if(employeesList.get(i)<= employee_no && employee_no <=employeesList.get(j)){
                    		employee_score = Float.parseFloat( String.valueOf(prop13.get(String.valueOf(employeesList.get(j))) ));
                    		break;
                    	}
                    }                	
                }
            }
    		
            float ownership_of_directors_score = 50;
            float ownership_of_family_score = 50;
            
            builder.append(""+"|"+"Ownership Structure"+"|"+"% Ownership of Directors*100"+"|"+"NA");
            builder.append(System.getProperty("line.separator"));
            
            builder.append(""+"|"+""+"|"+"% Ownership of Family*100"+"|"+"NA");
            builder.append(System.getProperty("line.separator"));
            
    		System.out.println(""+"|"+"Ownership Structure"+"|"+"% Ownership of Directors*100"+"|"+"NA");//empty value
    		System.out.println(""+"|"+""+"|"+"% Ownership of Family*100"+"|"+"NA");//empty value
            
    		
            List<KeyManagerialPersonType> list = com.getKeyManagerialPersons().getKeyManagerialPerson();
            Iterator<KeyManagerialPersonType> it = list.iterator();

            ArrayList<Integer> array = new ArrayList<Integer>();
            while(it.hasNext()){
            	KeyManagerialPersonType key = it.next();
            	
            	if(null != key.getDateOfAppointment()){                		
            		array.add(key.getDateOfAppointment().getYear());                		
            	}
            }

            int current_year = Calendar.getInstance().get(Calendar.YEAR);
            
        	int min = array.get(0);

        	if(!(array.isEmpty())){
        		for(Integer i: array) {
        		    if(i < min) min = i;
        		}
        	}


        	float years_of_experiance_score = 0;
        	float education_directors_score = 50;

        	for(int i=0; i<years_directorsList.size(); i++){
            	for(int j=i+1; j<years_directorsList.size(); j++){
            		if(years_directorsList.get(i)<=(current_year - min) && (current_year - min)<=years_directorsList.get(j)){
            			years_of_experiance_score = Integer.parseInt( (String) prop23.get(String.valueOf(years_directorsList.get(j))) );
            			break;
            		}
            	}            		
        	}
        	
        	builder.append(""+"|"+"Management Quality"+"|"+"Maximum of Years of Experience of directors"+"|"+(current_year - min));
        	builder.append(System.getProperty("line.separator"));
        	
        	builder.append(""+"|"+""+"|"+"Maximum Education Qualification of Directors"+"|"+"NA");
        	builder.append(System.getProperty("line.separator"));
        	
    		System.out.println(""+"|"+"Management Quality"+"|"+"Maximum of Years of Experience of directors"+"|"+(current_year - min));
    		System.out.println(""+"|"+""+"|"+"Maximum Education Qualification of Directors"+"|"+"NA");//empty value

    		
    		float type_of_company_score = 0;
    		String type_of_company = com.getCompanyProfile().getTypeOfCompany();
    		if(type_of_company!=null && !(type_of_company.equals("")))
    		{
    			builder.append(""+"|"+"Legal Status & family involvement"+"|"+"Type of Company"+"|"+type_of_company);
    			builder.append(System.getProperty("line.separator"));
    			
        		System.out.println(""+"|"+"Legal Status & family involvement"+"|"+"Type of Company"+"|"+type_of_company);  
                       		
        		for(int i=0; i<type_companyList.size(); i++){
            		for(int j=i+1; j<type_companyList.size(); j++){
            			if(type_companyList.contains(type_of_company)){
            				type_of_company_score = Float.parseFloat( String.valueOf(prop21.get(type_of_company)) );
            			}
            		}            			
        		}
        		
        		
    		}else{
    			builder.append(""+"|"+"Legal Status & family involvement"+"|"+"Type of Company"+"|"+"NA");
    			builder.append(System.getProperty("line.separator"));
    			
        		System.out.println(""+"|"+"Legal Status & family involvement"+"|"+"Type of Company"+"|"+"NA");//empty value
    		}
    		
    		float family_shares_encumbered_score = 50;
    		builder.append(""+"|"+""+"|"+"(% of Family shares Encumbered/pledged shares)*100"+"|"+"NA");
    		builder.append(System.getProperty("line.separator"));
    		
    		System.out.println(""+"|"+""+"|"+"(% of Family shares Encumbered/pledged shares)*100"+"|"+"NA");//empty value
    		
    		
        	float years_of_business_score = 0;
        	float export_import_score = 0;
        	float banking_relation_score = 0;
    		
        	for(int i=0; i<years_businessList.size(); i++){
            	for(int j=i+1; j<years_businessList.size(); j++){
            		if(years_businessList.get(i)<=(current_year - min) && (current_year - min)<=years_businessList.get(j)){
            			years_of_business_score = Integer.parseInt( (String) prop23.get(String.valueOf(years_businessList.get(j))) );
            			break;
            		}
            	}            		
        	}
    		
    		builder.append(""+"|"+"Business History & References"+"|"+"Years of Business"+"|"+(current_year - min));
    		builder.append(System.getProperty("line.separator"));
    		
    		builder.append(""+"|"+""+"|"+"Export Import History"+"|"+"No");
    		builder.append(System.getProperty("line.separator"));
    		
    		builder.append(""+"|"+""+"|"+"Banking relationship"+"|"+"No");
    		builder.append(System.getProperty("line.separator"));
    		
    		System.out.println(""+"|"+"Business History & References"+"|"+"Years of Business"+"|"+(current_year - min));
    		System.out.println(""+"|"+""+"|"+"Export Import History"+"|"+"No");
    		System.out.println(""+"|"+""+"|"+"Banking relationship"+"|"+"No");
    		
    		
    		
    		
    		//======================= Litigation Code Phase=========================//
    		
    		
    		
    		
    		builder.append(""+"|"+"Litigation"+"|"+"Defendent/Litigation Party"+"|"+"NA");
    		builder.append(System.getProperty("line.separator"));
    		
    		System.out.println(""+"|"+"Litigation"+"|"+"Defendent/Litigation Party"+"|"+"NA");
    		
    		
    		
    		
    		
    		//======================= Litigation Code Phase=========================//
    		
    		
    		
    		
    		
    		List<ProductOrServiceType> list_product_type = com.getPrincipalProductOrServices().getProductOrService();
            Iterator<ProductOrServiceType> it_product_type = list_product_type.iterator();
            String industry_type = "";
            float industry_type_score = 0;
            while(it_product_type.hasNext()){
            	ProductOrServiceType pr = it_product_type.next();
            	
            	if(null != pr.getProductOrServiceDescription() && !(pr.getProductOrServiceDescription().equals(""))){
            		industry_type = pr.getProductOrServiceDescription();
            	}
            }
            
    		if(prop9.containsKey(industry_type)){
    			industry_type_score = Float.parseFloat(String.valueOf(prop9.get(industry_type)));
    		}
            
            
            float industry_risk_score = 50;
            
            builder.append("Industry"+"|"+""+"|"+"Industry Type"+"|"+industry_type);
            builder.append(System.getProperty("line.separator"));
            
            builder.append(""+"|"+""+"|"+"Industry Ranking"+"|"+"NA");
            builder.append(System.getProperty("line.separator"));
            
    		System.out.println("Industry"+"|"+""+"|"+"Industry Type"+"|"+industry_type);
    		System.out.println(""+"|"+""+"|"+"Industry Ranking"+"|"+"NA");//empty value

    		double log_sales_asset = (Double.parseDouble(annual_turnover)/total_assets);
    		
    		float log_sales_asset_prev_score = Float.parseFloat(String.valueOf(Math.log(log_sales_asset)*100));
//    		System.out.println(log_sales_asset_prev_score);
    		float log_sales_asset_score = 0;
    
    		for(int i=0; i<logList.size(); i++){
        		for(int j=i+1; j<logList.size(); j++){
        			if(logList.get(i)<= Math.round(log_sales_asset_prev_score) && Math.round(log_sales_asset_prev_score) <= logList.get(j)){
        				log_sales_asset_score = Float.parseFloat( String.valueOf(prop24.get(String.valueOf(logList.get(j))) ));
        				break;
        			}
        		}        			
    		}
    
    		
//scores -----------------------------------------//        		
    		System.out.println("-------Scores------");
            System.out.println("1.Debt score "+debt_ratio_score);
            System.out.println("2.Debt Eqty "+debt_equity_ratio_score);
	        System.out.println("3.Current Ratio score "+current_ratio_score);
	        System.out.println("4.coverage_ratio_score "+coverage_ratio_score);
	        System.out.println("5.Asset "+asset_turnover_score);
	        System.out.println("6.Invetry "+inventory_turover_score);
	        System.out.println("7.Return On Investements "+return_on_investments_score);
	        System.out.println("8.Return on assets "+return_on_assets_score);
            System.out.println("9.Shortterm_netincome "+shortterm_netincome_score);
            System.out.println("10.Longterm_netincome "+longterm_netincome_score);
            System.out.println("11.net fixed asstets "+fixed_assets1_score);
            System.out.println("12.Real Estate value(Always) "+fixed_assets2_score);
            System.out.println("13.Ownership of Directors score "+ownership_of_directors_score);
            System.out.println("14.Ownership of Family score "+ownership_of_family_score);
            System.out.println("15.Years of experiance of directors score "+years_of_experiance_score);
            System.out.println("16.Education of directors score "+education_directors_score);
            System.out.println("17.Type of company score "+type_of_company_score);
            System.out.println("18.Famil shares encumbered score "+family_shares_encumbered_score);
            System.out.println("19.Years Of business score "+years_of_business_score);
            System.out.println("20.Export import score "+export_import_score);
            System.out.println("21.Banking relation score "+banking_relation_score);
            System.out.println("22.Log(Sales/Total Assets) score ");
            System.out.println("23.Employee score "+employee_score);
            System.out.println("24.Defendent/Litogation score ");
            System.out.println("25.Industry type score "+industry_type_score);
            System.out.println("26.Industry risk rating score "+industry_risk_score);
    		System.out.println("27.Log score "+log_sales_asset_score);

            System.out.println("-------Scores------");
            
            
            float debt_ratio_weighted = (float) (debt_ratio_score*0.03);
            float debt_equity_ratio_weighted = (float) (debt_equity_ratio_score*0.03);
            float current_ratio_weighted = (float) (current_ratio_score*0.06);
            float coverage_ratio_weighted = (float) (coverage_ratio_score*0.03);
            float asset_turnover_wieghted = (float) (asset_turnover_score*0.02);
            float inventory_turover_weighted = (float) (inventory_turover_score*0.02);
            float return_on_investments_weighted = (float) (return_on_investments_score*0.03);
            float return_on_assets_weighted = (float) (return_on_assets_score*0.03);
            float shortterm_netincome_weighted = (float) (shortterm_netincome_score*0.05);
            float longterm_netincome_weigghted = (float) (longterm_netincome_score*0.05);
            float fixed_assets1_weighted  = (float) (fixed_assets1_score*0.025);
            float fixed_assets2_weighted  = (float) (fixed_assets2_score*0.025);

            
            
            float quantitative_score = Math.round(((debt_ratio_weighted + debt_equity_ratio_weighted +current_ratio_weighted + coverage_ratio_weighted + asset_turnover_wieghted + inventory_turover_weighted
            		    + return_on_investments_weighted +return_on_assets_weighted +shortterm_netincome_weighted +longterm_netincome_weigghted +fixed_assets1_weighted +fixed_assets2_weighted)/40)*100);

            builder.append(System.getProperty("line.separator"));
            builder.append("Quantitative Score"+"|"+quantitative_score);
            builder.append(System.getProperty("line.separator"));
            
            System.out.println("Quantitative Score"+"|"+quantitative_score);
            
            float ownership_of_directors_weighted = (float) (ownership_of_directors_score*0.03);
            float ownership_of_family_weighted = (float) (ownership_of_family_score*0.03);
            float years_of_experiance_weighted = (float) (years_of_experiance_score*0.05);
            float education_directors_weighted = (float) (education_directors_score*0.05);
            float type_of_company_weighted = (float) (type_of_company_score*0.06);
            float family_shares_encumbered_weighted = (float) (family_shares_encumbered_score*0.05);
            float years_of_business_weighted = (float) (years_of_business_score*0.03);
            float export_import_weighted = (float) (export_import_score*0.03);
            float banking_relation_weighted = (float) (banking_relation_score*0.03);
            float log_sales_asset_weighted = (float) (log_sales_asset_score*0.06);
            float employee_weighted = (float) (employee_score*0.03);
            
            float industry_type_weighted = (float) (industry_type_score*0.05);
            float industry_risk_weighted = (float) (industry_risk_score*0.05);
            
            Float total_weighted_score = (debt_ratio_weighted+debt_equity_ratio_weighted+current_ratio_weighted+coverage_ratio_weighted+asset_turnover_wieghted
            		+inventory_turover_weighted+return_on_investments_weighted+return_on_assets_weighted+shortterm_netincome_weighted+longterm_netincome_weigghted
            		+fixed_assets1_weighted+fixed_assets2_weighted+ownership_of_directors_weighted+ownership_of_family_weighted+years_of_experiance_weighted
            		+education_directors_weighted+type_of_company_weighted+family_shares_encumbered_weighted+years_of_business_weighted+export_import_weighted
            		+banking_relation_weighted+log_sales_asset_weighted+employee_weighted+industry_type_weighted+industry_risk_weighted);
            
            float qualitative_score = Math.round(((ownership_of_directors_weighted+ownership_of_family_weighted+years_of_experiance_weighted+education_directors_weighted
            		+type_of_company_weighted+family_shares_encumbered_weighted+years_of_business_weighted+export_import_weighted+banking_relation_weighted+banking_relation_weighted
            		+log_sales_asset_weighted+employee_weighted)/50)*100);
            
            builder.append("Qualitative Score"+"|"+qualitative_score);
            builder.append(System.getProperty("line.separator"));
            
            System.out.println("Qualitative Score"+"|"+qualitative_score);
            
            
            float industry_score = Math.round(((industry_type_weighted+industry_risk_weighted)/10)*100); 
            
            builder.append("Idustry Score"+"|"+industry_score);
            builder.append(System.getProperty("line.separator"));
            
            System.out.println("Idustry Score"+"|"+industry_score);
            
            builder.append(System.getProperty("line.separator"));
            builder.append("Total Score"+"|"+total_weighted_score);
            builder.append(System.getProperty("line.separator"));
            
            System.out.println("Total Score"+"|"+total_weighted_score);
            
            //write the file=================
          /*  BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter("D://EIR Docs//output//"+"FileName"+".csv"));//source.getName()
            bw.write(builder.toString());
        
            bw.close();*/
            
            Map< Float, String> scoreMap = new HashMap<Float, String>();
            scoreMap.put(total_weighted_score, builder.toString());
            
            System.out.println("Done");
    		
            return scoreMap;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    
		return null;
	}
	
	

}
