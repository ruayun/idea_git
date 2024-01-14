package com.example.service;

import com.example.dao.AssetDao;
import com.example.entity.Asset;
import com.example.entity.Params;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AssetService {

    @Resource
    private AssetDao assetDao;


    public void add(Asset asset) {
        assetDao.insertSelective(asset);
    }

    public void update(Asset asset) {
        assetDao.updateByPrimaryKeySelective(asset);
    }

    public PageInfo<Asset> findBySearch(Params params) {
        // 开启分页查询
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        // 接下来的查询会自动按照当前开启的分页设置来查询
        List<Asset> list = assetDao.findBySearch(params);
        return PageInfo.of(list);
    }

    public void delete(Integer id) {
        assetDao.deleteByPrimaryKey(id);
    }

    public List<Asset> findAll() {
        return assetDao.selectAll();
    }
}
