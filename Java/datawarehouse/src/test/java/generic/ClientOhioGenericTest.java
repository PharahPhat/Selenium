package generic;

import com.sandata.entity.exportDWH.IndividualPayerInformationModel;
import com.sandata.entity.ohio.client.PatientAdressEntity;
import com.sandata.entity.ohio.client.PatientGeneralEntity;
import com.sandata.entity.ohio.client.PatientPhonesEntity;
import com.sandata.entity.ohio.client.ResponsiblePartyModel;

import java.util.ArrayList;
import java.util.List;

public class ClientOhioGenericTest extends ClientGenericTest {

    private String addressState = "OH";
    private String addressCity = "New York";
    private String payerId = "DODD";

    public List<PatientGeneralEntity> initializeClientCurrentOhioData(String accountId, String providerId) {
        List<PatientGeneralEntity> patientGeneralEntities = new ArrayList<>();
        PatientGeneralEntity patientGeneralEntity = new PatientGeneralEntity();

        patientGeneralEntity.BusinessEntityID = accountId;
        patientGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        patientGeneralEntity.IsPatientNewborn = false;
        patientGeneralEntity.PatientAlternateID = "1114314";
        patientGeneralEntity.PatientFirstName = clientDbService.generateNewClientFName(accountId);
        patientGeneralEntity.PatientLastName = clientDbService.generateNewClientLName(accountId);
        patientGeneralEntity.PatientMedicaidID = clientDbService.generateNewPatientMedicaidID(accountId);
        patientGeneralEntity.PatientOtherID = clientDbService.generateNewPatientOtherID(accountId);
        patientGeneralEntity.PatientTimezone = "US/Eastern";
        patientGeneralEntity.SequenceID = clientDbService.generateNewClientLSequenceNumber(accountId);

        List<ResponsiblePartyModel> responsibleParties = new ArrayList<>();
        ResponsiblePartyModel responsiblePartyModel = new ResponsiblePartyModel();
        responsiblePartyModel.PatientResponsiblePartyFirstName = "JStevee";
        responsiblePartyModel.PatientResponsiblePartyLastName = "KJobss";
        responsibleParties.add(responsiblePartyModel);
        patientGeneralEntity.ResponsibleParty = responsibleParties;

        List<IndividualPayerInformationModel> individualPayerInformationModels = new ArrayList<>();
        IndividualPayerInformationModel individualPayerInformationModel = new IndividualPayerInformationModel();
        individualPayerInformationModel.Payer = payerId;
        individualPayerInformationModel.PayerProgram = "SPHH";
        individualPayerInformationModel.ProcedureCode = "T1000";
        individualPayerInformationModels.add(individualPayerInformationModel);
        patientGeneralEntity.IndividualPayerInformation = individualPayerInformationModels;

        List<PatientPhonesEntity> phones = new ArrayList<>();
        PatientPhonesEntity phone = new PatientPhonesEntity();
        phone.PatientPhoneNumber = "9431650001";
        phone.PatientPhoneType = "Home";
        phones.add(phone);
        patientGeneralEntity.Phones = phones;

        List<PatientAdressEntity> addresses = new ArrayList<>();
        PatientAdressEntity address1 = new PatientAdressEntity();
        address1.PatientAddressIsPrimary = false;
        address1.PatientAddressLine1 = "201 Harbour Drive Rd";
        address1.PatientAddressLine2 = "2nd Floor";
        address1.PatientAddressType = "School";
        address1.PatientCity = addressCity;
        address1.PatientLatitude = 88.1155122001;
        address1.PatientLongitude = 85.1155122001;
        address1.PatientState = addressState;
        address1.PatientTimezone = "US/Eastern";
        address1.PatientZip = "55556";

        addresses.add(address1);
        patientGeneralEntity.Address = addresses;

        patientGeneralEntities.add(patientGeneralEntity);
        return patientGeneralEntities;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }
}
