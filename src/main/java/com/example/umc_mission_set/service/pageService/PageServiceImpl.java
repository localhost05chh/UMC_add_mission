package com.example.umc_mission_set.service.pageService;

public class PageServiceImpl implements PageService {

    @Override
    public Integer ChangePage(Integer page) {
        return page -= 1;
    }
}
