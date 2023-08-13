package com.spring.news.service;

import com.spring.news.DTO.NewsViewResponseDTO;
import com.spring.news.entity.News;
import com.spring.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }

    //서비스레이어는 테스트 코드 작성하기

    // 리스트 -> 추후 페이징 처리 방식으로 수정해야 함 (1페이지 게시글 10개)
    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(long newsId) {
        return newsRepository.findById(newsId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 뉴스번호: " + newsId ));
    }

    @Override
    public void deleteNewsById(long newsId) {
        newsRepository.deleteById(newsId);
    }

    // 검색기능 -> 추후 페이징 처리 방식으로 수정해야 함 (1페이지 게시글 10개)
    @Override
    public List<News> searchNewsByKeyword(String keyword) {
        return newsRepository.findByTitleContaining(keyword);
    }


}
