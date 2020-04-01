package Entity;

public class TestCaseQTestModel {
    private String id;
    private String testCaseName;
    private String testRunId;
    private String testCaseVersionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestRunId() {
        return testRunId;
    }

    public void setTestRunId(String testRunId) {
        this.testRunId = testRunId;
    }

    public String getTestCaseVersionId() {
        return testCaseVersionId;
    }

    public void setTestCaseVersionId(String testCaseVersionId) {
        this.testCaseVersionId = testCaseVersionId;
    }
}
