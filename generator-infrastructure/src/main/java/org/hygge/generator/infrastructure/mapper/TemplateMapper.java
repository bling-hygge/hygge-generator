package org.hygge.generator.infrastructure.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hygge.generator.domain.template.TemplateDomain;

import java.util.Date;
import java.util.List;

@Mapper
public interface TemplateMapper {

    @Select("SELECT template_id, name, create_time, update_time, content" +
            " FROM template " +
            " WHERE template_id=#{templateId} ")
    TemplateDomain findOne(@Param("templateId") Long templateId);

    @Select("<script>" +
            "SELECT template_id, name, create_time, update_time " +
            " FROM template " +
            "<where>" +
            "<if test=\"templateIdList != null and templateIdList.size() &gt; 0\">" +
            "   AND template_id IN " +
            "   <foreach collection=\"templateIdList\" item=\"item\" open=\"(\" close=\")\" separator=\",\">" +
            "      #{item} " +
            "   </foreach>" +
            "</if>" +
            "<if test=\"templateName != null and templateName != ''\">" +
            "   AND name LIKE concat('%', #{templateName}, '%') " +
            "</if>" +
            "<if test=\"createBeginTime != null\">" +
            "   AND create_time &gt;= #{createBeginTime} " +
            "</if>" +
            "<if test=\"createEndTime != null\">" +
            "   AND create_time &lt;= #{createEndTime} " +
            "</if>" +
            "<if test=\"updateBeginTime != null\">" +
            "   AND update_time &gt;= #{updateBeginTime} " +
            "</if>" +
            "<if test=\"updateEndTime != null\">" +
            "   AND update_time &lt;= #{updateEndTime} " +
            "</if>" +
            "</where>" +
            "</script>")
    IPage<TemplateDomain> findAllWithPage(IPage<TemplateDomain> page, @Param("templateIdList") List<Long> templateIdList, @Param("templateName") String templateName,
                                          @Param("createBeginTime") Date createBeginTime, @Param("createEndTime") Date createEndTime,
                                          @Param("updateBeginTime") Date updateBeginTime, @Param("updateEndTime") Date updateEndTime);

    @Insert("INSERT INTO template(template_id, name, create_time, update_time, content) " +
            " VALUES(#{templateDomain.templateId}, #{templateDomain.name}, #{templateDomain.createTime}, #{templateDomain.updateTime}, #{templateDomain.content}) ")
    Long templateInsert(@Param("templateDomain") TemplateDomain templateDomain);

    @Insert(" UPDATE template SET name=#{templateDomain.name}, update_time=#{templateDomain.updateTime}, content=#{templateDomain.content} " +
            " WHERE template_id=#{templateDomain.templateId} ")
    long templateUpdate(@Param("templateDomain") TemplateDomain templateDomain);
}
