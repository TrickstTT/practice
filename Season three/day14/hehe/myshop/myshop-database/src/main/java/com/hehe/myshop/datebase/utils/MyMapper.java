package com.hehe.myshop.datebase.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自己的 Mapper
 * 特别注意， 该接口不能被扫描到， 否则会出错
 * <p>Title: MyMapper</p>
 * <p>Description: </p>
 *
 * @author hehe
 * @version 1.0.0
 * @date 2018/1/5 11:42
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
