package qianmeima.finalproject_ocean;

/**
 * Created by Ailee on 2016/4/18.
 */
public class Diary {
    public String title;
    public String article;


    public Diary() {
        this("", "");
    }

    public Diary(String title, String article) {
        this.title = title;
        this.article = article;

    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Diary))
            return false;

        Diary diary = (Diary) object;
        return title.equals(diary.title);
    }
}
