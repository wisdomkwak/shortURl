package com.shortUrl.service;

import java.util.List;

import com.shortUrl.domain.Url;

public interface UrlService {

    List<Url> getUrls();

    String generateShortUrl(String longurl);

    String getLongUrlByShortUrl(String shorturl);
}
