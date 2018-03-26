package com.aibton.server.monitor.dao;

import com.aibton.server.monitor.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 14:51 huzhihui Exp $$
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    List<SysUser> findByNameIsAndPostIs(String name, String post);

}
