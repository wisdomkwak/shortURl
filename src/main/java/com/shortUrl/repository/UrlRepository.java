package com.shortUrl.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.shortUrl.domain.Url;

@Repository
public class UrlRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Url>  getUrls() {
		return sqlSession.selectList("urlMapper.getUrls");
	}

	public int getUrlIdByLongUrl(String longurl) {
		
		if(StringUtils.isEmpty(sqlSession.selectOne("urlMapper.getUrlIdByLongUrl", longurl)) == true){
			return 0;
		}
		
		return sqlSession.selectOne("urlMapper.getUrlIdByLongUrl", longurl);
	}

	public int updateLongUrl(String longurl) {
		return sqlSession.insert("urlMapper.updateLongUrl", longurl);
	}

	public String getLongUrlById(int id) {
		return sqlSession.selectOne("urlMapper.getLongUrlById", id);
	}

	public void updateCnt(Integer id) {
		sqlSession.update("urlMapper.updateCnt", id);
		
	}

}
