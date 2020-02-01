package com.example.ims.manage.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_md_index_performance")
public class IndexPerformance extends Model<IndexPerformance> {
    private String id;
    private String indexName;
    private Date date;
    private Double high;
    private Double low;
    private Double open;
    private Double close;
    private Double volume;
    private Double adjClose;

}
