package com.dgut.group33.javaBean;

/*import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString*/
public class Measure {
    private int achievement_id;
    private String achievement_title;
    private String achievement_time;
    private int content_id;
    private MeasureContent measureContent;

    public int getAchievement_id() {
        return achievement_id;
    }

    public void setAchievement_id(int achievement_id) {
        this.achievement_id = achievement_id;
    }

    public String getAchievement_title() {
        return achievement_title;
    }

    public void setAchievement_title(String achievement_title) {
        this.achievement_title = achievement_title;
    }

    public String getAchievement_time() {
        return achievement_time;
    }

    public void setAchievement_time(String achievement_time) {
        this.achievement_time = achievement_time;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public MeasureContent getMeasureContent() {
        return measureContent;
    }

    public void setMeasureContent(MeasureContent measureContent) {
        this.measureContent = measureContent;
    }
}
