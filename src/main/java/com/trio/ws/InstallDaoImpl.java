package com.trio.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InstallDaoImpl implements InstallDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Install> findAll() {
		String sql = "select dinstall, vidversion, vdescription, vidpatch from ahmdsbsc_mstinstall";
		
		List<Install> list = new ArrayList<Install>();
		List<Map<String, Object>> lisMaps =jdbcTemplate.queryForList(sql);
		
		//Perulangan Database//
		for (Map<String, Object> map : lisMaps) { //Mengambil Kolom//
			
			//--Mengambil Baris--//
			Date dinstall = (Date) map.get("dinstall");
			String vidversion = (String) map.get("vidversion");
			String vdescription = (String) map.get("vdescription");
			String vidpatch = (String) map.get("vidpatch");
			//------------------//
			
			Install install = new Install();
			install.setDinstall(dinstall);
			install.setVdescription(vdescription);
			install.setVidpatch(vidpatch);
			install.setVidversion(vidversion);
			
			list.add(install);
			
		}
		return list;
	}
	
	
}
