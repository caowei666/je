package com.smu.edu.vo;

import com.smu.edu.domain.Video;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterList {
    private List<Video> children = new ArrayList<>();

    private String title;

    private String id;
}
