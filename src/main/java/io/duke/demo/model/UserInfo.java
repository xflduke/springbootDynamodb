package io.duke.demo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "UserInfo")
public class UserInfo {
    @DynamoDBHashKey  (attributeName = "name")
    @DynamoDBAutoGeneratedKey
    private String username;
    @DynamoDBAttribute
    private String password;
    @DynamoDBAttribute
    private String passwordConfirm;
    @DynamoDBAttribute
    private String roles;
    @DynamoDBAttribute
    private String checkboxSample;
    @DynamoDBAttribute
    private String radioSample;
    @DynamoDBAttribute
    private String selectSample;

//    public UserInfo() {
//        id = null;
//        username = null;
//        password = null;
//        checkboxSample = null;
//        radioSample = null;
//        selectSample = null;
//    }

//    public UserInfo(String id, String username, String password, String checkboxSample, String radioSample, String selectSample) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.checkboxSample = checkboxSample;
//        this.radioSample = radioSample;
//        this.selectSample = selectSample;
//    }
//
//    @DynamoDBHashKey
//    @DynamoDBAutoGeneratedKey
//    public String getId() {
//        return id;
//    }
//
//    @DynamoDBAttribute
//    public String getUsername() {
//        return username;
//    }
//
//    @DynamoDBAttribute
//    public String getPassword() {
//        return password;
//    }
//
//    @DynamoDBAttribute
//    public String getCheckboxSample() {
//        return checkboxSample;
//    }
//
//    @DynamoDBAttribute
//    public String getRadioSample() {
//        return radioSample;
//    }
//
//    @DynamoDBAttribute
//    public String getSelectSample() {
//        return selectSample;
//    }
}