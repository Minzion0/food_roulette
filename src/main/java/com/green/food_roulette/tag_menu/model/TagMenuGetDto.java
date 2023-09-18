package com.green.food_roulette.tag_menu.model;

import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Data
public class TagMenuGetDto {
    private List<String> tags;
}
