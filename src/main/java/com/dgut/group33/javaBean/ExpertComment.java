/**
 * 校外专家评价实体类, 其他四个评价类也用这个
 * @Author wjwwhs
 */
package com.dgut.group33.javaBean;

public class ExpertComment {
    private int id;
    private String expert;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "expert='" + expert + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
