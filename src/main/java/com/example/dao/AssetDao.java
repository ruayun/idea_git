package com.example.dao;

import com.example.entity.Asset;
import com.example.entity.Params;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AssetDao extends Mapper<Asset> {

    List<Asset> findBySearch(@Param("params") Params params);
}
