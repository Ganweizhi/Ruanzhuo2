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
    private int measure_id;
    private String measure_title;
    private String measure_time;
    private int content_id;
    private MeasureContent measureContent;
    private String Content;
    private String Content_author;

    public String getContent() {
        if (measureContent!=null)
            return measureContent.getContent();
        else
            return null;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "measure_id=" + measure_id +
                ", measure_title='" + measure_title + '\'' +
                ", measure_time='" + measure_time + '\'' +
                ", content_id=" + content_id +
                ", measureContent=" + measureContent +
                ", Content='" + Content + '\'' +
                ", Content_author='" + Content_author + '\'' +
                '}';
    }

    public String getContent2() {
            return Content;
    }
    public String getContent_author2() {
            return Content_author;
    }
    public void setContent(String content) {
        Content = content;
    }

    public String getContent_author() {
        if (measureContent!=null)
            return measureContent.getContent_author();
        else
            return null;
    }

    public void setContent_author(String content_author) {
        Content_author = content_author;
    }

    public int getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(int measure_id) {
        this.measure_id = measure_id;
    }

    public String getMeasure_title() {
        return measure_title;
    }

    public void setMeasure_title(String measure_title) {
        this.measure_title = measure_title;
    }

    public String getMeasure_time() {
        return measure_time;
    }

    public void setMeasure_time(String measure_time) {
        this.measure_time = measure_time;
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
