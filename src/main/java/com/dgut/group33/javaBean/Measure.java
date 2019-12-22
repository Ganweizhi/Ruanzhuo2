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
    private int id;
    private String title;
    private String time;
    private int content_id;
    private MeasureContent measureContent;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public MeasureContent getMeasureContent(){return measureContent;}

    public void setMeasureContent(MeasureContent measureContent){
        this.measureContent=measureContent;
    }
}
