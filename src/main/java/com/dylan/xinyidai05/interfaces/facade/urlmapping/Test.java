package com.dylan.xinyidai05.interfaces.facade.urlmapping;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baoxiang
 * @create 2020-06-22 14:49
 */
public class Test {

    public static void main(String[] args) {
        String fileNmae = "x.xlsx";


        Map<String, List<String>> map = new HashMap<>();
        map = JSONObject.parseObject(data(),map.getClass());

        Map<Integer, Integer> columnMap = new HashMap<>();
        columnMap.put(0, map.keySet().stream().map(String::length).max(Integer::compareTo).orElse(10));
        columnMap.put(1, map.values().stream().flatMap(Collection::stream).map(String::length).max(Integer::compareTo).orElse(20));

        List<List<String>> head= new ArrayList<>();
        head.add(Collections.singletonList("类名"));
        head.add(Collections.singletonList("地址"));

        ExcelWriter build = EasyExcel.write(fileNmae, Map.class).build();
        WriteSheet sheet = EasyExcel.writerSheet("模板")
                .head(head)
                .registerWriteHandler(new ColumnStrategy(columnMap)).build();

        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger mergeStart = new AtomicInteger(1);

        map.forEach((k,v)->{
            int i = atomicInteger.incrementAndGet();
            WriteTable table = null;
            if (v.size()>1){
                table= EasyExcel.writerTable(i).needHead(false)
                        .registerWriteHandler(new MergeStrategy(mergeStart.get(),mergeStart.get()+v.size(),0,0)).build();
            }else{
                table= EasyExcel.writerTable(i).needHead(false).build();
            }
            List<List<String>> data = new ArrayList<>();
            v.forEach(x->{
                List<String> temp = new ArrayList<>();
                temp.add(k);
                temp.add(x.replaceAll("\\[","").replaceAll("]",""));
                data.add(temp);
            });
            build.write(data,sheet,table);
            mergeStart.getAndAdd(v.size());
        });
        build.finish();
    }

