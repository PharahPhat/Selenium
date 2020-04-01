package Sandata_healthcheck_URL_New;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import Utills_ExtentReport_Log4j.BaseTest;
import healthCheck.HealthCheckAssertionVerifier;

@Test(enabled = true, groups = {"All"})
@AdditionalInfo(module = "healthcheckf")
public class TC00002_Healthcheckurl_new extends BaseTest{

	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "healthcheckf")
	public void healthcheck_restclaim()
	{   
		// logger = extent.startTest("healthcheck_restclaim");
		System.out.println(CommonMethods.propertyfileReader("rest_claim_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("rest_claim_health"));		
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"claims\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "healthcheckf")
	public void healthcheck_batchclaim()
	{   
		// logger = extent.startTest("healthcheck_batchclaim");
		System.out.println(CommonMethods.propertyfileReader("batch_claim_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("batch_claim_health"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"batch-claims-validation\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_provider()
	{   
		// logger = extent.startTest("healthcheck_provider");
		System.out.println(CommonMethods.propertyfileReader("provider_import_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("provider_import_health"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"import-provider\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_dwhexport() throws ParseException
	{   
		// logger = extent.startTest("healthcheck_dwhexport");
		System.out.println(CommonMethods.propertyfileReader("dwh_export_health_evv"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("dwh_export_health_evv"));	
		
		HealthCheckAssertionVerifier.dwhExportAssertion(bodyAsString);
	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_identityvalidation()
	{   
		// logger = extent.startTest("healthcheck_identityvalidation");
		System.out.println(CommonMethods.propertyfileReader("identity_validation_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("identity_validation_health"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"auth\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_staffintake()
	{   
		// logger = extent.startTest("healthcheck_staffintake");
		System.out.println(CommonMethods.propertyfileReader("satff_validation_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("satff_validation_health"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"staff\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_petientintake()
	{   
		// logger = extent.startTest("healthcheck_petientintake");
		System.out.println(CommonMethods.propertyfileReader("petient_intake_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("petient_intake_health"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"patient\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}
	
	@Test(enabled = true, groups = {"All"})
	public void healthcheck_visitintake()
	{   
		// logger = extent.startTest("healthcheck_visitintake");
		System.out.println(CommonMethods.propertyfileReader("visit_intake_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("visit_intake_health"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"visit\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_clientintake()
	{   
		// logger = extent.startTest("healthcheck_clientintake");
		System.out.println(CommonMethods.propertyfileReader("healthcheck_clientintake"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("cleint_gateway"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"clients\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_employeeintake()
	{   
		// logger = extent.startTest("healthcheck_employeeintake");
		System.out.println(CommonMethods.propertyfileReader("employee_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("employee_gateway"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"employees\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_visitgateway()
	{   
		// logger = extent.startTest("healthcheck_visitgateway");
		System.out.println(CommonMethods.propertyfileReader("visit_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("visit_gateway"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"visits\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_completedvisitgateway()
	{   
		// logger = extent.startTest("healthcheck_completedvisitgateway");
		System.out.println(CommonMethods.propertyfileReader("completed_visit_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("completed_visit_gateway"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"completed-visits-gateway\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_zendeskhealth()
	{   
		// logger = extent.startTest("healthcheck_zendeskhealth");
		System.out.println(CommonMethods.propertyfileReader("zendesk_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("zendesk_health"));		
		Assert.assertTrue(bodyAsString.contains("\"code\":\"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"zendesk-integration\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

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
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"odm-welcome-kit\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthcheck_etlconfig()
	{   
		// logger = extent.startTest("healthcheck_etlconfig");
		System.out.println(CommonMethods.propertyfileReader("etl_job_config"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("etl_job_config"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"configure-etl-job\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}
	
	@Test(enabled = true, groups = {"All"})
	public void healthchek_providerimport()
	{   
		// logger = extent.startTest("healthchek_providerimport");
		System.out.println(CommonMethods.propertyfileReader("emport_provider_health"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("emport_provider_health"));		
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"evv-import-provider\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_authetlimport()
	{   
		// logger = extent.startTest("healthchek_authetlimport");
		System.out.println(CommonMethods.propertyfileReader("auth_etl_import"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("auth_etl_import"));		
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"auth-etl-import\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_clientetlimport()
	{   
		// logger = extent.startTest("healthchek_clientetlimport");
		System.out.println(CommonMethods.propertyfileReader("client_etl_import"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("client_etl_import"));		
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"client-etl-import\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_intakeprovider()
	{   
		// logger = extent.startTest("healthchek_intakeprovider");
		System.out.println(CommonMethods.propertyfileReader("intake_provider_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("intake_provider_gateway"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"providers\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_intakeauth()
	{   
		// logger = extent.startTest("healthchek_intakeauth");
		System.out.println(CommonMethods.propertyfileReader("inkate_auth_gateway"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("inkate_auth_gateway"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"auths\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_emailintegration()
	{   
		// logger = extent.startTest("healthchek_emailintegration");
		System.out.println(CommonMethods.propertyfileReader("email_integration"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("email_integration"));		
		Assert.assertTrue(bodyAsString.contains("\"status\":\"UP\""));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"email\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_etracintegartion()
	{   
		// logger = extent.startTest("healthchek_etracintegartion");
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("etrac_inegration"));		
		Assert.assertTrue(bodyAsString.contains("\"code\":\"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"etrac-integration\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

	@Test(enabled = true, groups = {"All"})
	public void healthchek_eevvdwh()
	{   
		// logger = extent.startTest("healthchek_eevvdwh");
		System.out.println(CommonMethods.propertyfileReader("evv_dwh_export"));
		String bodyAsString = CommonMethods.Gethealthresponse(CommonMethods.propertyfileReader("evv_dwh_export"));		
		Assert.assertTrue(bodyAsString.contains("\"code\": \"UP\","));
		Assert.assertTrue(bodyAsString.contains("\"service-name\":\"export\""));
		Assert.assertTrue(bodyAsString.contains("\"description\":\"\""));

	}

}
