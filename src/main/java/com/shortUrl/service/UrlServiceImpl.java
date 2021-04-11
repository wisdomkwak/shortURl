package com.shortUrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shortUrl.domain.Url;
import com.shortUrl.repository.UrlRepository;
import com.shortUrl.utils.Base62Util;
import com.shortUrl.utils.UrlTypeValidation;

@Service
public class UrlServiceImpl implements UrlService {

	@Autowired
	private UrlRepository urlRepository;

	@Autowired
	private UrlTypeValidation urlTypeValidation;

	@Autowired
	private Base62Util base62Util;

	@Override
	public List<Url> getUrls() {
		return urlRepository.getUrls();
	}

	@Override
	public String generateShortUrl(String longurl) {

		if (!urlTypeValidation.valid(longurl)) {
			throw new IllegalArgumentException("잘못된 URL 타입입니다.");
		}

		longurl = longurl.replace("https://", "");
		Integer id = urlRepository.getUrlIdByLongUrl(longurl);
		String shorturl;
		if (id == null || id == 0) {
			id = urlRepository.updateLongUrl(longurl);
		} else {
			urlRepository.updateCnt(id);
		}
		shorturl = base62Util.encoding(id);

		return "http://localhost:8080/" + shorturl;
	}

	@Override
	public String getLongUrlByShortUrl(String shorturl) {
		shorturl = shorturl.replace("http://localhost:8080/", "");
		int id = base62Util.decoding(shorturl);
		String longurl = urlRepository.getLongUrlById(id);

		return longurl;
	}

}
