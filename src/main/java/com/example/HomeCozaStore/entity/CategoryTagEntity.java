package com.example.HomeCozaStore.entity;

import com.example.HomeCozaStore.entity.keys.CategoryTagIds;

import javax.persistence.*;

@Entity(name="categoryTag")
public class CategoryTagEntity {

    @EmbeddedId
    private CategoryTagIds ids;

    @ManyToOne
    @JoinColumn(name="category_id",insertable = false,updatable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name="tag_id",insertable = false,updatable = false)
    private TagEntity tag;

    public CategoryTagIds getIds() {
        return ids;
    }

    public void setIds(CategoryTagIds ids) {
        this.ids = ids;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public TagEntity getTag() {
        return tag;
    }

    public void setTag(TagEntity tag) {
        this.tag = tag;
    }
}
