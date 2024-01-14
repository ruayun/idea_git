package com.example.controller;

import com.example.common.Result;
import com.example.entity.Asset;
import com.example.entity.Book;
import com.example.entity.Params;
import com.example.service.AssetService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin
@RestController
@RequestMapping("/asset")
public class AssetController {

    @Resource
    private AssetService assetService;

    @GetMapping("/search")
    public Result findBySearch(Params params) {
        PageInfo<Asset> info = assetService.findBySearch(params);
        return Result.success(info);
    }

    @PostMapping
    public Result save(@RequestBody Asset asset) {
        if (asset.getId() == null) {
            assetService.add(asset);
        } else {
            assetService.update(asset);
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        assetService.delete(id);
        return Result.success();
    }

}