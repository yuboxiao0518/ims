package com.example.ims.manage.api.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TMdMeeting extends Model<TMdMeeting> {

  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;
  @TableField(fill = FieldFill.INSERT)
  private String meetingName;
  private String meetingCode;
  private String createUser;
  @TableField(fill = FieldFill.INSERT)
  private Date createDate;
  private String projectId;
  private String result;


}
