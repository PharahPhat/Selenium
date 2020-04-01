package com.sandata.models.molina.employee;

public class SearchEmployee {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIsActiveEmployee() {
        return isActiveEmployee;
    }

    public void setIsActiveEmployee(String isActiveEmployee) {
        this.isActiveEmployee = isActiveEmployee;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        String body = "current=1&rowCount=5&searchPhrase=&columns%5B%5D=Actions&columns%5B%5D=LastName"
                + "&columns%5B%5D=FirstName&columns%5B%5D=AttId&columns%5B%5D=StxId&columns%5B%5D=Discipline"
                + "&firstName=" + firstName
                + "&lastName=" + lastName
                + "&isActiveEmployee=true"
                + "&discipline=" + discipline
                + "&employeeId=" + employeeId;
        return body;
    }

    public String firstName;
    public String lastName;
    public String isActiveEmployee;
    public String discipline;
    public String employeeId;
}
