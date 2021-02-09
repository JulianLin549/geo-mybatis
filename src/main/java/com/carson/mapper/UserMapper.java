package com.carson.mapper;

import com.carson.common.mybatis.GeoBaseInsertMapper;
import com.carson.common.mybatis.GeoBaseUpdateMapper;
import com.carson.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.base.BaseSelectMapper;

import java.util.List;

@Repository
public interface UserMapper extends GeoBaseInsertMapper<User>, GeoBaseUpdateMapper<User>, BaseSelectMapper<User> {
    @Select({"SELECT * FROM t_user " +
            "WHERE ST_Distance_Sphere(gis, POINT(#{lng}, #{lat})) < #{distance} " +
            "ORDER BY ST_Distance_Sphere(gis, POINT(#{lng}, #{lat})) ASC"})
    List<User> selectByDistance(@Param("lng") String lng, @Param("lat") String lat, @Param("distance") String distance);

}
