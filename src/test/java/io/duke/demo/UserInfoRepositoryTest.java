package io.duke.demo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import io.duke.demo.model.UserInfo;
import io.duke.demo.repos.UserInfoRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

//@ActiveProfiles("test")
@SpringBootTest(classes = DemoApplication.class)
@TestPropertySource(properties = {
        "amazon.dynamodb.endpoint=http://192.168.3.60:8000/",
        "amazon.aws.accesskey=fakeAWSAccessKey",
        "amazon.aws.secretkey=fakeAWSSecretAccessKey"})
public class UserInfoRepositoryTest {

    private static final String EXPECTED_COST = "20";
    private static final String EXPECTED_PRICE = "50";
    @Autowired
    UserInfoRepository repository;
    private DynamoDBMapper dynamoDBMapper;
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Before
    public void init() throws Exception {
        System.out.println("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟");
        // TODO
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        // TODO
        TableDescription table = null;
        try {
            amazonDynamoDB.deleteTable("UserInfo");
            DescribeTableRequest request = new DescribeTableRequest()
                    .withTableName("UserInfo");
            table = amazonDynamoDB.describeTable(request).getTable();
        } catch (Throwable e) {
//            e.printStackTrace();
        }

        if (table == null) {
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(UserInfo.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));

            amazonDynamoDB.createTable(tableRequest);
        }
        // TODO

        UserInfo userInfo = new UserInfo("username", "password", "passwordConfirmed", "admin", "1", "1", "1");
        UserInfo uInf = repository.save(userInfo);
        
        UserInfo result = repository.findByUsername("1").orElse(null);

        return;
//        List<UserInfo> result = (List<UserInfo>) repository.findAll();

        // TODO
//        dynamoDBMapper.batchDelete(
//                repository.findAll());
        // TODO
    }
}