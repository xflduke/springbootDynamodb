package io.duke.demo.repos;

import io.duke.demo.model.UserInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableScan
public interface UserInfoRepository extends
        CrudRepository<UserInfo, String> {

    Optional<UserInfo> findById(String id);

    Optional<UserInfo> findByUsername(String username);
}