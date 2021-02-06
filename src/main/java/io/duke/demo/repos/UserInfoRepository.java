package io.duke.demo.repos;

import io.duke.demo.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends
        CrudRepository<UserInfo, String> {

    Optional<UserInfo> findById(String id);
}