    public static String data(){
        return "{\n" +
                "  \"appWithdrawalController\": [\n" +
                "    \"[/api/v1/insuring/repeal]\"\n" +
                "  ],\n" +
                "  \"customerInfoController\": [\n" +
                "    \"[/api/v1/customer/qryCustomerInfo]\"\n" +
                "  ],\n" +
                "  \"signPlatformController\": [\n" +
                "    \"[/api/v1/signPlatform/signQry]\"\n" +
                "  ],\n" +
                "  \"payStateInquireController\": [\n" +
                "    \"[/api/v1/queryPayStatus1]\",\n" +
                "    \"[/api/v1/paystate]\",\n" +
                "    \"[/api/v1/queryPayStatus]\"\n" +
                "  ],\n" +
                "  \"recheckOrderController\": [\n" +
                "    \"[/api/v1/insuring/privateRecheckOrder]\",\n" +
                "    \"[/api/v1/insuring/selectRecheckOrder]\",\n" +
                "    \"[/api/v1/insuring/checkRecheckOrder]\",\n" +
                "    \"[/api/v1/insuring/manualUnderwriting]\"\n" +
                "  ],\n" +
                "  \"apiResourceController\": [\n" +
                "    \"[/swagger-resources/configuration/ui]\",\n" +
                "    \"[/swagger-resources]\",\n" +
                "    \"[/swagger-resources/configuration/security]\"\n" +
                "  ],\n" +
                "  \"commonController\": [\n" +
                "    \"[/api/v1/updateState]\",\n" +
                "    \"[/api/v1/dataTemporaryStorage]\",\n" +
                "    \"[/api/v1/queryManagementAgencyDetail]\",\n" +
                "    \"[/api/v1/queryManagementAgency]\",\n" +
                "    \"[/api/v1/queryConstantInformation]\",\n" +
                "    \"[/api/v1/temporaryStorageCheck]\",\n" +
                "    \"[/api/v1/customerIdentification]\",\n" +
                "    \"[/api/v1/queryAgentAgency]\",\n" +
                "    \"[/api/v1/saveData]\",\n" +
                "    \"[/api/v1/findCode]\"\n" +
                "  ],\n" +
                "  \"sendSMSController\": [\n" +
                "    \"[/api/v1/sendSMS/send]\"\n" +
                "  ],\n" +
                "  \"valuationManageController\": [\n" +
                "    \"[/api/v1/unitPriceManageTakeEffect]\",\n" +
                "    \"[/api/v1/unitPriceManageQuery]\"\n" +
                "  ],\n" +
                "  \"missionReassingInputController\": [\n" +
                "    \"[/api/v1/updateDoubleEntQuality]\",\n" +
                "    \"[/api/v1/lduser]\",\n" +
                "    \"[/api/v1/DoubleEntQuality]\"\n" +
                "  ],\n" +
                "  \"ldComController\": [\n" +
                "    \"[/api/v1/ldcon/spotCheck]\",\n" +
                "    \"[/api/v1/ldcon/selectcComCode]\",\n" +
                "    \"[/api/v1/ldcon/selectRiskCode]\"\n" +
                "  ],\n" +
                "  \"tempFeeWithdrawController\": [\n" +
                "    \"[/api/v1/TempFeeWithdraw/print]\",\n" +
                "    \"[/api/v1/TempFeeWithdraw/withdraw]\",\n" +
                "    \"[/api/v1/TempFeeWithdraw/tempFeeWithdrawQry]\"\n" +
                "  ],\n" +
                "  \"insuringWithdrawController\": [\n" +
                "    \"[/api/v1/insuringwithdraw/insurewithdraw]\"\n" +
                "  ],\n" +
                "  \"reconciliationController\": [\n" +
                "    \"[/api/v1/reconciliation/queryApplicationFormDetail]\",\n" +
                "    \"[/api/v1/reconciliation/findCustomerNoByContno]\"\n" +
                "  ],\n" +
                "  \"stateSelectController\": [\n" +
                "    \"[/api/v1/selectState]\",\n" +
                "    \"[/api/v1/detailSelect]\"\n" +
                "  ],\n" +
                "  \"agentController\": [\n" +
                "    \"[/api/v1/queryAgentInformation]\"\n" +
                "  ],\n" +
                "  \"taskController\": [\n" +
                "    \"[/api/v1/task/stateQuery]\",\n" +
                "    \"[/api/v1/task/infoQuery]\",\n" +
                "    \"[/api/v1/task/completeTest]\",\n" +
                "    \"[/api/v1/task/query]\",\n" +
                "    \"[/api/v1/task/complete]\",\n" +
                "    \"[/api/v1/task/processInstances]\"\n" +
                "  ],\n" +
                "  \"doubleEntryQualityController\": [\n" +
                "    \"[/api/v1/doubleEntrySpotCheckResultsEntry]\",\n" +
                "    \"[/api/v1/doubleFailedSamplingQuality]\",\n" +
                "    \"[/api/v1/doubleEntryResultQuality]\",\n" +
                "    \"[/api/v1/doubleEntrySpotCheckFiguredOut]\",\n" +
                "    \"[/api/v1/doubleEntrySpotCheckDisposeQuery]\",\n" +
                "    \"[/api/v1/doubleSpotCheckQuality]\",\n" +
                "    \"[/api/v1/doubleEntrySpotCheckDisposeApplyFor]\",\n" +
                "    \"[/api/v1/doubleEntryQualityTestingResultsEntry]\",\n" +
                "    \"[/api/v1/doubleEntryQualityTestingDisposeQuery]\",\n" +
                "    \"[/api/v1/exportDoubleSpotCheckQualityExcel]\",\n" +
                "    \"[/api/v1/doubleEntryQualityTestingDisposeApplyFor]\",\n" +
                "    \"[/api/v1/doubleEntryQualityTestingFiguredOut]\",\n" +
                "    \"[/api/v1/doubleEntQualitys]\",\n" +
                "    \"[/api/v1/doubleRecord]\",\n" +
                "    \"[/api/v1/doubleEntQuaryList]\",\n" +
                "    \"[/api/v1/doubleEntryQualityExportExcel]\",\n" +
                "    \"[/api/v1/doubleEntryQualityTestingHistoryQuery]\",\n" +
                "    \"[/api/v1/doubleEntryQualityListExportExcel]\",\n" +
                "    \"[/api/v1/exportDoubleFailedSamplingQualityExcel]\",\n" +
                "    \"[/api/v1/doubleEntryQuality]\"\n" +
                "  ],\n" +
                "  \"issueController\": [\n" +
                "    \"[/api/v1/issue/queryIssueModify]\",\n" +
                "    \"[/api/v1/issue/deleteIssue]\",\n" +
                "    \"[/api/v1/issue/applyIssue]\",\n" +
                "    \"[/api/v1/issue/queryIssueDetail]\",\n" +
                "    \"[/api/v1/issue/queryIssue]\",\n" +
                "    \"[/api/v1/issue/replyIssueFinish]\",\n" +
                "    \"[/api/v1/issue/replyIssue]\",\n" +
                "    \"[/api/v1/issue/updateIssue]\",\n" +
                "    \"[/api/v1/issue/addIssue]\",\n" +
                "    \"[/api/v1/issue/qualifyIssue]\",\n" +
                "    \"[/api/v1/issue/queryIssueNodeInstance]\",\n" +
                "    \"[/api/v1/issue/queryCustomerInfo]\"\n" +
                "  ],\n" +
                "  \"pendingAutomaticUnderwritingController\": [\n" +
                "    \"[/api/v1/underwriting/automaticUnderwritingBatch]\",\n" +
                "    \"[/api/v1/underwriting/automaticUnderwritingApply]\",\n" +
                "    \"[/api/v1/underwriting/automaticUnderwritingQuery]\"\n" +
                "  ],\n" +
                "  \"workFlowNotePadController\": [\n" +
                "    \"[/api/v1/workFlowNotePadSave]\",\n" +
                "    \"[/api/v1/workFlowNotePadSearch]\"\n" +
                "  ],\n" +
                "  \"autoWithdrawalController\": [\n" +
                "    \"[/api/v1/insuring/revoke]\"\n" +
                "  ],\n" +
                "  \"customerController\": [\n" +
                "    \"[/api/v1/cust/feedback]\"\n" +
                "  ],\n" +
                "  \"signPolicyController\": [\n" +
                "    \"[/api/v1/signPolicy/querySignPolicy]\",\n" +
                "    \"[/api/v1/signPolicy/signPolicy]\"\n" +
                "  ],\n" +
                "  \"WGJStateQueryController\": [\n" +
                "    \"[/api/v1/wgj/contInfo]\",\n" +
                "    \"[/api/v1/wgj/contState]\"\n" +
                "  ],\n" +
                "  \"payApplyController\": [\n" +
                "    \"[/api/v1/pay]\",\n" +
                "    \"[/api/v1/goodStartSignAndIssuePolicy]\",\n" +
                "    \"[/api/v1/signAndIssuePolicy]\"\n" +
                "  ],\n" +
                "  \"insuranceDeleteController\": [\n" +
                "    \"[/api/v1/insuring/deleteApplicant]\",\n" +
                "    \"[/api/v1/insuring/deletePayInfo]\",\n" +
                "    \"[/api/v1/insuring/deleteProduct]\",\n" +
                "    \"[/api/v1/insuring/deleteInsured]\",\n" +
                "    \"[/api/v1/insuring/deleteAgentDisclosure]\",\n" +
                "    \"[/api/v1/insuring/deleteBeneficiary]\",\n" +
                "    \"[/api/v1/insuring/deleteApplicantDisclosure]\",\n" +
                "    \"[/api/v1/insuring/deleteInsuredDisclosure]\"\n" +
                "  ],\n" +
                "  \"doubleCheckQualityController\": [\n" +
                "    \"[/api/v1/doubleCheckRiskInfoDisplay]\",\n" +
                "    \"[/api/v1/doubleEntrySpotCheckResultDeal]\",\n" +
                "    \"[/api/v1/doubleCheckDisplayQuery]\",\n" +
                "    \"[/api/v1/doubleCheckInforApplyFor]\"\n" +
                "  ],\n" +
                "  \"insureQualityTestingController\": [\n" +
                "    \"[/api/v1/insureSpotCheckFalseSave]\",\n" +
                "    \"[/api/v1/insureSignatureQualityTestingQuery]\",\n" +
                "    \"[/api/v1/insureSignatureQualityTestingApply]\",\n" +
                "    \"[/api/v1/insureSignatureQualityTestingCheck]\",\n" +
                "    \"[/api/v1/insureSpotCheckFalseExportExcel]\",\n" +
                "    \"[/api/v1/insureQualityTestingBakCheck]\",\n" +
                "    \"[/api/v1/insureQualityTestBakQy]\",\n" +
                "    \"[/api/v1/insureSpotCheckQuery]\",\n" +
                "    \"[/api/v1/insureSpotCheckResultsEntry]\",\n" +
                "    \"[/api/v1/insureSpotCheckFalseQuery]\",\n" +
                "    \"[/api/v1/qualityPercentOfPassExcel]\",\n" +
                "    \"[/api/v1/insureQualityTestBakQyExcel]\",\n" +
                "    \"[/api/v1/insureQualityTestingList]\",\n" +
                "    \"[/api/v1/insureQualityTestingQuery]\",\n" +
                "    \"[/api/v1/insureQualityTestingFiguredOut]\",\n" +
                "    \"[/api/v1/insureSpotCheckFiguredOut]\",\n" +
                "    \"[/api/v1/samplingPercentOfPass]\",\n" +
                "    \"[/api/v1/insureQualityTestingResultsEntry]\",\n" +
                "    \"[/api/v1/insureQualityTestingApplyFor]\",\n" +
                "    \"[/api/v1/inspectionRuleDefinition]\",\n" +
                "    \"[/api/v1/insureSpotCheckApplyFor]\",\n" +
                "    \"[/api/v1/insureQualityTestingListExcel]\",\n" +
                "    \"[/api/v1/qualityTestingQueryProduct]\",\n" +
                "    \"[/api/v1/qualityTestingQueryBaseDetail]\",\n" +
                "    \"[/api/v1/qualityTestingPassing]\"\n" +
                "  ],\n" +
                "  \"policyReturnController\": [\n" +
                "    \"[/dorado/api/v1/policyReturn/policyReturnReceipt]\"\n" +
                "  ],\n" +
                "  \"underwritingPushController\": [\n" +
                "    \"[/api/v1/underwritingPush]\"\n" +
                "  ],\n" +
                "  \"policyStatusQueryController\": [\n" +
                "    \"[/api/{version}/insuring/selectstate]\"\n" +
                "  ],\n" +
                "  \"basicErrorController\": [\n" +
                "    \"[/error]\",\n" +
                "    \"[/error]\"\n" +
                "  ],\n" +
                "  \"urlCotroller\": [\n" +
                "    \"[/getAllUrlMapping]\"\n" +
                "  ],\n" +
                "  \"ESValidationController\": [\n" +
                "    \"[/api/v1/doctbworkflow/dealData]\"\n" +
                "  ],\n" +
                "  \"insureScheduleSelectController\": [\n" +
                "    \"[/api/v1/ScheduleSelect]\"\n" +
                "  ],\n" +
                "  \"insurancePreservationController\": [\n" +
                "    \"[/api/v1/preservate/insertOrUpdateApplicantDisclosures]\",\n" +
                "    \"[/api/v1/preservate/addInsured]\",\n" +
                "    \"[/api/v1/preservate/addPaymentinfo]\",\n" +
                "    \"[/api/v1/preservate/addApplicant]\",\n" +
                "    \"[/api/v1/preservate/addContract]\",\n" +
                "    \"[/api/v1/preservate/addSingleProduct]\",\n" +
                "    \"[/api/v1/preservate/addSingleInsured]\",\n" +
                "    \"[/api/v1/preservate/checkMainInsuranceExistence]\",\n" +
                "    \"[/api/v1/preservate/addSingleBeneficiary]\"\n" +
                "  ],\n" +
                "  \"insuringController\": [\n" +
                "    \"[/api/v1/insuring/test]\",\n" +
                "    \"[/api/v1/insuring/queryServiceOrder]\",\n" +
                "    \"[/api/v1/insuring/counterInsure]\",\n" +
                "    \"[/api/v1/insuring/addServiceOrder]\",\n" +
                "    \"[/api/v1/insuring/productInfoCheck]\",\n" +
                "    \"[/api/v1/insuring/insure]\",\n" +
                "    \"[/api/v1/insuring/onlineExternalInsurance]\",\n" +
                "    \"[/api/v1/insuring/applyServiceOrder]\"\n" +
                "  ]\n" +
                "}";
    }
}
