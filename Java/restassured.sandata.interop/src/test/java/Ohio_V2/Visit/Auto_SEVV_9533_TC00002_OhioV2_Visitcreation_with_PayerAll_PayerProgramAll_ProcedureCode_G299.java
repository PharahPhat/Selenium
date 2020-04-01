package Ohio_V2.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.VisitV2.UniqueJsonGeneratorVisit;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;


public class Auto_SEVV_9533_TC00002_OhioV2_Visitcreation_with_PayerAll_PayerProgramAll_ProcedureCode_G299 extends BaseTest {

    UniqueJsonGeneratorVisit GenerateUniqueParam = new UniqueJsonGeneratorVisit();
    Assertion_DbVerifier Assertion_DbVerifier = new Assertion_DbVerifier();

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_OHC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_OHC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_OHC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Aetna");
        jsonObject.put(globalVariables.PayerProgram, "OHC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_SPHH");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_SPHH");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Aetna");
        jsonObject.put(globalVariables.PayerProgram, "SPHH");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_SP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_SP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_SP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Aetna");
        jsonObject.put(globalVariables.PayerProgram, "SP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_DD() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_DD");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_DD");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Aetna");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_MyC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_MyC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_MyC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Aetna");
        jsonObject.put(globalVariables.PayerProgram, "MyC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Aetna_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Aetna");
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }


    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_OHC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_OHC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_OHC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Buckeye");
        jsonObject.put(globalVariables.PayerProgram, "OHC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_SPHH");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_SPHH");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Buckeye");
        jsonObject.put(globalVariables.PayerProgram, "SPHH");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_SP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_SP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_SP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Buckeye");
        jsonObject.put(globalVariables.PayerProgram, "SP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_DD() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_DD");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_DD");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Buckeye");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_MyC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_MyC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_MyC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Buckeye");
        jsonObject.put(globalVariables.PayerProgram, "MyC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Buckeye_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Buckeye");
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }


    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_OHC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_OHC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_OHC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "CareSource");
        jsonObject.put(globalVariables.PayerProgram, "OHC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_SPHH");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_SPHH");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "CareSource");
        jsonObject.put(globalVariables.PayerProgram, "SPHH");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_SP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_SP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_SP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "CareSource");
        jsonObject.put(globalVariables.PayerProgram, "SP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_DD() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_DD");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_DD");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "CareSource");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_MyC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_MyC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_MyC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "CareSource");
        jsonObject.put(globalVariables.PayerProgram, "MyC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_CareSource_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "CareSource");
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }


    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_OHC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_OHC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_OHC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "DODD");
        jsonObject.put(globalVariables.PayerProgram, "OHC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_SPHH");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_SPHH");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "DODD");
        jsonObject.put(globalVariables.PayerProgram, "SPHH");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_SP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_SP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_SP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "DODD");
        jsonObject.put(globalVariables.PayerProgram, "SP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_DD() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_DD");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_DD");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "DODD");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_MyC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_MyC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_MyC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "DODD");
        jsonObject.put(globalVariables.PayerProgram, "MyC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_DODD_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "DODD");
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }


    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_OHC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_OHC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_OHC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Molina");
        jsonObject.put(globalVariables.PayerProgram, "OHC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_SPHH");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_SPHH");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Molina");
        jsonObject.put(globalVariables.PayerProgram, "SPHH");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_SP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_SP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_SP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Molina");
        jsonObject.put(globalVariables.PayerProgram, "SP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_DD() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_DD");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_DD");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Molina");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_MyC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_MyC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_MyC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Molina");
        jsonObject.put(globalVariables.PayerProgram, "MyC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Molina_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Molina");
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }


    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_OHC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_OHC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_OHC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODA");
        jsonObject.put(globalVariables.PayerProgram, "OHC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_SPHH");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_SPHH");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODA");
        jsonObject.put(globalVariables.PayerProgram, "SPHH");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_SP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_SP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_SP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODA");
        jsonObject.put(globalVariables.PayerProgram, "SP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_DD() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_DD");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_DD");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODA");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_MyC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_MyC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_MyC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODA");
        jsonObject.put(globalVariables.PayerProgram, "MyC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODA_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODA");
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }


    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_OHC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_OHC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_OHC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODM");
        jsonObject.put(globalVariables.PayerProgram, "OHC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_SPHH");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_SPHH");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODM");
        jsonObject.put(globalVariables.PayerProgram, "SPHH");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProceLdureCode_G0299_Payer_ODM_PayerProgram_SP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_SP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_SP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODM");
        jsonObject.put(globalVariables.PayerProgram, "SP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_DD() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_DD");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_DD");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODM");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_MyC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_MyC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_MyC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODM");
        jsonObject.put(globalVariables.PayerProgram, "MyC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_ODM_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "ODM");
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }


    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_OHC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_OHC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_OHC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Paramount");
        jsonObject.put(globalVariables.PayerProgram, "OHC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_SPHH");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_SPHH");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Paramount");
        jsonObject.put(globalVariables.PayerProgram, "SPHH");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_SP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_SP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_SP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Paramount");
        jsonObject.put(globalVariables.PayerProgram, "SP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_DD() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_DD");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_DD");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Paramount");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_MyC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_MyC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_MyC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Paramount");
        jsonObject.put(globalVariables.PayerProgram, "MyC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Paramount_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "Paramount");
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }


    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_OHC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_OHC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_OHC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "UHC");
        jsonObject.put(globalVariables.PayerProgram, "OHC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_SPHH");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_SPHH");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "UHC");
        jsonObject.put(globalVariables.PayerProgram, "SPHH");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_SP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_SP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_SP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "UHC");
        jsonObject.put(globalVariables.PayerProgram, "SP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_DD() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_DD");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_DD");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "UHC");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_MyC() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_MyC");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_MyC");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "UHC");
        jsonObject.put(globalVariables.PayerProgram, "MyC");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "UHC");
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, jsonObject);
    }

    //Error message verification for payer, Program, ProcedureCode

    @Test(groups = {"All"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_DD_ProcedureCode_invalid() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_DD_ProcedureCode_invalid");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_DD_ProcedureCode_invalid");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put("ProcedureCode", CommonMethods.generateRandomStringOfFixLength(3));
        jsonObject.put(globalVariables.payer, "UHC");
        jsonObject.put(globalVariables.PayerProgram, "DD");

        JSONArray jsonArrayVisitCall = (JSONArray) jsonObject.get("Calls");
        JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
        jsonObjectVisitCall.put("ProcedureCode", CommonMethods.generateRandomStringOfFixLength(3));

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.errorProcedureCodeVisit);
    }

    @Test(groups = {"All","fixing"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_invalid() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_invalid");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_UHC_PayerProgram_invalid");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, "UHC");
        jsonObject.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(3));

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.payerProgramErrorVisit);


    }

    @Test(groups = {"All"})
    @AdditionalInfo(module = "OhioVisit")
    public void OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Invalid_PayerProgram_PP() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        // logger = extent.startTest("OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Invalid_PayerProgram_PP");
        logger.log(LogStatus.INFO, "OhioV2_Visitcreation_with_Payer_ProcedureCode_G0299_Payer_Invalid_PayerProgram_PP");

        JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2_SEVV9533_ProcedureCode_G0299();

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        jsonObject.put(globalVariables.payer, CommonMethods.generateRandomStringOfFixLength(3));
        jsonObject.put(globalVariables.PayerProgram, "PP");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_visit_v2"));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2_get));

        CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PayerErrorVisit);

    }


}
