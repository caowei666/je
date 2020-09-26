package com.test.bike.service;

import com.github.pagehelper.PageInfo;
import com.test.bike.pojo.DubboResult;
import com.test.bike.pojo.Record;
import com.test.bike.pojo.RecordSearch;

public interface RecordService {
    PageInfo<Record> getRecordList(RecordSearch search,Integer pageNum,Integer pageSize);

    Record getRecordById(Integer id);

    DubboResult addRecord(Record record);

    DubboResult updateRecord(Record record);

    DubboResult deleteRecord(Integer id);
}
