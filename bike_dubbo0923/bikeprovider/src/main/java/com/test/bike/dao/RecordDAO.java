package com.test.bike.dao;

import com.github.pagehelper.PageInfo;
import com.test.bike.pojo.DubboResult;
import com.test.bike.pojo.Record;
import com.test.bike.pojo.RecordSearch;

import java.util.List;

public interface RecordDAO {
    List<Record> getRecordList(RecordSearch search);

    Record getRecordById(Integer id);

    int addRecord(Record record);

    int updateRecord(Record record);

    int deleteRecord(Integer id);
}
