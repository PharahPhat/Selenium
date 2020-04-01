package com.sandata.models.molina.client;

import com.sandata.core.annotation.Column;

public class ClientAccountModel {
    @Column("LOC")
    private String ClientId;

    @Column("F_NAME")
    private String FirstName;

    @Column("L_NAME")
    private String LastName;

    public String getClientId() {
        return ClientId;
    }

    public void setClientId(String clientId) {
        ClientId = clientId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
