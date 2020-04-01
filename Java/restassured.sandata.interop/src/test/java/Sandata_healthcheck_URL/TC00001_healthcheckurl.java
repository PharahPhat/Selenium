package Sandata_healthcheck_URL;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import Utills_ExtentReport_Log4j.BaseTest;


@Test(enabled = true, groups = {"All"})
@AdditionalInfo(module = "healthcheckf")
public class TC00001_healthcheckurl extends BaseTest{

	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "healthcheckf")
	public void healthcheck_restclaim()
	{
		// logger = extent.startTest("healthcheck_restclaim");
		System.out.println(CommonMethods.propertyfileReader("rest_claim_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("rest_claim_health"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "healthcheckf")
	public void healthcheck_batchclaim()
	{
		// logger = extent.startTest("healthcheck_batchclaim");
		System.out.println(CommonMethods.propertyfileReader("batch_claim_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("batch_claim_health"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_provider()
	{
		// logger = extent.startTest("healthcheck_provider");
		System.out.println(CommonMethods.propertyfileReader("provider_import_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("provider_import_health"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_dwhexport()
	{
		// logger = extent.startTest("healthcheck_dwhexport");
		System.out.println(CommonMethods.propertyfileReader("dwh_export_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("dwh_export_health"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_identityvalidation()
	{
		// logger = extent.startTest("healthcheck_identityvalidation");
		System.out.println(CommonMethods.propertyfileReader("identity_validation_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("identity_validation_health"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_staffintake()
	{
		// logger = extent.startTest("healthcheck_staffintake");
		System.out.println(CommonMethods.propertyfileReader("satff_validation_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("satff_validation_health"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_petientintake()
	{
		// logger = extent.startTest("healthcheck_petientintake");
		System.out.println(CommonMethods.propertyfileReader("petient_intake_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("petient_intake_health"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_visitintake()
	{
		// logger = extent.startTest("healthcheck_visitintake");
		System.out.println(CommonMethods.propertyfileReader("visit_intake_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("visit_intake_health"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_clientintake()
	{
		// logger = extent.startTest("healthcheck_clientintake");
		System.out.println(CommonMethods.propertyfileReader("cleint_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("cleint_gateway"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_employeeintake()
	{
		// logger = extent.startTest("healthcheck_employeeintake");
		System.out.println(CommonMethods.propertyfileReader("employee_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("employee_gateway"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_visitgateway()
	{
		// logger = extent.startTest("healthcheck_visitgateway");
		System.out.println(CommonMethods.propertyfileReader("visit_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("visit_gateway"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_completedvisitgateway()
	{
		// logger = extent.startTest("healthcheck_completedvisitgateway");
		System.out.println(CommonMethods.propertyfileReader("completed_visit_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("completed_visit_gateway"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_zendeskhealth()
	{
		// logger = extent.startTest("healthcheck_zendeskhealth");
		System.out.println(CommonMethods.propertyfileReader("zendesk_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("zendesk_health"));
		Assert.assertTrue(bodyAsString.contains("\"code\":\"UP\","));

	}

	/* @Test(enabled = true, groups = {"All"})
	 * This URL is Not required as of Now.
	public void healthcheck_trackerhealth()
	 {   
	  // logger = extent.startTest("healthcheck_trackerhealth");
	  System.out.println(CommonMethods.propertyfileReader("tracker_health"));
	  String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("tracker_health"));		
	 Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	 }*/

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_odmwelcomekit()
	{
		// logger = extent.startTest("healthcheck_odmwelcomekit");
		System.out.println(CommonMethods.propertyfileReader("odm_welcome_kit"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("odm_welcome_kit"));
		Assert.assertTrue(bodyAsString.contains("\"code\":\"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_etlconfig()
	{
		// logger = extent.startTest("healthcheck_etlconfig");
		System.out.println(CommonMethods.propertyfileReader("etl_job_config"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("etl_job_config"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_providerimport()
	{
		// logger = extent.startTest("healthchek_providerimport");
		System.out.println(CommonMethods.propertyfileReader("emport_provider_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("emport_provider_health"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_authetlimport()
	{
		// logger = extent.startTest("healthchek_authetlimport");
		System.out.println(CommonMethods.propertyfileReader("auth_etl_import"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("auth_etl_import"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_clientetlimport()
	{
		// logger = extent.startTest("healthchek_clientetlimport");
		System.out.println(CommonMethods.propertyfileReader("client_etl_import"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("client_etl_import"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_intakeprovider()
	{
		// logger = extent.startTest("healthchek_intakeprovider");
		System.out.println(CommonMethods.propertyfileReader("intake_provider_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("intake_provider_gateway"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_intakeauth()
	{
		// logger = extent.startTest("healthchek_intakeauth");
		System.out.println(CommonMethods.propertyfileReader("inkate_auth_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("inkate_auth_gateway"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_emailintegration()
	{
		// logger = extent.startTest("healthchek_emailintegration");
		System.out.println(CommonMethods.propertyfileReader("email_integration"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("email_integration"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_etracintegartion()
	{
		// logger = extent.startTest("healthchek_etracintegartion");
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("etrac_inegration"));
		Assert.assertTrue(bodyAsString.contains("\"code\":\"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_eevvdwh()
	{
		// logger = extent.startTest("healthchek_eevvdwh");
		System.out.println(CommonMethods.propertyfileReader("evv_dwh_export"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("evv_dwh_export"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_geo_location()
	{
		// logger = extent.startTest("healthchek_geo_location");
		System.out.println(CommonMethods.propertyfileReader("geo_location"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("geo_location"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_import_provider()
	{
		// logger = extent.startTest("healthchek_import_provider");
		System.out.println(CommonMethods.propertyfileReader("import_provider"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("import_provider"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_sam_care_connect()
	{
		// logger = extent.startTest("healthchek_sam_care_connect");
		System.out.println(CommonMethods.propertyfileReader("sam_care_connect"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("sam_care_connect"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_vnsny_gps()
	{
		// logger = extent.startTest("healthchek_vnsny_gps");
		System.out.println(CommonMethods.propertyfileReader("vnsny_gps"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("vnsny_gps"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_map_user_import()
	{
		// logger = extent.startTest("healthchek_map_user_import");
		System.out.println(CommonMethods.propertyfileReader("map_user_import"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("map_user_import"));
		Assert.assertTrue(bodyAsString.contains("\"code\":\"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_mvv_app()
	{
		// logger = extent.startTest("healthchek_mvv_app");
		System.out.println(CommonMethods.propertyfileReader("mvv_app"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_app"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_mvv_datasync()
	{
		// logger = extent.startTest("healthchek_mvv_datasync");
		System.out.println(CommonMethods.propertyfileReader("mvv_datasync"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_datasync"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_mvv_web()
	{
		// logger = extent.startTest("healthchek_mvv_web");
		System.out.println(CommonMethods.propertyfileReader("mvv_web"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_web"));
		Assert.assertTrue(bodyAsString.contains("\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_mvv_forms_svs()
	{
		// logger = extent.startTest("healthchek_mvv_forms_svs");
		System.out.println(CommonMethods.propertyfileReader("mvv_forms_svs"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_forms_svs"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_intake_member_gateway()
	{
		// logger = extent.startTest("healthchek_intake_member_gateway");
		System.out.println(CommonMethods.propertyfileReader("intake_member_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("intake_member_gateway"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_file_transfer()
	{
		// logger = extent.startTest("healthchek_file_transfer");
		System.out.println(CommonMethods.propertyfileReader("file_transfer"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("file_transfer"));
		Assert.assertTrue(bodyAsString.contains("\"code\":\"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_mvv_setting()
	{
		// logger = extent.startTest("healthchek_mvv_setting");
		System.out.println(CommonMethods.propertyfileReader("mvv_setting"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_setting"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}


	@Test(enabled = true, groups = {"All"})
	public void healthcheck_mvv_mobile_auth_service()
	{
		// logger = extent.startTest("healthchek_mvv_mobile_auth_service");
		System.out.println(CommonMethods.propertyfileReader("mvv_mobile_auth_service"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_mobile_auth_service"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}


	@Test(enabled = true, groups = {"All"})
	public void healthcheck_mvv_sam_app()
	{
		// logger = extent.startTest("healthchek_mvv_sam_app");
		System.out.println(CommonMethods.propertyfileReader("mvv_sam_app"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_sam_app"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_mvv_task_service()
	{
		// logger = extent.startTest("healthchek_mvv_task_service");
		System.out.println(CommonMethods.propertyfileReader("mvv_task_service"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_task_service"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_intake_schedule_gateway()
	{
		// logger = extent.startTest("healthchek_intake_schedule_gateway");
		System.out.println(CommonMethods.propertyfileReader("intake_schedule_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("intake_schedule_gateway"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_sam_dwh_export()
	{
		// logger = extent.startTest("healthchek_sam_dwh_export");
		System.out.println(CommonMethods.propertyfileReader("sam_dwh_export"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("sam_dwh_export"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_schedule_etl_job()
	{
		// logger = extent.startTest("healthchek_schedule_etl_job");
		System.out.println(CommonMethods.propertyfileReader("schedule_etl_job"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("schedule_etl_job"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_intake_client_auth()
	{
		// logger = extent.startTest("healthchek_intake_client_auth");
		System.out.println(CommonMethods.propertyfileReader("intake_client_auth"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("intake_client_auth"));
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));

	}


	@Test(enabled = true, groups = {"All"})
	public void healthcheck_payroll_export()
	{
		// logger = extent.startTest("healthchek_intake_client_auth");
		System.out.println(CommonMethods.propertyfileReader("payroll_export"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("payroll_export"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_training_integration()
	{
		// logger = extent.startTest("healthchek_training_integration");
		System.out.println(CommonMethods.propertyfileReader("training_integration"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("training_integration"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_lms_integration_build()
	{
		// logger = extent.startTest("healthchek_lms_integration_build");
		System.out.println(CommonMethods.propertyfileReader("lms_integration_build"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("lms_integration_build"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_mvv_task_services()
	{
		// logger = extent.startTest("healthchek_mvv_task_services");
		System.out.println(CommonMethods.propertyfileReader("mvv_task_services"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_task_services"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_mvv_visit_capture()
	{
		// logger = extent.startTest("healthchek_mvv_visit_capture");
		System.out.println(CommonMethods.propertyfileReader("mvv_visit_capture"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_visit_capture"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_mvv_group_visit_service_capture()
	{
		System.out.println(CommonMethods.propertyfileReader("mvv_group_visit_service"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("mvv_group_visit_service"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_devero_export_capture()
	{
		System.out.println(CommonMethods.propertyfileReader("devero_export"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("devero_export"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_hcplus_care_connect_export_capture()
	{
		System.out.println(CommonMethods.propertyfileReader("hcplus_care_connect_export"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("hcplus_care_connect_export"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_vnsny_files_transfer_capture()
	{
		System.out.println(CommonMethods.propertyfileReader("vnsny_files_transfer"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("vnsny_files_transfer"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_vnsny_files_transfer_hcprod2_capture()
	{
		System.out.println(CommonMethods.propertyfileReader("vnsny_files_transfer_hcprod2"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("vnsny_files_transfer_hcprod2"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));
	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_vnsny_gps_hcprod2_capture()
	{
		System.out.println(CommonMethods.propertyfileReader("vnsny_gps_hcprod2"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("vnsny_gps_hcprod2"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));
	}

//	@Test(enabled = true, groups = {"All"})
//	public void healthchek_shared_comon_gpsmap_capture()
//	{
//		System.out.println(CommonMethods.propertyfileReader("shared_comon_gpsmap"));
//		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("shared_comon_gpsmap"));
//		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));
//	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_hcplus_care_connect_import_capture()
	{
		System.out.println(CommonMethods.propertyfileReader("hcplus_care_connect_import"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("hcplus_care_connect_import"));
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));
	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_vnsny_ops_integration_capture()
	{
		System.out.println(CommonMethods.propertyfileReader("vnsny_ops_integration"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("vnsny_ops_integration"));
		Assert.assertTrue(bodyAsString.contains("\"code\":\"UP\""));
	}

}
