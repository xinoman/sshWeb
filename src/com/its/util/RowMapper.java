/**
 * 
 */
package com.its.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:34:13
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public interface RowMapper {
	
	public Object mapRow(ResultSet rs, int index) throws SQLException;

}
