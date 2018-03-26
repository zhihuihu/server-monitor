package com.aibton.server.monitor.dao;

import com.aibton.server.monitor.entity.StartRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huzhihui
 * @version $: v 0.1 2018 2018/3/26 18:34 huzhihui Exp $$
 */
@Repository
public interface StartRecordRepository extends JpaRepository<StartRecord, String> {
}
