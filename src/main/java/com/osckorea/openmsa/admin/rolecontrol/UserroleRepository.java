package com.osckorea.openmsa.admin.rolecontrol;


import com.osckorea.openmsa.admin.rolecontrol.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserroleRepository extends CrudRepository<UserInfo, String > {


    UserInfo findByUserNm(String userNm); // 사용자 이름으로 조회하는 메서드 추가
}
