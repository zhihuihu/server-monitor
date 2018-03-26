package com.aibton.server.monitor.dao;

import com.aibton.server.monitor.entity.SysProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 18:33 huzhihui Exp $$
 */
@Repository
public interface SysProjectRepository extends JpaRepository<SysProject, String> {

    List<SysProject> queryByNameIs(String name);
}
